package com.ljr.mvc_mvp.mvp.View;

import com.ljr.mvc_mvp.mvp.Bean.Pet;

import java.util.List;

/**
 * Created by LinJiaRong on 2017/8/27.
 * TODO：视图类：对视图方法的抽象
 */

public interface IPetView {
    /**
     * 展示操作
     * @param list
     */
    void showPet(List<Pet> list);

    /**
     * 刷新操作
     */
    void refreshPet();
}
