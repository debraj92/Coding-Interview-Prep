//sining.qin@intel.com

#pragma once

#include <iostream>
#include <vector>
using namespace std;

class IntelInterview {
public:

	int solveMinDistance(vector<vector<int>>& inp, vector<vector<int>>& out, vector<vector<bool>>& visited, int r, int c, int len) {

	  if(inp[r][c] == 0) {
		return len;
	  }

	  if(out[r][c] > -1) {
		  return len + out[r][c];
	  }

	  if(visited[r][c]) {
		  cout<<"Error"<<endl;
	  }

	  visited[r][c] = true;

	  int n = inp.size();
	  int m = inp[0].size();

	  int up = 100, down = 100, left = 100, right = 100;

	  // up
	  if(r > 0 and (not visited[r-1][c])) {
		  if (out[r-1][c] <= 0) {
			  up = solveMinDistance(inp, out, visited, r-1, c, 1);
		  } else {
			  up = out[r-1][c];
		  }
	  }

	  // down
	  if (r < n - 1 and (not visited[r+1][c])) {
		  if (out[r+1][c] <= 0) {
			  down = solveMinDistance(inp, out, visited, r+1, c, 1);
		  } else {
			  down = out[r+1][c];
		  }
	  }

	  // left
	  if (c > 0 and (not visited[r][c-1])) {
		  if (out[r][c-1] <= 0) {
			  left = solveMinDistance(inp, out, visited, r, c-1, 1);
		  } else {
			  left = out[r][c-1];
		  }
	  }

	  // right
	  if (c < m - 1 and (not visited[r][c+1])) {
		  if (out[r][c+1] <= 0) {
			  right = solveMinDistance(inp, out, visited, r, c+1, 1);
		  } else {
			  right = out[r][c+1];
		  }
	  }

	  int minValue = up;
	  minValue = min(minValue, down);
	  minValue = min(minValue, left);
	  minValue = min(minValue, right);
	  out[r][c] = minValue;
	  return len + minValue;
	}

	void solveMinDistance() {

	  //vector<vector<int>> inp {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
	  //vector<vector<int>> out {{0, 0, 0}, {0, -1, 0}, {-1, -1, -1}};
	  vector<vector<int>> inp {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
	  vector<vector<int>> out {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
	  vector<vector<bool>> visited {{false, false, false}, {false, false, false}, {false, false, false}};
	  int n = inp.size();
	  int m = inp[0].size();
	  for(int i=0; i<n; ++i) {
		for(int j=0; j<m; ++j) {
			if(not visited[i][j]) {
				solveMinDistance(inp, out, visited, i, j, 0);
			}
		}
	  }

	  for(int i=0; i<n; ++i) {
		for(int j=0; j<m; ++j) {
		  cout<<out[i][j]<<" ";
		}
		cout<<endl;
	  }
	}
};
