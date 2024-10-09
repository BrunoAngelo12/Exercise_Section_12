package app.entities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import app.entities.enums.OrderStatus;

public class Order {
    SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    private Date moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> items = new ArrayList<>();//a lista tem que ser instanciada de começo
    
    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Order (){
    }

    public void addItem(OrderItem item){
        this.items.add(item);
    }
    
    public void removeItem(OrderItem item){
        this.items.remove(item);
    }

    public Double total(){
        double total = 0.0;
        for(OrderItem x : items){
            total += x.subTotal();
        }
        return total;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        double sum = 0.0;
        sb.append("ORDER SUMARY:\nOrder moment: ").append(fmt1.format(moment)).append("\nOrder status: ")
        .append(status).append("\nClient: ").append(client.getName()).append(" ")
        .append(fmt.format(client.getBirthDate())).append(" - ").append(client.getEmail())
        .append("\nOrder items: \n");

        for(OrderItem x : items){
            sb.append(x.geProduct().getName()).append(", R$").append(x.getPrice()).
            append(", Quantity: ").append(x.getQuantity()).append(", Subtotal: R$")
            .append(x.subTotal()).append("\n");
            sum += x.subTotal();
        }
        sb.append("Total price: ").append("R$").append(sum);
        return sb.toString();
    }
}
