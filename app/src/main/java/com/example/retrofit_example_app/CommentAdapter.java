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

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{
    private List<Comment> comments = new ArrayList<>();
    Context context;

    public CommentAdapter(List<Comment> comments, Context context) {
        this.comments = comments;
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
        Comment currentComment = comments.get(position);
        holder.postId.setText(String.valueOf(currentComment.getPostId()));
        holder.id.setText(String.valueOf(currentComment.getId()));
        holder.name.setText(String.valueOf(currentComment.getName()));
        holder.text.setText(String.valueOf(currentComment.getText()));
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView postId;
        private TextView id;
        private TextView name;
        private TextView email;
        private TextView text;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            postId = itemView.findViewById(R.id.text_view_userId);
            id = itemView.findViewById(R.id.text_view_id);
            name = itemView.findViewById(R.id.text_view_title);
            text = itemView.findViewById(R.id.text_view_text);
        }
    }
}
