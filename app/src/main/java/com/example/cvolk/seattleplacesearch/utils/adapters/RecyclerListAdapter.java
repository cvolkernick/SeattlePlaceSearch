package com.example.cvolk.seattleplacesearch.utils.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.cvolk.seattleplacesearch.R;
import com.example.cvolk.seattleplacesearch.model.VenuesItem;

import java.util.List;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ViewHolder> {

    List<VenuesItem> venues;

    public RecyclerListAdapter(List<VenuesItem> venues) { this.venues = venues; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.search_result_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VenuesItem venuesItem = venues.get(position);

        // bind views with data
        holder.tvName.setText(venuesItem.getName());
    }

    @Override
    public int getItemCount() {
        return venues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
