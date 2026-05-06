# 122. Best Time to Buy and Sell Stock II

**Difficulty:** Medium


**Topic:** Array, Dynamic Programming, Greedy

**Company:** Amazon, Google, Microsoft, Apple, Bloomberg

You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `i`th day.

On each day, you may decide to buy and/or sell the stock. You can only hold **at most one share** of the stock at any time. However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.

Find and return the *maximum profit* you can achieve.

---

## Example 1

```
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation:
Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
```

## Example 2

```
Input: prices = [1,2,3,4,5]
Output: 4
Explanation:
Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
```

## Example 3

```
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy
the stock to achieve the maximum profit of 0.
```

## Cách giải

Bài này khác s121 ở chỗ là s122 có thể buy/ sell liên tục trong cùng 1 ngày bất kể.
Miễn là ra profit.

Trong khi s121 lại yêu cầu trả về max profit biết rằng buy 1 ngày và bán vào 1 ngày khác.

Do đó, để ý rằng nếu diff giữa 2 ngày mà >= 0 thì sum vào để cộng dồn profit liên tục bất kể ngày nào.

```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff >= 0) {
                maxProfit += diff;
            }
        }

        return maxProfit;
    }
}
```