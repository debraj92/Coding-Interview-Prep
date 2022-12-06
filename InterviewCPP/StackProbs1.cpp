//
// Created by Debraj Ray on 2022-10-30.
//

#include "StackProbs1.h"
#include <algorithm>
#include <stack>
#include <iostream>
#include <set>

/**
 * Sort the intervals.
 * Then use stack to merge the intervals which are overlapping
 * Iterate stack to print unique intervals
 */
 using namespace std;
void StackProbs1::mergeOverlappingIntervals(vector<Interval> intervals) {
    sort(intervals.begin(), intervals.end());
    stack<Interval> st;
    for(Interval i: intervals) {
        if(st.empty()) {
            st.push(i);
        } else {
            // check for clash
            Interval top = st.top();
            if(i.begin <= top.end) {
                // conflict, requires merge
                if(i.end > top.end) {
                    /**
                     * if next interval ends after the current interval. Then merge is required.
                     * Otherwise, the next interval is entirely inside the current interval - nothing to do
                     */
                    st.pop();
                    st.push({top.begin, i.end});
                }
            } else {
                // no conflict
                st.push(i);
            }
        }
    }
    while(!st.empty()) {
        Interval i = st.top();
        cout<<i.begin<<", "<<i.end<<endl;
        st.pop();
    }
}
