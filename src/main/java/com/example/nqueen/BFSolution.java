package com.example.nqueen;

import java.util.*;

public class BFSolution {

    public static NQueen getSolutions(NQueen problem) {
        Queue<NQueen> open  = new LinkedList<>();
        open.add(problem);


        int counter = 0;

        while(open.size()!=0){
            counter++;
            NQueen current = open.poll();
            if(current.isFinalState()){
                if(current.isValidNQueenSolution()){
                    System.out.println(counter);
                    return current;
                }
            }else {
                List<NQueen> childNodes = current.getNextNodes();
                Collections.reverse(childNodes);
                open.addAll(childNodes);
            }
        }

        return null;
    }

}