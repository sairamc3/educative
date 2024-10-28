# Collect Coins in minimum steps

Find the min no of steps it takes to collect the coins given an array of the heights of vertically stacked coins.

Suppose you are given many adjacent piles of vertically stacked coins.

You are required to calculate min no of steps neede to collect these coins(min no of straight lines that pass through all the coins). In one step you can collect one horizantal or one vertical line of coins and the collected coins should be continuous. 

## Problem Statement

Given an integer array representing the height of each stack of coins and the number of coins, calculate the min no of straight lines that pass through the coins.

### Input

```java
int[] height = [3,1,1,5,1];
```
Each value in the array corrosponds to the **Height of the stack**.

In the given array there are 5 stacks of coins. In the first stack there are 3 coins, then one in the second and third and so on 

```java
int n = 5;
```

The size of the given array or, in other words, the number of given stacks.

### Output

```java
int output = 3;
```
All the above coins can be collected in less than 3 moves
