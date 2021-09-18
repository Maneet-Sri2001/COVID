package com.example.covid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class stateAdapter extends RecyclerView.Adapter<stateAdapter.ViewHolder> {

    private Context context;
    private List<stateModal> modalList;

    public stateAdapter(@NonNull Context context, List<stateModal> list) {
        this.context = context;
        this.modalList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null, true);
        return new stateAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final stateModal modal = modalList.get(position);
        holder.state.setText(modal.getStateName());
        holder.cases.setText(modal.getCases());
        holder.todcases.setText("Today : "+modal.getTodCases());
        holder.death.setText(modal.getDeath());
        holder.todDeath.setText("Today : "+modal.getToDeath());
        holder.rec.setText(modal.getRecovered());
        holder.todRec.setText("Today : "+modal.getTodRecovered());
    }

    @Override
    public int getItemCount() {
        return modalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView state, cases, todcases,  death, todDeath, rec, todRec;

        public ViewHolder(@NonNull View view) {
            super(view);

            state = view.findViewById(R.id.state_name);
            cases = view.findViewById(R.id.state_cases);
            todcases = view.findViewById(R.id.state_todcases);
            death = view.findViewById(R.id.state_death);
            todDeath = view.findViewById(R.id.state_toddeath);
            rec = view.findViewById(R.id.state_recovered);
            todRec = view.findViewById(R.id.state_todReco);

        }
    }
}
