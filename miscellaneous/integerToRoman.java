package miscellaneous;

class integerToRoman {
    static final int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    static final String[] romans = { "M", "CM", "D", "CD", "C", "LC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public static void main(String[] args) {
        int number = 3_924;
        System.out.println(solveUsingSubstraction(number));
    }

    private static String solveUsingSubstraction(int number) {
        String res = "";
        int i = 0;
        while (i < nums.length) {
            if (number >= nums[i]) {
                number -= nums[i];
                res += romans[i];
            } else {
                i++;
            }
        }
        return res;
    }
}
