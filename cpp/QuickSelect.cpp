#include "headers.hpp"

class QuickSelect
{
public:
	void solve()
	{
		vector<int> v {7, 10, 4, 3, 20, 15};
		int k = 3;
		int kLargest = findKLargest(v,k);
		cout<<k<<" largest element is "<<kLargest<<endl;
		cout<<"\n";

		k=4;
		kLargest = findKLargest(v,k);
		cout<<k<<" largest element is "<<kLargest<<endl;
	}

private:

	/**
	 * The idea of quickselect is to partition the array and search the kth element in the appropriate half.
	 *
	 * Average Time complexity : O(n)
	 * Worst case time complexity : O(n^2)
	 */
	int findKLargest(vector<int> v, int k)
	{
		// size of the array
		int n = v.size();
		// k largest = n - k smallest
		k = n-k;
		int start = 0, end = n-1;
		int pos = partition(v, start, end);

		// continue partitioning until we have found the k largest
		while(pos != k)
		{
			if(pos > k)
			{
				// we have to look in the first half
				end = pos - 1;
			}
			else
			{
				// we have to look in the second half
				start = pos + 1;
			}
			pos = partition(v, start, end);
		}
		return v[pos];
	}

	/**
	 * Lets partition using the last element.
	 *
	 * @returns the appropriate position of the pivot element
	 */
	int partition(vector<int> &v, int start, int end)
	{
		int pivot = end;
		int low=start, high=pivot-1;
		// note even when low = high we still need to enter the loop. The idea is that low should cross over to the high
		// values. This will ensure that when we swap the pivot element with low, a high value is moved to the place of
		// pivot (end).
		while(low <= high)
		{
			/**
			 * While partitioning, we have to first keep moving the left pointer and then start moving the right pointer when the left pointer is fixed. This way we are ensuring
			 * the left pointer will point to perfect place of the pivot element. If we move both the pointers together then we cannot guarantee that the left pointer will always
			 * point to the perfect position of the pivot element.
			 */
			if (v[low] < v[pivot])
			{
				++low;
			}
			else if (v[high] > v[pivot])
			{
				--high;
			}
			else
			{
				swap(v, low, high);
				++low;
				--high;
			}
		}
		// place pivot at the right place
		swap(v, low, pivot);
		return low;
	}

	void swap(vector<int> &v, int first, int second)
	{
		int temp = v[first];
		v[first] = v[second];
		v[second] = temp;
	}
};
