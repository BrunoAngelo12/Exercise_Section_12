package app;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Exercise12{
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter the client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        String dateClientStr = sc.nextLine();

        Date birthDate = (Date) fmt.parse(dateClientStr);

        System.out.println(birthDate);

        sc.close();
    }
}