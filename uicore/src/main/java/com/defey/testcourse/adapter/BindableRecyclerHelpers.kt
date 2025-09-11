package com.defey.testcourse.adapter

import android.view.View
import androidx.collection.ArrayMap
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
fun <T : BindableRecyclerDisplayItem, VH : BindableViewHolderFactory<*, *>>
        binderAdapterOf(vararg factories: Pair<KClass<out T>, VH>): BindableRecyclerAdapter =
    BindableRecyclerAdapter(
        arrayMapOf(factories)
                as ArrayMap<KClass<out BindableRecyclerDisplayItem>, BindableViewHolderFactory<View, BindableRecyclerDisplayItem>>
    )

infix fun <M : BindableRecyclerDisplayItem, B : View>
        KClass<M>.bindWith(factory: BindableViewHolderFactory<B, M>):
        Pair<KClass<out M>, BindableViewHolderFactory<B, M>> = this to factory

fun RecyclerView.updateItems(
    newItems: List<BindableRecyclerDisplayItem>,
    detectMoves: Boolean = false,
) {
    (adapter as? BindableRecyclerAdapter)?.let {
        val diffUtilResult = DiffUtil.calculateDiff(
            BindableDiffUtilsCallback(
                oldItems = it.itemsList,
                newItems = newItems
            ), detectMoves
        )

        it.setItems(diffUtilResult, newItems)
    }
}

fun ViewPager2.updateItems(
    newItems: List<BindableRecyclerDisplayItem>,
    detectMoves: Boolean = false,
) {
    (adapter as? BindableRecyclerAdapter)?.let {
        val diffUtilResult = DiffUtil.calculateDiff(
            BindableDiffUtilsCallback(
                oldItems = it.itemsList,
                newItems = newItems
            ), detectMoves
        )

        it.setItems(diffUtilResult, newItems)
    }
}

private fun <K, V> arrayMapOf(pairs: Array<out Pair<K, V>>): ArrayMap<K, V> {
    val map = ArrayMap<K, V>(pairs.size)
    for ((first, second) in pairs) {
        map[first] = second
    }

    return map
}