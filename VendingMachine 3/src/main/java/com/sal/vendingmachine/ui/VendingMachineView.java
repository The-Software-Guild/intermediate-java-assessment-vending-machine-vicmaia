
package com.sal.vendingmachine.ui;

import com.sal.vendingmachine.dto.Coins;
import com.sal.vendingmachine.dto.Item;
import com.sal.vendingmachine.service.VendingMachineService;
import com.sal.vendingmachine.ui.UserIOImpl;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vicmaia
 */
public class VendingMachineView{
    private UserIO io;

    public VendingMachineView (UserIO io){
        this.io = io;
    }

    public BigDecimal addFunds() {
        //asks user to input the amount of money
        return io.readBigDecimal("Please input the amount money in dollars before making selection");
    }

    public void displayMenuBanner() {
        io.print("=== Menu ===");
    }

    //displays items with costs
    public void displayMenu(Map<String, BigDecimal> itemsInStockWithCosts){
        itemsInStockWithCosts.entrySet().forEach(entry ->{
            System.out.println(entry.getKey() + ": $" +entry.getValue());
        });
    }

    //this message displays once user input money amount
    public String getItemSelection(){
        return io.readString("Please select a snack from the vending machine or 'exit' to quit");
    }

    //this message displays once the user purchases an item

    public void displayEnjoyBanner(String name) {
        io.print("Enjoy your " + name + "!");
    }


    //this message appears when the item costs more than the money input

    public void displayInsufficientFundsMsg(BigDecimal money){
        io.print("Insufficent funds, you only have input $"+ money);
    }

    //final message
    public void displayExitBanner() {
        io.print("Purchase Succeeded!");
        io.print("Good Bye");
    }

    //if user enters an item that is out of stock
    public void displayItemOutOfStockMsg(String name){
        io.print("Error, " + name + " is out of stock.");
    }

    //displays amount of change in pennies
    public void displayChangeDuePerCoin(Map<BigDecimal, BigDecimal> changeDuePerCoin) {
        changeDuePerCoin.entrySet().forEach(entry ->{
            System.out.println(entry.getKey() + "c : " +entry.getValue());
        });
    }


    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage (String errorMsg) {
        io.print("=== Error ===");
        io.print(errorMsg);
    }

    //user enters an invalid input.
    public void displayPleaseTryAgainMsg() {
        io.print("Please select something else.");
    }
}
