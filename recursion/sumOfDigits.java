package recursion;

/**
 * sumOfDigits
 */
public class sumOfDigits {
    public static void main(String[] args) {
        int x = 4;
        int sum = 0;
        // System.out.println(recursiveSumOfDigits(x, sum));
        System.out.println(recursive(123));
    }

    private static int recursiveSumOfDigits(int x, int sum) {
        if (x < 10) {
            return sum + x;
        } else {
            int y = x % 10;
            x = x / 10;
            y += sum;
            return recursiveSumOfDigits(x, y);
        }
    }

    public static int recursive(int x) {
        if (x == 0) {
            return 0;
        }
        return x % 10 + recursive(x / 10);

    }

}