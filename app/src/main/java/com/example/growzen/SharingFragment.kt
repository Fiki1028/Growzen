package com.example.growzen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.growzen.Adapter.PostAdapter
import com.example.growzen.Model.ModelSharing


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SharingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SharingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var postAdapter: PostAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sharing, container, false)

        val postList = generateDummyData()
        postAdapter = PostAdapter(requireContext(), postList)

        recyclerView = view.findViewById(R.id.rv_post)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = postAdapter

        return view
    }

    private fun generateDummyData(): List<ModelSharing> {
        // You can replace this with your actual data retrieval logic
        val dummyList = mutableListOf<ModelSharing>()
        dummyList.add(ModelSharing(
            R.drawable.pp1, "Nayeon", "12 October 2023", "SDH mw 3 bulan minum oat, 2 mnggu trakhir ni dr pinggul sampai lutut nyeri trutama saat mw bangun dr tidur, trus kalau di kaki ditekuk itu nyeri skalii, ada yg sama gak,??\n" +
                "Tnggl 13 ni kntrol dahak dan ronsen doakan yha smoga hasilnya membaik", 10, 9))
        dummyList.add(ModelSharing(
            R.drawable.pp3, "Momo", "11 October 2023", "Halo. Saya mau tanya nih. Kemarin jadwal makan obat saya malam.\n" +
                "Tapi karena ketiduran jadi ingatnya pagi jam 5. Setelah itu sekarang keadaan saya persis seperti gejala awal. Mohon masukan bagi yg mengerti, apakah saya sudah kebal obat ya? "
            ,  20, 8))
        // Add more items as needed
        return dummyList
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SharingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SharingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}