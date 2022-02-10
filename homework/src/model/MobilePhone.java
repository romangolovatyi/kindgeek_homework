package model;

import exceptions.FieldIsNull;
import interfaces.ChargingPhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MobilePhone extends Phone implements ChargingPhone, Runnable {

    private Display display;
    private List<Case> mobilePhoneCases;

    public MobilePhone() {
        this.display = display;
        this.mobilePhoneCases = new ArrayList<>();
    }

    public MobilePhone(String model, long imeiCode, String color, Display display) {
        setModel(model);
        setImeiCode(imeiCode);
        setColor(color);
        this.display = display;
        this.mobilePhoneCases = new ArrayList<>();
    }

    public MobilePhone(int price, long imeiCode, String color, Display display) {
        setPrice(price);
        setImeiCode(imeiCode);
        setColor(color);
        this.display = display;
        this.mobilePhoneCases = new ArrayList<>();
    }

    public MobilePhone(String model, int price, long imeiCode, String color, Display display) {
        setModel(model);
        setPrice(price);
        setImeiCode(imeiCode);
        setColor(color);
        this.display = display;
        this.mobilePhoneCases = new ArrayList<>();
    }

    public void turnOnMobilePhone() {
        System.out.println("Show a picture");
        System.out.println("Enter the password");
        turnOn();
    }

    public void turnOffMobilePhone() {
        System.out.println("Show brand picture");
        turnOff();
    }

    public List<Case> addCase(Case newMobilePhoneCase){
        mobilePhoneCases.add(newMobilePhoneCase);
        System.out.println("Congratulations! Nice mobile case!");
        return mobilePhoneCases;
    }

    public Display getDisplay() {
        return display;
    }
    
    public List<Case> getMobilePhoneCases() {
        return mobilePhoneCases;
    }

    public void mobilePhoneCharging(){
        System.out.println("The screen lit up. The picture of the phone company is shown. Charging is slow.");
    }

    @Override
    public void call() {
        System.out.println("Vibration");
        System.out.println("Music + light");
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
            System.out.println("The model of this mobile phone - " + this.getModel() + ". The price of this mobile phone is " + this.getPrice() + " uah. " + "Display dimensions: " + this.getDisplay());
        }
    }

    @Override
    public void turnOnCharging() {
        mobilePhoneCharging();
    }

    @Override
    public void run() {
        System.out.println("OK. We take the charger. Connect it to the mobile phone. We plug the other side into an rosette.");
       turnOnCharging();
    }
}