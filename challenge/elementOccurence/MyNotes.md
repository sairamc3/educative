# Problem

Given a sorted array of Integers, find the frequency of occurence of a particular value in the array.

If the element is not found the array at all, then return **0**

# My approach

* Doing a linear Search will solve the problem, but there would be better approach
* Use binary search
* Find the center element
	- If it is equal to the searching element, then increment counter and look left
	- incrment the counter until the element series breaks
	- repeat the same process for the right side of the array
	- summing up would give the total no of repeating elements
* If it is not the centre element then 
	- find the left array of find the element
	- if not, do the same for right array. 

