package com.pinale.androidbeaconclient;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by a.pinato on 08/08/2017.
 */

public class MapFragment extends Fragment {
    TextView txtTest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map,
                container, false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        txtTest = (TextView) getActivity().findViewById(R.id.txtTest);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        txtTest = (TextView) getActivity().findViewById(R.id.txtTest);
    }

    //viene chiamato dall'implementazione dell'interfaccia (metodo HighlightBeaconOnMap in MainActivity)
    public void  HighlightBeacon(String beacon)
    {
        txtTest.setText(beacon);
    }
}
