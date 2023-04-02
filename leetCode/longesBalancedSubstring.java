package leetCode;

/*
 * 
 */
public class longesBalancedSubstring {
    public static void main(String[] args) {
        String s = "00111";
        System.out.println("longes balanced string : " + balancedMax(s));
    }

    private static int balancedMax(String s) {
        int max = 0, index = 0, zeros = 0, ones = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '0') {
                zeros++;
            } else if (s.charAt(index) == '1') {
                ones++;
                if (ones >= zeros) {
                    Math.max(max, ones);
                }
            } else if (s.charAt(index) == '0' && (index != s.length() - 1 && s.charAt(index + 1) == '1')) {
                ones = 0;
            } else if (s.charAt(index) == '1' && (index != 0 && s.charAt(index - 1) == '0')) {
                ones = 0;
                zeros = 0;
            }
            index++;

        }
        return max;
    }
}
