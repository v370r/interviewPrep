package fundamentals;

class Test {
    public static void main(String[] args) {
        try {
            System.out.println(10 / 0);
            // } catch (Exception ex || ArithmeticException e) { fails
        } catch (Exception ex) {
            System.out.println("Sefsef");
            ;
        }
    }
}