package fundamentals.innerclassesConcept;

class Outer {
    int x = 10;

    class Inner {
        int x = 100;

        public void main(String[] args) {
            System.out.println("Iner");

        }

        public void methodOne() {
            int x = 1000;
            System.out.println("inner class method");
            System.out.println(x);
            System.out.println(this.x);
            System.out.println(Outer.this.x);
        }

    }

    public static void main(String[] args) {
        System.out.println("Outer");
    }
}

class concept {

    public static void main(String[] args) {
        new Outer().new Inner().methodOne();
        ;
    }

}