# Remove Duplicates from Sorted Array

> **Section:** Arrays Easy  |  **Your solution file:** `RemoveDuplicatesFromAnArray.java`

## Question

```text
Given an integer array nums sorted in non-decreasing order, remove all duplicates in-place so that each unique element appears only once.

Return the number of unique elements in the array.

If the number of unique elements be k, then,

Change the array nums such that the first k elements of nums contain the unique values in the order that they were present originally.
The remaining elements, as well as the size of the array does not matter in terms of correctness.
The driver code will assess correctness by printing and checking only the first k elements of the modified array.
An array sorted in non-decreasing order is an array where every element to the right of an element is either equal to or greater in value than that element.

Example 1:
Input: nums = [0, 0, 3, 3, 5, 6]

Output: 4

Explanation:

Resulting array = [0, 3, 5, 6, _, _]

There are 4 distinct elements in nums and the elements marked as _ can have any value.

Example 2:
Input: nums = [-2, 2, 4, 4, 4, 4, 5, 5]

Output: 4

Explanation:

Resulting array = [-2, 2, 4, 5, _, _, _, _]

There are 4 distinct elements in nums and the elements marked as _ can have any value.
```

## Approach 1 — Brute Force

### Idea — how to think about it

Put the elements in a Set (a set keeps only unique values; use a `TreeSet`/`LinkedHashSet` so the order is kept), then copy the set's elements back into the first k positions of the array and return k.

### Pseudocode

```text
set = empty TreeSet
for x in arr: set.add(x)
index = 0
for v in set:
    arr[index] = v
    index++
return index
```

### Time & Space Complexity

**Time: O(n log n)**  
Inserting n elements into a TreeSet costs log n each (balanced tree) → n·log n; copying back is O(k) ≤ O(n). (With a HashSet it would be O(n) but the order is not guaranteed.)

**Space: O(n)**  
The set may hold up to n distinct values.

## Approach 2 — Optimal

### Idea — how to think about it

Because the array is **sorted**, equal values sit next to each other — a new value appears whenever `arr[j] != arr[i]`. Use two pointers: `i` marks the end of the unique prefix, `j` scans ahead. When `arr[j]` differs from `arr[i]`, it is a new unique value: move `i` forward and copy `arr[j]` there. At the end the first `i+1` slots contain the unique values (your notes: `return i+1`).

### Pseudocode

```text
if n == 0 return 0
i = 0
for j = 1 to n-1:
    if arr[j] != arr[i]:
        i++
        arr[i] = arr[j]
return i + 1
```

### Time & Space Complexity

**Time: O(n)**  
`j` moves through the array once; every step is O(1).

**Space: O(1)**  
In place — only the two indices.

## Corrected Java

```java
static int removeDuplicates(int[] arr) {
    if (arr.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < arr.length; j++) {
        if (arr[j] != arr[i]) {
            i++;
            arr[i] = arr[j];       // <- the write that was missing
        }
    }
    return i + 1;
}
```

## Corrections to your notes / code

- **Code does not do what the question requires (confirmed):** it only counts the unique values; the array is never rearranged, so `[0,0,3,3,5,6]` is left unchanged. The question says the first k elements must *contain* the unique values. Use the `arr[++i] = arr[j]` write shown above.
- Empty array: your code returns `1` (count+1 with count=0). Guard `n == 0` and return 0.
