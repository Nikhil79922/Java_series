
// import College.Students;
import School.Students;

public class Mains {

    public static void main(String[] args) {
        Students schoolStu = new Students();
        schoolStu.print();

        College.Students colStudents = new College.Students();
// colStudents.print(); casue error because print has default access modifier and it only provide access to the package only. 

    }
}
