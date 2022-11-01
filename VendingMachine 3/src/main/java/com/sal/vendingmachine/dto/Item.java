
package com.sal.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author vicmaia
 */
public class Item {

    private String name;
    private BigDecimal cost;
    private int numInventoryItems; // no of items in inventory


    //constructor

    public Item(String name, String cost, int inventory) {
        this.name = name;
        this.cost = new BigDecimal(cost);
        this.numInventoryItems = inventory;
    }

    public Item(String name) {
        this.name = name;
    }

    //getter methods
    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public int getInventory() {
        return numInventoryItems;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    //setter method
    public void setInventory(int numInventoryItems) {
        this.numInventoryItems = numInventoryItems;
    }

    //returns the name, cost, and number of items of a specific item
    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", cost=" + cost + ", numInventoryItems=" + numInventoryItems + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.cost);
        hash = 97 * hash + this.numInventoryItems;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.numInventoryItems != other.numInventoryItems) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.cost, other.cost)) {
            return false;
        }
        return true;
    }


    
    
}
