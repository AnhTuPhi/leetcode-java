# Problem 14. Longest Common Prefix

## Issue
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
```
Input: strs = ["flower","flow","flight"]
Output: "fl"
```

Example 2:
```
Input: strs = ["dog","racecar","car"]
Output: ""
```
Explanation: There is no common prefix among the input strings.

Constraints:
```
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
```

## Solution
The important thing is realized that using array sorts the strings in lexicographical order.

After sorts, the first and last strings are the longest common prefix. 
We just need to check these instead of looping the whole strings.\

## Complexity
Time: 0ms
Space: O(n)