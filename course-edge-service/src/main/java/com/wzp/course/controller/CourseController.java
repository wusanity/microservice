package com.wzp.course.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wzp.course.dto.CourseDTO;
import com.wzp.course.service.ICourseService;
import com.wzp.thrift.user.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName CourseController
 * @Description TODO
 * @Author wuzph
 * @Date 2020/10/13 9:24
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    //dubbo特有注解，用于将接口注入进来
    @Reference
    private ICourseService courseService;

    @RequestMapping(value = "/courseList", method = RequestMethod.GET)
    @ResponseBody
    public List<CourseDTO> cousreList(HttpServletRequest request) {

        UserDTO user = (UserDTO) request.getAttribute("user");
        System.out.println(user.toString());
        return courseService.courseList();
    }
}
