package ua.opnu.java.inheritance;

import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill extends GroceryBill {
    private boolean isRegularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.isRegularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    @Override
    public void add(Item i) {
        super.add(i);

        if (this.isRegularCustomer) {
            double itemDiscount = i.getDiscount();
            if (itemDiscount > 0.0) {
                this.discountCount++;
                this.discountAmount += itemDiscount;
            }
        }
    }

    @Override
    public double getTotal() {
        double fullTotal = super.getTotal();

        double finalTotal;
        if (this.isRegularCustomer) {
            finalTotal = fullTotal - this.discountAmount;
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
        return this.isRegularCustomer ? this.discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        if (!this.isRegularCustomer) {
            return 0.0;
        }

        double fullTotal = super.getTotal();

        if (fullTotal == 0.0) {
            return 0.0;
        }

        double discountedTotal = this.getTotal();
        double percent = 100.0 - (discountedTotal * 100.0) / fullTotal;

        double factor = 10000000000000.0;
        return Math.round(percent * factor) / factor;
    }
}
