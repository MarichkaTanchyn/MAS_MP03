package Dynamiczne;

import java.time.LocalDateTime;
import java.util.Set;

public class OneFamilyHouse extends House {
    private double houseArea;
    private double yardArea;

    public OneFamilyHouse(long id, String name, LocalDateTime dateOfSale, HouseAddress houseAddress, double houseArea, double yardArea) {
        super(id, name, dateOfSale, houseAddress);
        setHouseArea(houseArea);
        setYardArea(yardArea);
    }

    public double getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(double houseArea) {
        this.houseArea = houseArea;
    }

    public double getYardArea() {
        return yardArea;
    }

    public void setYardArea(double yardArea) {
        this.yardArea = yardArea;
    }
    @Override
    public LocalDateTime getDateOfSale() {
        return getDateOfStartBuilding().plusMonths(5);
    }
    @Override
    public String toString() {
        return super.toString() + ", yard area: " + yardArea + " , house area: " + houseArea;
    }
}
