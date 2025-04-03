package friday2803.arrays;

public class FindMaxInArr {

    public static void main(String[] args) {
        int[] number = { 7, 3, 4, 67, 4, 3, 6 };
        int[] sortedArr = { 1, 2, 2, 3, 4, 5, 6, 7 };
        System.out.println("Max in Array: " + MaxInArr(number));
        System.out.println("Sum Of Array: " + SumOfArr(number));
        System.out.println("Smallest in Array: " + Smallest(number));
        SecondLargest(number);
        System.out.println("Array is Sorted? :" + CheckSorted(sortedArr));
    }

    public static int MaxInArr(int[] arr) {
        int max = 0;

        for (int i : arr) {
            if (i > max) max = i;
        }
        return max;
    }

    public static int Smallest(int[] arr) {
        int small = arr[0];

        for (int i : arr) {
            if (i < small) small = i;
        }
        return small;
    }

    public static int SumOfArr(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static void SecondLargest(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("Second Largest ArrayElement: " + arr[1]);
    }

    public static boolean CheckSorted(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }
}
