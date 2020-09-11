package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

   TextView tv_lastname;
   TextView tv_firstname;
   TextView tv_email;
   TextView tv_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_lastname = findViewById(R.id.last_name);
        tv_firstname = findViewById(R.id.first_name);
        tv_email = findViewById(R.id.email);
        tv_id = findViewById(R.id.id);

        Retrofit client = new RetrofitClient().getInstance();
        Retrofitinterface retrofitinterface = client.create(Retrofitinterface.class);

//        Call<User> call = retrofitinterface.getUser();
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User result = response.body();
//                tv_firstname.setText(result.getData().getFirstName());
//                tv_lastname.setText(result.getData().getLastName());
//                tv_email.setText(result.getData().getEmail());
//                tv_id.setText(result.getData().getId()+"");
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                makeFailToast();
//            }
//        });
        //id:522

//        Call<Createresponse>call=retrofitinterface.createUser("undefined","programer");
//        call.enqueue(new Callback<Createresponse>() {
//            @Override
//            public void onResponse(Call<Createresponse> call, Response<Createresponse> response) {
//                Createresponse createresponse=response.body();
//                Log.d("qwerty","data"+response.body().getId());
//                tv_firstname.setText(createresponse.getId());
//                tv_lastname.setText(createresponse.getName());
//                tv_email.setText(createresponse.getCreatedAt());
//                tv_id.setText(createresponse.getId());
//            }
//
//            @Override
//            public void onFailure(Call<Createresponse> call, Throwable t) {
//                makeFailToast();
//            }
//        });

//        Call<Createresponse>call=retrofitinterface.updateUser("defined", "chicken");
//        call.enqueue(new Callback<Createresponse>() {
//            @Override
//            public void onResponse(Call<Createresponse> call, Response<Createresponse> response) {
//                Createresponse createresponse=response.body();
//                Log.d("qwerty","data"+response.body().getId());
//                tv_firstname.setText(createresponse.getJob());
//                tv_lastname.setText(createresponse.getName());
//            }
//
//            @Override
//            public void onFailure(Call<Createresponse> call, Throwable t) {
//                makeFailToast();
//            }
//        });

        Call<Void> call=retrofitinterface.deleteUser();
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("qwerty","code"+response.code());
                tv_email.setText(response.code()+"");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                makeFailToast();
            }
        });
    }
    void makeFailToast(){
        Toast.makeText(this,"server connection failed", Toast.LENGTH_LONG).show();
    }
}