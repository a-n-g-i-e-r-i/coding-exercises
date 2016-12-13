package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/*
Compilation: javac quick-sort.java
Execution: java quicksort

The given file, quicksort.txt contains all of the 100,000 integers between 1 and 100,000 (inclusive)
in some order, with no integer repeated.

Compute the total number of comparisons used by QuickSortFirst to sort the given input file,
quicksort.txt, where the ith row of the file indicates the ith entry of an array.

For each recursive call on subarray of length m, increment the running count, x, by m - 1.

Implement the Partition sub-routine exactly as described in lecture.
Different Partition implementations yield varying results.

Pivot Variation 1: Use the first element of the array as the pivot element.

Pivot Variation 2: Use the last element of the array as the pivot element.

Pivot Variation 3: Use the median element of the array as the pivot element. The median element is defined as the
median element of the first, middle, and last elements of the array. [3, 1, 4] --> 3

The numeric answer for the given input file should be the output.

[TIP: before submitting, first test the correctness of your program on some small test files or your own devising.
Then post your best test cases to the discussion forums to help your fellow students!]
*/
public class QuickSortFirst {
    private Long count;
    private String selection;

    public QuickSortFirst(Long count, String selection) {
        this.count = count;
        this.selection = selection;
    }

    public static void main(String args[]) throws FileNotFoundException {
        QuickSortFirst quickSortMedian = new QuickSortFirst((long) 0, "median");
        quickSortMedian.run();
        // 162085
        QuickSortFirst quickSortFirst = new QuickSortFirst((long) 0, "first");
        quickSortFirst.run();
        // 164123
        QuickSortFirst quickSortLast = new QuickSortFirst((long) 0, "last");
        quickSortLast.run();
        // 138382
    }

    public void run() throws FileNotFoundException {
        List<Integer> list = rowsToArrayList();
        List<Integer> test = new ArrayList<>();
        test.add(4);
        test.add(5);
        test.add(1);
        test.add(3);
        test.add(2);
        quickSort(list);
        print();
    }

    public void quickSort(List <Integer> input) {
        if (input.size() < 2){
            return;
        } else if(input.size() == 2) {
            count += input.size() - 1;
            if(input.get(0) > input.get(1)) {
                Collections.swap(input, 0, 1);
                return;
            }
            return;
        }
        count += input.size() - 1;
        Integer pivot = assignPivot(selection, input);
        input = partition(input, pivot);
        List<Integer> inputA;
        List<Integer> inputB;
        inputA = input.subList(0, input.indexOf(pivot));
        inputB = input.subList(input.indexOf(pivot) + 1, input.size());
        quickSort(inputA);
        quickSort(inputB);
        return;
    }

    public Integer assignPivot(String selection, List<Integer> input) {
        if (selection == "first") {
            return input.get(0);
        } else if (selection == "last") {
            return input.get(input.size() - 1);
        }
        Integer mid = ((input.size() + (input.size() % 2)) / 2) - 1;
        return findMedian(input.get(0), input.get(mid), input.get(input.size() - 1));
    }

    public Integer findMedian(Integer a, Integer b, Integer c) {
        if (b > a && b < c || b < a && b > c) {
            return b;
        } else if (a > b && a < c || a < b && a > c) {
            return a;
        }
        return c;
    }

    public List partition(List<Integer> input, Integer pivot) {
        Collections.swap(input, 0, input.indexOf(pivot));
        Integer p = 0;
        Integer i = 0 + 1, j;
        for (j = 0 + 1; j < input.size(); j++ ) {
            if (input.get(j) < input.get(p)) {
                Collections.swap(input, j, i);
                i += 1;
            }
        }
        Collections.swap(input, 0, (i-1));
        return input;
    }

    public void print() {
        System.out.printf("The number of comparisons are equal to : %d", this.count);
    }

    List<Integer> rowsToArrayList() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("./src/quicksort.txt"));
        List<Integer> aList = new ArrayList<>();
        while(scanner.hasNextInt()){
            aList.add(scanner.nextInt());
        }
        return aList;
    }
}

