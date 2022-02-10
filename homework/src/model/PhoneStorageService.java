package model;

public class PhoneStorageService {
    public void receivePhone(Phone phone){
        System.out.println("Receiving phone (model: " + phone.getModel() + ", color: " + phone.getColor() + "imeiCode: "+ phone.getImeiCode() + "), saving it into DB");
    }

    public void sellPhone(Phone phone){
        System.out.println("Selling phone (model: " + phone.getModel() + ", color: " + phone.getColor() + "imeiCode: "+ phone.getImeiCode() + "), delete it into DB.");
    }
}