package KlasaAbstrakcyjna;

public class Cleaner extends Person {
    private int numberOfEntrancesForCleaning;

    public Cleaner(long id, String firstName, String lastName, int numberOfEntrancesForCleaning) {
        super(id, firstName, lastName);
        setNumberOfEntrancesForCleaning(numberOfEntrancesForCleaning);
    }


    @Override
    public float getSalary() {
        return numberOfEntrancesForCleaning * 100;
    }

    public int getNumberOfEntrancesForCleaning() {
        return numberOfEntrancesForCleaning;
    }

    public void setNumberOfEntrancesForCleaning(int numberOfEntrancesForCleaning) {
        this.numberOfEntrancesForCleaning = numberOfEntrancesForCleaning;
    }
}
