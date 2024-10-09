package app;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import app.entities.Client;
import app.entities.Order;
import app.entities.OrderItem;
import app.entities.Product;
import app.entities.enums.OrderStatus;

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

        Date birthDate = fmt.parse(dateClientStr);

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");

        System.out.print("Status: ");
        String strStatus = sc.nextLine();

        System.out.print("How many items to this order?: ");
        int n = sc.nextInt();

        Date currentTime = new Date();
        Order order = new Order(currentTime, OrderStatus.valueOf(strStatus), client);

        for(int i = 0; i < n; i++){
            sc.nextLine();
            System.out.println("Enter #" + (i+1) + " item data: ");
            System.out.print("Product name: ");
            String strProductName = sc.nextLine();
            System.out.print("Product price: ");
            double doubProductPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int intProductQuantity = sc.nextInt();
            Product product = new Product(strProductName, doubProductPrice);
            OrderItem orderItem = new OrderItem(intProductQuantity, doubProductPrice, product);
            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println(order.toString());
        sc.close();
    }
}