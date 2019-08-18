package com.zhangwenyu.resource.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Teacher {
    private String teacherId;

    private String teacherName;

    private String teacherSex;

    @JSONField(format = "yyyy-MM-dd")
    private Date teacherBirth;

    private String teacherDesc;

    public Teacher() {
    }

    public Teacher(String teacherId, String teacherName, String teacherSex, Date teacherBirth, String teacherDesc) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSex = teacherSex;
        this.teacherBirth = teacherBirth;
        this.teacherDesc = teacherDesc;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex == null ? null : teacherSex.trim();
    }

    public Date getTeacherBirth() {
        return teacherBirth;
    }

    public void setTeacherBirth(Date teacherBirth) {
        this.teacherBirth = teacherBirth;
    }

    public String getTeacherDesc() {
        return teacherDesc;
    }

    public void setTeacherDesc(String teacherDesc) {
        this.teacherDesc = teacherDesc == null ? null : teacherDesc.trim();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSex='" + teacherSex + '\'' +
                ", teacherBirth=" + teacherBirth +
                ", teacherDesc='" + teacherDesc + '\'' +
                '}';
    }
}