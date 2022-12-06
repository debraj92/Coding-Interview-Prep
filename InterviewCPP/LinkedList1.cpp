//
// Created by Debraj Ray on 2022-12-03.
//

#include "LinkedList1.h"
#include <unordered_set>
#include <iostream>

using namespace std;

LinkedList1::Node* LinkedList1::createList1() {
    LinkedList1::Node* l1 = new LinkedList1::Node(1);
    l1->next = new LinkedList1::Node(3);
    l1->next->next = new LinkedList1::Node(30);
    l1->next->next->next = new LinkedList1::Node(90);
    l1->next->next->next->next = new LinkedList1::Node(120);
    l1->next->next->next->next->next = new LinkedList1::Node(240);
    l1->next->next->next->next->next->next = new LinkedList1::Node(511);
    return l1;
}

LinkedList1::Node* LinkedList1::createList2() {
    LinkedList1::Node* l2 = new LinkedList1::Node(0);
    l2->next = new LinkedList1::Node(3);
    l2->next->next = new LinkedList1::Node(12);
    l2->next->next->next = new LinkedList1::Node(32);
    l2->next->next->next->next = new LinkedList1::Node(90);
    l2->next->next->next->next->next = new LinkedList1::Node(125);
    l2->next->next->next->next->next->next = new LinkedList1::Node(240);
    l2->next->next->next->next->next->next->next = new LinkedList1::Node(249);
    return l2;
}

void LinkedList1::deleteList(LinkedList1::Node* l) {
    auto p = l;
    l = l->next;
    for(;l != nullptr; l = l->next) {
        delete p;
        p = l;
    }
}

void LinkedList1::printList(LinkedList1::Node* l) {
    for(;l != nullptr; l = l->next) {
        cout<<l->data<<endl;
    }
}

/**
 * https://www.geeksforgeeks.org/maximum-sum-linked-list-two-sorted-linked-lists-common-nodes/
 *
 * First find the common elements of both the lists and store them in a set.
 * Now we have to iterate both the lists and use 4 pointers.
 * head1 and head2 point to the start of the 2 lists.
 * l1Common and l2Common are pointers that start from head1 and head2 and stop at the common element in each list.
 * sumL1 and sumL2 keeps track of the sum between 2 common elements
 * if sumL1 > sumL2, the merged list follows head1 as it moves towards l1Common.
 * else the merged list follows head2 as it moves towards l2Common.
 * After this, everything is reset. head1 and head2 point to the elements after the common element, sumL1 and sumL2 is
 * reset to 0.
 * If one of the list is exhausted, sum of that list will be 0 and therefore l3 will contain values from the other list
 */
void LinkedList1::mergeSortedListMax() {
    auto l1 = createList1();
    auto l2 = createList2();
    auto l3 = new LinkedList1::Node(-1);

    auto head1 = l1;
    auto head2 = l2;
    auto head3 = l3;
    // get all the common values
    unordered_set<int> elemsL1;
    unordered_set<int> common;

    for(;head1 != nullptr; head1 = head1->next) {
        elemsL1.insert(head1->data);
    }
    for(;head2 != nullptr; head2 = head2->next) {
        if(elemsL1.count(head2->data)) {
            common.insert(head2->data);
        }
    }

    head1 = l1;
    head2 = l2;

    int sumL1 = 0, sumL2 = 0;
    LinkedList1::Node *l1Common = head1, *l2Common = head2;

    while(head1 != nullptr or head2 != nullptr) {

        while(l1Common != nullptr and common.count(l1Common->data) == 0) {
            sumL1 += l1Common->data;
            l1Common = l1Common->next;
        }

        while(l2Common != nullptr and common.count(l2Common->data) == 0) {
            sumL2 += l2Common->data;
            l2Common = l2Common->next;
        }
        if (sumL1 > sumL2) {
            while(head1 != l1Common) {
                head3->next = new LinkedList1::Node(head1->data);
                head1 = head1->next;
                head3 = head3->next;
            }
            if (l1Common != nullptr) {
                head3->next = new LinkedList1::Node(l1Common->data);
                head3 = head3->next;
            }
            head2 = l2Common;
        } else {
            while(head2 != l2Common) {
                head3->next = new LinkedList1::Node(head2->data);
                head2 = head2->next;
                head3 = head3->next;
            }
            if (l2Common != nullptr) {
                head3->next = new LinkedList1::Node(l2Common->data);
                head3 = head3->next;
            }
            head1 = l1Common;
        }

        sumL1 = 0;
        sumL2 = 0;

        if (l1Common != nullptr) {
            l1Common = l1Common->next;
            head1 = l1Common;
        }

        if (l2Common != nullptr) {
            l2Common = l2Common->next;
            head2 = l2Common;
        }

    }

    head3 = l3->next;
    printList(head3);


    deleteList(l1);
    deleteList(l2);
    deleteList(l3);

}