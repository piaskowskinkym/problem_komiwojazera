package com.barstool.cockwojaer

import java.util.Vector

import kotlin.math.min

public class algorithm {
    fun <T: Comparable<T>> nextPermutation(vector: MutableList<T>, first: Int, last: Int): Boolean {
        if (first == last) {
            return false
        }

        var i = last
        while (i > first && vector[i - 1] >= vector[i]) {
            i--
        }

        if (i == first) {
            return false
        }

        var j = last
        while (vector[j] <= vector[i - 1]) {
            j--
        }

        val temp = vector[i - 1]
        vector[i - 1] = vector[j]
        vector[j] = temp

        j = last
        while (i < j) {
            val temp2 = vector[i]
            vector[i] = vector[j]
            vector[j] = temp2
            i++
            j--

        }

        return true
    }
    fun shortest_path_sum(edges_list:Array<Array<Int>>,num_nodes:IntArray) {
        var source = 0
        val nodes = Vector<Int>()

        for (i in num_nodes) {
            if (i != source) {
                nodes.add(i)
            }

        }

        var shortest_path = Int.MAX_VALUE

        while (nextPermutation(nodes, nodes.firstElement(), nodes.lastElement())){
            var path_weight = 0
            var j = source
            for(n in nodes){
                path_weight += edges_list[j][nodes[n]]
                j = nodes[n]
            }
            path_weight += edges_list[j][source]
            shortest_path = min(shortest_path, path_weight)
        }
        return
    }
}