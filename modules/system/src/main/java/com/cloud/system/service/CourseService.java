package com.cloud.system.service;

import com.cloud.system.domain.Course;

public interface CourseService {

    void save(Course course);
    void update(Course course);
}
