package com.example.mysubmissionapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewCourseAdapter extends RecyclerView.Adapter<CardViewCourseAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<Course> listCourse;

    private ArrayList<Course> getListCourse(){
        return listCourse;
    }

    public CardViewCourseAdapter(Context context){
        this.context = context;
    }

    public void setListCourse(ArrayList<Course> listCourse){
        this.listCourse =listCourse;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_course, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {
        Course c = getListCourse().get(i);
        Glide.with(context)
                .load(c.getPhoto())
                .apply(new RequestOptions().override(350, 500))
                .into(cardViewHolder.imgPhoto);

        cardViewHolder.tvName.setText(c.getName());
        cardViewHolder.tvDetail.setText(c.getDetail());

        cardViewHolder.btnTakeCourse.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Anda Memilih Kelas "+getListCourse().get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public int getItemCount() {
        return getListCourse().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        Button btnTakeCourse;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnTakeCourse =  itemView.findViewById(R.id.btn_set_takecourse);
        }
    }
}
