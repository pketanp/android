package com.example.termwork5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context c;
    String n[],p[];
    int i[];
    public RecyclerAdapter(Context context, String name[],String phNo[],int img[]){
        c=context;
        n=name;
        p=phNo;
        i=img;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(c);
        View view=inflater.inflate(R.layout.contacts,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namew.setText(n[position]);
        holder.phone.setText(p[position]);
        holder.imageView.setImageResource(i[position]);

    }

    @Override
    public int getItemCount() {
        return n.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView namew, phone;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namew=itemView.findViewById(R.id.titles);
            phone=itemView.findViewById(R.id.phoneno);
            imageView=itemView.findViewById(R.id.images);
        }
    }
}
