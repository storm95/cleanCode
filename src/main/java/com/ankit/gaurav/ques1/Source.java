package com.ankit.gaurav.ques1;

class Customer {
    int customerId;
    String name;
    double walletBalance;

    Customer(int customerId, String name, double walletBalance) {
        this.customerId = customerId;
        this.name = name;
        this.walletBalance = walletBalance;
    }
}

class Item {
    int itemId;
    String name;
    double price;
    boolean isInStock;

    Item(int itemId, String name, double price, boolean isInStock) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.isInStock = isInStock;
    }
}

class ShoppingWebsite {
    public String purchaseItem(Item i, Customer c) throws StockBalanceException {
        if (!i.isInStock) {
            throw new StockBalanceException("item is out of stock");
        }

        if (i.price > c.walletBalance) {
            throw new StockBalanceException("customer wallet balance is not sufficient");
        }

        return "Order Successful";
    }
}

class StockBalanceException extends Exception {
    StockBalanceException(String message) {
        super(message);
    }
}

public class Source {
    public static void main(String args[]) throws Exception {
        Customer cusDet = new Customer(927392, "Steve", 5000.0);//, "USA")
        Item itemDet = new Item(27392, "T-Shirt", 800, true);

        ShoppingWebsite shoppingWebsite = new ShoppingWebsite();
        System.out.println(shoppingWebsite.purchaseItem(itemDet, cusDet));
    }
}
