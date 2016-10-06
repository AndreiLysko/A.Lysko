package com.epam.logic;

import com.epam.data.Graph;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Input linear numbers of Y positive, negative and X top width, bottom width");
        Graph graph = new Graph(Input.enterKeys(), Input.enterKeys(), Input.enterKeys(), Input.enterKeys());
        System.out.println("Input coordinates:");
        double x = Input.enterKeys();
        double y = Input.enterKeys();
        System.out.println(DotCheck.dotBelongsToGraph(graph, x, y));
    }
}
