#pragma once
#include <iostream>
#include <string>
#include <vector>

using namespace std;

/**
 * https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
 */
class KadaneAlgo
{
public:
	void solve()
{
		//vector<int> v {-2, -3, 4, -1, -2, 1, 5, -3};
		//vector<int> v {2, -1,3,5,0,-5,6,2};
		vector<int> v {2, -1,3,5,-10,-5,6,2};

		int start=-1, next=0;
		int max_sum=0;
		int current_sum=0;
		/**
		 * Algorithm:
		 * We have a pointer start and next. The current_sum keeps track of sum from start till next. If the
		 * current sum exceeds max sum seen till now then max sum is updated with current sum. Thus max sum
		 * contains the largest contiguous sum.
		 *
		 * The idea is that even when a negative number is encountered in a contiguous stretch we can still
		 * accept it in the contiguous stretch provided the overall (or current) sum continues to stay positive.
		 * If eventually due to negative numbers the current sum dips to zero we have to reset start. Start should
		 * be reset to a new positive number in the array. Note this dipping of current sum to 0 does not impact
		 * the max sum. It is still up to date with the max contiguous sum seen till next.
		 */
		while(next < v.size())
		{
			if(v[next] >= 0)
			{
				if(start ==-1)
				{
					start = next;
					current_sum = v[next];
				}
				else
				{
					current_sum += v[next];
				}
				max_sum = max_sum > current_sum ? max_sum : current_sum;
			}
			else
			{
				if (start !=-1)
				{
					if(current_sum + v[next] < 0)
					{
						start = -1;
						current_sum = 0;
					}
					else
					{
						current_sum += v[next];
					}
				}
			}
			++next;
		}
		cout<<"Max Length contiguous sum "<< max_sum <<endl;
}

};

/**
 * https://practice.geeksforgeeks.org/problems/equilibrium-point/0
 */
class Equilibrium
{
public:
	void solve()
	{
		//vector<int> v {3,3,3,4,9};
		vector<int> v {-7, 1, 5, 2, -4, 3, 0};

		/**
		 * Algorithm: find the sum of the array -> say s ... Big O(n)
		 * Now traverse the array once more -> O(n)
		 * While traversing keep track of the sum till before the current element (s_before). You will also know
		 * the sum after the current element which is = s - s_before - current_element
		 */

		int sum = 0;
		for (int i=0; i < v.size(); i++)
		{
			sum +=v[i];
		}

		int sum_before=0, sum_after=-1,i;
		for (i=0; i < v.size(); i++)
		{
			sum_after = sum - sum_before - v[i];
			if(sum_before == sum_after)
			{
				break;
			}
			sum_before += v[i];
		}

		if(i == v.size())
		{
			cout<<"Equilibrium not present"<<endl;
		}
		else
		{
			cout<<"Equilibrium point "<<i<<endl;
		}
	}
};
