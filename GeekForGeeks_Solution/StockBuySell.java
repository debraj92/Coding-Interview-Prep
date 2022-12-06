package JavaLearn.GeekForGeeks_Solution;

/**
 * https://www.geeksforgeeks.org/stock-buy-sell/
 * 
 * The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days.
 *
 */
public class StockBuySell {
	public static void main(String[]args) {
		int[] prices = new int[] {100, 180, 260, 310, 40, 535, 695};
		System.out.println("Max profit "+buySell(prices));
	}
	
	/**
	 * The idea is to find the maximum difference in O(N) such that the max value occurs after the min value. 
	 * For this, the easiest way is to just keep track of the minimum element seen
	 * till now. Find the diff with the current and check if this diff is greater than max_diff. 
	 * 
	 */
	public static int buySell(int[] prices) {
		// We buy on day 0 and sell on day 1 - base case
		int b=0;
		int s=1;
		int max_diff = prices[s] - prices[b]; // assuming at least 2 days
		int min = Math.min(prices[b], prices[s]);
		int i=2;
		while(i<prices.length) {
			max_diff = Math.max(max_diff, prices[i] - min);
			min = Math.min(min, prices[i]);
			i++;
		}
		
		return max_diff;
	}
}
