# 169. Majority Element
**Difficulty:** Easy

**Topic:** Array, Hash Table, Divide and Conquer, Sorting, Counting

**Company:** Amazon, Apple, Google, Microsoft, Adobe

## Problem

Given an array `nums` of size `n`, return the majority element.

The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.

## Examples

**Example 1:**
```
Input: nums = [3,2,3]
Output: 3
```

**Example 2:**
```
Input: nums = [2,2,1,1,1,2,2]
Output: 2
```

## Constraints

- `n == nums.length`
- `1 <= n <= 5 * 10^4`
- `-10^9 <= nums[i] <= 10^9`
- The input is generated such that a majority element will exist in the array.

## Follow-up

Could you solve the problem in linear time and in O(1) space?

## Cách giải

Đề yêu cầu trả về phần tử xuất hiện nhiều hơn n/2 lần (đây chính là ý nghĩa của majority element) trong một mảng n phần tử.

```java
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int index = n / 2;

        Map<Integer, Integer> mapper = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Integer key = mapper.getOrDefault(nums[i], null);
            if (Objects.isNull(key)) {
                mapper.put(nums[i], 1);
            } else {
                key++;
                mapper.put(nums[i], key);
            }
        }

        for (Map.Entry<Integer, Integer> entry : mapper.entrySet()) {
            if (entry.getValue() > index) return entry.getKey();
        }

        return 0;
    }
}
```

Sử dụng hashmap để làm counter với key là giá trị và value là số lần count được.