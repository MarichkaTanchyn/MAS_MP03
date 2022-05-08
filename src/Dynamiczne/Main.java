package Dynamiczne;

import java.time.LocalDateTime;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        House h1 = new ApartmentBuilding(2,"GardenAppart", LocalDateTime.of(2012,02,12,0,0),
                new HouseAddress("Konowaltsya",12),500, Set.of(1,2,3,4,5,6,7,8,9,10),5);


        House h2 = new OneFamilyHouse(12,"Khomitski family", LocalDateTime.of(2012,02,12,0,0),
                new HouseAddress("Konowaltsya",25),80.4,100.45);

        System.out.println("ApartmentBuilding :");
        System.out.println(h1);
        h1.stopBeingApartmentBuilding();
        System.out.println(h1);
        h1 = h1.startBeOneFamilyHouse();
        System.out.println(h1 + "\n");

        System.out.println("One Family house :");
        System.out.println(h2);
        h2.stopBeingOneFamilyHouse();
        System.out.println(h2);
        h2 = h2.startBeApartmentBuilding();
        System.out.println(h2);

    }
}
