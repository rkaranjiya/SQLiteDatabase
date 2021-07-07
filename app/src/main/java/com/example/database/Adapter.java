package com.example.database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private List<Data> datarow;
    public Adapter(List<Data>datarow) {

        this.datarow = datarow;

    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        String id = datarow.get(position).getTx1();
        String name = datarow.get(position).getTx2();
        Double salary = datarow.get(position).getTx3();
        holder.setDate(id,name,salary);

    }

    @Override
    public int getItemCount() {
        return datarow.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textView1,textView2,textView3;

        public ViewHolder(@NonNull final View itemView)
        {
            super(itemView);
            textView1 = itemView.findViewById(R.id.id);
            textView2 = itemView.findViewById(R.id.name);
            textView3 = itemView.findViewById(R.id.salary);

        }

        public void setDate(String id, String name, Double salary) {

            textView1.setText("ID: "+id);
            textView2.setText("Name: "+name);
            textView3.setText("Salary: "+salary+"₹");

        }
    }
}
