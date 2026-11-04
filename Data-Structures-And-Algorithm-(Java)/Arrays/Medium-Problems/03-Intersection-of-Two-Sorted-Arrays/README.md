# Intersection of Two Sorted Arrays

> **Section:** Arrays Medium  |  **Your solution file:** `IntersectionOfTwoSortedArrays.java`

## Question

```text
Given two sorted arrays, nums1 and nums2, return an array containing the intersection of these two arrays. Each element in the result must appear as many times as it appears in both arrays; that is, if an element appears x times in nums1 and y times in nums2, it should appear min(x, y) times in the result.

The intersection of two arrays is an array where all values are present in both arrays. Since both input arrays are sorted, the resulting intersection array should also be in sorted order.

Example 1:
Input: nums1 = [1, 2, 2, 3, 5], nums2 = [1, 2, 7]

Output: [1, 2]

Explanation:

The elements 1, 2 are the only elements present in both nums1 and nums2

Example 2:
Input: nums1 = [1, 2, 2, 3, 3, 3], nums2 = [2, 3, 3, 4, 5, 7]

Output: [2, 3, 3]

Explanation:

The element 2 appears in both arrays only one time.

The element 3 appears in both arrays two times so we add element 3 equal to its number of occurrences.
```

## Approach 1 — Brute Force

### Idea — how to think about it

For each element of `nums1`, search `nums2` for an **unused** equal element (mark it in a `visited` array so duplicates are matched only as many times as they exist in both arrays). Add it to the answer and stop searching for this element.

### Pseudocode

```text
vis[n2] = 0 ; ans = []
for i = 0 to n1-1:
    for j = 0 to n2-1:
        if nums1[i] == nums2[j] and vis[j] == 0:
            ans.add(nums1[i]) ; vis[j] = 1 ; break
        if nums2[j] > nums1[i]: break          // sorted → can stop early
return ans
```

### Time & Space Complexity

**Time: O(n1 × n2)**  
Nested loops: for each of n1 elements we may scan up to n2 elements.

**Space: O(n2)**  
The `visited` array.

## Approach 2 — Optimal

### Idea — how to think about it

Both arrays are sorted, so use **two pointers** (like merge):
- `nums1[i] < nums2[j]` → `nums1[i]` can't match anything further in `nums2` → `i++`
- `nums2[j] < nums1[i]` → `j++`
- equal → common element: add it, `i++`, `j++` (moving both makes duplicates match one-for-one, i.e. min(x, y) times).
Stop when either array ends.

### Pseudocode

```text
i = 0 ; j = 0 ; ans = []
while i < n1 and j < n2:
    if nums1[i] < nums2[j]:      i++
    else if nums2[j] < nums1[i]: j++
    else:
        ans.add(nums1[i]) ; i++ ; j++
return ans
```

### Time & Space Complexity

**Time: O(n1 + n2)**  
Every iteration moves at least one pointer forward, and the pointers can move at most n1 + n2 times in total.

**Space: O(1) extra (output excluded)**  
Only two indices besides the answer list.

## Corrected Java

```java
while (i < n1 && j < n2) {
    if (a[i] < b[j])       i++;
    else if (a[i] > b[j])  j++;          // <- was a repeat of the first test
    else { ans.add(a[i]); i++; j++; }
}
```

## Corrections to your notes / code

- **Code bug (confirmed by running it):** `IntersectionOfTwoSortedArrays` has `else if (arrayTwo[j] > arrayOne[i])` which is the *same* condition as the first branch, so it can never run; the `else` therefore fires when `arrayOne[i] > arrayTwo[j]` and wrongly adds a value. Example: `[7]` ∩ `[1,5]` printed `[7]` instead of `[]`. The second branch must be `arrayOne[i] > arrayTwo[j]` → `j++`.
- **Notes (brute force):** the early-exit test is written `if (arr1[i] > arr2[j]) break` — it should be `arr2[j] > arr1[i]` (stop when the scanned value is already larger).
- **Notes (optimal):** the second condition is written with `nums1[j]` — it must be `nums2[j] < nums1[i]`.
