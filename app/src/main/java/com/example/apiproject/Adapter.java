package com.example.apiproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {

    private List<post_pojo> datalist;
    private Context context;
    public Adapter(Context context,List<post_pojo> datalist){
        this.context = context;
        this.datalist = datalist;
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView titles,posts;

         CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            titles = itemView.findViewById(R.id.Title);
            posts = itemView.findViewById(R.id.body);
        }
    }

    @NonNull
    @Override
    public Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.design,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.CustomViewHolder holder, int position) {
        holder.titles.setText(datalist.get(position).getTitle());
        holder.posts.setText(datalist.get(position).getBody());

    }



    @Override
    public int getItemCount() {
        return datalist.size();
    }
    }



