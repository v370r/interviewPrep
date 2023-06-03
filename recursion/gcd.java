
public class gcd {
    public static void main(String[] args) {
        int x = 12, y = 18;
        System.out.println(euclidiangcd(x, y));
    }

    public static int euclidiangcd(int x, int y) {
        if (x == 0) {
            return y;
        }

        return euclidiangcd(y % x, x); // best and understandable approach :)
    }
}
