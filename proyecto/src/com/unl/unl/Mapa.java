package com.unl.unl;

import java.util.List;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.unl.unl.*;//unl.mapa.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;

public class Mapa extends MapActivity {

	private MapView mapView;
	private MapController myMapController;
	private List<Overlay> mOverlays;
	private MyLocationOverlay mOverlayLocation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.mapa);
		
		mapView = (MapView) findViewById(R.id.mapae);
        myMapController = mapView.getController();
        GeoPoint centro = new GeoPoint((int)( -3.99313 *1E6), (int)(-79.20422 * 1E6));
        myMapController.setCenter(centro);
        myMapController.setZoom(14);
        mOverlays = mapView.getOverlays();
        mOverlayLocation = new MyLocationOverlay(this, mapView);
        mOverlayLocation.enableMyLocation();
        mOverlayLocation.enableCompass();
        mOverlays.add(mOverlayLocation);
        mapView.postInvalidate();
  	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}
