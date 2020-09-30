package com.example.retrofit_example_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{
    private List<Post> posts = new ArrayList<>();
    Context context;

    public PostAdapter(List<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post currentPost = posts.get(position);
        holder.UserId.setText(String.valueOf(currentPost.getUserId()));
        holder.id.setText(String.valueOf(currentPost.getId()));
        holder.title.setText(String.valueOf(currentPost.getTitle()));
        holder.text.setText(String.valueOf(currentPost.getText()));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView UserId;
        private TextView id;
        private TextView title;
        private TextView text;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            UserId = itemView.findViewById(R.id.text_view_userId);
            id = itemView.findViewById(R.id.text_view_id);
            title = itemView.findViewById(R.id.text_view_title);
            text = itemView.findViewById(R.id.text_view_text);
        }
    }
}
