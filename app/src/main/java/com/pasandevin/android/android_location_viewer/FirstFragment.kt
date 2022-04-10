package com.pasandevin.android.android_location_viewer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pasandevin.android.android_location_viewer.database.AppDatabase
import com.pasandevin.android.android_location_viewer.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerView //
        binding.recyclerview.layoutManager = LinearLayoutManager(view.context)
        val db = AppDatabase.getDatabase(view.context)
        db.locationDao().getAll().observe(viewLifecycleOwner, {
            Log.d("FirstFragment", "onViewCreated: ${it.size}")
            binding.recyclerview.adapter = LocationAdapter(it)
        })
//        val photos = userAPIService.getPhotos()
//        Log.i("beforeenqueing", "before enqueing")
//        photos.enqueue(object:Callback<List<Photo>> {
//            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
//                val photos = response.body()
//                //Database//
//                val db = AppDatabase.getDatabase(view.context)
//                photos?.forEach() {
//                    db.photoDao().insert(it)
//                }
//                //Database//
//                val adapter = PhotoAdapter(photos!!)
////                binding.recyclerview.adapter = adapter
//            }
//
//            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }

//        })
        // RecyclerView //
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}