#include "headers.hpp"
#include "Utilities.cpp"

class LinkedList_DeleteDuplicatesFromList : public LinkedList
{
public:

	/**
	 * Remove all elements that are repeating and keep only the unique elements
	 */
	void deleteDuplicates()
	{
		shared_ptr<ListNode> prev, curr, temp;
		curr = head;

		while(curr)
		{
			temp = curr;
			while(temp && temp->key == curr->key)
			{
				temp = temp->next;
			}
			/**
			 * temp is pointing to the next different element. It could be just the next element (no duplicate)
			 * or a few elements away from curr (if duplicates of curr are present)
			 */
			if(curr->next != temp)
			{
				// need to delete curr key and its duplicates
				// note during deletion, prev won't change its position. only curr will move to temp.
				// This is because even if curr moves to the next element, prev will still be just before
				// curr as the element between prev and curr is deleted.
				if(!prev)
				{
					// head needs to be modified
					head = temp;
					curr = temp;
				}
				else
				{
					prev->next = temp;
					curr = temp;
				}
			}
			else
			{
				// No deletion
				prev = curr;
				curr = temp;
			}
		}
	}
};


class DeleteDuplicatesFromList
{
public:

	void solve()
	{
		LinkedList_DeleteDuplicatesFromList l;
		vector<int> v{1,1,2,3,3,4,4,5,6,7,7};
		l.insert(v);
		l.print();
		cout<<"\n";
		cout<<"Deleting duplicates\n"<<endl;
		l.deleteDuplicates();
		l.print();
	}
};
