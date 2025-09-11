package com.defey.testcourse.adapter

interface BindableRecyclerDisplayItem {
    val itemId: String
        get() = this.javaClass.simpleName

    fun areItemsTheSame(other: Any?): Boolean =
        (other as? BindableRecyclerDisplayItem)?.itemId == itemId

    fun areContentsTheSame(other: Any?): Boolean = other?.equals(this) == true
}