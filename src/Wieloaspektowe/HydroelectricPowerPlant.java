package Wieloaspektowe;

import java.time.LocalDate;

public class HydroelectricPowerPlant extends PowerPlant {
    
    private String stateClosed = "Closed", stateOpened = "Opened";
    private double damLength;
    private String damGatesState = stateClosed;

    public HydroelectricPowerPlant(
            String name, 
            String address, 
            LocalDate createDate, 
            int powerGeneratedElectricityPerDay,
            int damLength, 
            int lastAverageWorkingTime
    ) {
        super(name, address, createDate, powerGeneratedElectricityPerDay);
        this.damLength = damLength;
        createEnvironmentallyFriendly(lastAverageWorkingTime);
    }

    public double getDamLength() {
        return damLength;
    }

    public void setDamLength(double damLength) {
        this.damLength = damLength;
    }

    public String getDamGatesState() {
        return damGatesState;
    }

    private void setDamGatesState(String damGatesState) {
        this.damGatesState = damGatesState;
    }
    
    public void openDamGates(){
        this.setDamGatesState(stateOpened);
    }
    
    public void closedDamGates(){
        this.setDamGatesState(stateClosed);
    }
    
    public void showDamGatesState(){
        System.out.println("Dam Gates State is " + getDamGatesState());
    }
            
    @Override
    public void showMonthElectricictyGeneration() {
        int quantityDays = 30;
        if(getDamGatesState().equals(stateClosed)){
            quantityDays--;
        }
        
        String message =
                "Electricicty generated in 30 days by Hydroelectric Power Plant: " + 
                (
                quantityDays
                *
                this.getPowerGeneratedElectricityPerDay()
                )
                + ";";
        
        System.out.println(message);
        showDamGatesState();
    }

    @Override
    public String toString() {
        return "HydroelectricPowerPlant{" + "stateClosed=" + stateClosed + ", stateOpened=" + stateOpened + ", damLength=" + damLength + ", damGatesState=" + damGatesState + '}';
    }
}
