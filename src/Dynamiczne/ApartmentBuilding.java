package Dynamiczne;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ApartmentBuilding extends House {
    private Set<Integer> apartments;
    private int numberOfFloors;

    public ApartmentBuilding(long id, String name, LocalDateTime dateOfSale, HouseAddress houseAddress,
                             Set<Integer> apartments, int numberOfFloors) {
        super(id, name, dateOfSale, houseAddress);
        setApartments(apartments);
        setNumberOfFloors(numberOfFloors);
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
    public String toString() {
        return super.toString() + " , number of floors: " + numberOfFloors + " ,apartments: " + apartments;
    }
}
