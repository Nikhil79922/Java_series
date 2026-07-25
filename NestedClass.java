
public class NestedClass {

    public static void main(String[] args) {
        //Type 1 :- Static Nested class.
        Outter outter = new Outter();
        Outter.Inner inner = new Outter.Inner(outter);
        inner.fun();

        //Type 2 :- Inner class 
        InnerNestedClass innerNested = new InnerNestedClass();
        InnerNestedClass.innerClass insideClass = innerNested.new innerClass();
        insideClass.fun();
        //Instead do this 
        InnerNestedClass.innerClass insideClass1 = new InnerNestedClass().new innerClass();

        insideClass1.fun();

        //Type 3 :- local class 
        ThirdType t3 = new ThirdType();
        t3.checkLocal();

        //Type 4 :- Anonynous class
        Person p1 = new Person() {
            @Override
            void introduce() {
                greet();
                System.out.println("Hi am a Nikhil");
            }

            void greet() {
                System.out.println("Hi");
            }
        };

        p1.introduce();
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

//Type - 3
class ThirdType {

    Object localValue() {
        final int y = 0;

        class Local {

            void fun() {
                System.out.println(y);
            }
        }

        Local l = new Local();
        l.fun();
        System.out.println(l);
        return l;
    }

    void checkLocal() {
        Object local2 = localValue();
    }

}

// Type 4 = anonymous class 
class Person {

    void introduce() {
        System.out.println("Hi am a Person");
    }
}

class Greet extends Person {

    @Override
    void introduce() {
        System.out.println("Hi am a Nikhil");
    }
}




/*
Use cases precedences
1) Static nested class 
2) Inner class 
3) Anonymous class --> now replace by ---> Lambda expressions
4) Local class :- very rarely used. 
*/
