package com.ljr.mvc_mvp.mvc.Model;

import com.ljr.mvc_mvp.R;
import com.ljr.mvc_mvp.mvc.Bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LinJiaRong on 2017/8/27.
 * TODO：Model层  --  对数据库的操作
 */
public class PersonModel {
    private static List<Person> list = new ArrayList<>();
     //模拟本地数据库
    static{
        list.add(new Person(R.drawable.a,"Nike 女"));
        list.add(new Person(R.drawable.b,"大头"));
        list.add(new Person(R.drawable.c,"蜡笔小新"));
        list.add(new Person(R.drawable.d,"黑色星期天"));
    }
    //添加操作
   public void addPerson(int imgs,String name){
       list.add(new Person(imgs,name));
   }
     //删除操作
   public void deletePerson(){
       list.remove(list.size()-1);
   }
     // 查询操作
   public List<Person> query(){
       return list;
   }

}
