package com.telkomuniversity.iflab.spriflab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemHolder>{

    private ArrayList<BookingInfo> listData = new ArrayList<>();
    private Context activityContext;

    public RecyclerViewAdapter(Context context, ArrayList<BookingInfo> listData) {
        this.listData = listData;
        activityContext = context;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private TextView tvNim, tvNama, tvNohp;
        private LinearLayout parentLayout;

        public ItemHolder(View itemView) {
            super(itemView);
            tvNim = itemView.findViewById(R.id.tvNIM);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNohp = itemView.findViewById(R.id.tvNohp);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }

    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_tabel_list, parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.tvNim.setText(listData.get(position).getNim());
        holder.tvNama.setText(listData.get(position).getNama());
        holder.tvNohp.setText(listData.get(position).getNohp());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activityContext, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


}
