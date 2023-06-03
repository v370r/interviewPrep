import java.util.Arrays;
import java.util.stream.Collectors;

class A {
    private static int counter = 0;

    public static int getInstanceCount() {
        return counter;
    }

    public A() {
        counter++;
    }

    public static void main(String[] args) {
        A a = new A();
        A a1 = new A();
        System.out.println(A.getInstanceCount());
    }
}

/**
 * test
 */
class test {
    public static void main(String[] args) {
        System.out.println(38 / 17 + " " + 38 % 17);
    }

}