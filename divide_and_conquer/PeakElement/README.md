# Peak Element

> ** A peak element in an array is the element which is greater than or equal to its nighbours. **

Ex: 

Consider an array of {13,27,54,31,99,11}

The peak elments are 54 and 99, they are greater than their nighbours. 

In case the element is at the end of the array, we consider only the available member.

## Boundary Cases

1. If the input array is sorted in assending order, the last element is always the peak element
2. If it is ordered in descending order then the first element is the peak element.
3. If the array holds all identical entries, any elment can be a peak value.

## Problem

Given an array of integers, return a peak element. 

## Input

Array of integers.

## Output

The `index` of the peak element in array `arr[].`
