package com.ljr.mvc_mvp.mvp.Presenter;

import com.ljr.mvc_mvp.mvp.Bean.Pet;
import com.ljr.mvc_mvp.mvp.Model.IPetModel;
import com.ljr.mvc_mvp.mvp.Model.PetModel;
import com.ljr.mvc_mvp.mvp.View.IPetView;

import java.util.List;

/**
 * Created by LinJiaRong on 2017/8/27.
 * TODO：中间者 ：绑定View层和Model层
 */

public class PetPresenter {
    private IPetModel mIPetModel;
    private IPetView mIPetView;

    public PetPresenter(IPetView petView) {
        mIPetModel = new PetModel();
        this.mIPetView = petView;
    }
    /**
     * 通过Model查询，在View中展示
     */
    public void queryPet(){
        mIPetModel.query(new IPetModel.onQueryListener() {
            @Override
            public void onComplete(List<Pet> pets) {
                mIPetView.showPet(pets);
            }
        });
    }
    /**
     * 通过Model添加，在View中更新
     */
    public void addPet(){
        mIPetModel.addPet(new IPetModel.onAddPetListener() {
            @Override
            public void onComplete() {
                mIPetView.refreshPet();
            }
        });
    }
    /**
     * 通过Model删除，在View中更新
     */
    public void deletePet(){
        mIPetModel.deletePet(new IPetModel.onDeletePetListener() {
            @Override
            public void onComplete() {
                mIPetView.refreshPet();
            }
        });
    }
}
