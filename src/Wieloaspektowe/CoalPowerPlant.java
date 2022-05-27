package Wieloaspektowe;

import java.time.LocalDate;
import java.util.Random;

public class CoalPowerPlant extends PowerPlant {
    private int quantityOfTurbines;

//    change to coal power plant

    public CoalPowerPlant(String name, String address, LocalDate createDate, int powerGeneratedElectricityPerDay, int quantityOfTurbines, String fuelName, int fuelAmount) {
        super(name, address, createDate, powerGeneratedElectricityPerDay);
        this.quantityOfTurbines = quantityOfTurbines;
        createNotEnvironmentallyFriendly(fuelName, fuelAmount);
    }

    public int getQuantityOfTurbines() {
        return quantityOfTurbines;
    }

    public void setQuantityOfTurbines(int quantityOfTurbines) {
        this.quantityOfTurbines = quantityOfTurbines;
    }
    
    public void showQuantityOfWorkingReactors(){
        Random random = new Random();
        for(int i = 0; i < this.getQuantityOfTurbines(); i++){
            String message = "Reactor number :" + i ;
            if(random.nextBoolean()){
                message.concat("; Is working.");
            } else{
                message.concat("; Is not working.");
            }
            System.out.println(message);
        }
    }
    
    @Override
    public void showMonthElectricictyGeneration() {
        System.out.println(
                "Electricicty generated in 30 days by Coal Power Plant: " +
                (
                30
                *
                this.getPowerGeneratedElectricityPerDay()
                *
                this.getQuantityOfTurbines()
                )
        );
    }

    @Override
    public String toString() {
        return "CoalPowerPlant{" + "quantityOfReactors=" + quantityOfTurbines + '}';
    }
    
    
}
