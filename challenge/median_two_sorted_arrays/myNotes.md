# Problem

Given two sorted arrays, find the median by combining the arrays.
	* If the length of the new array is odd, then middle eliment will become the median
	* If the length of the new array is even, then average of middle two elements becomes median

For Ex: A = {100}, B = {1,5,8,10,20}
then 
	C = {1,5,8,10,20,100}
Even number. Hence `(8+10)/2` becomes 9.0.

Hence the median is 9.0

## My approach

* Initially we need to merge the two arrays and get it sorted. 
* This can be done in multiple ways

* We can combine the arrays and them sort them using arrays library. But there might be better way.
* While merging itself we can find the actual place where the element needs to be inserted.
	- Since both arrays are sorted, we need not compare the whole array all the time. 
	- More can be explained in the code, if this approach is followed. 


