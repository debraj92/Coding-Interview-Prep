#pragma once
#include "headers.hpp"

class Node
{
public:
	Node(int k): key(k)
	{
		cout<<"Node "<< key <<" created"<<endl;
	}
	~Node()
	{
		cout<<"Node "<< key <<" destroyed"<<endl;
	}
	int key;
	shared_ptr<Node> left;
	shared_ptr<Node> right;
};

class BinTree
{
public:
	shared_ptr<Node> root;

	/**
	 *              6
	 *             /  \
	 *            3    8
	 *                /  \
	 *               4    2
	 *              / \    \
	 *             1   7    3
	 */
	void createTree1()
	{
		root = make_shared<Node>(6);

        root->left = make_shared<Node>(3);
        root->right = make_shared<Node>(8);
        root->right->left = make_shared<Node>(4);
        root->right->right = make_shared<Node>(2);
        root->right->left->left = make_shared<Node>(1);
        root->right->left->right = make_shared<Node>(7);
        root->right->right->right = make_shared<Node>(3);

	}

	/**
	 *        15
	 *       /  \
	 *     10     20
	 *     /\     / \
	 *    8  12  16  25
	 *           /
	 *          18
	 */
	void createTree2()
	{
		root = make_shared<Node>(15);
		root->left = make_shared<Node>(10);
		root->left->left = make_shared<Node>(8);
		root->left->right = make_shared<Node>(12);
		root->right = make_shared<Node>(20);
		root->right->left = make_shared<Node>(16);
		root->right->right = make_shared<Node>(25);
		root->right->left->left = make_shared<Node>(18);
	}

	/**
	 *               50
	 *             /    \
	 *           25      76 [modification to make invalid= 94]
	 *          /  \       \
	 *         17   33      93
	 *        /\   /  \     /\
	 *      10 21 29  44   91 100
	 *            /\   /        /\
	 *          25 36 38       98 105
	 *
	 *     We will create the above BST using insert in BST algorithm
	 */
	void createBST1()
	{
		vector<int> v {50,25,76,17,33,93,10,21,29,44,91,100,25,36,38,98,105};
		for(int i : v)
		{
			insertInBST(i);
		}
	}

	/**
	 * Notice BST operations can often be done using iterative solutions.
	 */
	void insertInBST(int val)
	{
		// root is null
		if(!root)
		{
			root = make_shared<Node>(val);
		}
		else
		{
			// find the perfect place
			shared_ptr<Node> parent;
			shared_ptr<Node> curr = root;
			while(curr)
			{
				parent = curr;
				if(val < curr->key)
				{
					curr = curr->left;
				}
				else
				{
					curr = curr->right;
				}
			}
			// insert the key using parent
			if(val < parent->key)
			{
				parent->left = make_shared<Node>(val);
			}
			else
			{
				parent->right = make_shared<Node>(val);
			}
		}

	}

	/**
	 * Delete has 3 cases
	 * 1> Leaf Node : Delete directly using parent
	 * 2> Node with one child: Delete Node and attach child to parent of the node
	 * 3> Node with 2 children: Delete Node and make inorder successor as the deleted node
	 *
	 * All cases consider if the Node to be deleted is root node.
	 *
	 * @return true if delete is successful
	 */
	bool deleteFromBST(int val)
	{
		// first find the node with key = val and its parent
		vector<shared_ptr<Node>> nodes = getNodeAndParentFromBST(val);
		return deleteFromBST(nodes);
	}

	/**
	 * More generic delete utility. Can delete any node, given we know its address and it's parent's address.
	 */
	bool deleteFromBST(vector<shared_ptr<Node>> nodes)
	{
		shared_ptr<Node> curr = nodes[0];
		shared_ptr<Node> parent = nodes[1];
		if(!curr) {
			cout<<"Cannot find value in the BST"<<endl;
			return false;
		}

		// case 1
		if(!curr->left && !curr->right)
		{
			if(curr == root)
			{
				cout<<"Deleting root";
				root.reset();
			}
			else
			{
				parent->left == curr? parent->left.reset(): parent->right.reset();
			}
		}
		// case 3
		else if (curr->left && curr->right)
		{
			// in this case we do not have to treat root differently as we are not directly deleting the node, but just replacing its key with that of its inorder successor.
			shared_ptr<Node> successor = getMinimum(curr->right);
			int successor_key = successor->key;
			// delete successor
			deleteFromBST(successor_key);
			// replace key
			curr->key = successor_key;
		}
		// case 2
		else
		{
			if(curr == root)
			{
				cout<<"Deleting root";
				// root is the only child
				root = root->left ? root->left : root->right;
			}
			else
			{
				// attach only child to parent
				if(parent->left == curr)
				{
					parent->left = curr->left ? curr->left : curr->right;
				}
				else
				{
					parent->right = curr->left ? curr->left : curr->right;
				}
			}
		}
		return true;
	}

	/**
	 * Returns the [node,parent]
	 */
	vector<shared_ptr<Node>> getNodeAndParentFromBST(int val)
	{
		shared_ptr<Node> curr = root;
		shared_ptr<Node> parent = root;
		while(curr && curr->key != val)
		{
			parent = curr;
			if(val < curr->key)
			{
				curr = curr->left;
			}
			else
			{
				curr = curr->right;
			}
		}
		return vector<shared_ptr<Node>>{curr,parent};
	}

	shared_ptr<Node> getMinimum(shared_ptr<Node> temp)
	{
		while(temp->left)
		{
			temp = temp->left;
		}
		return temp;
	}


	void printInorder()
	{
		printInorderInternal(root);
	}

private:

	void printInorderInternal(shared_ptr<Node> root)
	{
		if(!root) return;

		printInorderInternal(root->left);
		cout<<root->key<<endl;
		printInorderInternal(root->right);
	}
};


/**
 * Linked List implementation
 */
class ListNode
{
public:

	ListNode(int k) : key(k)
	{
		//cout << "Node "<<k<<" created"<<endl;
	}

	~ListNode()
	{
		//cout << "Node "<<key<<" destroyed"<<endl;
	}

	int key;
	shared_ptr<ListNode> next;
};

class LinkedList
{
public:

	shared_ptr<ListNode> head;

	void insert(vector<int> &v)
	{
		shared_ptr<ListNode> temp;
		for(int i: v)
		{
			if(!head)
			{
				head = make_shared<ListNode>(i);
				temp = head;
			}
			else
			{
				temp->next = make_shared<ListNode>(i);
				temp = temp->next;
			}
		}
	}

	void print()
	{
		shared_ptr<ListNode> temp = head;
		cout<<"Printing list"<<endl;
		while(temp)
		{
			cout<<temp->key<<endl;
			temp=temp->next;
		}
	}
};


