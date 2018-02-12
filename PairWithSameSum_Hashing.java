package JavaLearn;

import java.util.HashMap;

public class PairWithSameSum_Hashing {

	public static void main(String[] args) {
		int arr[] = {3,4,7,1,2,8,9};
		PairwithsamesumInternal ps = new PairwithsamesumInternal();
		ps.IsPairWithSameSum_Method(arr);
		
	}	
}

class PairwithsamesumInternal {
	class Pair {
		int num1, num2;

		Pair(int n1, int n2) {
			num1 = n1;
			num2 = n2;
		}
	}

	public void IsPairWithSameSum_Method(int[] arr) {

		HashMap<Integer, Pair> hm = new HashMap<Integer, Pair>();

		for (int i = 0; i < arr.length; ++i) {
			for (int j = i + 1; j < arr.length; ++j) {
				int sum = arr[i] + arr[j];
				if (!hm.containsKey(sum)) {
					hm.put(sum, new Pair(i, j));
				} else {
					Pair p = hm.get(sum);

					System.out.println("(" + arr[p.num1] + "," + arr[p.num2] + ") , (" + arr[i] + " ," + arr[j] + " )");
				}
			}

		}
	}
}