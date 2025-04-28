package array;

public class _122_BestTimetoBuyandSellStock_II {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]){
                maxProfit = maxProfit + prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        _122_BestTimetoBuyandSellStock_II solution = new _122_BestTimetoBuyandSellStock_II();

        // 测试用例1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test case 1 result: " + solution.maxProfit(prices1));  // 输出: 7

        // 测试用例2
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Test case 2 result: " + solution.maxProfit(prices2));  // 输出: 4

        // 测试用例3
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Test case 3 result: " + solution.maxProfit(prices3));  // 输出: 0

        // 测试用例4
        int[] prices4 = {2, 4, 1, 5, 3, 7};
        System.out.println("Test case 4 result: " + solution.maxProfit(prices4));  // 输出: 10

        // 测试用例5：只有一天
        int[] prices5 = {5};
        System.out.println("Test case 5 result: " + solution.maxProfit(prices5));  // 输出: 0

        // 测试用例6：价格没有变动
        int[] prices6 = {10, 10, 10, 10, 10};
        System.out.println("Test case 6 result: " + solution.maxProfit(prices6));  // 输出: 0
    }
}
