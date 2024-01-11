# Problem statment
Given an array of strings that contains anagrams, write a function to print those anagrams.
**Anagram**: A word or a phrase formed by rearranging the letters of different word or phrase, typically using all the original letters exactly once.

## Sample Input
"cat", "dog", "tac", "god", "act",  "tom marvolo riddle ","abc", "def",  "cab", "fed", "clint eastwood ", "i am lord voldemort", "elvis", "old west action",  "lives" 

## Sample Output
"[cat, tac, act][abc, cab][def, fed][clint eastwood , old west action][tom marvolo riddle , i am lord voldemort][elvis, lives][dog, god]"

# My thoughts

* Iterate through the array
	* For every element find the Anagram
	* If found remove it from the array and place it in the list add in a hashmap
	* You can as well make it null and check for null for every validation
* Challanege is to find the anagram
	* Split the string into an array or a list of characters
	* Check if all the elements in the array exist in the other element as well.

The logic suggested is similar to my approach.

Hence implmenting the same.
