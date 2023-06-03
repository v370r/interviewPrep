package contest23rdApril;

//divisible by 3 ,5, and 7;
public class sumMultiples {
    public static void main(String[] args) {
        int n = 7;
        System.out.println("sums multiple divisible by 3,5,7 are " + sumOfMulitples(n));
    }

    private static int sumOfMulitples(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                res += i;
            }
        }
        return res;
    }
}
