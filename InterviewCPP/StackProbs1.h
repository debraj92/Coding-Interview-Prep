//
// Created by Debraj Ray on 2022-10-30.
//

#ifndef INTERVIEWCPP_STACKPROBS1_H
#define INTERVIEWCPP_STACKPROBS1_H

#include <vector>

using namespace std;

class StackProbs1 {
public:

    struct Interval {
        int begin, end;

        bool operator<(const Interval &i) const {
            return begin < i.begin;
        }
    };

    void mergeOverlappingIntervals(vector<Interval> intervals);
};


#endif //INTERVIEWCPP_STACKPROBS1_H
