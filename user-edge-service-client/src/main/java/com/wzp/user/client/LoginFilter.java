package com.wzp.user.client;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.wzp.thrift.user.dto.UserDTO;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @ClassName LoginFilter
 * @Description TODO
 * @Author wuzph
 * @Date 2020/10/12 14:38
 */

public abstract class LoginFilter implements Filter {

    private static Cache<String,UserDTO> cache =
            CacheBuilder.newBuilder().maximumSize(10000)
            .expireAfterWrite(3, TimeUnit.MINUTES).build();

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = request.getParameter("token");
        if(StringUtils.isBlank(token)){
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for (Cookie c : cookies){
                    if(c.getName().equals("token")){
                        token = c.getValue();
                    }
                }
            }
        }
        UserDTO userDTO = null;
        if(StringUtils.isNotBlank(token)){
            userDTO = cache.getIfPresent(token);
            if(userDTO == null) {
                userDTO = requestUserInfo(token);
                if(userDTO!=null){
                    cache.put(token,userDTO);
                }
            }
        }
        if(userDTO==null){
            response.sendRedirect("http://www.zyy.com:8083/user/login");
            return;
        }

        //方法执行到此处说明用户已登录，此处可以使用用户执行个性化的登录操作，例如：存储相应属性
        login(request,response,userDTO);

        filterChain.doFilter(request,response);
    }

    protected abstract void login(HttpServletRequest request, HttpServletResponse response, UserDTO userDTO) ;

    protected abstract String userEdgeServiceAddr();

    private UserDTO requestUserInfo(String token) {
        String url = "http://" + userEdgeServiceAddr() + "/user/authentication";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        post.addHeader("token",token);
        InputStream inputStream = null;
        try {
            HttpResponse response = client.execute(post);
            if(response.getStatusLine().getStatusCode() != HttpStatus.SC_OK){
                throw new RuntimeException("request user info failed! StatusLine:"+response.getStatusLine());
            }
            inputStream = response.getEntity().getContent();
            byte[] temp = new byte[1024];
            StringBuilder sb = new StringBuilder();
            int len = 0;
            while ((len = inputStream.read(temp)) > 0){
                sb.append(new String(temp,0,len));
            }
            UserDTO userDTO = new ObjectMapper().readValue(sb.toString(), UserDTO.class);
            return userDTO;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void destroy() {

    }
}
