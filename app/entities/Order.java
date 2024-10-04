package app.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import app.entities.enums.OrderStatus;

public class Order {
    private Date moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> items = new ArrayList<>();//a lista tem que ser instanciada de começo
    
    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
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

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    // continuar criando os métodos da classe
}
