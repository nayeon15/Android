package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

   TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.hello);

        Retrofit client = new RetrofitClient().getInstance();
        Retrofitinterface retrofitinterface = client.create(Retrofitinterface.class);

        Call<User> call = retrofitinterface.getUser();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User result = response.body();
                textView.setText(result.getData().getEmail());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                makeFailToast();
            }
        });


    }
    void makeFailToast(){
        Toast.makeText(this,"server connection failed", Toast.LENGTH_LONG).show();
    }
}