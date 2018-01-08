package JavaLearn;

import java.util.Comparator;

public class PracticeComparator {
	public static void main(String[]args) {
		/**
		 * We will use the Comparator when unfortunately our Objects don't implement
		 * Comparable interface. But we still want to sort them based on some logic.
		 * Or we want to decide at different situations on what basis we want to sort our 
		 * objects.
		 * 
		 * Comparator is a separate utility passed on the the sorting method which
		 * can do the comparison that the sorting method will need. In case of comparable
		 * the objects define themselves as comparable and so they have to compareTo
		 * method. For comparator the objects themselves don't know if they can be compared.
		 * The comparator is an external utility that has some logic to compare objects
		 * which are otherwise not comparable
		 */
		MobileBrand[] brands = new MobileBrand[] {
				new MobileBrand("Lenovo",10),
				new MobileBrand("Samsung",20),
				new MobileBrand("Apple",15),
				new MobileBrand("LG",8),
				new MobileBrand("Motorola",7),
				new MobileBrand("OPPO",5),
				new MobileBrand("Huawei",13)
		};
		BubbleSortUtil sorter = new BubbleSortUtil();
		Comparator compareOnBrandName = new Comparator<MobileBrand>() {
			@Override
			public int compare(MobileBrand m1, MobileBrand m2) {
				return m1.name.compareTo(m2.name);
			}
		};
		Comparator compareOnMarketShare = new Comparator<MobileBrand>() {
			@Override
			public int compare(MobileBrand m1, MobileBrand m2) {
				return m1.marketShare-m2.marketShare;
			}
		};
		System.out.println("Sorted on brand names");
		sorter.sort(brands, compareOnBrandName);
		print(brands);
		System.out.println();
		System.out.println("Sorted on market share");
		sorter.sort(brands, compareOnMarketShare);
		print(brands);
	}
	
	public static void print(MobileBrand[] brands) {
		for(MobileBrand brand: brands) {
			System.out.println(brand);
		}
	}
}

class MobileBrand {
	String name;
	int marketShare; // in percentage
	
	MobileBrand (String name, int share) {
		this.name = name;
		marketShare = share;
	}
	
	public String toString() {
		return "Name: "+name+" Market Share "+marketShare;
	}
}

class BubbleSortUtil{
	public void sort(Object[] anyObjects, Comparator comparator) {
		/**
		 * In bubble sort, in each iteration the heaviest element moves to the bottom of
		 * the array (right of the array). Note after i iterations the bottom i elements
		 * are already sorted.
		 */
		//https://www.geeksforgeeks.org/bubble-sort/
		for(int i=0; i<anyObjects.length - 1;i++) {
			for(int j= 0; j<anyObjects.length-i-1;j++) {
				if(comparator.compare(anyObjects[j],anyObjects[j+1])>0) {
					//jth object greater than j+1 th object. Swap them
					Object temp = anyObjects[j];
					anyObjects[j] = anyObjects[j+1];
					anyObjects[j+1] = temp;
				}
			}
		}
	}
}


