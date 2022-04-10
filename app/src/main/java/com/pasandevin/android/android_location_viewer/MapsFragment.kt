package com.pasandevin.android.android_location_viewer

import android.R.attr.defaultValue
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.pasandevin.android.android_location_viewer.database.AppDatabase


class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->


        var sharedPref : SharedPreferences = activity!!.getPreferences(Context.MODE_PRIVATE)
        val locationLat = sharedPref.getFloat("latitudeKey", 44.34f)
        val locationLng = sharedPref.getFloat("longitudeKey", 32.34f)
        val locationName = sharedPref.getString("nameKey", "location")
        val location = LatLng(locationLat.toDouble(), locationLng.toDouble())

        googleMap.addMarker(MarkerOptions().position(location).title(locationName))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(location))


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}