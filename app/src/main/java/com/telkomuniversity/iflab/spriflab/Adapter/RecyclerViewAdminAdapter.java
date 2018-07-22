package com.telkomuniversity.iflab.spriflab.Adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.telkomuniversity.iflab.spriflab.Model.BookingInfo;
import com.telkomuniversity.iflab.spriflab.R;

import java.util.ArrayList;

public class RecyclerViewAdminAdapter extends RecyclerView.Adapter<RecyclerViewAdminAdapter.ItemHolder>{

    private ArrayList<BookingInfo> listData;
    private Context activityContext;

    public RecyclerViewAdminAdapter(Context activityContext, ArrayList<BookingInfo> listData) {
        this.listData = listData;
        this.activityContext = activityContext;
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        private TextView tvNim, tvNama, tvNohp, tvStatus;
        private LinearLayout parentLayout;

        public ItemHolder(View itemView) {
            super(itemView);
            tvNim = itemView.findViewById(R.id.tvNIMAdmin);
            tvNama = itemView.findViewById(R.id.tvNamaAdmin);
            tvNohp = itemView.findViewById(R.id.tvNohpAdmin);
            tvStatus = itemView.findViewById(R.id.tvStatus);

            parentLayout = itemView.findViewById(R.id.parent_layout_admin);
        }
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_tabel_list_admin, parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemHolder holder, final int position) {
        holder.tvNim.setText(listData.get(position).getNim());
        holder.tvNama.setText(listData.get(position).getNama());
        holder.tvNohp.setText(listData.get(position).getNohp());

        if(listData.get(position).getStatus() == "ACCEPTED"){
            holder.tvStatus.setBackgroundColor(-11751600);
        } else if (listData.get(position).getStatus() == "REJECTED"){
            holder.tvStatus.setBackgroundColor(-105105105);
        }

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(activityContext, "Clicked", Toast.LENGTH_SHORT).show();

                if(holder.tvStatus.getBackground() instanceof ColorDrawable){
                    ColorDrawable cd = (ColorDrawable) holder.tvStatus.getBackground();
                    int colorCode = cd.getColor();

                    //Toast.makeText(activityContext, String.valueOf(colorCode), Toast.LENGTH_SHORT).show();

                    if(listData.get(position).getStatus() == "ACCEPTED"){
                        try {
                            holder.tvStatus.setBackgroundColor(-105105105);
                            listData.get(position).setStatus("REJECTED");
                            Toast.makeText(activityContext, holder.tvNim.getText() + "Status = " + listData.get(position).getStatus(),
                                    Toast.LENGTH_SHORT).show();
                        } catch (Exception e){
                            Toast.makeText(activityContext, "Exception detected", Toast.LENGTH_SHORT).show();
                        }
                    }else if(listData.get(position).getStatus() == "REJECTED"){
                        try {
                            holder.tvStatus.setBackgroundColor(-11751600);
                            listData.get(position).setStatus("ACCEPTED");
                            Toast.makeText(activityContext, holder.tvNim.getText() + "Status = " + listData.get(position).getStatus(),
                                    Toast.LENGTH_SHORT).show();
                        } catch(Exception e){
                            Toast.makeText(activityContext, "Exception detected", Toast.LENGTH_SHORT).show();
                        }
                    }

                    /*
                    if(colorCode == -11751600){
                        holder.tvStatus.setBackgroundColor(-105105105);
                    }else if(colorCode == -105105105){
                        holder.tvStatus.setBackgroundColor(-11751600);
                    }
                    */
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
