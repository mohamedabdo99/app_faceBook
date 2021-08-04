package com.mohamed.abdrahman.retrofit_mvvm.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mohamed.abdrahman.retrofit_mvvm.R;
import com.mohamed.abdrahman.retrofit_mvvm.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView_java;
    PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPosts();
        recyclerView_java = findViewById(R.id.recycle_view);
        AdapterPosts adapter = new AdapterPosts();
        recyclerView_java.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_java.setAdapter(adapter);

        postViewModel.postMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.SetPost(postModels);
            }
        });

    }
}