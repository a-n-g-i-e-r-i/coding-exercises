package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/*
Compilation: javac min-cut.java
Execution: java min-cut

The given file, adjacency-list.txt contains the adjacency list representation of a simple undirected graph.
There are 200 vertices labeled 1 to 200.
Each Row has the following columns: Vertex label, vertices that the vertex is adjacent to

EX: Row 6:
 6 155 56 52 120 ......". Vertex with label 6 is adjacent to (i.e., shares an edge with)
 the vertices with labels 155,56,52,120,......

1.	Code the randomized contraction algorithm for the min cut problem
	⁃	Base case: 2 remaining vertices
	⁃	Main loop:
	⁃	decrease remaining vertices by 1
	⁃	Subproblem: Implement of edge contractions
	⁃	Pick random edge from remaining edges
	⁃	Fuse two edge vertices (U,V) —> V
	⁃	Remove self-loops
	⁃	Create new graph from the old graph every time there's an edge contraction
	⁃	Next find more efficient implementations
2.	Input the given graph to compute the min cut
	⁃	Run the algorithm many times with different random seeds
	⁃	The smallest cut that you ever find is the homework result

[TIP: before submitting, first test the correctness of your program on some small test files or your own devising.
Then post your best test cases to the discussion forums to help your fellow students!]
*/
public class MinCut {
    private Long minCut;

    public MinCut(Long minCut) {
        this.minCut = minCut;
    }

    public static void main(String args[]) throws FileNotFoundException {
        MinCut randomizedContraction = new MinCut((long) 0);
        randomizedContraction.run();
    }

    public void run() throws FileNotFoundException {
        List<Integer> list = rowsToAdjacencyList();
        List<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(4);
        test.add(1);
        test.add(3);
        test.add(5);
        this.minCut = Long.valueOf(0);
        print(randomizedContraction(list));
    }

    public List randomizedContraction(List<Integer> input) {
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
            inputA = randomizedContraction(inputA);
            inputB = randomizedContraction(inputB);
            // merge halves together, overwriting original array
            return edgeContraction(inputA, inputB);
        }
    }

    public List edgeContraction(AdjacencyList<Integer> input) {
        List<Integer> output = new ArrayList<>();
        return output;
    }

    public void print(List list) {
        System.out.printf("The min cut is equal to : %d", this.minCut);
        System.out.print(list);
    }

    List<Integer> rowsToAdjacencyList() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("./src/adjacency-list.txt"));
        List<Integer> aList = new ArrayList<>();
        while(scanner.hasNextInt()){
            aList.add(scanner.nextInt());
        }
        return aList;
    }
}

