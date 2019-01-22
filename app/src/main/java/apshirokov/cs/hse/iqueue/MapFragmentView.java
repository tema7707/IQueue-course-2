package apshirokov.cs.hse.iqueue;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.here.android.mpa.common.Image;
import com.here.android.mpa.common.OnEngineInitListener;
import com.here.android.mpa.common.PositioningManager;
import com.here.android.mpa.mapping.Map;
import com.here.android.mpa.mapping.MapMarker;
import com.here.android.mpa.mapping.SupportMapFragment;

import java.io.File;
import java.io.IOException;


public class MapFragmentView {
    private SupportMapFragment m_mapFragment;
    private Map m_map;
    private MapMarker m_map_marker;
    private AppCompatActivity m_activity;


    public MapFragmentView(SupportMapFragment m_mapFragment, AppCompatActivity activity) {
        this.m_mapFragment = m_mapFragment;
        m_activity = activity;
        initMapFragment();
    }

    private void initMapFragment() {
        // Set path of isolated disk cache
        String diskCacheRoot = Environment.getExternalStorageDirectory().getPath()
                + File.separator + ".isolated-here-maps";
        // Retrieve intent name from manifest
        String intentName = "";
        try {
            ApplicationInfo ai = m_activity.getPackageManager().getApplicationInfo(m_activity.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            intentName = bundle.getString("INTENT_NAME");
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(this.getClass().toString(), "Failed to find intent name, NameNotFound: " + e.getMessage());
        }

        if (m_mapFragment != null) {
            /* Initialize the SupportMapFragment, results will be given via the called back. */
            m_mapFragment.init(new OnEngineInitListener() {
                @Override
                public void onEngineInitializationCompleted(OnEngineInitListener.Error error) {

                    if (error == Error.NONE) {
                        /*
                         * If no error returned from map fragment initialization, the map will be
                         * rendered on screen at this moment.Further actions on map can be provided
                         * by calling Map APIs.
                         */
                        m_map = m_mapFragment.getMap();

                        createMapMarker();

                        //PositioningManager posManager = PositioningManager.getInstance();
                        //posManager.start(PositioningManager.LocationMethod.GPS_NETWORK);
                        //m_map.setCenter(posManager.getPosition().getCoordinate(), Map.Animation.NONE);

                        // Display position indicator
                        m_map.getPositionIndicator().setVisible(true);
                    }
                }
            });
        }
    }


    /**
     * create a MapMarker and add the MapMarker to active map view.
     */
    public void createMapMarker() {
        // create an image from cafe.png.
        Image marker_img = new Image();
        try {
            marker_img.setImageResource(R.drawable.map_icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // create a MapMarker centered at current location with png image.
        m_map_marker = new MapMarker(m_map.getCenter(), marker_img);
        // add a MapMarker to current active map.
        m_map.addMapObject(m_map_marker);
    }
}
