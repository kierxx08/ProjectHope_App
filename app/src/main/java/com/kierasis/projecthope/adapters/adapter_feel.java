package com.kierasis.projecthope.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.kierasis.projecthope.R;
import com.kierasis.projecthope.models.adapterExt_feel;

import java.util.List;

public class adapter_feel extends RecyclerView.Adapter<adapter_feel.ViewHolder> {
    LayoutInflater inflater;
    List<adapterExt_feel> feel_list;
    private OnFeelListener mOnFeelListener;
    private Context mcontext;


    public adapter_feel(Context ctx, List<adapterExt_feel> feel_list, OnFeelListener onFeelListener){
        mcontext = ctx;
        this.inflater = LayoutInflater.from(ctx);
        this.feel_list = feel_list;
        this.mOnFeelListener = onFeelListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.feeling_layout,parent, false);
        return new ViewHolder(view, mOnFeelListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        /*
        Glide.with(mcontext)
                .load(feel_list.get(position).getString_01())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(holder.feel_image);

         */
        if(feel_list.get(position).getString_00().equals("ADD")){
            holder.add_cv.setVisibility(View.VISIBLE);
            holder.feel_cv.setVisibility(View.GONE);
        }else{
            String reaction = feel_list.get(position).getString_01();
            holder.feel_name.setText(reaction);
            holder.feel_month.setText(feel_list.get(position).getString_02());
            holder.feel_day.setText(feel_list.get(position).getString_03());
            if(reaction.equals("Great")){
                holder.feel_image.setImageResource(R.drawable.img_greatreaction);
                holder.feel_cv.setCardBackgroundColor(Color.parseColor("#FFCF26"));
            }else if(reaction.equals("Good")){
                holder.feel_image.setImageResource(R.drawable.img_goodreaction);
                holder.feel_cv.setCardBackgroundColor(Color.parseColor("#00BDAC"));
            }else if(reaction.equals("Okay")){
                holder.feel_image.setImageResource(R.drawable.img_okayreaction);
                holder.feel_cv.setCardBackgroundColor(Color.parseColor("#9196ce"));
            }else if(reaction.equals("Bad")){
                holder.feel_image.setImageResource(R.drawable.img_badreaction);
                holder.feel_cv.setCardBackgroundColor(Color.parseColor("#fe5561"));
            }else if(reaction.equals("Awful")){
                holder.feel_image.setImageResource(R.drawable.img_awfulreaction);
                holder.feel_cv.setCardBackgroundColor(Color.parseColor("#98777a"));
            }
        }



    }

    @Override
    public int getItemCount() {
        return feel_list.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView feel_name,feel_month, feel_day;
        ImageView feel_image;
        OnFeelListener onFeelListener;
        CardView add_cv, feel_cv;
        public ViewHolder(@NonNull View itemView, OnFeelListener onFeelListener) {
            super(itemView);

            feel_name = itemView.findViewById(R.id.text_feeling);
            feel_month = itemView.findViewById(R.id.text_month);
            feel_day = itemView.findViewById(R.id.text_day);
            feel_image = itemView.findViewById(R.id.feel_image);
            add_cv = itemView.findViewById(R.id.add_cardview);
            feel_cv = itemView.findViewById(R.id.feel_cardview);
            this.onFeelListener = onFeelListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onFeelListener.onFeelClick(getAdapterPosition());
        }
    }

    public interface  OnFeelListener{
        void onFeelClick(int position);
    }
}
