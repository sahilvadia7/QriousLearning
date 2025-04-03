// 1. Merge two sorted array in ascending order.

// Input1 : [1,2,5]
// Input2 : [3,4,6]
// Output : [1,2,3,4,5,6]

public class Program1 {

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 5 };
        int[] arr2 = { 3, 4, 6 };
        int[] sortedArray = new int[6];

        //concate
        for (int i = 0; i <= sortedArray.length - 1; i++) {
            if (i < 3) sortedArray[i] = arr1[i];
            else sortedArray[i] = arr2[i - 3];
        }

        //sorting
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[i] > sortedArray[j]) {
                    int temp;
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                }
            }
        }

        //printing
        for (int i = 0; i <= sortedArray.length - 1; i++) {
            System.out.println(sortedArray[i]);
        }
    }
}
