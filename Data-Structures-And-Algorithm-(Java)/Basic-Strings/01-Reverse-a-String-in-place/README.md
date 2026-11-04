# Reverse a String (in place)

> **Section:** Basic Strings  |  **Your solution file:** `ReverseAString.java`

## Question

```text
Given a string, the task is to reverse it. The string is represented by an array of characters s.

Perform the reversal in place with O(1) extra memory.

Note: no need to return anything, modify the given list.

Example 1:
Input : s = ["h", "e" ,"l" ,"l" ,"o"]

Output : ["o", "l", "l", "e", "h"]

Explanation :

The given string is s = "hello" and after reversing it becomes s = "olleh".

Example 2:
Input : s = ["b", "y" ,"e" ]

Output : ["e", "y", "b"]

Explanation :

The given string is s = "bye" and after reversing it becomes s = "eyb".
```

## Approach 1 — Brute Force

### Idea — how to think about it

Create a second array and copy the characters from the back. Easy, but it breaks the 'O(1) extra memory' requirement of the question.

### Pseudocode

```text
rev = new char[n]
for i = 0 to n-1:
    rev[i] = s[n-1-i]
copy rev back into s
```

### Time & Space Complexity

**Time: O(n)**  
n characters copied (plus n copied back).

**Space: O(n)**  
Second character array of n elements.

## Approach 2 — Optimal

### Idea — how to think about it

Strings given as a char array can be changed in place. Same two-pointer swap as *Reverse an Array*: `start` at index 0, `end` at n−1, swap and move inwards until they cross.

### Pseudocode

```text
start = 0 ; end = n - 1
while start < end:
    swap s[start], s[end]
    start++ ; end--
```

### Time & Space Complexity

**Time: O(n)**  
n/2 swaps = O(n).

**Space: O(1)**  
Only a `temp` variable.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.
