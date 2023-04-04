package com.example.nqueen;



import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import java.util.*;

public class AStar1 {

    public static Statistics getSolution(NQueen problem){

        long startTime = System.currentTimeMillis();

        PriorityQueue<NodeStar> open = new PriorityQueue<>(Comparator.comparingInt(NodeStar::getF));
        open.add(new NodeStar(problem , 0 , 0));

        int generated = 1;
        int developed = 0;
        int visited = 0;

        while (open.size() != 0){
            NodeStar current = open.poll();
            visited++;
            if(current.getState().isFinalState()){
                long executionTime = System.currentTimeMillis() - startTime;
                if (current.getState().isValidNQueenSolution(1)){
                    return  new Statistics(current.getState() , generated , developed , visited , executionTime);
                }
            }else{
                developed++;
                List<NQueen> nextStates = current.getState().getNextNodes();
                if(nextStates != null){
                    generated+= nextStates.size();
                    for(NQueen state : nextStates){

                        int cost = g(state);
                        int heuristic = h(state);
                        NodeStar tmp = new NodeStar(state , cost , heuristic);
                        open.offer(tmp);
                    }
                }
            }

        }

        return null;
    }

    public static int h(NQueen state) {
        return state.getDiagonalConflicts();
    }

    public static int g(NQueen state){
        return 0;
    }
}