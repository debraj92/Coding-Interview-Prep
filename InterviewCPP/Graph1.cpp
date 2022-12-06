//
// Created by Debraj Ray on 2022-11-01.
//

#include "Graph1.h"
#include <string>
#include <iostream>

using namespace std;

/**
 *  Consider using BFS for shortest path
 *
 */
int Graph1::dfsLongestPath(const vector<vector<int>>& graph, vector<vector<int>>& lip, int row, int col, int n, int m) {
    // check all possible moves
    int pathLengthUp = 0;
    int pathLengthDown = 0;
    int pathLengthLeft = 0;
    int pathLengthRight = 0;

    for(int move = available_moves::up; move != available_moves::right; ++move) {
        switch (move) {
            case up:
                if(row > 0 and graph[row-1][col] > graph[row][col]) {
                    if (lip[row-1][col] > -1) {
                        pathLengthUp = lip[row-1][col] + 1;
                    } else {
                        pathLengthUp = dfsLongestPath(graph, lip, row - 1, col, n, m) + 1;
                    }
                }
            case down:
                if(row < n - 1 and graph[row + 1][col] > graph[row][col]) {
                    if (lip[row + 1][col] > -1) {
                        pathLengthDown = lip[row + 1][col] + 1;
                    } else {
                        pathLengthDown = dfsLongestPath(graph, lip, row + 1, col, n, m) + 1;
                    }
                }

            case left:
                if(col > 0 and graph[row][col - 1] > graph[row][col]) {
                    if (lip[row][col - 1] > -1) {
                        pathLengthLeft = lip[row][col - 1] + 1;
                    } else {
                        pathLengthLeft = dfsLongestPath(graph, lip, row, col - 1, n, m) + 1;
                    }
                }

            case right:
                if(col < m - 1 and graph[row][col + 1] > graph[row][col]) {
                    if (lip[row][col + 1] > -1) {
                        pathLengthRight = lip[row][col + 1] + 1;
                    } else {
                        pathLengthRight = dfsLongestPath(graph, lip, row, col + 1, n, m) + 1;
                    }
                }
        }
    }
    lip[row][col] = max({pathLengthUp, pathLengthDown, pathLengthLeft, pathLengthRight});
    if (!lip[row][col]) {
        lip[row][col] = 1;
    }
    return lip[row][col];
}

// graph is of size n X m
int Graph1::findLongestPath(const vector<vector<int>>& graph) {
    int n = graph.size();
    int m = graph[0].size();
    /**
     * Will contain longest increasing path starting from the cell (i,j)
     */
    vector<vector<int>> lip(n);

    // initialize with -1
    for(int i = 0; i < n; ++i) {
        lip[i].reserve(m);
        for(int j = 0; j < m; ++j) {
            lip[i][j] = -1;
        }
    }

    // start from each cell and find longest increasing path. Notice the lip values are continuously cached.
    int maxLength = -1;
    for(int i = 0; i < n; ++i) {
        for(int j = 0; j < m; ++j) {
            auto pathLength = dfsLongestPath(graph, lip, i, j, n, m);
            if(pathLength > maxLength) {
                maxLength = pathLength;
            }
        }
    }

    return maxLength;
}