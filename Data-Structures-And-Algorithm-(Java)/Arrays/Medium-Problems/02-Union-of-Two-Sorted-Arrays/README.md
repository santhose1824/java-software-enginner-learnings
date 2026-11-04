# Union of Two Sorted Arrays

> **Section:** Arrays Medium  |  **Your solution file:** `UnionOfTwoSortedArrays.java`

## Question

```text
Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in ascending order.

The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both.

Example 1:
Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]

Output: [1, 2, 3, 4, 5, 7]

Explanation:

The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2

Example 2:
Input: nums1 = [3, 4, 6, 7, 9, 9], nums2 = [1, 5, 7, 8, 8]

Output: [1, 3, 4, 5, 6, 7, 8, 9]

Explanation:

The element 7 is common to both, 3, 4, 6, 9 are from nums1 and 1, 5, 8 is from nums2
```

## Approach 1 — Brute Force

### Idea — how to think about it

A union contains every value **once**. Throw both arrays into a sorted set (`TreeSet`) — duplicates vanish automatically — then copy the set into the result.

### Pseudocode

```text
set = empty TreeSet
for x in nums1: set.add(x)
for x in nums2: set.add(x)
return set as array
```

### Time & Space Complexity

**Time: O(n1·log n1 + n2·log n2) (≈ O((n1+n2)·log(n1+n2)))**  
Each insertion into a balanced tree set costs log(size). We do n1 + n2 insertions. Copying the set out is O(n1+n2).

**Space: O(n1 + n2)**  
Set plus the answer array.

## Approach 2 — Optimal

### Idea — how to think about it

Both arrays are already sorted, so **merge** them like in merge sort with two pointers `i`, `j`: always take the smaller current element. The only difference from a normal merge: **skip a value if it equals the last value we added** (that is the 'is it repeating?' check in your notes). When one array runs out, process the rest of the other the same way.

### Pseudocode

```text
i = 0 ; j = 0 ; union = []
while i < n1 and j < n2:
    if nums1[i] <= nums2[j]:
        if union is empty or union.last != nums1[i]: union.add(nums1[i])
        i++
    else:
        if union is empty or union.last != nums2[j]: union.add(nums2[j])
        j++
while i < n1:
    if union.last != nums1[i]: union.add(nums1[i]) ; i++
while j < n2:
    if union.last != nums2[j]: union.add(nums2[j]) ; j++
return union
```

### Time & Space Complexity

**Time: O(n1 + n2)**  
Each step advances either `i` or `j`; together they advance at most n1 + n2 times, and every step is O(1).

**Space: O(n1 + n2) for the output, O(1) extra**  
The result list is required by the question; no other storage is used.

## Corrections to your notes / code

- Your code is correct. (Space: the output list is the only storage — it is *required* output, so the extra/auxiliary space is O(1).)
