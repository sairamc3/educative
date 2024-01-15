# Problem

Implment a function that tells wheather a given target is present in the given sorted matrix or not.

The output should return boolean value if the element is found in the matrix. 

# My approach

	* To Minimize the comparisions, since it is sorted matrix
	* Find the rows having 1st value greater than the sarching element
	* So the previous row should have the value 
	* Iterate over the previous row to find the element
	* This process reduces the size of the iteration
