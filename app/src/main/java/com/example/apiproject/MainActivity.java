package com.example.apiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        apiInterface = Retrofitinstance.getRetrofit().create(ApiInterface.class);
        apiInterface.getpost().enqueue(new Callback<List<post_pojo>>() {
            @Override
            public void onResponse(Call<List<post_pojo>> call, Response<List<post_pojo>> response) {
                List<post_pojo> postlist = response.body();
                if(response.body().size() > 0){

                    Adapter a = new Adapter(MainActivity.this,postlist);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(a);
                    Toast.makeText(MainActivity.this, "List is not Empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "List is Empty", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<post_pojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}