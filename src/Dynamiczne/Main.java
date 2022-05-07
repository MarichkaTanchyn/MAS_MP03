package Dynamiczne;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        House h1 = new ApartmentBuilding(1,"GardenAppart", LocalDateTime.of(2012,02,12,0,0),
                new HouseAddress("Konowaltsya",12), Set.of(1,2,3,4,5,6,7,8,9,10),5);


        House h2 = new OneFamilyHouse(2,"Khomitski family", LocalDateTime.of(2012,02,12,0,0),
                new HouseAddress("Konowaltsya",25),80.4,100.45);

        System.out.println(h1.getDateOfSale());
        System.out.println(h2.getDateOfSale());
        System.out.println(h1);
        System.out.println(h2);

//        kompozycja

    }
}
