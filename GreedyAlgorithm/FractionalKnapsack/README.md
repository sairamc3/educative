# Fractional Snapsack

Given the weights & values of __n__ items, put the items in a knapsack with a capacity of __W__

## Problem Statement

You are given a capacity of knapsack __W__ and list of __n__ items that each have a certain value.
Fractions of each item can be placed in a knapsack. Your goal is to implment function for getting
the maximum possible total value of __V__ in the knapsack.

> **Note**: The problem is also known as the *continuous snapsack problem*

### Input

The inputs are the items as (*value, weight*) pairs and knapsack capacity *W*.

#### Sample input

```java
double[] weights = {2, 1, 6, 0.5, 0.25, 7};
double[] values = {50, 70, 100, 50, 30, 99};
int capacity = 10;
```

### Output

Maximum possible value

#### Sample output

```java
double result = 303.54;
```
