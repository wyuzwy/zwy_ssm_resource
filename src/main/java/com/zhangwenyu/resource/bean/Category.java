package com.zhangwenyu.resource.bean;

public class Category extends CategoryKey {
    private String categoryDesc;

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc == null ? null : categoryDesc.trim();
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryDesc='" + categoryDesc + '\'' +
                '}';
    }
}