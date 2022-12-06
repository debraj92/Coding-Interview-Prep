//https://www.techiedelight.com/print-top-view-binary-tree/

#ifndef TOPVIEWBT_H_
#define TOPVIEWBT_H_

#include "treeNode.h"
#include <unordered_map>

using namespace std;

class binTreeProbs1 {

	treeNode* root;
	unordered_map<int, int> umap;
	int smallest = 1000;

	void printTopViewInternal(treeNode* root_, int pos);
    int findDepth(treeNode* root_, int n, int d);
    void printNodesAtLevel(treeNode *root_, int d);

    /**
     * Expect tree with root = root_ to be zero-sinked and root swapped with 0
     */
    void sinkNodeInternal(treeNode *root_);
    void sinkNodes(treeNode *root_);

    void exchangeValues(treeNode *node1, treeNode *node2);

    void printInorderInternal(treeNode *node);

public:

	void createTree();

    void createTree2();

    //// https://www.techiedelight.com/print-top-view-binary-tree/
	void printTopView();

    /// https://www.techiedelight.com/print-cousins-of-given-node-binary-tree/
    void printCousins(int n);

    /// https://www.techiedelight.com/sink-nodes-containing-zero-bottom-binary-tree/
    void sinkNodes();

    void printInorder();

	binTreeProbs1();
	virtual ~binTreeProbs1();
};

#endif /* TOPVIEWBT_H_ */
