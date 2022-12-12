package com.example.saludate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MiViewHolder>{

    Context context;
    ArrayList<Medicine_Object> list;

    public MedicineAdapter(Context context, ArrayList<Medicine_Object> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MedicineAdapter.MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.medicine_card, parent, false);
        return new MedicineAdapter.MiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineAdapter.MiViewHolder holder, int position) {
        Medicine_Object medicine = list.get(position);
        holder.dosis.setText(medicine.getDosis());
        holder.intervalos.setText(medicine.getIntervals());
        holder.name.setText(medicine.getName());
        holder.time.setText(medicine.getTime());
        holder.via.setText(medicine.getVia());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MiViewHolder extends RecyclerView.ViewHolder{

        TextView id, dosis, intervalos, name, time, via;

        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            dosis=itemView.findViewById(R.id.txt_medicineDosis_re);
            intervalos=itemView.findViewById(R.id.txt_mediceIntervals_re);
            name=itemView.findViewById(R.id.txt_medicineName_re);
            time=itemView.findViewById(R.id.txt_medicineTime_re);
            via=itemView.findViewById(R.id.txt_medicineVia_re);


        }
    }

    public void setMedicineList(ArrayList<Medicine_Object> medicine){
        this.list=medicine;
        notifyDataSetChanged();
    }
}
