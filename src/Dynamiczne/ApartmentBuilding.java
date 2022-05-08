package Dynamiczne;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApartmentBuilding extends House {
    private Set<Integer> apartments;
    private int numberOfFloors;

    public ApartmentBuilding(long id, String name, LocalDateTime dateOfSale, HouseAddress houseAddress, double area,
                             Set<Integer> apartments, int numberOfFloors) {
        super(id, name, dateOfSale, houseAddress, area);
        setApartments(apartments);
        setNumberOfFloors(numberOfFloors);
    }

    public void stopBeingApartmentBuilding() {
        if (apartments != null && numberOfFloors != 0) {
            this.apartments = null;
            numberOfFloors = 0;
        }
    }

    public ApartmentBuilding startBeApartmentBuilding() {
        if (apartments == null && numberOfFloors == 0) {
            if (getArea() / 10 >= 50) {
                setApartments(Set.of(1, 2, 3, 4, 5));
            } else {
                setApartments(Set.of(1, 2));
            }
            numberOfFloors = this.apartments.size();
        }

        return new ApartmentBuilding(this.getId()+1,this.getName(),this.getDateOfSale(),this.getHouseAddress(),this.getArea(),this.getApartments(),this.getNumberOfFloors());
    }

    public void addApartment(int apNumber) throws IllegalArgumentException {
        if (apNumber <= 0) {
            throw new IllegalArgumentException("Apartment number cannot be negative or 0");
        }
        boolean alreadyExists = this.apartments.stream().anyMatch(a -> a == apNumber);
        if (alreadyExists) {
            throw new IllegalArgumentException("Apartment number you entered already exists.");
        }
        this.apartments.add(apNumber);
    }

    public void removeApartment(int apNumber) throws IllegalArgumentException {
        if (apNumber <= 0) {
            throw new IllegalArgumentException("Apartment number cannot be negative or 0");
        }
        boolean removed = this.apartments.remove(apNumber);
        if (!removed) {
            throw new IllegalArgumentException("Cannot remove apartment which was not added to the set");
        }
    }

    public Set<Integer> getApartments() {
        return Collections.unmodifiableSet(apartments);
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public void setApartments(Set<Integer> apartments) throws IllegalArgumentException {
        if (apartments == null || apartments.size() <= 0) {
            throw new IllegalArgumentException("Apartments set cannot be null");
        }
        boolean isNegative = apartments.stream().anyMatch(a -> a <= 0);
        if (isNegative) {
            throw new IllegalArgumentException("Apartments set cannot have non positive values");
        }
        this.apartments = new HashSet<>(apartments);
    }

    @Override
    public LocalDateTime getDateOfSale() {
        return getDateOfStartBuilding().plusMonths(2);
    }

    @Override
    public void stopBeingOneFamilyHouse() throws Exception {
        throw new Exception("This house is " + getClass().getName() +  " and cannot be stopped being one family house! ");
    }

    @Override
    public OneFamilyHouse startBeOneFamilyHouse() throws Exception {
       if (apartments == null && numberOfFloors == 0){
           double yardArea = ((this.getArea() * 2) / 2) + 15;
           return new OneFamilyHouse(this.getId()+1,this.getName(),this.getDateOfSale(),this.getHouseAddress(),this.getArea(),yardArea);
       }
       else {
           throw new Exception("This house is already one family house and cannot be started being one family house! ");
       }
    }

    @Override
    public String toString() {
        return super.toString() + " , number of floors: " + numberOfFloors + " ,apartments: " + apartments;
    }
}
