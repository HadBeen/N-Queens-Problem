package com.example.nqueen;

import java.util.*;

public class DFSolution {

    public static NQueen getSolutions(NQueen problem){
        Stack<NQueen> open  = new Stack<>();
        open.push(problem);



        int counter = 0;
        while(!open.empty()){
            counter++;
            NQueen current = open.pop();
            if(current.isFinalState()){
                if(current.isValidNQueenSolution()){
                    System.out.println(counter);
                    return current;
                }
            }else {
                List<NQueen> childNodes = current.getNextNodes();
                open.addAll(childNodes);
            }
        }

        return null;
    }



}