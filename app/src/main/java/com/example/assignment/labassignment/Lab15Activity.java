package com.example.assignment.labassignment;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Lab15Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private List<Post> postList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab15);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postList = new ArrayList<>();

        JsonPlaceholderApi apiService = ApiClient.getClient().create(JsonPlaceholderApi.class);

        // Fetch posts
//        apiService.getPosts().enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    postAdapter = new PostAdapter(Lab15Activity
//                            .this, response.body());
//                    recyclerView.setAdapter(postAdapter);
//                } else {
//                    Toast.makeText(Lab15Activity.this, "Failed to get posts", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                Toast.makeText(Lab15Activity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
//                Log.e("MainActivity", "Error: " + t.getMessage(), t);
//            }
//        });
        apiService.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Extract only the first 20 posts
                    postList.addAll(response.body().subList(0, Math.min(20, response.body().size())));
                    postAdapter = new PostAdapter(Lab15Activity.this, postList);
                    recyclerView.setAdapter(postAdapter);
                } else {
                    Toast.makeText(Lab15Activity.this, "Failed to get posts", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(Lab15Activity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Lab15Activity", "Error: " + t.getMessage(), t);
            }
        });


//        Post post = new Post(1, "New Post Title", "New Post Body");
//        apiService.createPost(post).enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    Toast.makeText(Lab15Activity.this, "Post created with ID: " + response.body().getId(), Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(Lab15Activity.this, "Failed to create post", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//                Toast.makeText(Lab15Activity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
//                Log.e("MainActivity", "Error: " + t.getMessage(), t);
//            }
//        });
        Post post = new Post(1, "New Post Title", "New Post Body");
        apiService.createPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful() && response.body() != null) {
                    postList.add(0, response.body());
                    postAdapter.notifyItemInserted(0);
                    recyclerView.scrollToPosition(0);
                    Toast.makeText(Lab15Activity.this, "Post created with ID: " + response.body().getId(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Lab15Activity.this, "Failed to create post", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(Lab15Activity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Lab15Activity", "Error: " + t.getMessage(), t);
            }
        });
    }
}