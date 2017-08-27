package com.ljr.mvc_mvp.mvp.Bean;

/**
 * Created by LinJiaRong on 2017/8/27.
 * TODO：
 */

public class Pet {
    private int imgs;
    private String name;

    public Pet(int imgs, String name) {
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
