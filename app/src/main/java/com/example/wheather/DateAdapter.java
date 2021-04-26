package com.example.wheather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DateAdapter extends  RecyclerView.Adapter<DateAdapter.DateHolder> {
    @NonNull
    private  OnClickWeather mOnclickWeather;
    private Context context;
    private int layout;
    private ArrayList<Date> dateArrayList;

    public DateAdapter(@NonNull Context context, int layout, ArrayList<Date> dateArrayList) {
        this.context = context;
        this.layout = layout;
        this.dateArrayList = dateArrayList;
    }

    @Override
    public DateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layout, parent, false);
        return new DateHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DateHolder holder, int position) {
        Date date = dateArrayList.get(position);
        int temp = Integer.parseInt(date.getDate());
        if(Integer.parseInt(date.getDate()) > 31){
            temp = temp - 31;
        }
        String string = date.getWeekday().substring(0,3) + " " + date.getMonth().substring(0,3) + " " + temp;
        holder.date.setText(string);
        String s = date.getHumidity() + "/ " + date.getTemp() + "°C";
        holder.temp.setText(s);
        holder.status.setImageResource(date.getStatus());
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnclickWeather != null) {
                    mOnclickWeather.onclick(holder.getAdapterPosition());
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return dateArrayList.size();
    }

    public static class DateHolder extends RecyclerView.ViewHolder {
        TextView date, temp;
        ImageView status;
        RelativeLayout linear;
        public DateHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.weekday);
            temp = itemView.findViewById(R.id.humidity);
            status = itemView.findViewById(R.id.status2);
            linear =  itemView.findViewById(R.id.linear1);
        }
    }
    public void setOnItemClickRecyclerView(OnClickWeather onItemClick){
        mOnclickWeather = onItemClick;
    }
}
