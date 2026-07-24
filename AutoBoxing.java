
public class AutoBoxing {

    public static void main(String[] args) {
        Integer x = new Integer(69); // old java 

        Integer y = x; // Autoboxing 

        System.out.println(x + " " + y); // Unboxing 

        int z = y; // Unboxing 
        int a = y.intValue(); //Inernal working on Unboxing
        System.out.println("A==> " + a);
        System.out.println("Z==> " + z);

        Integer val = 11;
        printIntegerUnboxing(val);

        int value = 20;
        printIntAutoboxing(value);

        //Arithematic ops 
        Integer a1 = 10;
        Integer b1 = 20;

        int sum = a1 + b1;
        System.out.println("Sum====> " + sum);

        // Null pointer exception 
        Integer num = null; //Objects can store null value , this is fine 
        int n = num; // no issue in compile time;
        System.out.println(" Null pointer exception " + n); // Exeception cause primitive data type can't store null values 
    }

    static void printIntegerUnboxing(int x) {
        System.out.println(x);
    }

    static void printIntAutoboxing(Integer x) {
        System.out.println(x);
    }
}

// Unboxing / Autoboxing 
// 1) Assignments 
// 2) Method calls 
// 3) Arithematic ops 
