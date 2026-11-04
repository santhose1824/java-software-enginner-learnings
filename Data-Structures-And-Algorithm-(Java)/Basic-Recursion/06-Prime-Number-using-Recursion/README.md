# Prime Number using Recursion

> **Section:** Basic Recursion  |  **Your solution file:** `PrimeNumberOrNot.java`

## Question

```text
Given an integer num, return true if it is prime otherwise false.

A prime number is a number that is divisible only by 1 and itself.

Example 1:
Input : num = 5

Output : true

Explanation : The factors of 5 are 1 and 5 only.

So it satisfies the prime number condition.

Example 2:
Input : num = 15

Output : false

Explanation : The factors of 15 are 1, 3, 5, 15 only.

As the number has factors other than 1 and itself, So it is not a prime number.
```

## Approach 1 — Brute Force

### Idea — how to think about it

**How to build any recursion (from your notes):** (1) write the **base condition** first — the smallest input whose answer you know, so the calls stop; (2) express the answer for size n using the answer for a *smaller* size; (3) every call adds one frame to the call stack, so the stack depth is the extra space.

The loop `for i = 2…` becomes a recursive call that carries `i` as a parameter: `isPrime(num, i)` = "does any number from i upward divide num?". Base: if `i*i > num` nothing divides it → prime. If `num % i == 0` → not prime. Otherwise try `i+1`. (Your notes: `isPrime(7,2) → (7,3)`.)

### Pseudocode

```text
isPrime(num, i):
    if num <= 1: return false
    if i * i > num: return true
    if num % i == 0: return false
    return isPrime(num, i + 1)

call: isPrime(num, 2)
```

### Time & Space Complexity

**Time: O(√n)**  
i climbs 2, 3, 4 … until i·i > num, i.e. at most √num calls.

**Space: O(√n)**  
Each of those √n calls is still waiting on the stack when the next one is made.

## Approach 2 — Optimal

### Idea — how to think about it

The loop version of the same √n test has the same time but needs no stack: O(1) space (see Basic-Maths → Prime Number Check).

### Pseudocode

```text
if n <= 1 return false
for i = 2 while i * i <= n:
    if n % i == 0: return false
return true
```

### Time & Space Complexity

**Time: O(√n)**  
Same √n iterations.

**Space: O(1)**  
No recursion.

## Corrections to your notes / code

- **Code bug (same as Maths):** `isPrime(1, 2)` returns `true` because `2 > √1`. Add `if (num <= 1) return false`.
