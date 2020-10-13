package com.wzp.course.filter;

import com.wzp.thrift.user.dto.UserDTO;
import com.wzp.user.client.LoginFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CourseFilter
 * @Description TODO
 * @Author wuzph
 * @Date 2020/10/13 9:32
 */

public class CourseFilter extends LoginFilter {
    @Override
    protected void login(HttpServletRequest request, HttpServletResponse response, UserDTO userDTO) {
        //个性化登录的具体实现
        request.setAttribute("user",userDTO);
    }
}
