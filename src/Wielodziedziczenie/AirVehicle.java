package Wielodziedziczenie;

public class AirVehicle extends Vehicle{
    private double maxHeight;
    private double minFlightHeight;

    public AirVehicle(long id, String serialNumber, String manufacturer, double maxHeight, double minFlightHeight) {
        super(id, serialNumber, manufacturer);
        setMaxHeight(maxHeight);
        setMinFlightHeight(minFlightHeight);
    }

    @Override
    public String getTechnicalDetails() {
        return "Air vehicle " + this.getSerialNumber() + " Manufacturer " + this.getManufacturer() + " Max depth " + maxHeight;

    }

    public void makeInsideLoop(int loopOnHeight) {
        if (loopOnHeight > minFlightHeight && loopOnHeight < maxHeight)
            System.out.println("The Inside Loop was done on height " + loopOnHeight);
        else {
            System.out.println("Min height is " + minFlightHeight + " and max "
                    + maxHeight + " loop can't be done on " + loopOnHeight + "height");
        }
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public double getMinFlightHeight() {
        return minFlightHeight;
    }

    public void setMinFlightHeight(double minFlightHeight) {
        this.minFlightHeight = minFlightHeight;
    }
}
