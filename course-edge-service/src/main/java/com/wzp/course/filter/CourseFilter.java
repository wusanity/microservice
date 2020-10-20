package com.wzp.course.filter;

import com.wzp.thrift.user.dto.UserDTO;
import com.wzp.user.client.LoginFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CourseFilter
 * @Description TODO
 * @Author wuzph
 * @Date 2020/10/13 9:32
 */
@Component
public class CourseFilter extends LoginFilter {

    @Value("${user.edge.service.addr}")
    private String userEdgeServiceAddr;

    @Override
    protected void login(HttpServletRequest request, HttpServletResponse response, UserDTO userDTO) {
        //个性化登录的具体实现
        request.setAttribute("user",userDTO);
    }

    @Override
    protected String userEdgeServiceAddr() {
        return userEdgeServiceAddr;
    }
}
