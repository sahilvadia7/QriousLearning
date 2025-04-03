public class Program2 {

    public static void main(String[] args) {
        int[] arr1 = { 1, 4, 5, 3, 9, 0, 8, 6 };
        SumOfTwo(arr1);
        // for (int i = 0; i < SumOfTwo(arr1).length; i++) {
        //     System.out.println(i);
        // }
    }

    public static int[] SumOfTwo(int[] arr1) {
        for (int i = 0; i <= arr1.length - 1; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] + arr1[j] == 9) {
                    System.out.print("[" + arr1[i] + "," + arr1[j] + "] ,");
                    return new int[] { i, j };
                }
            }
        }

        return null;
    }
}
