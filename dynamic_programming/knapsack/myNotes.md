# Problem 

Imagine that you’re a burglar at a jewelry store with a knapsack. Your goal is to choose a combination of jewelry that results in the most profit. Let’s see how you would code this problem.

Given two integer arrays that represent the weights and profits of N items, implement a function knapSack() that finds a subset of these items that will gives us the maximum profit without their cumulative weight exceeding a given number capacity. Each item can only be selected once, which means we either skip it or put it in the knapsack.

# My Approach

## Brute force approach

* Fill the elments in the bag with hightest value first. Fill it until the jewelary is over or the bag cannot take any jewelary of same time. 
* Then put the next type of jewelary which is less than max value. 
* Repeat the steps untilt he sack is full or none of the jewelary can be added to the sack.
