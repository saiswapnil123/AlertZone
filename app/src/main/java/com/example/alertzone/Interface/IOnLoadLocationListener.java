package com.example.alertzone.Interface;

import com.example.alertzone.myLatLng;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public interface IOnLoadLocationListener {
    void onLoadLocationSuccess(List<myLatLng> latLngs);
    void onLoadLocationFailed(String message);
}
