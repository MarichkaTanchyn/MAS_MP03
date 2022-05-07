package Dynamiczne;

import java.io.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class House {
    private long id;
    private String name;
    private LocalDateTime dateOfStartBuilding;
    private HouseAddress houseAddress;
    private static Set<House> houses = new HashSet<>();//ekstensja


    public House(long id, String name, LocalDateTime dateOfStartBuilding, HouseAddress houseAddress) {
        setId(id);
        setName(name);
        setDateOfStartBuilding(dateOfStartBuilding);
        setHouseAddress(houseAddress);
        House.addHouse(this);
    }

    public abstract LocalDateTime getDateOfSale();

    private static void addHouse(House house) throws IllegalArgumentException {
        if (house == null) {
            throw new IllegalArgumentException("basic.withAttribute.qualifide.House cannot be null");
        }
        boolean alreadyAdded = House.houses.stream().anyMatch(h -> h.getId() == house.getId());
        if (alreadyAdded) {
            throw new IllegalArgumentException("basic.withAttribute.qualifide.House with id " + house.getId() + " has already been added");
        }
        House.houses.add(house);
    }

    private static void removeHouse(House house) throws IllegalArgumentException {
        if (house == null) {
            throw new IllegalArgumentException("basic.withAttribute.qualifide.House cannot be null");
        }
        boolean alreadyDeleted = House.houses.stream().allMatch(h -> h.getId() != house.getId());
        if (alreadyDeleted) {
            throw new IllegalArgumentException("basic.withAttribute.qualifide.House with id " + house.getId() + " has already been deleted");
        }
        House.houses.remove(house);
    }


    //metoda klasowa
    public static List<House> getHouseInUseSince(LocalDateTime date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (date.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Cannot define date in future");
        }
        return House.houses
                .stream()
                .filter(p -> p.getDateOfStartBuilding().isAfter(date))
                .collect(Collectors.toList());
    }

// ekstensja trwala save & load
    public static boolean save(String path) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path))) {
            os.writeObject(houses);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void load(String path) {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(path))) {
            Set<House> loadedHouses = (Set<House>) is.readObject();
            setHouses(loadedHouses);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Getters
    public long  getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateOfStartBuilding() {
        return dateOfStartBuilding;
    }

    public HouseAddress getHouseAddress() {
        return houseAddress;
    }


    public static Set<House> getHouses() {
        return Collections.unmodifiableSet(houses);
    }

    //atribute pochodny
    public long getOperatingTime() {
        return ChronoUnit.YEARS.between(LocalDateTime.now(), this.dateOfStartBuilding);
    }

    //Setters

    public void setId(long id) throws IllegalArgumentException {
        if (id < 0) {
            throw new IllegalArgumentException("Id can not be negative value.");
        }
        boolean alreadyExists = houses.stream().anyMatch(house -> house.getId() == id);
        if (alreadyExists) {
            throw new IllegalArgumentException("Id you entered already exists.");
        }
        this.id = id;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name != null && name.trim().equals("")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setDateOfStartBuilding(LocalDateTime dateOfStartBuilding) throws IllegalArgumentException {
        if (dateOfStartBuilding == null) {
            throw new IllegalArgumentException("Sale date cannot be null");
        }
        if (dateOfStartBuilding.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Date of sale cannot be set to date in future");
        }
        this.dateOfStartBuilding = dateOfStartBuilding;
    }

    public void setHouseAddress(HouseAddress houseAddress) throws IllegalArgumentException {
        if (houseAddress == null) {
            throw new IllegalArgumentException("basic.withAttribute.qualifide.House address cannot be null.");
        }
        this.houseAddress = houseAddress;
    }



    public static void setHouses(Set<House> houses) throws IllegalArgumentException {
        if (houses == null || houses.size() <= 0) {
            throw new IllegalArgumentException("Houses list cannot be null (or empty).");
        }

        House.houses = new HashSet<>(houses);
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfSale=" + dateOfStartBuilding +
                ", houseAddress=" + houseAddress;
    }
}
