package FastFood;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private String customerName;
    private List<Item> orderItems;

    public OrderBuilder(){
        customerName = "Customer";
        orderItems = new ArrayList<>();
    }

    public OrderBuilder withItem(Item item){
        orderItems.add(item);
        return this;
    }

    public Order build() {
        return new Order(customerName, orderItems);
    }

    public OrderBuilder forCustomer(String customerName) {
        this.customerName = customerName;
        return this;
    }

//    public Order forCustomer(String customerName){
//        this.customerName = customerName;
//        return this;
//    }
//
//    public Order withMenuMeal(MenuItem item){
//        meals.add( new Meal().fromMenu(item));
//        return this;
//    }
}
