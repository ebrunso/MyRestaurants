package com.example.myrestaurants

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val geocoder = Geocoder(this)

        // Add a marker in Sydney and move the camera
        val marietta = LatLng(33.955117, -84.536290)
        val riosSteakhouseLatLng = LatLng(33.921262,-84.466279)
        val chickfilaLatLng = LatLng(33.878026, -84.532994)
        val cookoutLatLng = LatLng(33.861423, -84.598328)
        val krispykremeLatLng = LatLng(33.846906, -84.497770)
        val wendysLatLng = LatLng(33.900588, -84.476595)


        mMap.addMarker(MarkerOptions().position(marietta).title("Marker in Marietta"))
        mMap.addMarker(MarkerOptions()
            .position(riosSteakhouseLatLng)
            .title(locateByReverseGeocoding(riosSteakhouseLatLng))
            .icon(BitmapDescriptorFactory
                .fromResource(R.drawable.rioslogo)))
        mMap.addMarker(MarkerOptions()
            .position(chickfilaLatLng)
            .title(locateByReverseGeocoding(chickfilaLatLng))
            .icon(BitmapDescriptorFactory
                .fromResource(R.drawable.cfalogo)))
        mMap.addMarker(MarkerOptions()
            .position(cookoutLatLng)
            .title(locateByReverseGeocoding(cookoutLatLng))
            .icon(BitmapDescriptorFactory
                .fromResource(R.drawable.cookoutlogo)))
        mMap.addMarker(MarkerOptions()
            .position(krispykremeLatLng)
            .title(locateByReverseGeocoding(krispykremeLatLng))
            .icon(BitmapDescriptorFactory
                .fromResource(R.drawable.krispykremelogo)))
        mMap.addMarker(MarkerOptions()
            .position(wendysLatLng)
            .title(locateByReverseGeocoding(wendysLatLng))
            .icon(BitmapDescriptorFactory
                .fromResource(R.drawable.wendyslogo)))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(marietta))

    }

    private fun locateByReverseGeocoding(latLng: LatLng) : String {
        val geocoder = Geocoder(this)
        val results = geocoder.getFromLocation(
            latLng.latitude, latLng.longitude, 1)

        return results[0].getAddressLine(0).toString()
    }
}
