/*
 * topViewBT.cpp
 *
 *  Created on: Oct. 29, 2022
 *      Author: debrajray
 */

#include "binTreeProbs1.h"
#include <iostream>


binTreeProbs1::binTreeProbs1() {
	// TODO Auto-generated constructor stub

}

binTreeProbs1::~binTreeProbs1() {
	// TODO Auto-generated destructor stub
}

/*
 *           1
 *          / \
 *         2   3
 *            / \
 *           5   6
 *          / \
 *         7   8
 *
 */
void binTreeProbs1::createTree() {
	root = new treeNode(1);
	root->left = new treeNode(2);
	root->right = new treeNode(3);
	root->right->left = new treeNode(5);
	root->right->right = new treeNode(6);
	root->right->left->left = new treeNode(7);
	root->right->left->right = new treeNode(8);
}


/*
 *           0
 *          / \
 *         1   0
 *            / \
 *           0   2
 *          / \
 *         3   4
 *
 */
void binTreeProbs1::createTree2() {
    root = new treeNode(0);
    root->left = new treeNode(1);
    root->right = new treeNode(0);
    root->right->left = new treeNode(0);
    root->right->right = new treeNode(2);
    root->right->left->left = new treeNode(3);
    root->right->left->right = new treeNode(4);
}


void binTreeProbs1::printTopViewInternal (treeNode* root_, int pos) {
	if(root_ == nullptr) {
		return;
	}
	if(!umap.count(pos)) {
		umap.insert({pos, root_->value});
		smallest = pos < smallest ? pos : smallest;
	}
	printTopViewInternal(root_->left, pos - 1);
	printTopViewInternal(root_->right, pos + 1);
}

void binTreeProbs1::printTopView() {
	printTopViewInternal(root, 0);
	while(umap.count(smallest)) {
		std::cout<<umap.find(smallest)->second<<", ";
		smallest++;

	}
}

int binTreeProbs1::findDepth(treeNode *root_, int n, int d) {
    if (root_->left == nullptr and root_->right == nullptr) {
        return root_->value == n ? d + 1 : 1000;
    }
    return root_->value == n ? d + 1 : min(findDepth(root_->left, n, d + 1), findDepth(root_->right, n, d + 1));
}

void binTreeProbs1::printCousins(int n) {
    int n_depth = findDepth(root, n, 0);
    printNodesAtLevel(root, n_depth);

}

void binTreeProbs1::printNodesAtLevel(treeNode *root_, int d) {
    if(root_ == nullptr) {
        // will never hit
        return;
    }
    if (d == 1) {
        cout<<root_->value<<endl;
    }
    printNodesAtLevel(root_->left, d - 1);
    printNodesAtLevel(root_->right, d - 1);
}

void binTreeProbs1::sinkNodeInternal(treeNode *root_) {
    if(root_ == nullptr) {
        return;
    }
    if(root_->left != nullptr and root_->left->value != 0) {
        exchangeValues(root_, root_->left);
        sinkNodeInternal(root_->left);
    } else if(root_->right != nullptr and root_->right->value != 0) {
        exchangeValues(root_, root_->right);
        sinkNodeInternal(root_->right);
    }
}

void binTreeProbs1::exchangeValues(treeNode *node1, treeNode *node2) {
    int temp = node1->value;
    node1->value = node2->value;
    node2->value = temp;
}

/*
 *           1
 *          / \
 *         0   3
 *            / \
 *           4   2
 *          / \
 *         0   0
 *
 */
void binTreeProbs1::sinkNodes() {
    sinkNodes(root);
}

/**
 * Use utility sinkNodeInternal to sink a 0 node to the bottom. Do this for all nodes bottom up.
 * bottom up : post order traversal
 */
void binTreeProbs1::sinkNodes(treeNode *root_) {
    if(root_ == nullptr) {
        return;
    }
    sinkNodes(root_->left);
    sinkNodes(root_->right);
    if(!root_->value) {
        if (root_->left != nullptr and root_->left->value) {
            exchangeValues(root_, root_->left);
            sinkNodeInternal(root_->left);
        } else if (root_->right != nullptr and root_->right->value) {
            exchangeValues(root_, root_->right);
            sinkNodeInternal(root_->right);
        }
    }
}

void binTreeProbs1::printInorder() {
    printInorderInternal(root);
}

void binTreeProbs1::printInorderInternal(treeNode *node) {
    if(node == nullptr) {
        return;
    }
    printInorderInternal(node->left);
    cout<<node->value<<endl;
    printInorderInternal(node->right);
}

