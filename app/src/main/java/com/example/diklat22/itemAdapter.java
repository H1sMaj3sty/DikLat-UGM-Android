package com.example.diklat22;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {
    private Context context;
    private ArrayList<itemData> values;
    private LayoutInflater inflater;
    public itemAdapter(Context context, ArrayList<itemData> values){
        this.context=context;
        this.values=values;
        this.inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final itemData data = values.get(position);
        holder.titleText.setText(data.itemTitle);
        holder.subtitleText.setText(data.itemSubTitle);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Anda memilih data " + data.itemTitle, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                values.remove(data);
                notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView subtitleText;
        TextView titleText;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            titleText=itemView.findViewById(R.id.text);
            subtitleText=itemView.findViewById(R.id.text2);
        }
    }
}
