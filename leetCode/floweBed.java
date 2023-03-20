package leetCode;

public class floweBed {
    public static void main(String[] args) {
        int arr[] = { 0, 0, 0 }, flowers = 0;
        System.out.println("Flowers can be placed : " + flowersPlacing(arr, flowers));
    }

    private static int flowersPlacing(int[] arr, int flowers) {
        int count = 0;
        int len = arr.length;
        if (len < 3) {
            if (len == 0) {
                return 0;
            } else if (len == 1 && arr[0] == 0) {
                return 1;
            } else if (len == 2 && (arr[0] == 0 && arr[1] == 0)) {
                return 1;
            }
            return 0;
        }

        int[] slide = new int[3];
        for (int i = 0; i < slide.length; i++) {
            slide[i] = arr[i];
        }
        if (slide[1] == 0 && slide[0] != 1) {
            count += 1;
            slide[0] = 1;
        }

        for (int i = 1; i < arr.length - 2; i++) {
            if (slide[0] == 0 && slide[1] == 0 && slide[2] == 0) {
                slide[1] = 1;
                count++;
            }
            moveForwared(slide, arr[i + 2]);
        }

        if (slide[0] == 0 && slide[1] == 0 && slide[2] == 0) {
            count++;
        } else if (slide[0] == 1 && slide[1] == 0 && slide[2] == 0) {
            count++;
        }

        return count;
    }

    private static void moveForwared(int[] slide, int element) {
        for (int i = 0; i < slide.length - 1; i++) {
            slide[i] = slide[i + 1];
        }
        slide[2] = element;
    }
}
