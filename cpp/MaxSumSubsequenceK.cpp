#pragma once
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

/*
 * Use K Min-Heap. Store the first K items in a heap.
 * Iterate remaining items : from index k to n-1
 * For every element check if it is bigger than the root of the min-heap. If yes, replace root with this
 * element. Sink root to maintain heap.
 *
 * Sink is logK and we do for n elements. Time complexity is NlogK
 *
 * For returning the sequence, store both index and value in the heap. Later sort the heap by index: KlogK
 * The heap will now contain the max sum subsequence of length K.
 *
 * Min-Heap implementation done using priority queue.
 */
class MaxSubSubsequenceK {

public:

	struct item
	{
	    int value;
	    int index;

	    item(int v, int i) : value(v), index(i) {
	    }
	};

	struct CompareItems {
	    bool operator()(item const& i1, item const& i2)
	    {
	        return i1.value > i2.value;
	    }
	};

    vector<int> maxSubsequence(vector<int>& nums, int k) {

    		priority_queue<item, vector<item>, CompareItems> minHeap;

    		for (int i=0; i<nums.size(); i++) {
    			if(minHeap.size() < k) {
    				minHeap.push(item(nums[i], i));
    			} else if (minHeap.top().value < nums[i]) {
    				minHeap.pop();
    				minHeap.push({nums[i], i});
    			}
    		}

    		vector<item> kItems;
    		while(!minHeap.empty()) {
    			kItems.push_back(minHeap.top());
    			minHeap.pop();
    		}

    		sort(kItems.begin(),kItems.end(), [](item &a, item &b){ return a.index < b.index; });

    		vector<int> result;
    		for(item i: kItems) {
    			result.push_back(i.value);
    		}

    		return result;
    }

    void testMaxSubsequence() {
    		vector<int> nums{-1,-2,3,4};
    		int k = 3;
    		vector<int> result = maxSubsequence(nums, k);
    		for(int r: result) {
    			cout<<r<<" ";
    		}
    }

};

