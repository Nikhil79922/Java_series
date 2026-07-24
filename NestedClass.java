
public class NestedClass {

    public static void main(String[] args) {
        Outter outter = new Outter();
        Outter.Inner inner = new Outter.Inner(outter);
        inner.fun();

        //Type 2
        InnerNestedClass innerNested = new InnerNestedClass();
        InnerNestedClass.innerClass insideClass = innerNested.new innerClass();
        insideClass.fun();
        //Instead do this 
        InnerNestedClass.innerClass insideClass1 = new InnerNestedClass().new innerClass();

        insideClass1.fun();
    }
}

class Outter {

    private static int x = 10;
    int y;

    static class Inner {

        Outter outter;

        public Inner(Outter outter) {
            this.outter = outter;
        }

        void fun() {
            System.out.println(x);
            System.out.println(outter.y);

        }
    }
}

class Bank {

    private static class interestCompute {

        private int x;

        static double yealyInterest(double balance, double rate) {
            return balance * rate;
        }

        static double monthlyInterest(double balance, double rate) {
            return balance * rate;
        }
    }

    public double computeYealyInterest(double balance, double rate) {
        return interestCompute.yealyInterest(balance, rate);
    }

    public double computeMonthlyInterest(double balance, double rate) {
        return interestCompute.monthlyInterest(balance, rate);
    }

    /* 
    1. Can have the access in the outter class. As a helper class 
    2. Build design patterns 
    3. If you wants to have static methods inside a nested class.
    4. Request/Response DTO. 
     */
}

//Type - 2
class InnerNestedClass {

    int x = 10;

    class innerClass {

        int x = 20;

        static void fun2() {
            System.out.println();
        }

        void fun() {
            System.out.println(x);
            System.out.println(InnerNestedClass.this.x);
            System.out.println("Hello");
        }
    }

}
