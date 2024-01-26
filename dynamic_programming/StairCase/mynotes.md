# Problem

A Child is running up the stairs with n steps and can hop either 1step, 2 steps, 3 steps at a time.
Implement a function to count the no of ways that child can run up the stairs

# Brute Force Approach

The main idea is to if you have n stairs, then you can hop either 1 step, 2 steps or 3 steps

1. if you hop 1 step, then you have n-1 remaining stairs
2. if you hop 2 steps, then you have n-2 remaining stairs
3. if you hop 3 steps, then you have n-3 remaining stairs

Hence, the total no of way a child can hop the stairs becomes

```
countWays(n-1) + countWays(n-2) + countWays(n-3)
```
It is similar to febinocci series problem, infact it follows the same approach

Time Complexity: **O(3^n)**


