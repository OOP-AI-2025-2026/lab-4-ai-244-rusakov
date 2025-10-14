package ua.opnu.java.inheritance.bill;

import java.util.ArrayList;
import java.util.List;

public class GroceryBill {
    private Employee clerk;
    private List<Item> items;
    private double fullTotal;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.items = new ArrayList<>();
        this.fullTotal = 0.0;
    }

    public Employee getClerk() { return clerk; }

    public void add(Item i) {
        items.add(i);
        fullTotal += i.getPrice();
    }

    public double getTotal() {
        double factor = 100.0;
        return Math.round(fullTotal * factor) / factor;
    }
}
