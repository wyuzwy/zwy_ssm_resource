package com.zhangwenyu.resource.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Student {
    private String studentId;

    private String studentName;

    private String studentSex;

    @JSONField(format = "yyyy-MM-dd")
    private Date studentBirth;

    private String studentClass;

    private String studentDesc;

    public Student() {
    }

    public Student(String studentId, String studentName, String studentSex, Date studentBirth, String studentClass, String studentDesc) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.studentBirth = studentBirth;
        this.studentClass = studentClass;
        this.studentDesc = studentDesc;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex == null ? null : studentSex.trim();
    }

    public Date getStudentBirth() {
        return studentBirth;
    }

    public void setStudentBirth(Date studentBirth) {
        this.studentBirth = studentBirth;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass == null ? null : studentClass.trim();
    }

    public String getStudentDesc() {
        return studentDesc;
    }

    public void setStudentDesc(String studentDesc) {
        this.studentDesc = studentDesc == null ? null : studentDesc.trim();
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", studentBirth=" + studentBirth +
                ", studentClass='" + studentClass + '\'' +
                ", studentDesc='" + studentDesc + '\'' +
                '}';
    }
}