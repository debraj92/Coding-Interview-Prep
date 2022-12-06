#define MAIN

#include "headers.hpp"

/**
 * https://www.codechef.com/problems/ROBOGAME
 *
 * Solution - https://www.codechef.com/viewsolution/21963446
 * (Correct)
 */
class ROBOGAME
{
public:
	void execute()
	{
		int t;
		cin >> t;
		for (int i=0; i<t; i++)
		{
			cin >> robots;
			if (isSafe(robots))
			{
				cout<<"safe"<<endl;
			}
			else
			{
				cout<<"unsafe"<<endl;
			}
		}
	}

	bool isSafe(string& robots)
	{
		int len = robots.length();
		// represents all cells of the array in which the robots move
		// all the cells will be initially false - no robot can reach them
		vector<bool> cells(len);
		// we will find out if any cell can be visited by more than 1 robot
		string::iterator it;
		int pos=0;
		for (it = robots.begin(); it<robots.end(); ++it)
		{
			string robot { *it };
			if(robot != ".")
			{
				int limit = boost::lexical_cast<int>(robot);
				//int limit = stoi(robot);
				int lowerLimit = (pos - limit) >= 0? (pos - limit) : 0;
				int upperLimit = (pos + limit) < len? (pos + limit) : len - 1;
				for (int j=lowerLimit; j<=upperLimit; j++)
				{
					if (!cells[j])
					{
						cells[j] = true;
					}
					else
					{
						return false;
					}
				}
			}
			++pos;
		}
		return true;
	}

private:
	string robots;
};





int main()
{
	//ROBOGAME obj;
	//obj.execute();
	//KadaneAlgo obj;
	//obj.solve();
	//Equilibrium obj;
	//NumToWords obj;

	//TruncateBinTree obj;

	//RemoveInvalidNodeFromBST obj;

	//DeleteDuplicatesFromList obj;

	//QuickSelect obj;
	//obj.solve();

	//MaxSubSubsequenceK mk;
	//mk.testMaxSubsequence();

	IntelInterview i;
	i.solveMinDistance();
	return 0;
}
