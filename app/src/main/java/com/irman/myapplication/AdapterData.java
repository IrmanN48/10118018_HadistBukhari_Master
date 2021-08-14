package com.irman.myapplication;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    List<DataModel> listData;
    LayoutInflater inflater;
    Context context;

    public AdapterData(Context context, List<DataModel> listData) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
        this.context  = context;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_data, parent, false);
        HolderData holderData = new HolderData(view);
        holderData.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, hadistActivity.class);
                i.putExtra("no_hadist",listData.get(holderData.getAbsoluteAdapterPosition()).getNo());
                i.putExtra("hadist",listData.get(holderData.getAbsoluteAdapterPosition()).getHadist());
                i.putExtra("terjermahan",listData.get(holderData.getAbsoluteAdapterPosition()).getTerjemahan());

                context.startActivity(i);
            }
        });
        return holderData;

    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.txt_noHadist.setText(listData.get(position).getNo());


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView txt_noHadist;
        LinearLayout view_container;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.linearLayout);
            txt_noHadist = itemView.findViewById(R.id.noHadist);


        }
    }
}
