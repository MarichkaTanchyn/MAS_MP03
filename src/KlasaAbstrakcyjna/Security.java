package KlasaAbstrakcyjna;

public class Security extends Person {
    private int numberOfGuardedHouses;

    public Security(long id, String firstName, String lastName, int numberOfGuardedHouses) {
        super(id, firstName, lastName);
        setNumberOfGuardedHouses(numberOfGuardedHouses);
    }

    @Override
    public float getSalary() {
        return numberOfGuardedHouses * 150;
    }

    public int getNumberOfGuardedHouses() {
        return numberOfGuardedHouses;
    }

    public void setNumberOfGuardedHouses(int numberOfGuardedHouses) {
        this.numberOfGuardedHouses = numberOfGuardedHouses;
    }
}
