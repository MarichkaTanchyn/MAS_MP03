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
        if (numberOfEntrancesForCleaning < 0) {
            throw new IllegalArgumentException("Number of entrances for cleaning can't be smaller than 0");
        }
        this.numberOfEntrancesForCleaning = numberOfEntrancesForCleaning;
    }

    @Override
    public String toString() {
        return "Cleaner " + super.toString() +
                " numberOfEntrancesForCleaning=" + numberOfEntrancesForCleaning;
    }
}
