package com.pinale.androidbeaconclient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a.pinato on 27/07/2017.
 */

public class BeaconScanner {
    public List<BeaconDto> Scan()
    {
        List<BeaconDto> beacons = new ArrayList<BeaconDto>() ;
        beacons.add(new BeaconDto("f5d6sf565fds6fds5fd5s6f","Beacon 1",2));
        beacons.add(new BeaconDto("dfg87dfvd78t7dt8fg7dfg8","Beacon 2",5));
        beacons.add(new BeaconDto("75nv7svudt7vdu7vduds7su","Beacon 3",1));
        beacons.add(new BeaconDto("hdfugufg7gdfg7f7g77fgg7","Beacon 4",2));
        beacons.add(new BeaconDto("454g5hg4hg54hg5ghghggh4","Beacon 5",2));
        beacons.add(new BeaconDto("4v4hvhfg3h5gh5gvwjhgjhg","Beacon 6",4));
        beacons.add(new BeaconDto("fgifgufidnuviudfigu5nj4","Beacon 7",9));
        beacons.add(new BeaconDto("999bfdfgdgdfgd444vsvssv","Beacon 8",11));
        return beacons;
    }


    public List<String> Dacancellare()
    {
        List<String> beacons = new ArrayList<String>() ;
        beacons.add("f5d6sf565fds6fds5fd5s6f");
        beacons.add("f5d6sf565fds6fds5fd5s6f");
        return beacons;
    }

}

