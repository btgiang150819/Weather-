package com.example.wheather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class TimeAdapter extends  RecyclerView.Adapter<TimeAdapter.TimeHolder>{
    private final Context context;

    public TimeAdapter(Context context, int layout, ArrayList<Time> timeArrayList) {
        this.context = context;
        this.layout = layout;
        this.timeArrayList = timeArrayList;
    }

    private final int layout;
    ArrayList<Time> timeArrayList;
    @NonNull
    @Override
    public TimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layout, parent, false);
        return new TimeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeHolder holder, int position) {
        Time time = timeArrayList.get(position);
        Calendar c = Calendar.getInstance();
        int temp = c.get(Calendar.HOUR_OF_DAY);
        if(time.getHour() == temp){
            String  string = "Now";
            holder.hour.setText(string);
        }
        else if(time.getHour() > 12){
            String string = (time.getHour() - 12) + "pm";
            holder.hour.setText(string);
        }
        else {
            String string = time.getHour() + "am";
            holder.hour.setText(string);
        }
        holder.status.setImageResource(time.getStatus());
        String string = time.getTemp() + " °C";
        holder.temp.setText(string);
    }

    @Override
    public int getItemCount() {
        return timeArrayList.size();
    }

    public static class TimeHolder extends RecyclerView.ViewHolder {
        TextView hour, temp;
        ImageView status;
        public TimeHolder(@NonNull View itemView) {
            super(itemView);
            hour = itemView.findViewById(R.id.time1);
            temp = itemView.findViewById(R.id.temp);
            status = itemView.findViewById(R.id.status);
        }
    }
}
