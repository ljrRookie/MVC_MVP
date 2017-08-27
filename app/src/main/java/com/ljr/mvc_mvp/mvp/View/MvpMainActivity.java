package com.ljr.mvc_mvp.mvp.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ljr.mvc_mvp.R;
import com.ljr.mvc_mvp.mvc.Adapter.PersonAdapter;
import com.ljr.mvc_mvp.mvc.Bean.Person;
import com.ljr.mvc_mvp.mvp.Adapter.PetAdapter;
import com.ljr.mvc_mvp.mvp.Bean.Pet;
import com.ljr.mvc_mvp.mvp.Model.IPetModel;
import com.ljr.mvc_mvp.mvp.Presenter.PetPresenter;

import java.util.List;

/**
 * 视图类：对视图层的实现
 */
public class MvpMainActivity extends AppCompatActivity implements IPetView, View.OnClickListener {
    private TextView mTitle;
    private RecyclerView mRvPerson;
    private Button mBtnAdd;
    private Button mBtnDelete;
    private PetPresenter mPetPresenter;
    private PetAdapter mPetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc_main);
        initView();
    }

    private void initView() {
        mTitle = (TextView) findViewById(R.id.title);
        mTitle.setText("MVP");
        mRvPerson = (RecyclerView) findViewById(R.id.rv_person);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnDelete = (Button) findViewById(R.id.btn_delete);
        mBtnAdd.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);


        mPetPresenter = new PetPresenter(this);
        mPetPresenter.queryPet();
    }

    @Override
    public void onClick(View v) {
    switch(v.getId()){
        case R.id.btn_add :
            mPetPresenter.addPet();
               break;
        case R.id.btn_delete :
            mPetPresenter.deletePet();
            break;
        default:
               break;
    }
    }

    /**
     * 展示操作
     *
     * @param list
     */
    @Override
    public void showPet(List<Pet> list) {
        mPetAdapter = new PetAdapter(this, list);
        mRvPerson.setLayoutManager(new LinearLayoutManager(this));
        mRvPerson.setAdapter(mPetAdapter);

    }

    /**
     * 刷新操作
     */
    @Override
    public void refreshPet() {
        mPetAdapter.notifyDataSetChanged();
        mRvPerson.smoothScrollToPosition(mPetAdapter.getItemCount()-1);
    }
}
