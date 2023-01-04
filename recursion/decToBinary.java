
public class decToBinary {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(decToBinary.convertby100(x));

    }

    static String convert(int x) {
        if (x == 0 || x < 0) {
            return "";
        } else {
            return convert(x / 2) + String.valueOf(x % 2);
        }
    }

    static int convertby100(int x) {
        if (x == 0 || x < 0) {
            return 0;
        } else {
            return convertby100(x / 2) * 10 + (x % 2);
        }
    }
}
