//
// Created by Debraj Ray on 2022-12-03.
//

#ifndef INTERVIEWCPP_LINKEDLIST1_H
#define INTERVIEWCPP_LINKEDLIST1_H


class LinkedList1 {

public:
    struct Node {
        Node(int d) {
            data = d;
        }
        int data;
        Node* next = nullptr;
    };

    LinkedList1::Node* createList1();
    LinkedList1::Node* createList2();

    void deleteList(LinkedList1::Node* l);

    void printList(LinkedList1::Node* l);

    void mergeSortedListMax();

};


#endif //INTERVIEWCPP_LINKEDLIST1_H
