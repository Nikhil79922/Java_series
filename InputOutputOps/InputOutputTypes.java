package InputOutputOps;

import java.io.IOException;
import java.util.Scanner;

public class InputOutputTypes {

    public static void main(String[] args) throws IOException {

        // InputStreamReader isr = new InputStreamReader(System.in);
        // BufferedReader br = new BufferedReader(isr);
        // String name = br.readLine();
        // System.out.println("Output streams data ===> " + name);
        // //Type 1 :- console I/P
        // System.err.println("Checking error");

        /*
        --- Input
        1) Firstly take the Input from User
        2) convert to OS streams 
        3) Create the InputStreams of Character from streams of Bytes 
        4) Store the Char Streams in Java buffer memory.
        5) Read the complete streams using readLine --> and then store the same in String varaible.
        --- Output
         */
        //Now these are similfied or cover in Scanner class in Java 
        Scanner sc = new Scanner(System.in);

        //full line 
        String line = sc.nextLine();
        System.out.println(line);

        //One word 
        String word = sc.next();
        System.out.println(word);

        //Int 
        int val = sc.nextInt();
        System.out.println(val);

        //Double
        double dou = sc.nextDouble();
        System.out.println(dou);

        //Boolean
        boolean bool = sc.nextBoolean();
        System.out.println(bool);
    }

}
