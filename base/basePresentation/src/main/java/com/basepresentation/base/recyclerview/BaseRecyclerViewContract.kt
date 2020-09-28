package com.aapa.listener.recyclerview

interface BaseRecyclerViewContract {

    interface ClickHandler<E,T> {
        //    this method will be called by xml of recyclerview item whenever item is clicked
//   E is the event which contains event type and T contains pojo model
        fun  onRecyclerViewItemClicked(event: E, item: T)
    }

    interface PaginationListener<T> {
        //        this method will be called each time new data is required,
//        whenever this listener will be attached to recyclerview loadMore will be directly called
//      clazz is the type of item needs to be loaded
        fun loadMore(clazz: Class<T>)
    }

}