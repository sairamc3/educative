# Maximum Subarray Sum

> **In a given unsorted array, the maximum sum of a continuoes subarray is the one who's elements, when added together, give largest possible sum**

This problem is tricky one, because the array might have negative integers in any position.
Therefore, we have to cater to those negative integers while choosing the continuous subarray with largest positive values.

## Extreme cases

| Case | Solution |
|------|----------|
|When all entries are positive| Sum of all the elements will become the max sum|
|When all entries are negative| Smallest negative element will become the max sum|
|When there are both positive & Negative | This becomes complicated, \n as we have to sum all the possible combinations of the subarray \n to find the one which gives the maximum sum. |  

The task is to find the more efficient, divide and conquer technique to solve this problem.

