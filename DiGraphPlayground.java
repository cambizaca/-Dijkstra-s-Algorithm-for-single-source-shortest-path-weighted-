package assignment5_f20;

import java.util.Arrays;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
      exTest();
    }
  
    public static void exTest(){
      DiGraph d = new DiGraph();
      d.addNode(0, "a");
      d.addNode(1, "b");
      d.addNode(2, "c");
      d.addEdge(0, "a", "b", 3, null);
      d.addEdge(1, "a", "c", 10, null);
      d.addEdge(2, "b", "c", 4, null);
      System.out.println(Arrays.toString(d.shortestPath("a")));


        		  
    }
}
