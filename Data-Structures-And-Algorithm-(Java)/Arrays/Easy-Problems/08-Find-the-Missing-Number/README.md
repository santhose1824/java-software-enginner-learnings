# Find the Missing Number

> **Section:** Arrays Easy  |  **Your solution file:** `FindTheMissingNumber.java`

## Question

```text
Given an integer array of size n containing distinct values in the range from 0 to n (inclusive), return the only number missing from the array within this range.

Example 1:
Input: nums = [0, 2, 3, 1, 4]

Output: 5

Explanation:

nums contains 0, 1, 2, 3, 4 thus leaving 5 as the only missing number in the range [0, 5]

Example 2:
Input: nums = [0, 1, 2, 4, 5, 6]

Output: 3

Explanation:

nums contains 0, 1, 2, 4, 5, 6 thus leaving 3 as the only missing number in the range [0, 6]
```

## Approach 1 — Brute Force

### Idea — how to think about it

The array should contain every number from 0 to n. For each candidate number i in 0…n, search the array (linear search); the number that is never found is the answer.

### Pseudocode

```text
for i = 0 to n:
    found = false
    for j = 0 to n-1:
        if arr[j] == i: found = true ; break
    if not found: return i
```

### Time & Space Complexity

**Time: O(n²)**  
n+1 candidates × a linear search of up to n elements each.

**Space: O(1)**  
A flag only.

## Approach 2 — Optimal

### Idea — how to think about it

**Optimal I — sum:** the full set 0…n adds up to n(n+1)/2. Subtract the sum of the given array; what is left is the missing number. (Notes: n = 5 → 15 minus the array sum.)
**Optimal II — XOR (no overflow):** `a ^ a = 0` and `0 ^ a = a`. XOR all numbers 0…n together with all array elements: every number present appears twice and cancels to 0, only the missing one remains. Both are O(n) time and O(1) space; XOR cannot overflow.

### Pseudocode

```text
// Optimal I (sum)
expected = n * (n + 1) / 2
return expected - (sum of all arr[i])

// Optimal II (XOR)  -- n = length of arr, values 0..n
xor1 = 0 ; xor2 = 0
for i = 0 to n-1:
    xor1 = xor1 ^ (i + 1)       // 1 ^ 2 ^ ... ^ n
    xor2 = xor2 ^ arr[i]        // XOR of the array
return xor1 ^ xor2              // 0 is neutral, so skipping 0 is fine
```

### Time & Space Complexity

**Time: O(n)**  
Both versions make a single pass over the n elements; the formula / XOR step is O(1) per element.

**Space: O(1)**  
Two or three integer variables.

## Corrected Java

```java
static int missingNumber(int[] arr) {
    int xor1 = 0, xor2 = 0;
    for (int i = 0; i < arr.length; i++) {   // all n elements
        xor1 ^= (i + 1);                      // 1..n
        xor2 ^= arr[i];
    }
    return xor1 ^ xor2;
}
```

## Corrections to your notes / code

- **Code bug (confirmed by running it):** for `[0,2,3,1,4]` (answer 5) `FindTheMissingNumber` prints **4**; for `[0,1]` it prints 1 instead of 2. The loops run to `length - 1`, so the last element and the number `n` are never XOR-ed. Loop over **all n elements** (`i < array.length`) with `(i+1)` on the first XOR, as in your notes.
- **Notes (brute force):** the outer loop is `for(1 → N)` — it must start at **0** (0 may be the missing number).
- **Notes (Optimal I):** 'return sum − sum' should say `expectedSum − arraySum`. Use `long` for the sums (your note: 'may need long') or prefer the XOR version.
