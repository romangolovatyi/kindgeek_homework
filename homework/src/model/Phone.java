package model;

import exceptions.FieldIsNull;

import java.util.Map;
import java.util.Set;

public abstract class Phone {

    private String model;
    private int price;
    private long imeiCode;
    private String color;

    public abstract void call();

    public void turnOn() {
        System.out.println("Connect to network");
    }

    public void turnOff() {
        System.out.println("Disconnect from network");
    }

    public void sayPhoneDetails() throws FieldIsNull {
        if(getModel()==null) {
            throw new FieldIsNull("Model is null");
        } else if(getPrice()==0){
            throw new FieldIsNull("Price is zero");
        } else {
            System.out.println("The model of this phone - " + this.getModel() + ". The price of this phone is " + this.getPrice() + ".");
        }
    }

    public static void showInformationsAboutAllCases(Map<Case, String> mb){
        Set<Map.Entry<Case, String>> entrySet = mb.entrySet();
        for (Map.Entry<Case, String> entry: entrySet) {
            System.out.print(entry.getValue().toUpperCase() + " ");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getImeiCode() {
        return imeiCode;
    }

    public void setImeiCode(long imeiCode) {
        this.imeiCode = imeiCode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}