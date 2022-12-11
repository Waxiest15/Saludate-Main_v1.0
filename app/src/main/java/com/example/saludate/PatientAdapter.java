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

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.MiViewHolder> implements View.OnClickListener {

    RecyclerView mRecyclerView;



    Context context;
    ArrayList<Paciente_Recycle> list;
    private View.OnClickListener listener;

    public PatientAdapter(Context context, ArrayList<Paciente_Recycle> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        mRecyclerView = recyclerView;
    }

    @NonNull
    @Override
    public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.pacientes_card, parent, false);

        v.setOnClickListener(this);

        return new MiViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull MiViewHolder holder, int position) {
        Paciente_Recycle paciente = list.get(position);
        holder.name.setText(paciente.getName());
        holder.age.setText(paciente.getAge());
        holder.bed.setText(paciente.getBed());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
    if (listener!=null){
        listener.onClick(v);
    }
    }

    public static class MiViewHolder extends RecyclerView.ViewHolder{

        TextView name, age, bed;

        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.txt_patientName);
            age=itemView.findViewById(R.id.txt_agePatient);
            bed=itemView.findViewById(R.id.txt_bedPatient);
        }
    }

    public void setPatientList(ArrayList<Paciente_Recycle> patients){
        this.list=patients;
        notifyDataSetChanged();
    }
}
