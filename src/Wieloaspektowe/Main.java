package Wieloaspektowe;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {

        PowerPlant powerPlant1 = new CoalPowerPlant(
                        "South-Ukrainian nuclear power plant",
                        "Mykolaiv Oblast",
                        LocalDate.of(1982, Month.MARCH, 14),
                        3000,
                        4,
                        "coal",
                        100
                );
        powerPlant1.createNotEnvironmentallyFriendly("Uran",100);
        PowerPlant.NotEnvironmentallyFriendly nef =(PowerPlant.NotEnvironmentallyFriendly)powerPlant1.getImpactOnEnvironment();
        System.out.println("nef.countUsedFullToday();");
        System.out.println(nef.countUsedFullToday());

        PowerPlant powerPlant2 = new HydroelectricPowerPlant(
                "Wisla Entertaiment",
                "Black",
                LocalDate.of(1995, 10, 18),
                1212,
                200,
                0
        );
        PowerPlant.EcologicalyFriendly ef = (PowerPlant.EcologicalyFriendly) powerPlant2.getImpactOnEnvironment();
        System.out.println("ef.countAverageWorkingTime()");
        System.out.println(ef.countAverageWorkingTime());
    }
}
