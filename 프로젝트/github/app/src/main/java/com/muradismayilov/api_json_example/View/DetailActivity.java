package com.muradismayilov.api_json_example.View;

import android.content.Intent;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.muradismayilov.api_json_example.Model.Pojo.GitHubRepo;
import com.muradismayilov.api_json_example.R;

public class DetailActivity extends AppCompatActivity {

    private TextView mName, mDescription, mLanguage, mCreated, mStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final Button buttonSearch = (Button) findViewById(R.id.webButton);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        configViews();

        mName.setText(bundle.getString("name"));
        mDescription.setText(bundle.getString("description"));
        mLanguage.setText(bundle.getString("language"));
        mCreated.setText(bundle.getString("created"));
        mStars.setText(bundle.getString("stars"));

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(bundle.getString("htmlUrl")));
                startActivity(myIntent);
            }
        });

    }

    private void configViews() {
        mName = (TextView) findViewById(R.id.repoName);
        mDescription = (TextView) findViewById(R.id.repoDescription);
        mLanguage = (TextView) findViewById(R.id.repoLanguage);
        mCreated = (TextView) findViewById(R.id.repoCreated);
        mStars = (TextView) findViewById(R.id.repoStars);
    }
}