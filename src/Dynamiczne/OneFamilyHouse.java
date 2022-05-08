package Dynamiczne;

import java.time.LocalDateTime;
import java.util.Set;

public class OneFamilyHouse extends House {
    private double yardArea;

    public OneFamilyHouse(long id, String name, LocalDateTime dateOfSale, HouseAddress houseAddress, double area, double yardArea) {
        super(id, name, dateOfSale, houseAddress, area);
        setYardArea(yardArea);
    }

    public void stopBeingOneFamilyHouse() {
        if (yardArea != 0) {
            this.yardArea = 0;
        }
    }

    public OneFamilyHouse startBeOneFamilyHouse() {
        if (yardArea == 0) {
            this.yardArea = ((this.getArea() * 2) / 2) + 15;
        }
        return new OneFamilyHouse(this.getId() +1, this.getName(), this.getDateOfSale(), this.getHouseAddress(), this.getArea(), this.yardArea);
    }

    @Override
    public void stopBeingApartmentBuilding() throws Exception {
        throw new Exception("This house is " + getClass().getName() + " and cannot be stopped being apartment building! ");
    }

    @Override
    public ApartmentBuilding startBeApartmentBuilding() throws Exception {
        if (yardArea == 0) {
            Set<Integer> apartments;
            if (getArea() / 10 >= 50) {
                apartments = Set.of(1, 2, 3, 4, 5);
            } else {
                apartments = Set.of(1, 2);
            }
            int numberOfFloors = apartments.size();
            return new ApartmentBuilding(this.getId()+1, this.getName(), this.getDateOfSale(), this.getHouseAddress(), this.getArea(), apartments, numberOfFloors);
        } else {
            throw new Exception("This house is apartment house and cannot be stopped being apartment building! ");
        }
    }

    public double getYardArea() {
        return yardArea;
    }

    public void setYardArea(double yardArea) {
        if (yardArea <= 0) {
            throw new IllegalArgumentException("Yard area cannot be smaller then 0 or be 0");
        }
        this.yardArea = yardArea;
    }

    @Override
    public LocalDateTime getDateOfSale() {
        return getDateOfStartBuilding().plusMonths(5);
    }

    @Override
    public String toString() {
        return super.toString() + ", yard area: " + yardArea;
    }
}
