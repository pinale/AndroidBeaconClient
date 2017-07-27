package com.pinale.androidbeaconclient;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.IntegerRes;

/**
 * Created by a.pinato on 26/07/2017.
 */

//TODO: completare costruttore e altri campi utili
public class BeaconDto {
    public BeaconDto(String id, String name, Integer distance) {
        Id=id;
        Name=name;
        Distance=distance;
    }

    public String Id;
    public String Name;
    public String Description;
    public Image Pic;
    public Integer Distance;
    public Integer Field;
}
