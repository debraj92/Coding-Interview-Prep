/*
 * treeNode.h
 *
 *  Created on: Oct. 29, 2022
 *      Author: debrajray
 */

#ifndef TREENODE_H_
#define TREENODE_H_

class treeNode {
public:

	int value;
	treeNode* left = nullptr;
	treeNode* right = nullptr;

	treeNode(int v) {
		value = v;
	}

	virtual ~treeNode() {}
};

#endif /* TREENODE_H_ */
