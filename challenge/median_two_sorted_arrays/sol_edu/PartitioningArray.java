class Median {
 static Helper obj = new Helper(); // Helper class contating functions to find maximum or minimum 

 static double getMedian(int[] array1, int[] array2) {
  int size1 = array1.length;
  int size2 = array2.length;
  int end_index = size1;
  int start_index = 0, i = 0, j = 0, median = 0;

  while (start_index <= end_index) {
   i = (start_index + end_index) / 2;
   j = ((size1 + size2 + 1) / 2) - i;

   if (i < size1 && j > 0 && array2[j - 1] > array1[i])
    start_index = i + 1;

   else if (i > 0 && j < size2 && array2[j] < array1[i - 1])
    end_index = i - 1;

   else {
    if (i == 0)
     median = array2[j - 1];

    else if (j == 0)
     median = array1[i - 1];
    else
     median = obj.maximum(array1[i - 1],
     array2[j - 1]);
    break;
   }
  }

  if ((size1 + size2) % 2 == 1)
   return (double) median;


  if (i == size1)
   return (median + array2[j]) / 2.0;


  if (j == size2)
   return (median + array1[i]) / 2.0;

  return (median + obj.minimum(array1[i],
   array2[j])) / 2.0;
 }

 public static void main(String args[]) {
  int[] array1 = new int[] {
   900
  };
  int[] array2 = new int[] {5, 8, 10, 11, 20};

  int size1 = array1.length;
  int size2 = array2.length;

  if(size1 > size2){
    System.out.println("The median of " + Arrays.toString(array1) + " and " + Arrays.toString(array2) + " is " + getMedian(array2, array1));
  }else{
    System.out.println("The median of " + Arrays.toString(array1) + " and " + Arrays.toString(array2) + " is " + getMedian(array1, array2));
  }
  
 }
}
