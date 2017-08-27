package com.ljr.mvc_mvp.mvp.Model;

import com.ljr.mvc_mvp.mvp.Bean.Pet;

import java.util.List;

/**
 * Created by LinJiaRong on 2017/8/27.
 * TODO：模型抽象类： 对模型层的抽象
 */

public interface IPetModel {

    /**
     * 查询回调
     */
    interface onQueryListener {
        void onComplete(List<Pet> pets);
    }

    /**
     * 添加回调
     */
    interface onAddPetListener {
        void onComplete();
    }

    /**
     * 删除回调
     */
    interface onDeletePetListener {
        void onComplete();
    }

    /**
     * 查询操作
     *
     * @param listener
     */
    void query(onQueryListener listener);

    /**
     * 添加操作
     *
     * @param listener
     */
    void addPet(onAddPetListener listener);


    /**
     * 删除操作
     *
     * @param listener
     */
    void deletePet(onDeletePetListener listener);
}
