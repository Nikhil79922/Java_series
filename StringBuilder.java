
public class StringBuilder {

    public static void main(String[] args) {
        String s = "Nikhil";
        String s1 = new String("Nikhil");

        String s2 = new String(s);

        char[] arr = {'N', 'i', 'k', 'h', 'i', 'l', ' ', 'S', 'i', 'n', 'g', 'h'};
        String s3 = new String(arr);

        String s4 = new String(arr, 0, 5);
        System.out.println(s3);
        System.out.println(s4);
        byte[] arr2 = {97, 98, 99};

        String s5 = new String(arr2);
        System.out.println("s5 ==> " + s5);
    }
}
