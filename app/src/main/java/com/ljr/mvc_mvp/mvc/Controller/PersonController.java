package com.ljr.mvc_mvp.mvc.Controller;

import com.ljr.mvc_mvp.R;
import com.ljr.mvc_mvp.mvc.Bean.Person;
import com.ljr.mvc_mvp.mvc.Model.PersonModel;

import java.util.List;

/**
 * Created by LinJiaRong on 2017/8/27.
 * TODO：控制层：处理业务逻辑，调用Model的操作，并对外暴露接口
 */

public class PersonController {
    private PersonModel mPersonModel;
    public PersonController() {
        mPersonModel = new PersonModel();
    }
   // 添加成功的回调接口
    public interface onAddPersonListener {
        void onComplete();
    }
   // 删除成功的回调接口
    public interface onDeletePersonListener {
        void onComplete();
    }
    //添加操作
    public void add(onAddPersonListener listener) {
        mPersonModel.addPerson(R.drawable.e, "空中飞舞的屁");
        if (listener != null) {
            listener.onComplete();
        }
    }
   // 删除操作
    public void delete(onDeletePersonListener listener) {
        if(mPersonModel.query().isEmpty()){
            return;
        }else{
            mPersonModel.deletePerson();
        }
        if (listener != null) {
            listener.onComplete();
        }
    }
    //查询所有操作
    public List<Person> query() {
        return mPersonModel.query();
    }
}

