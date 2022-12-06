#include "headers.hpp"

class NumToWords
{

private:

	// array of all alphabets
	// Notice a dummy character X is inserted in the array at 0th location. This ensures all the alphabets
	// are at indices 1-26
	std::array<char,27> alpha{'X', 'a','b','c','d','e','f','g','h','i','j','k','l','m',
		'n','o','p','q','r','s','t','u','v','w','x','y','z'};

	void findWords(const std::vector<int> &v, int pos, std::string word)
	{
		if(pos == v.size())
		{
			std::cout<<word<<std::endl;
			return;
		}
		findWords(v, pos+1, word + alpha[v[pos]]);
		if(pos < v.size() - 1)
		{
			int num = v[pos] * 10 + v[pos+1];
			if(num <= 26) {
				findWords(v, pos+2, word + alpha[num]);
			}
		}
	}

public:
	/**
	 * Problem description:
	 * https://www.techiedelight.com/combinations-of-words-formed-replacing-given-numbers-corresponding-english-alphabet/
	 *
	 * Combine a sequence of numbers to form words.
	 * For example: 1, 2, 2 => ABB, AV, LB
	 */
	void solve()
	{
		//std::vector<int> v {1,2,2};
		std::vector<int> v {1,2,2,1};
		findWords(v,0,"");
	}
};

