package recursion;

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