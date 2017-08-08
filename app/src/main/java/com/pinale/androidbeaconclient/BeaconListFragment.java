package com.pinale.androidbeaconclient;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by a.pinato on 29/07/2017.
 */

public class BeaconListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    IFragmentCommunicator  fragcom;

    Context ctx = getActivity();  // i fragment non hanno un contesto, lo recuperdo dalla parent activity

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beaconlist,
                container, false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null)
        {
            String link = bundle.getString("itemname");
        }
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ctx = getActivity();
        fragcom = (IFragmentCommunicator)  ctx;

        Bundle bundle = getArguments();

        BeaconScanner bs = new BeaconScanner();
        List<BeaconDto> beacons = bs.Scan();
        LoadList(beacons);

        if (bundle != null) {
            String link = bundle.getString("itemname");
            //LoadList(link);
        }

        //test
        Toast.makeText(getActivity(),"cioane proprio!",Toast.LENGTH_SHORT).show();

    }

    public void LoadList(List<BeaconDto> beacons) {
        //TextView view = (TextView) getView().findViewById(R.id.detailsText);
        //view.setText(url);

        recyclerView = (RecyclerView) getView().findViewById(R.id.my_recycler_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(ctx);  // in un activity era "this"
        recyclerView.setLayoutManager(mLayoutManager);


        //BeaconScanner bs = new BeaconScanner();

        //List<String> input = bs.Dacancellare();
        //List<BeaconDto> beacons = bs.Scan();

        mAdapter = new BeaconListAdapter(beacons, fragcom);
        recyclerView.setAdapter(mAdapter);
    }

}
