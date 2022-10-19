package com.phanith.core_3_phanithchheak

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ToastbarSnack: BottomSheetDialogFragment() {
    private lateinit var exampleItem: ExampleItem
    private lateinit var text1: TextView
    private lateinit var text2: TextView
    private lateinit var text3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            exampleItem = bundle.get("data") as ExampleItem
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var fragview = inflater.inflate(R.layout.toastbar_snack,container,false)
        text1 = fragview.findViewById(R.id.test_view_1)
        text2 = fragview.findViewById(R.id.test_view_2)
        text3 = fragview.findViewById(R.id.test_view_3)

        //set variables
        text1.text = exampleItem.text1
        text2.text = exampleItem.text2
        text3.text = "Added"

        return fragview
    }
}