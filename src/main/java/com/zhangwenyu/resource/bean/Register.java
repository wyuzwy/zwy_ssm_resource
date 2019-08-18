package com.zhangwenyu.resource.bean;

public class Register {
    private String registerId;

    private String registerPassword;

    private String registerName;

    private String registerClass;

    private String registerLevel;

    private Integer registerCheck;

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId == null ? null : registerId.trim();
    }

    public String getRegisterPassword() {
        return registerPassword;
    }

    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword == null ? null : registerPassword.trim();
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName == null ? null : registerName.trim();
    }

    public String getRegisterClass() {
        return registerClass;
    }

    public void setRegisterClass(String registerClass) {
        this.registerClass = registerClass == null ? null : registerClass.trim();
    }

    public String getRegisterLevel() {
        return registerLevel;
    }

    public void setRegisterLevel(String registerLevel) {
        this.registerLevel = registerLevel == null ? null : registerLevel.trim();
    }

    public Integer getRegisterCheck() {
        return registerCheck;
    }

    public void setRegisterCheck(Integer registerCheck) {
        this.registerCheck = registerCheck;
    }


    @Override
    public String toString() {
        return "Register{" +
                "registerId='" + registerId + '\'' +
                ", registerPassword='" + registerPassword + '\'' +
                ", registerName='" + registerName + '\'' +
                ", registerClass='" + registerClass + '\'' +
                ", registerLevel='" + registerLevel + '\'' +
                ", registerCheck=" + registerCheck +
                '}';
    }
}