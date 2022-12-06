#include <iostream>
#include "binTreeProbs1.h"
#include "StackProbs1.h"
#include "Graph1.h"
#include "Ubisoft.h"
#include "Cisco.h"
#include "Array1.h"
#include "LinkedList1.h"
#include <vector>

void printTopView() {

    binTreeProbs1 t;
    t.createTree();
    t.printTopView();

}

void printCousins() {
    binTreeProbs1 t;
    t.createTree();
    t.printCousins(5);
}

void sinkNodes() {
    binTreeProbs1 t;
    t.createTree2();
    t.sinkNodes();
    t.printInorder();
}

void mergeIntervals() {
    StackProbs1 sp;
    std::vector<StackProbs1::Interval> intervals = {{1, 5}, {2, 3}, {4, 6},
                                                    {7, 8}, {8, 10}, {12, 15}};
    sp.mergeOverlappingIntervals(intervals);
}

void findLongestPathInGraph() {
    Graph1 gp1;
    /*
    vector<vector<int>> graph {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
    };
     */

    vector<vector<int>> graph {
            {1, 2}
    };

    cout<<"Longest Path: "<<gp1.findLongestPath(graph)<<endl;
}

void ubisoft_test() {
    Ubisoft u;
    //cout<<u.solution(33, 100)<<endl;

    //cout<<u.solution(100, 33)<<endl;

    cout<<u.solution(16, 64)<<endl;
    cout<<u.solution(16, 16)<<endl;
}

void findMin() {
    vector<int> A {-2,-5,-1,0,1000,2000,1500,5,8,-199,-50};
    int ans = A[0];
    for (uint i = 1; i < A.size(); i++) {
        if (ans > A[i]) {
            ans = A[i];
        }
    }
    cout<<ans;
}

void solveCisco() {
    Cisco c;
    c.solve();
}

void threeSum() {
    Array1 a1;
    a1.findClosestThreeSum();
}

void mergeSortedListMax() {
    LinkedList1 l1;
    l1.mergeSortedListMax();
}

int main() {
    //printTopView();
    //printCousins();
    //sinkNodes();
    //mergeIntervals();
    //findLongestPathInGraph();

    //ubisoft_test();
    //findMin();

    mergeSortedListMax();
    return 0;
}










