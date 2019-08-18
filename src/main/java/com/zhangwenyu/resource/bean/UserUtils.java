package com.zhangwenyu.resource.bean;

import java.util.Date;

public class UserUtils {
    private String uId;

    private String uName;

    private String uSex;

    private Date uBirth;

    private String uClass;

    private String uDesc;

    private String uLevel;


    public UserUtils() {
    }

    public UserUtils(String uId, String uName, String uSex, Date uBirth, String uClass, String uDesc, String uLevel) {
        this.uId = uId;
        this.uName = uName;
        this.uSex = uSex;
        this.uBirth = uBirth;
        this.uClass = uClass;
        this.uDesc = uDesc;
        this.uLevel = uLevel;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public Date getuBirth() {
        return uBirth;
    }

    public void setuBirth(Date uBirth) {
        this.uBirth = uBirth;
    }

    public String getuClass() {
        return uClass;
    }

    public void setuClass(String uClass) {
        this.uClass = uClass;
    }

    public String getuDesc() {
        return uDesc;
    }

    public void setuDesc(String uDesc) {
        this.uDesc = uDesc;
    }

    public String getuLevel() {
        return uLevel;
    }

    public void setuLevel(String uLevel) {
        this.uLevel = uLevel;
    }


    @Override
    public String toString() {
        return "UserUtils{" +
                "uId='" + uId + '\'' +
                ", uName='" + uName + '\'' +
                ", uSex='" + uSex + '\'' +
                ", uBirth=" + uBirth +
                ", uClass='" + uClass + '\'' +
                ", uDesc='" + uDesc + '\'' +
                ", uLevel='" + uLevel + '\'' +
                '}';
    }
}
