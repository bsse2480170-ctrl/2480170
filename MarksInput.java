import java.util.Scanner;

public class MarksInput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sub1 = sc.nextInt();
        int sub2 = sc.nextInt();
        int sub3 = sc.nextInt();
        int sub4 = sc.nextInt();
        int sub5 = sc.nextInt();

        int total = sub1 + sub2 + sub3 + sub4 + sub5;
        float average = total / 5.0f;

        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
    }
}
