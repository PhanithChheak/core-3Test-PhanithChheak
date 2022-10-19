package com.phanith.core_3_phanithchheak

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class ExampleItem(
    val imageResource: Int = R.drawable.ic_baseline_1k_plus_24,
    val text1: String?,
    val text2: String?,
    val int1: Int,
    val int2: Int,
    val int3: Int
) : Parcelable, Serializable {

}
