package ua.opnu.java.inheritance;

import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill2 {
    private GroceryBill bill;
    private boolean isRegularCustomer;
    private int discountCount;
    private double totalDiscountAmount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.isRegularCustomer = regularCustomer;
        this.discountCount = 0;
        this.totalDiscountAmount = 0.0;
    }

    public Employee getClerk() {
        return this.bill.getClerk();
    }

    public void add(Item i) {
        this.bill.add(i);

        if (this.isRegularCustomer) {
            double itemDiscount = i.getDiscount();
            if (itemDiscount > 0.0) {
                this.discountCount++;
                this.totalDiscountAmount += itemDiscount;
            }
        }
    }

    public double getTotal() {
        double fullTotal = this.bill.getTotal();

        double finalTotal;
        if (this.isRegularCustomer) {
            finalTotal = fullTotal - this.totalDiscountAmount;
        } else {
            finalTotal = fullTotal;
        }

        double factor = 100.0;
        return Math.round(finalTotal * factor) / factor;
    }

    public int getDiscountCount() {
        return this.isRegularCustomer ? this.discountCount : 0;
    }

    public double getDiscountAmount() {
        return this.isRegularCustomer ? this.totalDiscountAmount : 0.0;
    }

    public double getDiscountPercent() {
        if (!this.isRegularCustomer) {
            return 0.0;
        }

        double fullTotal = this.bill.getTotal();
        double discountedTotal = this.getTotal();

        if (fullTotal == 0.0) {
            return 0.0;
        }

        double percent = 100.0 - (discountedTotal * 100.0) / fullTotal;

        double factor = 10000000000000.0;
        return Math.round(percent * factor) / factor;
    }
}
