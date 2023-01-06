package com.barstool.cockwojaer

import android.icu.lang.UCharacter.GraphemeClusterBreak.V


public class algorithm {
    fun travellingSalesmanProblem(
        graph: Array<IntArray>,
        s: Int
    ): Int {
        // store all vertex apart
        // from source vertex
        val vertex = ArrayList<Int>()
        for (i in 0 until V) if (i != s) vertex.add(i)

        // store minimum weight
        // Hamiltonian Cycle.
        var min_path = Int.MAX_VALUE
        do {
            // store current Path weight(cost)
            var current_pathweight = 0

            // compute current path weight
            var k = s
            for (i in 0 until vertex.size) {
                current_pathweight += graph[k][vertex[i]]
                k = vertex[i]
            }
            current_pathweight += graph[k][s]

            // update minimum
            min_path = Math.min(
                min_path,
                current_pathweight
            )
        } while (findNextPermutation(vertex))
        return min_path
    }

    // Function to swap the data
    // present in the left and right indices
    fun swap(
        data: ArrayList<Int>,
        left: Int, right: Int
    ): ArrayList<Int> {
        // Swap the data
        val temp = data[left]
        data[left] = data[right]
        data[right] = temp

        // Return the updated array
        return data
    }

    // Function to reverse the sub-array
    // starting from left to the right
    // both inclusive
    fun reverse(
        data: ArrayList<Int>,
        left: Int, right: Int
    ): ArrayList<Int> {
        // Reverse the sub-array
        var left = left
        var right = right
        while (left < right) {
            val temp = data[left]
            data[left++] = data[right]
            data[right--] = temp
        }

        // Return the updated array
        return data
    }

    // Function to find the next permutation
    // of the given integer array
    fun findNextPermutation(
        data: ArrayList<Int>
    ): Boolean {
        // If the given dataset is empty
        // or contains only one element
        // next_permutation is not possible
        var data = data
        if (data.size <= 1) return false
        var last: Int = data.size - 2

        // find the longest non-increasing
        // suffix and find the pivot
        while (last >= 0) {
            if (data[last] <
                data[last + 1]
            ) {
                break
            }
            last--
        }

        // If there is no increasing pair
        // there is no higher order permutation
        if (last < 0) return false
        var nextGreater: Int = data.size - 1

        // Find the rightmost successor
        // to the pivot
        for (i in data.size - 1 downTo last + 1) {
            if (data[i] >
                data[last]
            ) {
                nextGreater = i
                break
            }
        }

        // Swap the successor and
        // the pivot
        data = swap(
            data,
            nextGreater, last
        )

        // Reverse the suffix
        data = reverse(
            data, last + 1,
            data.size - 1
        )

        // Return true as the
        // next_permutation is done
        return true
    }

}