
public class InterfacesDeep {

    public static void main(String[] args) {
        Payment p = new CreditCard();
        p.drive();

        A a = new D();
        a.fun();
    }
}

//After Java 8
interface Payment {

    void pay();

    // Default method
    default public void drive() {
        System.out.println("Payment is driving on transactions");
    }
}

class DebitCard implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment via Debit Card");
    }

    void fun() {
        System.out.println("checking and clearing doubts");
    }
}

class CreditCard implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment via Credit Card");
    }
}

interface A {

    default void fun() {
        System.out.println("A interface");
    }
}

interface B extends A {

    @Override
    default void fun() {
        System.out.println("B interface");
    }
;

}


interface C extends A {

    @Override
    default void fun() {
        System.out.println("C interface");
    }
;

}

class D implements B, C {

    @Override
    public void fun() {
        System.out.println("Inside D class");
        B.super.fun();
        C.super.fun();
    }
}
