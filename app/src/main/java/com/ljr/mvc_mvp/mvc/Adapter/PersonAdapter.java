package com.ljr.mvc_mvp.mvc.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ljr.mvc_mvp.R;
import com.ljr.mvc_mvp.mvc.Bean.Person;
import com.ljr.mvc_mvp.mvc.View.MvcMainActivity;

import java.math.MathContext;
import java.util.List;

/**
 * Created by LinJiaRong on 2017/8/27.
 * TODO：
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private final List<Person> mList;
    private final Context mContext;

    public PersonAdapter(Context context, List<Person> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_person, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = mList.get(position);
        holder.mTv.setText(person.getName());
        Glide.with(mContext).load(person.getImgs()).into(holder.mIv);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIv;
        private TextView mTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mIv = (ImageView) itemView.findViewById(R.id.iv);
            mTv = (TextView) itemView.findViewById(R.id.tv);
        }
    }

}
