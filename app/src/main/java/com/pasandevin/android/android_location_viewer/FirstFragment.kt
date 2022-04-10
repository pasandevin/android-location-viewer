package com.pasandevin.android.android_location_viewer


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pasandevin.android.android_location_viewer.R
import com.pasandevin.android.android_location_viewer.adapter.LocationAdapter
import com.pasandevin.android.android_location_viewer.database.AppDatabase
import com.pasandevin.android.android_location_viewer.databinding.FragmentFirstBinding
import com.pasandevin.android.android_location_viewer.listener.RecyclerItemClickListener


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

        val db = AppDatabase.getDatabase(view.context)
        binding.recyclerview.layoutManager = LinearLayoutManager(view.context)
        binding.recyclerview.adapter = LocationAdapter(db.LocationDao().getAll())

        val recyclerView: RecyclerView = binding.recyclerview
        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(
                context,
                recyclerView,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {
                        findNavController().navigate(R.id.action_FirstFragment_to_MapsFragment)
                    }

                    override fun onLongItemClick(view: View?, position: Int) {
                        // do whatever
                    }
                })
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}