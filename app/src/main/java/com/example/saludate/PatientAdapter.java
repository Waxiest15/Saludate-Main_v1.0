package com.example.saludate;

import static com.example.saludate.R.id.txt_patientName;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.MiViewHolder> {

    Context context;
    ArrayList<Paciente_Recycle> list;

    public PatientAdapter(Context context, ArrayList<Paciente_Recycle> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.pacientes_card, parent, false);
        return new MiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiViewHolder holder, int position) {
        Paciente_Recycle paciente = list.get(position);
        holder.name.setText(paciente.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MiViewHolder extends RecyclerView.ViewHolder{

        TextView name;

        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.txt_patientName);
        }
    }

    public void setPatientList(ArrayList<Paciente_Recycle> patients){
        this.list=patients;
        notifyDataSetChanged();
    }
}
