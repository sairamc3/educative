# Missing number in a sorted Array

Suppose you are given an array of integers starting from 1 to `n`, with one integer missing from any position in the array. 

Ex: `array = {1,2,3,4,6,7,8,9}`

The missing integer in the array is `6`

2. `array = {2,3,4}`

The missing integer in the array is `1`

## My idea

Since it is a sorted array, we can use binary search. 
For every middle element check if the value is greater then `1` by it's index. 
if it is ?  Yes -> then the left side array is fine and you can look in the right array
If not -> then the left side array is where the element is missing. 

Include the middle element for the left array, since if it is mismatching then the middle element as well be missing the actual element. 
