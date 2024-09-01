class Median {
 public static double getMedian(int array1[], int array2[]) {
  int sizeOfArray1 = array1.length;
  int sizeOfArray2 = array2.length;
  int arraySize = sizeOfArray1 + sizeOfArray2;
  int arraySizeMid = arraySize / 2;

  int i = 0;
  int j = 0;
  int count;

  int median = -1;
  int previousMedian = -1;

  for (count = 0; count <= arraySizeMid; count++) {
    previousMedian = median; // For even elements, we need to take the average of two medians and for that we are storing previous median
    if (i != sizeOfArray1 && j != sizeOfArray2) {
     if (array1[i] > array2[j]) {
      median = array2[j];
      j++;
     } else {
      median = array1[i];
      i++;
     }
    } else if (i < sizeOfArray1) {
     median = array1[i];
     i++;
    } else {
     median = array2[j];
     j++;
    }
   }
   if (arraySize % 2 == 1) { // if the total size of the two arrays is odd
    return median;
   } else { // if the total size of the two arrays is even
    return (median + previousMedian) / 2.0;
   }
 }

 public static void main(String args[]) {
  int array1[] = {
   4,
   5,
   7,
   10
  };
  int array2[] = {
   12,
   13,
   15,
   18,
   20,
   24
  };

  System.out.println("The median of " + Arrays.toString(array1) + " and " + Arrays.toString(array2) + " is " + getMedian(array1, array2));

  // Example 2
  int array3[] = {
   1,
   2,
   3,
   4,
   5
  };
  int array4[] = {
   100,
   200,
   300,
   400
  };

  System.out.println("The median of " + Arrays.toString(array3) + " and " + Arrays.toString(array4) + " is " + getMedian(array3, array4));
 }
}
