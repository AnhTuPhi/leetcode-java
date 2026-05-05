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

| Cách                   | Time | Space | Ghi chú |
|------------------------|---|---|---|
| HashMap                | O(n) | O(n) | Dễ hiểu nhất |
| Sort                   | O(n log n) | O(1) | Code ngắn nhất |
| **Boyer-Moore Voting** | **O(n)** | **O(1)** | **Tối ưu nhất** |

### HashMap
Sử dụng hashmap để làm counter với key là giá trị và value là số lần count được.

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

### Boyer-Moore Voting Algorithm
VD:
nums = [2, 2, 1, 1, 1, 2, 2]

num=2: count=0 → candidate=2, count=1
num=2: num==candidate → count=2
num=1: num!=candidate → count=1
num=1: num!=candidate → count=0
num=1: count=0 → candidate=1, count=1
num=2: num!=candidate → count=0
num=2: count=0 → candidate=2, count=1

return 2 ✅

## Tại sao ra 2?

Boyer-Moore không cần kiểm tra `n/2` — **majority element tự động sống sót** vì bản chất toán học của nó.

### Hãy nghĩ theo kiểu "triệt tiêu"

```
Mỗi cặp (khác nhau) sẽ triệt tiêu nhau:

[2, 1] → triệt tiêu nhau → còn lại gì? 2 dư ra
[2, 1] → triệt tiêu nhau → còn lại gì? 2 dư ra
[2, 2] → cùng loại, không triệt tiêu

nums = [2, 2, 1, 1, 1, 2, 2]
        ↑           ↑        → triệt tiêu
           ↑     ↑           → triệt tiêu
              ↑        ↑  ↑  → 2 còn dư lại ✅
```

---

## Vậy điều kiện n/2 ở đâu?

Điều kiện `n/2` đã được **ẩn trong logic toán học**:

```
n = 7
Số lần xuất hiện: 2 → 4 lần, 1 → 3 lần

Cần triệt tiêu tối đa 3 lần (số lần của 1)
2 vẫn còn dư: 4 - 3 = 1 lần → candidate cuối = 2 ✅
```

> Vì majority element xuất hiện **hơn n/2 lần**, dù bị triệt tiêu bao nhiêu lần bởi các phần tử khác, nó **vẫn luôn dư ra** ít nhất 1 lần ở cuối.

---

## Nếu không có majority element thì sao?

```
nums = [1, 2, 3]  ← không có majority element
→ Boyer-Moore vẫn trả về 1 số nào đó nhưng SAI ❌
```

> Đó là lý do đề bài **đảm bảo** majority element luôn tồn tại — Boyer-Moore chỉ đúng khi có điều kiện này.

```java
public Integer solve2(Input input) {
        int[] nums = input.nums();
        int vote = 0;
        int candidate = 0;

        for (int num : nums) {
            if (vote == 0) {
                candidate = num;
            }

            if (candidate == num) {
                vote++;
            } else {
                vote--;
            }
        }

        return candidate;
    }
```

