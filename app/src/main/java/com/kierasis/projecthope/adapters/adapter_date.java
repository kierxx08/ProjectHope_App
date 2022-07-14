package com.kierasis.projecthope.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.kierasis.projecthope.R;
import com.kierasis.projecthope.models.adapterExt_feel;

import java.util.List;

public class adapter_date extends RecyclerView.Adapter<adapter_date.ViewHolder> {
    LayoutInflater inflater;
    List<adapterExt_feel> date_list;
    private OnDateListener mOnDateListener;
    private Context mcontext;


    public adapter_date(Context ctx, List<adapterExt_feel> date_list, OnDateListener onDateListener){
        mcontext = ctx;
        this.inflater = LayoutInflater.from(ctx);
        this.date_list = date_list;
        this.mOnDateListener = onDateListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.date_layout,parent, false);
        return new ViewHolder(view, mOnDateListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        /*
        Glide.with(mcontext)
                .load(date_list.get(position).getString_01())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(holder.feel_image);

         */
        holder.date_month.setText(date_list.get(position).getString_02());
        holder.date_day.setText(date_list.get(position).getString_03());

        if(Integer.parseInt(date_list.get(position).getString_01())<=4){
            holder.date_name.setText("Normal");
            holder.date_ll.setBackgroundColor(Color.parseColor("#FFCF26"));

        }else if(Integer.parseInt(date_list.get(position).getString_01())<=9){
            holder.date_name.setText("Mild Depression");
            holder.date_ll.setBackgroundColor(Color.parseColor("#00BDAC"));

        }else if(Integer.parseInt(date_list.get(position).getString_01())<=14){
            holder.date_name.setText("Moderate Depression");
            holder.date_ll.setBackgroundColor(Color.parseColor("#9196ce"));

        }else if(Integer.parseInt(date_list.get(position).getString_01())<=19){
            holder.date_name.setText("Moderately Severe Depression");
            holder.date_ll.setBackgroundColor(Color.parseColor("#fe5561"));

        }else if(Integer.parseInt(date_list.get(position).getString_01())<=30){
            holder.date_name.setText("Severe Depression");
            holder.date_ll.setBackgroundColor(Color.parseColor("#d1643d"));

        }




    }

    @Override
    public int getItemCount() {
        return date_list.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView date_name,date_month, date_day;
        LinearLayout date_ll;
        //ImageView feel_image;
        OnDateListener onDateListener;
        //CardView add_cv, feel_cv;
        public ViewHolder(@NonNull View itemView, OnDateListener onDateListener) {
            super(itemView);

            date_ll = itemView.findViewById(R.id.list_01_img);
            date_name = itemView.findViewById(R.id.list_01_title);
            date_month = itemView.findViewById(R.id.list_01_month);
            date_day = itemView.findViewById(R.id.list_01_day);
            this.onDateListener = onDateListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onDateListener.onDateClick(getAdapterPosition());
        }
    }

    public interface  OnDateListener{
        void onDateClick(int position);
    }
}
