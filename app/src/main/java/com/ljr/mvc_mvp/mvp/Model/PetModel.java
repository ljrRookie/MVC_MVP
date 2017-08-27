package com.ljr.mvc_mvp.mvp.Model;

import com.ljr.mvc_mvp.R;
import com.ljr.mvc_mvp.mvp.Bean.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LinJiaRong on 2017/8/27.
 * TODO：模型实现类 ： 对模型层的实现
 */

public class PetModel implements IPetModel {
    private static List<Pet> list = new ArrayList<>();

    /**
     * 本地模拟数据库
     */
    static {
        list.add(new Pet(R.drawable.cat, "懵逼傻猫"));
        list.add(new Pet(R.drawable.dog, "空中飞舞的二哈"));
        list.add(new Pet(R.drawable.pig, "亲亲猪"));
        list.add(new Pet(R.drawable.m, "鼠来宝主角"));
        list.add(new Pet(R.drawable.n, "皮皮龙"));
        list.add(new Pet(R.drawable.cat, "懵逼傻猫"));
        list.add(new Pet(R.drawable.dog, "空中飞舞的二哈"));
        list.add(new Pet(R.drawable.pig, "亲亲猪"));
        list.add(new Pet(R.drawable.m, "鼠来宝主角"));
        list.add(new Pet(R.drawable.n, "皮皮龙"));

    }

    @Override
    public void query(onQueryListener listener) {
        if (listener != null) {
            listener.onComplete(list);
        }
    }

    @Override
    public void addPet(onAddPetListener listener) {
        list.add(new Pet(R.drawable.l, "贵族草泥马"));
        if (listener != null) {
            listener.onComplete();
        }
    }

    @Override
    public void deletePet(onDeletePetListener listener) {
        if (list.size() > 0) {
            list.remove(list.size() - 1);
        }
        if(listener != null){
            listener.onComplete();
        }
    }
}
