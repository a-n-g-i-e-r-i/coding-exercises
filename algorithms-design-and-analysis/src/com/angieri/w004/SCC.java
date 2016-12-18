package com.angieri.w004;

/*
The file contains the edges of a directed graph. Vertices are labeled as positive integers from 1 to 875714.
Every row indicates an edge, the vertex label in first column is the tail and the vertex label in second column is
the head (recall the graph is directed, and the edges are directed from the first column vertex to the second column
vertex). So for example, the 11th row looks like : "2 47646". This just means that the vertex with label 2 has an
outgoing edge to the vertex with label 47646.

Your task is to code up the algorithm from the video lectures for computing strongly connected components (SCCs),
and to run this algorithm on the given graph.

Output Format: You should output the sizes of the 5 largest SCCs in the given graph, in decreasing order of sizes,
separated by commas (avoid any spaces). So if your algorithm computes the sizes of the five largest SCCs to be:
    500, 400, 300, 200 and 100, then your answer should be "500,400,300,200,100" (without the quotes).

If your algorithm finds less than 5 SCCs, then write 0 for the remaining terms.

Thus, if your algorithm computes only 3 SCCs whose sizes are 400, 300, and 100, then your answer should be:
   "400,300,100,0,0"
   (without the quotes)
   (Note also that your answer should not have any spaces in it.)

WARNING: This is the most challenging programming assignment of the course.
Because of the size of the graph you may have to manage memory carefully.
The best way to do this depends on your programming language and environment,
and we strongly suggest that you exchange tips for doing this on the discussion forums.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SCC {

    private Set<Integer> seenVertex;
    private HashMap<Integer, Integer> buffer;
    private boolean isFirstPass = true;
    private int finishingPos = 0;

    /*
    * IMPORTANT !!!
    * My VM options: -Xss8m -XX:+UseSerialGC
    * It is needed for huge Graphs because of StackOverflow problem
    *
    * Kosaraju's algorithm
    *
    * SCC(G)
    *
    * call DFS(G) to compute finishing times u.f for each vertex u
    * compute GT
    * call DFS(GT), but in the main loop of DFS, consider the verteces in order of decreasing u.f (as computed in line 2)
    * output the vertices of each tree in the depth-first forest formed in line 4 as a separate strongly connected component
    */

    public ArrayList<Integer> runAlgorithm(HashMap<Integer, ArrayList<Integer>> G, HashMap<Integer, ArrayList<Integer>> rG, int maxVertex) {
        computeFinishingTimes(rG, maxVertex);
        return computeResultSCC(G, maxVertex);  // all SCC sizes in unsorted order
    }

    /*
    *  First DFS-loop to compute finishing times
    *
    *  instance variable HashMap<Integer, Integer> buffer = stores finishing times of each vertex
    *  instance variable int finishingPos = finishing times counter
    *
    *  @param G - directed graph
    *  @param maxVertex - highest vertex id in graph
    *
    *  after this loop instance variable buffer
    *  will map each finishing time with VertexID // buffer.put(finishingPos, v);
    */
    private void computeFinishingTimes(HashMap<Integer, ArrayList<Integer>> G, int maxVertex) {
        seenVertex = new HashSet<>();
        buffer = new HashMap<>(maxVertex);
        for (int i = 1; i <= maxVertex; i++) {
            if (!seenVertex.contains(i)) {
                finishingPos = depthFirstSearch(G, i);
            }
        }
    }

    /*
    *  Second DFS-loop to compute result unordered SCC sizes
    *
    *  @param G In Directed Graph
    *  @param maxVertex Highest vertex id in Graph
    *
    *  @return unordered ArrayList<Integer> of SCC sizes
    */
    private ArrayList<Integer> computeResultSCC(HashMap<Integer, ArrayList<Integer>> G, int maxVertex) {
        ArrayList<Integer> result = new ArrayList<>();
        seenVertex = new HashSet<>();
        isFirstPass = false;

        for (int i = maxVertex; i > 0; i--)
            if (buffer.containsKey(i) && !seenVertex.contains(buffer.get(i))) {
                finishingPos = 0;
                int sccSize = depthFirstSearch(G, buffer.get(i));
                result.add(sccSize);
            }

        return result;
    }

    /*
    *  Second DFS-loop to compute result unordered SCC sizes
    *
    *  @param G - directed graph
    *  @param v - vertex to start
    *
    *  if (isFirstPass) buffer will map each finishing time with VertexID
    *
    *  @return vertexes reached
    */
    private int depthFirstSearch(HashMap<Integer, ArrayList<Integer>> G, int v) {
        if (!seenVertex.contains(v)) {

            seenVertex.add(v);

            for (int e : adjacentEdges(G, v)) {
                depthFirstSearch(G, e);
            }
            finishingPos++;
            if (isFirstPass) {
                buffer.put(finishingPos, v);
            }
        }
        return finishingPos;
    }

    /*
    * Helper function to protect from Vertexes with 0 outgoing edges
    */
    private ArrayList<Integer> adjacentEdges(HashMap<Integer, ArrayList<Integer>> G, int v) {
        if (G.containsKey(v)) return G.get(v);
        else return new ArrayList<>();
    }

    private static final String filename = "scc.txt";
    private static final String filename1 = "scc-basic.txt";  // "3,3,3,0,0"

    private static final String SOLVED = "lol, calculate yourself";

    public static void main(String[] args) {

        run(filename1, "3,3,3,0,0");
//        run(filename, SOLVED);
    }

    private static void run(String filename, String correctSolution) {
        HashMap<Integer, ArrayList<Integer>> data = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> rData = new HashMap<>();


        DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");
        df.setTimeZone(TimeZone.getTimeZone("GMT-0"));
        long start = System.currentTimeMillis();

        System.out.println("Loading File SCC: ");

        int maxVertex = loadFile(filename, rData, data);
        System.out.println("Max Vertex: " + maxVertex);
        System.out.println("Loaded in: " + df.format(new Date(System.currentTimeMillis() - start)));

        System.out.println("Calculating SCC: ");

        SCC scc = new SCC();
        ArrayList<Integer> result = scc.runAlgorithm(data, rData, maxVertex);
        printResults(result, correctSolution);

        System.out.println("Algorithm runtime: " + df.format(new Date(System.currentTimeMillis() - start)));

        System.out.println("Total memory (bytes): " + Runtime.getRuntime().totalMemory() / 1024 / 1024);
    }

    private static int loadFile(String filename, HashMap<Integer, ArrayList<Integer>> rData, HashMap<Integer, ArrayList<Integer>> data) {
        int maxVertex = 0;
        try {

            BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
            while (true) {
                String line = br.readLine();

                if (line == null)
                    break;

                int curMaxValue = addEdge(line, rData, data);

                maxVertex = Math.max(maxVertex, curMaxValue);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return maxVertex;
    }

    private static int addEdge(String line, HashMap<Integer, ArrayList<Integer>> rData, HashMap<Integer, ArrayList<Integer>> data) {
        String[] newEntry = line.split("\\s");
        int key = Integer.parseInt(newEntry[0]);
        int edge = Integer.parseInt(newEntry[1]);

        addTo(key, edge, data);
        addTo(edge, key, rData);
        return Math.max(key, edge);
    }

    private static void addTo(int key, int edge, HashMap<Integer, ArrayList<Integer>> data) {
        if (!data.containsKey(key))
            data.put(key, new ArrayList<Integer>());

        data.get(key).add(edge);

    }

    private static void printResults(ArrayList<Integer> result, String correctSolution) {
        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println("-----------------------------\nSolution: (Should be: " + correctSolution + ")");
        String solution = "";
        for (int i = 0; i < 5; i++) {
            if (i < result.size())
                solution += result.get(i);
            else
                solution += "0";
            if (i != 4)
                solution += ",";
        }

        System.out.println(solution);

        if (!solution.equals(correctSolution) && !correctSolution.equals(SOLVED))
            System.out.println("!!!!!!!!!!!!!!!!!Incorrect " + solution + " should be " + correctSolution + "!!!!!!!!!!!!!!!!");
        System.out.println("-----------------------------");
    }
}