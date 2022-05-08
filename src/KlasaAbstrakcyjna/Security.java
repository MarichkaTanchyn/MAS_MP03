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
        if (numberOfGuardedHouses <0) {
            throw new IllegalArgumentException("Number of guarded houses can't be smaller than 0");
        }
        this.numberOfGuardedHouses = numberOfGuardedHouses;
    }

    @Override
    public String toString() {
        return "Security " + super.toString() + " " +
                "numberOfGuardedHouses=" + numberOfGuardedHouses;
    }
}
