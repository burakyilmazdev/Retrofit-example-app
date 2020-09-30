package com.example.retrofit_example_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public TextView UserId;
    public TextView Id;
    public TextView Title;
    public TextView Text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserId = findViewById(R.id.text_view_userId);
        Id = (TextView)findViewById(R.id.text_view_id);
        Title =(TextView) findViewById(R.id.text_view_title);
        Text =(TextView) findViewById(R.id.text_view_text);


        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);





        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>>  call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()){
                    Title.setText("Error");
                }

                List<Post> posts = response.body();



                final PostAdapter adapter = new PostAdapter(posts,MainActivity.this);
                recyclerView.setAdapter(adapter);






            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                System.out.println("hataa");

            }
        });



    }
}