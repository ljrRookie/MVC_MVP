package com.ljr.mvc_mvp.mvp.Adapter;

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
import com.ljr.mvc_mvp.mvp.Bean.Pet;

import java.util.List;

/**
 * Created by LinJiaRong on 2017/8/27.
 * TODO：
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {

    private final List<Pet> mList;
    private final Context mContext;

    public PetAdapter(Context context, List<Pet> list) {
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
        Pet pet = mList.get(position);
        holder.mTv.setText(pet.getName());
        Glide.with(mContext).load(pet.getImgs()).into(holder.mIv);
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
