package com.ljr.mvc_mvp.mvc.Bean;

/**
 * Created by LinJiaRong on 2017/8/27.
 * TODO：
 */

public class Person {
    private int imgs;
    private String name;

    public Person(int imgs, String name) {
        this.imgs = imgs;
        this.name = name;
    }

    public int getImgs() {
        return imgs;
    }

    public void setImgs(int imgs) {
        this.imgs = imgs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
