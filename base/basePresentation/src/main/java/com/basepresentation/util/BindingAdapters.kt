package com.basepresentation.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aapa.listener.recyclerview.BaseRecyclerViewBindableAdapter
import com.aapa.listener.recyclerview.BaseRecyclerViewContract

@BindingAdapter(
    value = ["adapter", "clickHandler", "data",
        "orientation", "reverseLayout"], requireAll = true
)
fun <A : RecyclerView.Adapter<*>,
        E, T>
        RecyclerView.setUpLinearRecyclerView(
    adapter: A,
    recyclerViewContract: BaseRecyclerViewContract.ClickHandler<E, T>,
    list: List<T>,
    orientation: Int,
    reverseLayout: Boolean

) {

    adapter?.safeCast<BaseRecyclerViewBindableAdapter<*, T>>()
        ?.setData(list)


//    applying this check bcs this function will be called mul times bcz of data updates
    if (this.adapter == null) {
        layoutManager = LinearLayoutManager(context, orientation, reverseLayout)

        adapter.safeCast<BaseRecyclerViewBindableAdapter<E, T>>()
            ?.setClickHandler(recyclerViewContract)

        this.adapter = adapter
    }

}


