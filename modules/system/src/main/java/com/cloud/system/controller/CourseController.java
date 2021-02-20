package com.cloud.system.controller;

import com.cloud.system.domain.Course;
import com.cloud.system.service.CourseService;
import com.cloud.system.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;


@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("/save")
    public String save(Course course) throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        course.setServerIp(ip.getHostAddress());
        course.setCourseId(IdUtils.UUID());
        course.setCourseType("1");
        if(course.getCourseName()==null || course.getCourseName().trim().length()==0){
            course.setCourseName("moren");
        }
        course.setZoneId("610000");
        courseService.save(course);
        return "success";
    }

    @RequestMapping("/update")
    public String update(Course course) throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        course.setServerIp(ip.getHostAddress());
        courseService.update(course);
        return "success";
    }
}
