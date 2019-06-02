package com.example.mysubmissionapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CourseDetail extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_PHOTO = "extra_photo";
    public static final String EXTRA_DESCRIPTION = "extra_description";
    public static final String EXTRA_ADRESS = "extra_adress";

    ImageView imgItemDetail;
    TextView tvItemDescription;
    Button btnSetStartCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        imgItemDetail = findViewById(R.id.img_item_detail);
        tvItemDescription = findViewById(R.id.tv_item_description);
        btnSetStartCourse = findViewById(R.id.btn_set_startcourse);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String description = getIntent().getStringExtra(EXTRA_DESCRIPTION);

        getSupportActionBar().setTitle(name);
        tvItemDescription.setText(description);

        String photo = getIntent().getStringExtra(EXTRA_PHOTO);
        Glide.with(this).load(photo).into(imgItemDetail);
    }

    public void onBrowseClick(View v){
        String url = getIntent().getStringExtra(EXTRA_ADRESS);
        Uri uri = Uri.parse(url);
        Intent setStartCourseIntent = new Intent(Intent.ACTION_VIEW, uri);
        if (setStartCourseIntent.resolveActivity(getPackageManager())!=null){
            startActivity(setStartCourseIntent);
        }
    }
}
