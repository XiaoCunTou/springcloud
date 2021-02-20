package com.cloud.system.service.impl;

import com.cloud.system.domain.Course;
import com.cloud.system.mapper.CourseMapper;
import com.cloud.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl  implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public void save(Course course) {
        courseMapper.save(course);
    }

    @Override
    public void update(Course course) {
        courseMapper.update(course);
    }
}
