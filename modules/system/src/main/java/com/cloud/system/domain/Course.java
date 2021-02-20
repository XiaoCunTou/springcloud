package com.cloud.system.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Course {

    private String courseId;
    private String courseName;
    private String courseType;
    private String zoneId;
    private String serverIp;
}
