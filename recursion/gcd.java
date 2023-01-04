package recursion;

public class gcd {
    public static void main(String[] args) {
        int x = 12, y = 18;
        System.out.println(euclidiangcd(x, y));
    }

    private static int euclidiangcd(int x, int y) {
        if (y == 0) {
            return x;
        }

        return euclidiangcd(y, x % y);
    }
}
