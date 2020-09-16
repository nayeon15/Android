package com.example.kakaotalklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View view) {
        Intent intent = new Intent(this, ClickActivity.class);
        EditText email = (EditText) findViewById(R.id.kakao_email);
        EditText password = (EditText) findViewById(R.id.kakao_password);

        String getemail = email.getText().toString();
        String getpassword = password.getText().toString();

        if (getemail.equals("nayeonvita@naver.com") && getpassword.equals("1234")) {
            startActivity(intent);
        }
        else Toast.makeText(this,"로그인 정보가 다릅니다.", Toast.LENGTH_LONG).show();


    }}