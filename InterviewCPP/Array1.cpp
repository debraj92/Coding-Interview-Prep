//
// Created by Debraj Ray on 2022-12-03.
//

#include "Array1.h"

int Array1::findClosestTwoSumInternal(vector<int> &numbers, int target, int start, int end) {
    int minDiff = INT_MAX;
    int minSum;
    for(int i = start, j = end; i < j;) {
        int sum = numbers[i] + numbers[j];
        if (abs(sum - target) < minDiff) {
            minDiff = abs(sum - target);
            minSum = sum;
        }
        if (sum < target) {
            ++i;
        } else if (sum > target) {
            --j;
        } else {
            break;
        }
    }
    return minSum;
}

// https://leetcode.com/problems/3sum-closest/
/**
 * We need to find sum of 3 elements s = a + b + c , such that abs(s - target) is minimum.
 * First sort the array. This ensure b and c can be picked in O(n)
 * Next, pick a one by one , which will be O(n). So the time complexity of the algorithm would be O(n^2)
 *
 * This is better than choosing all possible combinations of (a,b,c) and checking the condition. It would have been
 * O(n^3)
 */
int Array1::findClosestThreeSumInternal(vector<int> &numbers, int target) {
    sort(numbers.begin(), numbers.end());
    int n = numbers.size();
    int minDiff = INT_MAX;
    int minSum;
    for(int i=0; i<n-2; i++) {
        int threeSum = numbers[i] + findClosestTwoSumInternal(numbers, target - numbers[i], i+1, n-1);
        if (abs(threeSum - target) < minDiff) {
            minDiff = abs(threeSum - target);
            minSum = threeSum;
        }
    }
    return minSum;
}

void Array1::findClosestThreeSum() {
    //vector<int> numbers {-1, 2, 1, -4};
    //cout<<findClosestThreeSumInternal(numbers, 1);
    vector<int> numbers{4,0,5,-5,3,3,0,-4,-5};
    cout<<findClosestThreeSumInternal(numbers, -2);
}

