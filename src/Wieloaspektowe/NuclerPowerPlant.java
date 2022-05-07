package Wieloaspektowe;

import java.time.LocalDate;
import java.util.Random;

public class NuclerPowerPlant extends PowerPlant {
    private int quantityOfReactors;

    public NuclerPowerPlant(
            String name,
            String address, 
            LocalDate createDate, 
            int powerGeneratedElectricityPerDay, 
            int quantityOfReactors, 
            String fuelName,
            int fuelAmount
    ) {
        super(name, address, createDate, powerGeneratedElectricityPerDay);
        this.quantityOfReactors = quantityOfReactors;
        createNotEnvironmentallyFriendly(fuelName, fuelAmount);
    }

    public int getQuantityOfReactors() {
        return quantityOfReactors;
    }

    public void setQuantityOfReactors(int quantityOfReactors) {
        this.quantityOfReactors = quantityOfReactors;
    }
    
    public void showQuantityOfWorkingReactors(){
        Random random = new Random();
        for(int i = 0; i < this.getQuantityOfReactors(); i++){
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
                "Electricicty generated in 30 days by Nucler Power Plant: " + 
                (
                30
                *
                this.getPowerGeneratedElectricityPerDay()
                *
                this.getQuantityOfReactors()
                )
        );
    }

    @Override
    public String toString() {
        return "NuclerPowerPlant{" + "quantityOfReactors=" + quantityOfReactors + '}';
    }
    
    
}
