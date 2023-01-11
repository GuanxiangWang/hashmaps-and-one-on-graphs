import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class exerciseTwo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("description.txt");
        Scanner in = new Scanner(file);

        int n = in.nextInt();
        int[][] adj = new int[n][n];

        //build the matrix to represent the graph
        while(in.hasNext()){
            int v0 = in.next().charAt(0)-65;
            int v1 = in.next().charAt(0)-65;
            adj[v0][v1] = 1;
        }

        //build a vertices class
        //build an array list to store all the vertices
        ArrayList<vertex> verticesList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            verticesList.add(new vertex((char)(i+65)));
        }

        //using the matrix, store the indegree and the neighbours of each vertices
        for(int i = 0; i < adj.length; i++){
            for(int j = 0; j < adj[i].length; j++){
                //if the number is "1", it means there is a relationship
                if(adj[i][j] == 1){
                    verticesList.get(j).setPred(verticesList.get(j).getPred()+1);
                    verticesList.get(i).neighbours.add(verticesList.get(j));
                }
            }
       }
        Queue<vertex> queue = new LinkedList<>();

        //add a vertice to the queue if its indegree is 0
        for(int i = 0; i < n; i++){
            if(verticesList.get(i).getPred() == 0){
                queue.add(verticesList.get(i));
            }
        }

        int topnum = 1;

        //follow the steps in the pdf instructions
        while(queue.size() != 0){
            vertex w = queue.poll();
            w.setTopnum(topnum);
            topnum++;
            for(int i = 0; i < w.neighbours.size(); i++){
                w.neighbours.get(i).setPred(w.neighbours.get(i).getPred() - 1);
                if(w.neighbours.get(i).getPred() == 0){
                    queue.add(w.neighbours.get(i));
                }
            }
        }

        //printing the result with an increasing order of the topnum
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(verticesList.get(j).getTopnum() == i+1){
                    System.out.print(verticesList.get(j).getTopnum() + " ");
                }
            }
        }

        System.out.println();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(verticesList.get(j).getTopnum() == i+1){
                    System.out.print(verticesList.get(j).getLetter() + " ");
                }
            }
        }

    }
}
