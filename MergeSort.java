public class MergeSort {
   
   public static void mergeSort(int[] arr) {
      mergeSort(arr, new int[arr.length], 0, arr.length - 1);
   }
   
   public static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
      // base case: stop at size = 1
      if(leftStart >= rightEnd)
         return;
      int mid = (leftStart + rightEnd) / 2;
      // sort left half
      mergeSort(arr, temp, leftStart, mid);
      // sort right half
      mergeSort(arr, temp, mid + 1, rightEnd);
      // merge halves
      merge(arr, temp, leftStart, rightEnd);
   }
   
   public static void merge(int[] arr, int[] temp, int leftStart, int rightEnd) {
      int leftEnd = (leftStart + rightEnd) / 2;
      int rightStart = leftEnd + 1;
      int size = rightEnd - leftStart + 1;
      
      int left = leftStart;
      int right = rightStart;
      int tempIndex = leftStart;
      // compare and insert to temp, while in bounds
      while(left <= leftEnd && right <= rightEnd) {
         if(arr[left] < arr[right]) {
            temp[tempIndex] = arr[left];
            left++;
         }
         else {
            temp[tempIndex] = arr[right];
            right++;
         }
         tempIndex++;
      }
      System.arraycopy(arr, left, temp, tempIndex, leftEnd - left + 1);
      System.arraycopy(arr, right, temp, tempIndex, rightEnd - right + 1);
      System.arraycopy(temp, leftStart, arr, leftStart, size);
   }
   
   public static void main(String[] args) {
      int[] arr = {5, 3, 2, 7, 4, 1, 6, 8, 9, 25, 29, 21, 24, 23, 26, 28, 27, 22};
      mergeSort(arr);
      for(int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + ", ");
      }
   }
}