package com.ljr.mvc_mvp.mvc.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.ljr.mvc_mvp.R;
import com.ljr.mvc_mvp.mvc.Adapter.PersonAdapter;
import com.ljr.mvc_mvp.mvc.Bean.Person;
import com.ljr.mvc_mvp.mvc.Controller.PersonController;

import java.util.List;

public class MvcMainActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView mRvPerson;
    private Button mBtnAdd;
    private Button mBtnDelete;
    private PersonController mPersonController;
    private PersonAdapter mPersonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc_main);
        initView();

    }


    private void initView() {
        mRvPerson = (RecyclerView) findViewById(R.id.rv_person);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnDelete = (Button) findViewById(R.id.btn_delete);
        mBtnAdd.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        mPersonController = new PersonController();
        List<Person> list = mPersonController.query();
        mRvPerson.setLayoutManager(new LinearLayoutManager(this));
        mPersonAdapter = new PersonAdapter(this, list);
        mRvPerson.setAdapter(mPersonAdapter);
    }

    @Override
    public void onClick(View v) {
switch(v.getId()){
    case R.id.btn_add :
        mPersonController.add(new PersonController.onAddPersonListener() {
            @Override
            public void onComplete() {
                mPersonAdapter.notifyDataSetChanged();
                Toast.makeText(MvcMainActivity.this, "添加成功!!", Toast.LENGTH_SHORT).show();
            }
        });
           break;
    case R.id.btn_delete :
        mPersonController.delete(new PersonController.onDeletePersonListener() {
            @Override
            public void onComplete() {
                mPersonAdapter.notifyDataSetChanged();
                Toast.makeText(MvcMainActivity.this, "删除成功!!", Toast.LENGTH_SHORT).show();
            }
        });
        break;
    default:
           break;
}
    }
}
