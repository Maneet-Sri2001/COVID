package com.example.covid;

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

public class newsAdaptor extends RecyclerView.Adapter<newsAdaptor.ViewHolder> {

    private Context context;
    private List<newsModel> newsModelList;

    public newsAdaptor(Context context, List<newsModel> newsModelList) {
        this.context = context;
        this.newsModelList = newsModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news, null, true);
        return new newsAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final newsModel model = newsModelList.get(position);
        holder.des.setText(model.getTiltle());
        holder.auth.setText(model.getAuth());
        holder.pub.setText(model.getName());
        Glide.with(context).load(model.getImgUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return newsModelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView auth, des, pub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.news_img);
            des = itemView.findViewById(R.id.news_head);
            pub = itemView.findViewById(R.id.news_pub);
            auth = itemView.findViewById(R.id.news_auth);
        }
    }
}
