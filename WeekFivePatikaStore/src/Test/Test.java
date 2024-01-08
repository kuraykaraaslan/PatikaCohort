package Test;

import Entity.Category;
import Entity.Product;
import Entity.Spec;
import Entity.Store;

public class Test {

    public static void load(Store store)
     {

        // Create categories
        Category phones = new Category("Phones");
        Category laptops = new Category("Laptops");

        // Register store with all child categories
        phones.registerStoreWithAllChildCategories(store);
        laptops.registerStoreWithAllChildCategories(store);

        // Create specs for phones
        Spec phoneScreenSize = new Spec(phones, "Screen Size", Double.class);
        Spec phoneRam = new Spec(phones, "RAM", Integer.class);
        Spec phoneStorage = new Spec(phones, "Storage Space", Integer.class);
        Spec phoneBattery = new Spec(phones, "Battery mAh", Double.class);
        Spec phoneCameraRes = new Spec(phones, "Camera Resolution", Integer.class);
        Spec phoneColor = new Spec(phones, "Color", String.class);

        // Create specs for laptops
        Spec laptopScreenSize = new Spec(laptops, "Screen Size", Double.class);
        Spec laptopRam = new Spec(laptops, "RAM", Integer.class);
        Spec laptopStorage = new Spec(laptops, "Storage Space", Integer.class);
       

        // Create products

        // Create products for Laptops
        // Title                        | Price     | Brand     | Storage   | Screen    | RAM  
        
        // HUAWEI Matebook 14            | 7000.0 TL | Huawei    | 512       | 14.0      | 16  
        Product huaweiMatebook14 = new Product("HUAWEI Matebook 14");
        huaweiMatebook14.setBrand("Huawei");
        huaweiMatebook14.setPrice(7000.0);
        huaweiMatebook14.setQuantity(16);
        huaweiMatebook14.createSpecValues(laptopScreenSize, 14.0);
        huaweiMatebook14.createSpecValues(laptopRam, 16);
        huaweiMatebook14.createSpecValues(laptopStorage, 512);
        
        // LENOVO V14 IGL                | 3699.0 TL | Lenovo    | 1024      | 14.0      | 8 
        Product lenovoV14Igl = new Product("LENOVO V14 IGL");
        lenovoV14Igl.setBrand("Lenovo");
        lenovoV14Igl.setPrice(3699.0);
        lenovoV14Igl.setQuantity(8);
        lenovoV14Igl.createSpecValues(laptopScreenSize, 14.0);
        lenovoV14Igl.createSpecValues(laptopRam, 8);
        lenovoV14Igl.createSpecValues(laptopStorage, 1024);

        // ASUS Tuf Gaming               | 8199.0 TL | Asus      | 2048      | 15.6      | 32  

        Product asusTufGaming = new Product("ASUS Tuf Gaming");
        asusTufGaming.setBrand("Asus");
        asusTufGaming.setPrice(8199.0);
        asusTufGaming.setQuantity(32);
        asusTufGaming.createSpecValues(laptopScreenSize, 15.6);
        asusTufGaming.createSpecValues(laptopRam, 32);

        // Create products for Phones
        // Title                        | Price     | Brand     | Storage   | Screen    | RAM       | Battery   | Camera    | Color
        
        //SAMSUNG GALAXY A51            | 3199.0 TL | Samsung   | 128       | 6.5       | 32        | 4000.0    | 6         | Black
        Product samsungGalaxyA51 = new Product("SAMSUNG GALAXY A51");
        samsungGalaxyA51.setBrand("Samsung");
        samsungGalaxyA51.setPrice(3199.0);
        samsungGalaxyA51.setQuantity(32);
        samsungGalaxyA51.createSpecValues(phoneScreenSize, 6.5);
        samsungGalaxyA51.createSpecValues(phoneRam, 32);
        samsungGalaxyA51.createSpecValues(phoneStorage, 128);
        samsungGalaxyA51.createSpecValues(phoneBattery, 4000.0);
        samsungGalaxyA51.createSpecValues(phoneCameraRes, 6);
        samsungGalaxyA51.createSpecValues(phoneColor, "Black");


        // iPhone 11 64 GB               | 7379.0 TL | Apple     | 64        | 6.1       | 5         | 3046.0    | 6         | Blue
        Product iPhone11 = new Product("iPhone 11 64 GB");
        iPhone11.setBrand("Apple");
        iPhone11.setPrice(7379.0);
        iPhone11.setQuantity(5);
        iPhone11.createSpecValues(phoneScreenSize, 6.1);
        iPhone11.createSpecValues(phoneRam, 5);
        iPhone11.createSpecValues(phoneStorage, 64);
        iPhone11.createSpecValues(phoneBattery, 3046.0);
        iPhone11.createSpecValues(phoneCameraRes, 6);
        iPhone11.createSpecValues(phoneColor, "Blue");

        // Redmi Note 10 Pro 8GB         | 4012.0 TL | Xiaomi    | 128       | 6.5       | 35        | 4000.0    | 12        | White
        Product redmiNote10Pro8GB = new Product("Redmi Note 10 Pro 8GB");
        redmiNote10Pro8GB.setBrand("Xiaomi");
        redmiNote10Pro8GB.setPrice(4012.0);
        redmiNote10Pro8GB.setQuantity(35);
        redmiNote10Pro8GB.createSpecValues(phoneScreenSize, 6.5);
        redmiNote10Pro8GB.createSpecValues(phoneRam, 35);
        redmiNote10Pro8GB.createSpecValues(phoneStorage, 128);
        redmiNote10Pro8GB.createSpecValues(phoneBattery, 4000.0);
        redmiNote10Pro8GB.createSpecValues(phoneCameraRes, 12);
        redmiNote10Pro8GB.createSpecValues(phoneColor, "White");


        // Register products to Categories
         phones.registerProduct(samsungGalaxyA51);
         phones.registerProduct(iPhone11);
         phones.registerProduct(redmiNote10Pro8GB);
         laptops.registerProduct(huaweiMatebook14);
         laptops.registerProduct(lenovoV14Igl);
         laptops.registerProduct(asusTufGaming);

         


     }
}