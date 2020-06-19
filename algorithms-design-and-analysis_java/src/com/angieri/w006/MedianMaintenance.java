package com.angieri.w006;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * The goal of this problem is to implement the "Median Maintenance" algorithm (covered in the Week 5 lecture on heap
 * applications). The text file contains a list of the integers from 1 to 10000 in unsorted order; you should treat
 * this as a stream of numbers, arriving one by one. Letting xi denote the ith number of the file, the kth median mk
 * is defined as the median of the numbers x1,…,xk. (So, if k is odd, then mk is ((k+1)/2)th smallest number among
 * x1,…,xk; if k is even, then mk is the (k/2)th smallest number among x1,…,xk.)
 *
 * In the box below you should type the sum of these 10000 medians, modulo 10000 (i.e., only the last 4 digits).
 * That is, you should compute (m1+m2+m3+⋯+m10000)mod10000.
 *
 * OPTIONAL EXERCISE: Compare the performance achieved by heap-based and search-tree-based implementations of the algorithm.
 */
public class MedianMaintenance {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private int size;

    public MedianMaintenance(){
        minHeap = new PriorityQueue<>(5000);
        maxHeap = new PriorityQueue<>(5000, Collections.reverseOrder());
        size = 0;
    }
    public void add(int n){
        if (size == 0){
            maxHeap.add(n);
        } else if(size % 2 == 0){
            if (n > minHeap.peek()){
                maxHeap.add(minHeap.poll());
                minHeap.add(n);
            } else {
                maxHeap.add(n);
            }

        } else {
            if (n < maxHeap.peek()){
                minHeap.add(maxHeap.poll());
                maxHeap.add(n);
            } else {
                minHeap.add(n);
            }
        }
        size++;
    }
    public int median(){
        return maxHeap.peek();
    }

    public static void main(String [] args) throws FileNotFoundException {
        int sum = 0;
        MedianMaintenance m = new MedianMaintenance();
        Scanner in = new Scanner(new File("median.txt"));
        while (in.hasNextInt()){
            m.add(in.nextInt());
            //System.out.println(m.median());
            sum = sum + m.median();
        }
        System.out.println(sum % 10000);
    }
}
