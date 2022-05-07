package Overlapping;

import java.util.EnumSet;

enum PersonType {Person, Resident, Employee};

public class Person {
    private long id;
    private String firstName;
    private String lastName;

    // resident attribute
    private int apartmentNumber;
    // employee attribute
    private String profession;

    private EnumSet<PersonType> persons = EnumSet.of(PersonType.Person);

    // resident
    public Person(long id, String firstName, String lastName, int apartmentNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.apartmentNumber = apartmentNumber;
        this.persons.add(PersonType.Resident);
    }

    // employee
    public Person(long id, String firstName, String lastName, String profession) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.persons.add(PersonType.Employee);

    }

    public Person(long id, String firstName, String lastName, int apartmentNumber, String profession) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.apartmentNumber = apartmentNumber;
        this.profession = profession;
        this.persons.add(PersonType.Resident);
        this.persons.add(PersonType.Employee);
    }

    public double getRentCosts() throws Exception {
        double rentCosts = 500;

        if (persons.contains(PersonType.Employee) && persons.contains(PersonType.Resident)){
            rentCosts = 0.5 * rentCosts;
        }
        else if (persons.contains(PersonType.Employee) && (!persons.contains(PersonType.Resident)))
            rentCosts = 0;

        return rentCosts;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id cannot be less than or equal to 0.");
        }
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().equals("")) {
            throw new IllegalArgumentException("First name cannot be null or empty.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().equals("")) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        }
        this.lastName = lastName;
    }
    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    //TODO: setters jakos inicializuwaty

    public EnumSet<PersonType> getPersons() {
        return persons;
    }

    public void setPersons(EnumSet<PersonType> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        String info = "";

        // i pracownik i mieszkaniec
        if (persons.contains(PersonType.Employee) && persons.contains(PersonType.Resident)){
            info += "Osoba "+ firstName + " " + lastName + " jest mieszkańcem oraz pracownikiem w tym kompleksie mieszkaniowym";
        }
        //pracownik
        else if (persons.contains(PersonType.Employee) && (!persons.contains(PersonType.Resident))){
            info += "Osoba "+ firstName + " " + lastName + " jest pracownikiem w tym kompleksie mieszkaniowym";
        }
        else { // mieszkaniec
            info += "Osoba "+ firstName + " " + lastName + " jest mieszkańcem";
        }
        return info;
    }
}
