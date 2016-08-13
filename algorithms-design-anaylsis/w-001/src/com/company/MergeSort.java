package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/*
Compilation: javac merge-sort.java
Execution: java merge-sort

The given file, integer-array.txt contains all of the 100,000 integers between 1 and 100,000 (inclusive)
in some order, with no integer repeated.

Compute the number of inversions in the file given, integer-array.txt, where the ith row of the file indicates
the ith entry of an array.

Because of the large size of this array, you should implement the fast divide-and-conquer algorithm
covered in the video lectures.

The numeric answer for the given input file should be the output.

[TIP: before submitting, first test the correctness of your program on some small test files or your own devising.
Then post your best test cases to the discussion forums to help your fellow students!]
*/
public class MergeSort {
    private Long count;

    public MergeSort(Long count) {
        this.count = count;
    }

    public static void main(String args[]) throws FileNotFoundException {
        MergeSort mergeSort = new MergeSort((long) 0);
        mergeSort.run();
    }

    public void run() throws FileNotFoundException {
        List<Integer> list = rowsToArrayList();
        List<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(4);
        test.add(1);
        test.add(3);
        test.add(5);
        this.count = Long.valueOf(0);
        print(mergeAndSort(list));
    }

    public List mergeAndSort(List<Integer> input) {
        if (input.size() < 2){
            return input;
        } else {
            // split array in half
            List<Integer> inputA;
            List<Integer> inputB;
            Integer mid = (input.size() - (input.size() % 2)) / 2;
            inputA = input.subList(0, mid);
            inputB = input.subList(mid, input.size());
            // sort each half
            inputA = mergeAndSort(inputA);
            inputB = mergeAndSort(inputB);
            // merge halves together, overwriting original array
            return merge(inputA, inputB);
        }
    }

    public List merge(List<Integer> inputA, List<Integer> inputB) {
        List<Integer> output = new ArrayList<>();
        Long a = Long.valueOf(0);
        Long b = Long.valueOf(0);
        Integer bMax = inputB.size();
        Integer aMax = inputA.size();
        while (b < bMax && a < aMax) {
            if (inputA.get(Math.toIntExact(a)) < inputB.get(Math.toIntExact(b))) {
                output.add(inputA.get(Math.toIntExact(a)));
                a++;
            } else {
                output.add(inputB.get(Math.toIntExact(b)));
                b++;
                System.out.println(count);
                this.count += (aMax - a);
            }
        }
        List<Integer> remA = inputA.subList(Math.toIntExact(a), aMax);
        List<Integer> remB = inputB.subList(Math.toIntExact(b), bMax);
        output.addAll(remA);
        output.addAll(remB);
        return output;
    }

    public void print(List list) {
        System.out.printf("The number of inversions are equal to : %d", this.count);
//        System.out.print(list);
    }

    List<Integer> rowsToArrayList() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("./src/integer-array.txt"));
        List<Integer> aList = new ArrayList<>();
        while(scanner.hasNextInt()){
            aList.add(scanner.nextInt());
        }
        return aList;
    }
}

