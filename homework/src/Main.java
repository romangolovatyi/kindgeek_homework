import exceptions.FieldIsNull;
import interfaces.ChargingPhone;
import model.*;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FieldIsNull, IOException, NoSuchFieldException, IllegalAccessException {

//        Add phones with some parameters
        MobilePhone nokia = new MobilePhone("Nokia", 1250, 50505050, "black", new Display(100, 100));
        Smartphone iphone = new Smartphone("iPhone", 15000, 45678955, "white", new Display(500, 500));
        SimplePhone phone1 = new SimplePhone("Panasonic", 200, "blue");

//        Create list of all my phones to work with lambda
        List<Phone> listPhones = new ArrayList<>();
        listPhones.add(nokia);
        listPhones.add(iphone);
        listPhones.add(phone1);
        listPhones.add(new Smartphone("LG", 10500, 14905050, "red", new Display(300, 300)));
        listPhones.add(new MobilePhone("Siemens", 500, 98871150, "red", new Display(100, 100)));

//        List of my phones which cost more than 1000 uah (use lambda)
        listPhones.stream().filter(p -> p.getPrice()>=1000)
                .forEach(p -> {
                    System.out.println(p.getModel() + ", price: " + p.getPrice());
                        });


//        Add cases with some parameters
        Case case_black_bmw = new Case("black", "bmw");
        Case red_welcome_to_hell = new Case("red", "Welcome to hell!");
        Case green_without_text = new Case("green");

//        Find some phones details
        phone1.sayPhoneDetails();
        nokia.sayPhoneDetails();

//        Add cases to mobile phones and smartphones. Some cases are suitable for different phone models
        nokia.addCase(case_black_bmw);
        nokia.addCase(red_welcome_to_hell);
        nokia.addCase(green_without_text);
        iphone.addCase(red_welcome_to_hell);

//        List of our all phones cases
        List<Case> mobilePhoneCases = new ArrayList<>();
        mobilePhoneCases.add(0, case_black_bmw);
        mobilePhoneCases.add(1, red_welcome_to_hell);
        mobilePhoneCases.add(2, green_without_text);

        System.out.println(mobilePhoneCases);

        Map<Case, String> descriptionsOfMyCases = new HashMap<>();
        descriptionsOfMyCases.put(case_black_bmw, "My first mobiles case. Good design, but very old.");
        descriptionsOfMyCases.put(red_welcome_to_hell, "Very modern design. Has a text \"Welcome to hell\"");
        descriptionsOfMyCases.put(green_without_text, "I found this case in the dump. So I will go with him all my life.");

        Phone.showInformationsAboutAllCases(descriptionsOfMyCases);

//        Write informations about my all cases in file example.txt. Don't work.
//        FileWriter writer = new FileWriter("example.txt", true);
//        writer.write(Phone.showInformationsAboutAllCases(descriptionsOfMyCases));
//        writer.close();

//        Read and save phone's types example to disk
        URL urlSimplePhone = new URL("https://i.ebayimg.com/images/g/YzwAAOSwRJhffdMj/s-l300.jpg");
        URL urlMobilePhone = new URL("https://www.seekpng.com/png/detail/454-4549707_hp-nokia-png-nokia-cc-1020-soft-white.png");
        URL urlSmartphone = new URL("https://pngimg.com/uploads/iphone/iphone_PNG5736.png");

        InputStream isSimplePhone = urlSimplePhone.openStream();
        InputStream isMobilePhone = urlMobilePhone.openStream();
        InputStream isSmartphone = urlSmartphone.openStream();

        OutputStream osSimplePhone = new FileOutputStream("homework/src/img/simple_phone_example.png", true);
        OutputStream osMobilePhone = new FileOutputStream("homework/src/img/mobile_phone_example.png", true);
        OutputStream osSmartphone = new FileOutputStream("homework/src/img/smartphone_example.png", true);

        int nextSimplePhoneBytes;
        while ((nextSimplePhoneBytes = isSimplePhone.read()) != -1){
            osSimplePhone.write(nextSimplePhoneBytes);
        }

        int nextMobilePhoneBytes;
        while ((nextMobilePhoneBytes = isMobilePhone.read()) != -1){
            osMobilePhone.write(nextMobilePhoneBytes);
        }

        int nextSmartphoneBytes;
        while ((nextSmartphoneBytes = isSmartphone.read()) != -1){
            osSmartphone.write(nextSmartphoneBytes);
        }

        isSimplePhone.close();
        isMobilePhone.close();
        isSmartphone.close();
        osSimplePhone.close();
        osMobilePhone.close();
        osSmartphone.close();

//        Use reflections example
        Smartphone smartphone = new Smartphone("Motorola", 1000, 44442242, "black", new Display(300, 300));
        Class<Smartphone> cl = Smartphone.class;
        System.out.println(cl.getName());
        System.out.println(cl.getSuperclass().getName());
        System.out.println(Arrays.toString(cl.getInterfaces()));

        for (Constructor<?> constructor:cl.getConstructors()){
            System.out.println(Arrays.toString(constructor.getParameters()));
        }

//        Change private field. Show and edit.
        Field field = cl.getDeclaredField("display");
        field.setAccessible(true);
        System.out.println(field.get(smartphone));

        field.set(smartphone, new Display(1000, 1000));
        System.out.println(smartphone.getDisplay());

//        Use phone's object with FunctionalInterface. We include charging
        Charger charger = new Charger();
        charger.addElectricalAppliance(new SimplePhone());
        charger.addElectricalAppliance(new MobilePhone());
        charger.addElectricalAppliance(new Smartphone());

//        We've added an anonymous class mobile Tablet. In the future we will buy a SIM-card and repair the wi-fi module for him. But now, we can only charge it.
        charger.addElectricalAppliance(() -> System.out.println("Charging takes a very long time. After half an hour of charging, the tablet's logo appeared."));
        charger.chargOn();

//        Added a minimum set of multithreading, for fast charging of all our devices
        Thread chargerSimplePhoneWithRunnable = new Thread(new SimplePhone());
        chargerSimplePhoneWithRunnable.start();
        Thread chargerMobilePhoneWithRunnable = new Thread(new MobilePhone());
        chargerMobilePhoneWithRunnable.start();
        Thread chargerSmarthphoneWithRunnable = new Thread(new Smartphone());
        chargerSmarthphoneWithRunnable.start();
    }
}