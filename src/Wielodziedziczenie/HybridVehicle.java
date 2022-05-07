package Wielodziedziczenie;

public class HybridVehicle extends AirVehicle implements IWaterVehicle {
    private int maxDepth;
    private int numberOfSeats;

    public HybridVehicle(long id, String serialNumber, String manufacturer, double maxHeight, double minFlightHeight, int maxDepth, int numberOfSeats) {
        super(id, serialNumber, manufacturer, maxHeight, minFlightHeight);
        setMaxDepth(maxDepth);
        setNumberOfSeats(numberOfSeats);
    }

    @Override
    public void arrangeUnderwaterTour(int numberOfPeople) {
        if (numberOfPeople > numberOfSeats)
            System.out.println("The max number of people in water vehicle is " + numberOfSeats);
        else System.out.println("The attraction was success");
    }

    @Override
    public String getTechnicalDetails() {
        return "Hybrid vehicle " + this.getSerialNumber() + " Manufacturer "
                + this.getManufacturer() + " Max depth " + maxDepth + "Max height " + this.getMaxHeight();

    }

    public void makeInsideLoop(int loopOnHeight) {
        if (loopOnHeight > super.getMinFlightHeight() && loopOnHeight < super.getMaxHeight())
            System.out.println("The Inside Loop was done on height " + loopOnHeight);
        else {
            System.out.println("Min height is " + super.getMinFlightHeight() + " and max "
                    + super.getMaxHeight() + " loop can't be done on " + loopOnHeight + "height");
        }
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
