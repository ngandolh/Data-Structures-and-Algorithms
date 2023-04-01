/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph_matrix_demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 *
 * @author DELL
 */
public class Euler_Graph_Test {
    // Create a graph from a text file with agiven format
    public static Euler_Graph loadGraph(String fName) throws Exception {
        Euler_Graph g = null;
        FileReader fr = new FileReader(fName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine().trim();
        g = new Euler_Graph(line);
        int size = line.length();
        int[][] m = new int[size][size];
        StringTokenizer stk;
        for(int i=0; i<size; i++) {
            line= br.readLine().trim();
            stk= new StringTokenizer(line,",");
            for(int j =0; j<size; j++)
                m[i][j] = Integer.parseInt(stk.nextToken().trim());
        }
        br.close();
        fr.close();
        g.setAdjMatrix(m);
        return g;
    }
    
    public static void main(String[] args) throws Exception {
        String sourceF = "EulerGraph01.txt";
        String eulerF = "EulerGraph01-Results.txt";
        Euler_Graph g = loadGraph(sourceF);
        if(!g.hasEulerCycle())
            System.out.println("It has no Euler cycle!");
        else {
            int start = 2;
            System.out.println("Euler cycle from the vertex: "+(start+1));
            g.findEulerCycle(start);
            System.out.println(g.EulerCycleStr());
            if(g.printEulerCycleToFile(eulerF))
                System.out.println("File "+eulerF+" has been written.");
            else System.out.println("Error when writing file!");
        }
    }
}
