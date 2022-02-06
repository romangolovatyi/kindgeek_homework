package model;

import interfaces.ChargingPhone;

import java.util.ArrayList;
import java.util.List;

public class Charger {

    private  final List<ChargingPhone> chargingPhones = new ArrayList<>();

    public void chargOn(){
        System.out.println("Turned on the electricity. Plugged the charger into the mains");
        for (ChargingPhone cp:chargingPhones) {
            cp.turnOnCharging();
        }
    }

    public void addElectricalAppliance(ChargingPhone chargingPhone){
        chargingPhones.add(chargingPhone);
    }
}
