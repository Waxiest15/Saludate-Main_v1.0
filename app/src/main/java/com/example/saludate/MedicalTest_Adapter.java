package com.example.saludate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MedicalTest_Adapter extends RecyclerView.Adapter<MedicalTest_Adapter.MiViewHolder>{


    Context context;
    ArrayList<MedicalTest_Object> list;

    public MedicalTest_Adapter(Context context, ArrayList<MedicalTest_Object> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MedicalTest_Adapter.MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.medicaltest_card, parent, false);
        return new MedicalTest_Adapter.MiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicalTest_Adapter.MiViewHolder holder, int position) {
        MedicalTest_Object test = list.get(position);
        holder.doc.setText(test.getDocument());
        holder.done.setText(test.getDone_by());
        holder.date.setText(test.getFecha());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MiViewHolder extends RecyclerView.ViewHolder{

        TextView doc, done, date;

        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            doc=itemView.findViewById(R.id.txt_medicalTest_re);
            done=itemView.findViewById(R.id.txt_doneBy_re);
            date=itemView.findViewById(R.id.txt_dateTest_re);
        }
    }

    public void setMedicicalTestList(ArrayList<MedicalTest_Object> medicalTest){
        this.list=medicalTest;
        notifyDataSetChanged();
    }
}
