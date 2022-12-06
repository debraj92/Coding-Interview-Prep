//
// Created by Debraj Ray on 2022-11-01.
//

#ifndef INTERVIEWCPP_GRAPH_H
#define INTERVIEWCPP_GRAPH_H

#include <vector>

using namespace std;

class Graph1 {
    enum available_moves {
        up = 1,
        down,
        left,
        right
    };

    /// https://leetcode.com/problems/longest-increasing-path-in-a-matrix
    int dfsLongestPath(const vector<vector<int>>& graph, vector<vector<int>>& lip, int row, int col, int n, int m);

public:
    int findLongestPath(const vector<vector<int>>& graph);
};


#endif //INTERVIEWCPP_GRAPH_H
