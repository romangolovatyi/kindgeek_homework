package model;

import interfaces.ChargingPhone;

import static model.Consts.NATIONAL_PHONE_OPERATOR;

public class SimplePhone extends Phone implements ChargingPhone, Runnable {

    public SimplePhone() {
    }
    
    public SimplePhone(String model, int price, String color) {
        setModel(model);
        setPrice(price);
        setColor(color);
    }

    public void turnOnSimplePhone(){
        System.out.println("Play music");
        turnOn();
    }

    private void simplePhoneCharging() {
        System.out.println("Phones of this types don't work without power grid. Must always be connected to the network.");
    }

    @Override
    public void turnOn(){
        System.out.println("Connect to " + NATIONAL_PHONE_OPERATOR);
    }

    @Override
    public void call() {
        System.out.println("Ring, ring");
    }

    @Override
    public String toString() {
        return "SimplePhone{}";
    }

    @Override
    public void turnOnCharging() {
        simplePhoneCharging();
    }

    @Override
    public void run() {
        System.out.println("We take the charger. Connect it to the phone. We plug the other side into an rosette.");
        turnOnCharging();
    }
}