# Inversion Count

Inversion count represents how far or close an array is from being sorted. If an array is sorted, then the inversion count is 0. But if it's sorted in the reverse order, the inversion count is maximum.

Let's say there are two elements `arr[i]` and `arr[j]` of an array. 

if `arr[i] > arr[j]` where `i<j`, then there is an inversion. 

## Example

```
{9,5,6,11,8,10}

The number of inversions are **5**

(9,5) (9,6) (9,8) (11,8) (11,10)
```


