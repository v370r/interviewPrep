package udemyDSA.divideAndConqer;

/*
 * Given number N. find the number of ways to express N as sum of 1,3,4
 * N = 4
 * ans = 4 ,
 * 
 * N=5
 * ans= 6
 */
public class numberFactor {
    public static void main(String[] args) {
        int N = 5, ans = 0;
        System.out.println("No of ways possible  : " + waystOGetN(N));
    }

    /*
     * online solution
     */
    public static int waystOGetN(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return 1; /// base case
        }
        if (n == 3) {
            return 2;
        }
        int sub1 = waystOGetN(n - 1);
        int sub2 = waystOGetN(n - 3);
        int sub3 = waystOGetN(n - 4);
        return sub1 + sub2 + sub3;
    }

    /*
     * My solution
     */
    private static int factors(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (n < 3) {
            return factors(n - 1);
        } else if (n < 4) {
            return factors(n - 1) + factors(n - 3);
        } else {
            return factors(n - 1) + factors(n - 3) + factors(n - 4);
        }

    }
}
