package com.pasandevin.android.android_location_viewer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pasandevin.android.android_location_viewer.database.AppDatabase
import com.pasandevin.android.android_location_viewer.databinding.FragmentSecondBinding
import com.pasandevin.android.android_location_viewer.model.Location

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.inputlocationname.setOnClickListener {
            binding.inputlocationname.text.clear()
        }
        binding.inputlattitude.setOnClickListener {
            binding.inputlattitude.text.clear()
        }
        binding.inputlongitude.setOnClickListener {
            binding.inputlongitude.text.clear()
        }

        binding.submitbutton.setOnClickListener {
//            val locationName = binding.inputlocationname.text.toString()
//            val lattitude = binding.inputlattitude.text.toString().toDouble()
//            val longitude = binding.inputlongitude.text.toString().toDouble()
//            val location = Location(locationName, lattitude, longitude)

            //testing
            val locationName = "test2"
            val lattitude = 0.0
            val longitude = 0.0
            val location = Location(locationName, lattitude, longitude)
            //testing
            val db = AppDatabase.getDatabase(view.context)
            db.LocationDao().insert(location)
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}