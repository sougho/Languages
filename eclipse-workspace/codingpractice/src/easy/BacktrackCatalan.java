package easy;

import java.util.ArrayList;

public class BacktrackCatalan {
    public ArrayList<Character> arrangeMents = new ArrayList<Character>();
    
    int rightCount = 0; // Curr no of moves to right
    int downCount = 0; // Curr no of moves bottom
    int currLength = 0; // Lenght of current path
    int max = 0; // no of cells in square
    int totalArrCount = 0; // Global count of no of arrangements

    public BacktrackCatalan(int n) {
        // TODO Auto-generated constructor stub
        max = n;
    }

    public void createCatalans() {
        
        if ((rightCount == max) && (downCount == max)) {
            System.out.println("*** " + arrangeMents.toString());
            totalArrCount++;
        }
        
        if (rightCount < max) {
            // Not reached right border of board yet - move right
            rightCount++;
            // Move right corresponds to the open bracket
            arrangeMents.add('{'); 
            // recursively proceed from this cell towards the end
            createCatalans();
            // Done exploring - backtrack
            // Next two lines are for backtrack - done with this cell, backtrack 
            rightCount--;
            arrangeMents.remove(arrangeMents.size() - 1);
            
        }
        if (downCount < rightCount) {
            // Not reached the diagonal yet - we can move down
            downCount++;
            // Move down => }
            arrangeMents.add('}');
            // Recursively proceed towards the end
            createCatalans();
            // Done exploring - backtrack
            downCount--;
            arrangeMents.remove(arrangeMents.size() - 1);
        }
    }

    public static void main(String[] args) {
        BacktrackCatalan bc = new BacktrackCatalan(5);
        bc.createCatalans();
        System.out.println("Total No Of arrangements: " + bc.totalArrCount);
    }

}

