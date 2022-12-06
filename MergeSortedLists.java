package JavaLearn;

import java.util.Random;

/**
 * Program to merge 2 sorted Linked lists
 *
 *	Best solution in GeeksForGeeks
 *
		  public Node SortedMerge(Node A, Node B)  
		    { 
		      
		        if(A == null) return B; 
		        if(B == null) return A; 
		          
		        if(A.data < B.data)  
		        { 
		            A.next = SortedMerge(A.next, B); 
		            return A; 
		        } 
		        else 
		        { 
		            B.next = SortedMerge(A, B.next); 
		            return B; 
		        } 
		          
		    } 
 *
 */
public class MergeSortedLists {
	public static void main(String[] args) {
		MyLinkedList list1 = new MyLinkedList();
		MyLinkedList list2 = new MyLinkedList();
		/**
		 * To create the 2 sorted lists I will create 2 arrays containing random
		 * numbers and then sort using our old insertion sort algorithm
		 */
		Random random = new Random();
		int sizeArr1 = 5;
		int sizeArr2 = 7;
		int[] arr1 = new int[sizeArr1];
		int[] arr2 = new int[sizeArr2];
		// fill up the arrays
		for (int i = 0; i < sizeArr1; i++) {
			arr1[i] = random.nextInt(100);
		}
		for (int i = 0; i < sizeArr2; i++) {
			arr2[i] = random.nextInt(100);
		}
		// sort the arrays
		Sorting sorting = new Sorting();
		sorting.insertionSort(arr1);
		sorting.insertionSort(arr2);
		System.out.println("Printing sorted array 1");
		sorting.printArray(arr1);
		System.out.println("Printing sorted array 2");
		sorting.printArray(arr2);
		// pack the data in the linked lists
		for (int i = 0; i < sizeArr1; i++) {
			list1.insertNodeInTheEnd(arr1[i]);
		}
		for (int i = 0; i < sizeArr2; i++) {
			list2.insertNodeInTheEnd(arr2[i]);
		}
		System.out.println("Printing list 1");
		list1.printList();
		System.out.println("Printing list 2");
		list2.printList();
		// The arrays are no more needed
		arr1 = null;
		arr2 = null;
		 Node mergedListHead = mergeSortedLists2(list1.head,list2.head);
		//MyLinkedList resultList = mergeSortedLists(list1.head, list2.head);
		//resultList.printList();
		 printMergedSortedList(mergedListHead);
	}

	/**
	 * Method to merge two sorted linked lists. The final list must be sorted.
	 * Make the smaller between head1 and head2 as the next node of the result
	 * list. The result list can be represented with a headOfResultList and a
	 * tailOfResultList. The tailOfResultList will be used for adding the
	 * smaller node (between head1 and head2) in the end of the current result
	 * list. Continue adding nodes until both the lists are exhausted (head1 =
	 * null and head2 = null).
	 * 
	 * @param head1
	 *            the head of the first list
	 * @param head2
	 *            the head of the second list
	 * @return head of the merged list
	 */
	public static MyLinkedList mergeSortedLists(Node head1, Node head2) {
		MyLinkedList list3 = new MyLinkedList();
		if (head1.data <= head2.data) {
			list3.insertNodeInTheEnd(head1.data);
			head1 = head1.next;
		} else if (head1.data > head2.data) {
			list3.insertNodeInTheEnd(head2.data);
			head2 = head2.next;
		}
		while (head1 != null || head2 != null) {
			if (head1 == null) {
				while (head2 != null) {
					list3.insertNodeInTheEnd(head2.data);
					head2 = head2.next;
				}
				break;
			}
			if (head2 == null) {
				while (head1 != null) {
					list3.insertNodeInTheEnd(head1.data);
					head1 = head1.next;
				}
				break;
			}
			if (head1.data <= head2.data) {
				list3.insertNodeInTheEnd(head1.data);
				head1 = head1.next;
			} else {
				list3.insertNodeInTheEnd(head2.data);
				head2 = head2.next;
			}
		}
		return list3;
	}
	
	public static Node mergeSortedLists2(Node head1, Node head2) {
		Node headOfResultList = null;
		Node tailOfResultList = null;
		// while we have atleast some nodes of either list to add to the result list
		while(head1 != null || head2 != null) {
			//Notice if we enter the loop both head1 (or H1) and head2 (or H2) cannot be null simultaneously
			if(head1 == null) {
				System.out.println("H1 is null, H2 -"+head2.data);
				if(tailOfResultList == null) {
					// Head1 does not have any element. Thus tailOfResultList is never initialized. Also, headOfResultList is not yet set
					System.out.println("Setting head of list to H2");
					headOfResultList = head2;
					tailOfResultList = head2;
				} else {
					//This is the case when head1 had some elements but the list is now exhausted. We want to add the remaining elements of head2 to the merged list
					tailOfResultList.next = head2;
				}
				head2 = null; // necessary to break out of the loop
			} else if (head2 == null) {
				System.out.println("H2 is null, H1 -"+head1.data);
				if(tailOfResultList == null) {
					System.out.println("Setting head of list to H1");
					// Head2 does not have any element. Thus tailOfResultList is never initialized. Also, headOfResultList is not yet set
					headOfResultList = head1;
					tailOfResultList = head1;
				} else {
					//This is the case when head2 had some elements but the list is now exhausted. We want to add the remaining elements of head2 to the merged list
					tailOfResultList.next = head1;
				}
				head1 = null; // necessary to break out of the loop
			} else {
				//none of the lists are yet exhausted
				System.out.println("H1 -"+head1.data+" H2 -"+head2.data);
				if(head1.data<head2.data) {
					//smaller is head1.
					System.out.println("Smaller is H1");
					if(tailOfResultList == null) {
						System.out.println("Setting head of list to H1");
						headOfResultList = head1;
						tailOfResultList = head1;
					} else {
						System.out.println("Tail of list moves to H1");
						tailOfResultList .next = head1;
						tailOfResultList = tailOfResultList.next;
					}
					head1 = head1.next;
					tailOfResultList .next = null;
				} else {
					//smaller is head2.
					System.out.println("Smaller is H2");
					if(tailOfResultList == null) {
						System.out.println("Setting head of list to H2");
						headOfResultList = head2;
						tailOfResultList = head2;
					} else {
						System.out.println("Tail of list moves to H2");
						tailOfResultList .next = head2;
						tailOfResultList = tailOfResultList.next;
					}
					head2 = head2.next;
					tailOfResultList .next = null; // This step is not necessary. Done for clarity in understanding
				}
			}
		}
		return headOfResultList;
	}

	public static void printMergedSortedList(Node temp) {
		while(temp != null) {
			if(temp.next == null) {
				//for the last node we don't print the arrow
				System.out.print(temp.data);
			} else {
				System.out.print(temp.data+" -> ");
			}
			temp = temp.next;
		}
		System.out.println();
	}
}
