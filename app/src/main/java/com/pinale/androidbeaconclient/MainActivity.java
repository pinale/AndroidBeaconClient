package com.pinale.androidbeaconclient;

//import android.graphics.Region;
import android.app.FragmentManager;
import android.os.RemoteException;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.Region;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BeaconConsumer, IFragmentCommunicator {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //beacon
    protected static final String TAG = "MonitoringActivity";
    private BeaconManager beaconManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Make sure this is before calling super.onCreate
        setTheme(R.style.AppTheme);  //ripristino il tema base (nel manifest era stato impostato quello con lo splash)

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Beacon - AltBeacon =============================
        /*
        beaconManager = BeaconManager.getInstanceForApplication(this);
        // To detect proprietary beacons, you must add a line like below corresponding to your beacon
        // type.  Do a web search for "setBeaconLayout" to get the proper expression.
        // beaconManager.getBeaconParsers().add(new BeaconParser().
        //        setBeaconLayout("m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25"));
        beaconManager.bind(this);
        //simulare beacon https://altbeacon.github.io/android-beacon-library/beacon_simulator.html
        // If you wish to test beacon detection in the Android Emulator, you can use code like this:
        BeaconManager.setBeaconSimulator(new TimedBeaconSimulator() );
        ((TimedBeaconSimulator) BeaconManager.getBeaconSimulator()).createTimedSimulatedBeacons();
        */
        //=================================================


        //Fake beacons
        //BeaconScanner bs = new BeaconScanner();
        //List<BeaconDto> beacons = bs.Scan();

        //Bundle args=new Bundle();
        //args.putString("itemname", "ciao");
        //beaconListFragment=new BeaconListFragment();
        //beaconListFragment.setArguments(args);


        // Add the fragment to the 'fragment_container' FrameLayout
        //getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, beaconListFragment).commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        beaconManager.unbind(this);
    }

    @Override
    public void onBeaconServiceConnect() {
        beaconManager.addMonitorNotifier(new MonitorNotifier() {
            @Override
            public void didEnterRegion(Region region) {
                Log.i(TAG, "I just saw an beacon for the first time!");
            }

            @Override
            public void didExitRegion(Region region) {
                Log.i(TAG, "I no longer see an beacon");
            }

            @Override
            public void didDetermineStateForRegion(int state, Region region) {
                Log.i(TAG, "I have just switched from seeing/not seeing beacons: "+state);
            }
        });

        try {
            beaconManager.startMonitoringBeaconsInRegion(new Region("myMonitoringUniqueId", null, null, null));
        } catch (RemoteException e) {    }
    }

    @Override
    public void HighlightBeaconOnMap(String beacon) {
        FragmentManager manager = getFragmentManager();
        MapFragment mapfrag = (MapFragment) manager.findFragmentById(R.id.mapFragment);
        mapfrag.HighlightBeacon(beacon);
    }
}
