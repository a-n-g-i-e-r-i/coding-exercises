package com.angieri.w006;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * The goal of this problem is to implement a variant of the 2-SUM algorithm (covered in the Week 6 lecture on hash
 * table applications).
 *
 * The file contains 1 million integers, both positive and negative (there might be some repetitions!).This is your
 * array of integers, with the ith row of the file specifying the ith entry of the array.
 *
 * Your task is to compute the number of target values t in the interval [-10000,10000] (inclusive) such that
 * there are distinct numbers x,y in the input file that satisfy x+y=t. (NOTE: ensuring distinctness requires a one-line
 * addition to the algorithm from lecture.)
 *
 * Write your numeric answer (an integer between 0 and 20001) in the space provided.
 *
 * OPTIONAL CHALLENGE: If this problem is too easy for you, try implementing your own hash table for it.
 * For example, you could compare performance under the chaining and open addressing approaches to resolving collisions.
 */
public class TwoSum {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("two-sum.txt"));
        long[] numbers = new long[1000000];
        HashTable table = new HashTable(500000);
        for (int i = 0; i < 1000000; i++){
            long l = in.nextLong();
            numbers[i] = l;
            table.addLong(l);
        }
        int count = 0;
        HashSet<Integer> allSum = new HashSet<Integer>();
        for (long a : numbers){
            int i = (int) ((-a / table.RANGE) + 500000) / 2;
            for (int j = Math.max(0, i-1); j < 500000 && j <= i+1; j++){
                for (long b : table.table[j].list){
                    long sum = (int) (a + b);
                    if (sum < 10000 && sum > -10000){
                        if (!allSum.contains((int) sum)){
                            count++;
                            allSum.add((int) sum);
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}

class HashTable {
    public Bucket[] table;
    public final int RANGE = 200000;

    public HashTable(int size){
        table = new Bucket[size];
        for (int i = 0; i < size; i++){
            table[i] = new Bucket();
        }
    }
    public void addLong(long l){
        int index = (int) ((l / RANGE) + 500000) / 2;
        table[index].addLong(l);
    }
    public int bucketSize(int i){
        return table[i].size;
    }
}

class Bucket{
    public ArrayList<Long> list;
    public int size = 0;

    public Bucket(){
        list = new ArrayList<Long>();
    }
    public void addLong(long l){
        if (!list.contains(l)){
            list.add(l);
        }
        size++;
    }
}