package Wielodziedziczenie;

public class WaterVehicle extends Vehicle implements IWaterVehicle {
    private double maxDepth;
    private int numberOfSeats;

    public WaterVehicle(long id, String serialNumber, String manufacturer, double maxDepth, int numberOfSeats) {
        super(id, serialNumber, manufacturer);
        setMaxDepth(maxDepth);
        setNumberOfSeats(numberOfSeats);
    }

    @Override
    public String getTechnicalDetails() {
        return "Water vehicle " + this.getSerialNumber() + " Manufacturer " + this.getManufacturer() + " Max depth " + maxDepth;
    }

    @Override
    public void arrangeUnderwaterTour(int numberOfPeople) {
        if (numberOfPeople > numberOfSeats)
            System.out.println("The max number of people in water vehicle is " + numberOfSeats);
        else System.out.println("The attraction was success");
    }


    public double getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(double maxDepth) {
        this.maxDepth = maxDepth;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
