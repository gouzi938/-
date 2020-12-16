package com.example.ag_tiku_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RlvAdapter extends RecyclerView.Adapter {
    private List<Bean.ResultsBean> data;
    private Context context;

    public RlvAdapter(List<Bean.ResultsBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View one = LayoutInflater.from(context).inflate(R.layout.layout_item1, parent, false);
            return new OneHolder(one);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            OneHolder holder1 = (OneHolder) holder;
            Glide.with(context).load(data.get(position).getUrl()).into(holder1.iv_img1);
            holder1.tv_text1.setText(data.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public static
    class OneHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_img1;
        public TextView tv_text1;

        public OneHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_img1 = (ImageView) rootView.findViewById(R.id.iv_img1);
            this.tv_text1 = (TextView) rootView.findViewById(R.id.tv_text1);
        }

    }

}
