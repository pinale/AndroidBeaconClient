package com.pinale.androidbeaconclient;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BeaconListAdapter extends RecyclerView.Adapter<BeaconListAdapter.ViewHolder> {
    private List<BeaconDto> values;
    private IFragmentCommunicator _fragcom;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        // each data item is just a string in this case
        public TextView txtName;
        public TextView txtId;
        public TextView txtDistance;
        public View layout;

        public ViewHolder(View v) {
            super(v);

            v.setOnClickListener(this);  //https://stackoverflow.com/questions/24471109/recyclerview-onclick

            layout = v;
            txtName = (TextView) v.findViewById(R.id.beaconname);
            txtId = (TextView) v.findViewById(R.id.beaconid);
            txtDistance = (TextView) v.findViewById(R.id.beacondistance);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "position = " + getPosition(), Toast.LENGTH_SHORT).show();
        }

    }

    public void add(int position, BeaconDto item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public BeaconListAdapter(List<BeaconDto> myDataset, IFragmentCommunicator fragcom) {
        values = myDataset;
        _fragcom = fragcom;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public BeaconListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //final String name = values.get(position);
        final BeaconDto dto = values.get(position);
        holder.txtName.setText(dto.Name);
        holder.txtName.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //remove(position);
                _fragcom.HighlightBeaconOnMap(dto.Name);
            }
        });

        holder.txtId.setText("ID: " + dto.Id);
        holder.txtDistance.setText(dto.Distance+ "m");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }
}