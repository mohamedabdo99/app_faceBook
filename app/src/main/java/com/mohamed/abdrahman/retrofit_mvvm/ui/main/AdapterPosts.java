package com.mohamed.abdrahman.retrofit_mvvm.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mohamed.abdrahman.retrofit_mvvm.R;
import com.mohamed.abdrahman.retrofit_mvvm.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;


public class AdapterPosts extends RecyclerView.Adapter<AdapterPosts.PostViewHolder> {

    List<PostModel> postList = new ArrayList<>();

    public void SetPost(List<PostModel> setPost) {
        this.postList = setPost;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position)
    {
        holder.titleTV.setText(postList.get(position).getTitle());
        holder.userIDTV.setText(postList.get(position).getUserId()+"");
        holder.bodyTV.setText(postList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV,userIDTV,bodyTV;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.titleTV);
            userIDTV = itemView.findViewById(R.id.userIDTV);
            bodyTV = itemView.findViewById(R.id.bodyTV);
        }
    }
}
