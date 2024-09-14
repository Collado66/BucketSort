/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bucketsort;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author marce
 */

public class BucketSort {

    public static void bucketSort(float[] array, int n) {
        if (n <= 0)
            return;

        // 1. Cria n buckets vazios
        ArrayList<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2. Distribui os elementos no bucket correspondente
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) array[i] * n; // Índice do bucket
            buckets[bucketIndex].add(array[i]);
        }

        // 3. Ordena individualmente os buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // 4. Junta os buckets ordenados
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                array[index++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = { (float) 0.42, (float) 0.32, (float) 0.23, (float) 0.52, (float) 0.25, (float) 0.47, (float) 0.51 };
        int n = arr.length;

        System.out.println("Array antes da ordenação:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Chama o Bucket Sort
        bucketSort(arr, n);

        System.out.println("Array após a ordenação:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
    }
}
