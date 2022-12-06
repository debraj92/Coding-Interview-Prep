package Practice;

import java.util.*;


public class Robber {
	
	/**
	 * House Robber: https://leetcode.com/problems/house-robber/
	 * 
	 * The idea is simple: If you loot the current house then you don't loot the next house.
	 * Now, of the two choices, one will be higher loot and then this is the best option for this house.
	 * 
	 * DP equation for any house i: loot till now + max(money in house i + DP[i+2], DP[i+1])
	 * DP[i+1] implies not looting house i and getting best from house i+1
	 * 
	 * Now, to improve efficiency we have to avoid re-computation. The best data to store is given house i
	 * what can be the max loot if robber starts from house i. This will prevent repeated recursions.
	 * 
	 * Now to connect to the previous house (i-1) and (i-2), we just need to add the stored data to the best 
	 * loot in (i-1) and (i-2)
	 * 
	 * Time Complexity : O(N). Only traversal of original array
	 * Space Complexity : O(N). Key is house number and there are N houses.
	 * 
	 */
	
	static Map<Integer, Integer> houseMaxLoot = new HashMap<>();
	
	public static int rob(int[] money, int houseNo, int loot) {
		
		if(houseNo >= money.length) {
			// nothing more to loot
			return loot;
		}
		
		if(houseMaxLoot.containsKey(houseNo)) {
			return loot + houseMaxLoot.get(houseNo);
		}
		
		// assume robber STARTS looting from this house
		int totalLootExcludingThisHouse = rob(money, houseNo + 1, 0);
		int totalLootIncludingThisHouse = rob(money, houseNo + 2, money[houseNo]);
		int bestLoot = Math.max(totalLootExcludingThisHouse, totalLootIncludingThisHouse);
		
		houseMaxLoot.put(houseNo, bestLoot);
		
		// connecting subproblems by adding to previous loot
		return loot + bestLoot;
		
	}
	
	public static void main(String[]args) {
		
		int maxLoot = rob(new int[] {2,7,9,3,1}, 0, 0);
		System.out.println(maxLoot);
		
	}

}
