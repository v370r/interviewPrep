public class lcm {
    public static void main(String[] args) {
        int x = 12, y = 18;
        System.out.println(lcmOptimised(x, y));
        System.out.println(lcmUnOptimised(x, y));
    }

    /*
     * Best practise:
     * a*b = lcm(a)*gcd(b) since gcd takes O(log(min(a,b))) same time and space
     * ---its optimised
     */
    public static int lcmOptimised(int x, int y) {
        return ((x * y) / gcd.euclidiangcd(x, y));
    }

    public static int lcmUnOptimised(int x, int y) {
        int lcm = Math.max(x, y);
        while (true) {
            if (lcm % x == 0 && lcm % y == 0) {
                return lcm;
            } else {
                lcm++;
            }
        }

    }

}
