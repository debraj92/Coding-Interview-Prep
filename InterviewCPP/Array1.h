//
// Created by Debraj Ray on 2022-12-03.
//

#ifndef INTERVIEWCPP_ARRAY1_H
#define INTERVIEWCPP_ARRAY1_H

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
class Array1 {

    int findClosestTwoSumInternal(vector<int> &numbers, int target, int start, int end);
    int findClosestThreeSumInternal(vector<int> &numbers, int target);

public:

    void findClosestThreeSum();
};


#endif //INTERVIEWCPP_ARRAY1_H
