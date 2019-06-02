package com.example.mysubmissionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.mysubmissionapp.CourseDetail.EXTRA_ADRESS;
import static com.example.mysubmissionapp.CourseDetail.EXTRA_NAME;
import static com.example.mysubmissionapp.CourseDetail.EXTRA_PHOTO;
import static com.example.mysubmissionapp.CourseDetail.EXTRA_DESCRIPTION;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Course> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);

        list = new ArrayList<>();
        list.addAll(CourseData.getListData());
        showRecyclerCardView();
    }


    public void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewCourseAdapter cardViewCourseAdapter = new CardViewCourseAdapter(this);
        cardViewCourseAdapter.setListCourse(list);
        rvCategory.setAdapter(cardViewCourseAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedCourse(list.get(position));
            }
        });
    }

    private void showSelectedCourse(Course course){
//        Toast.makeText(this, "Kamu Memilih " +course.getName(),Toast.LENGTH_SHORT).show();
        Intent courseDetail = new Intent(MainActivity.this, CourseDetail.class);
        courseDetail.putExtra(EXTRA_NAME, course.getName());
        courseDetail.putExtra(EXTRA_PHOTO, course.getPhoto());
        courseDetail.putExtra(EXTRA_DESCRIPTION,course.getDescription());
        courseDetail.putExtra(EXTRA_ADRESS, course.getAddress());
        startActivity(courseDetail);
    }
}
