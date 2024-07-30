package com.example.assignment.labassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private Context mContext;
    private List<Post> mPosts;

    public PostAdapter(Context context, List<Post> posts) {
        mContext = context;
        mPosts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.post_item
                , parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = mPosts.get(position);
        holder.titleTextView.setText(post.getTitle());
        holder.bodyTextView.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView bodyTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.post_title);
            bodyTextView = itemView.findViewById(R.id.post_body);
        }
    }
}