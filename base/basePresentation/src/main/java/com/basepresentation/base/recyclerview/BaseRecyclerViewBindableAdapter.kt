package com.aapa.listener.recyclerview

//T is the type of event, V is the type of pojo
interface BaseRecyclerViewBindableAdapter<E,T> {
    fun setData(list: List<T>)
    fun setClickHandler(contract: BaseRecyclerViewContract.ClickHandler<E,T>)
    fun indexOf(item: T): Int
}