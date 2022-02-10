package model;

import exceptions.FieldIsNull;
import interfaces.ChargingPhone;
import interfaces.LocalizationSettings;
import interfaces.SmartphoneFunctions;

import java.util.ArrayList;
import java.util.List;

import static model.Consts.LINK_ON_ENTRY_SCREEN_FOR_SMARTPHONE;

public class Smartphone extends Phone implements SmartphoneFunctions, LocalizationSettings, ChargingPhone, Runnable {

    private Display display;
    private List<Case> smartphoneCases;

    public Smartphone() {
    }

    public Smartphone(String model, long imeiCode, String color, Display display) {
        setModel(model);
        setImeiCode(imeiCode);
        setColor(color);
        this.display = display;
        this.smartphoneCases = new ArrayList<>();
    }

    public Smartphone(String model, int price, long imeiCode, String color, Display display) {
        setModel(model);
        setPrice(price);
        setImeiCode(imeiCode);
        setColor(color);
        this.display = display;
        this.smartphoneCases = new ArrayList<>();
    }

    public Display getDisplay() {
        return display;
    }

    public List<Case> addCase(Case newSmartphoneCase){
        smartphoneCases.add(newSmartphoneCase);
        System.out.println("Congratulations! Nice mobile case!");
        return smartphoneCases;
    }


    private void smartphonePhoneCharging() {
        System.out.println("The screen lit up. On-screen animation of the charging process. The phone charges quickly.");
    }

    @Override
    public void turnOn(){
        System.out.println("Show picture " + LINK_ON_ENTRY_SCREEN_FOR_SMARTPHONE);
    }

    @Override
    public void call() {
        System.out.println("Subscriber's photo");
        System.out.println("Vibration");
        System.out.println("Music + light");
    }

    @Override
    public void establishInternetConnection() {
        System.out.println("Please wait.");
        System.out.println("Internet connection is establish.");
    }

    @Override
    public void turnOnCamera() {
        System.out.println("Turn on camera");
    }

    @Override
    public void checkLocalCountry() {
        System.out.println("Check country. If country is Ukraine - connection to database");
    }

    @Override
    public void changeLocalTariff() {
        System.out.println("Connect roaming");
    }

    @Override
    public void sayPhoneDetails() throws FieldIsNull {
        if(getModel()==null) {
            throw new FieldIsNull("Model is null");
        } else if(getPrice()==0){
            throw new FieldIsNull("Price is zero");
        } else if(getDisplay()==null){
            throw new FieldIsNull("Display is missing");
        } else {
            System.out.println("The model of this smartphone - " + this.getModel() + ". The price of this smartphone is " + this.getPrice() + " uah. " + "Display dimensions: " + this.getDisplay());
        }
    }

    @Override
    public void turnOnCharging() {
        smartphonePhoneCharging();
    }

    @Override
    public void run() {
        System.out.println("Now we take the charger. Connect it to the smartphone. We plug the other side into an rosette.");
        turnOnCharging();
    }
}