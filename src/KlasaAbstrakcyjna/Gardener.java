package KlasaAbstrakcyjna;

public class Gardener extends Person {
    private int areaOfTerritory;


    public Gardener(long id, String firstName, String lastName, int areaOfTerritory) {
        super(id, firstName, lastName);
        setAreaOfTerritory(areaOfTerritory);
    }

    @Override
    public float getSalary() {
        return areaOfTerritory * 120;
    }

    public int getAreaOfTerritory() {
        return areaOfTerritory;
    }

    public void setAreaOfTerritory(int areaOfTerritory) {
        if (areaOfTerritory < 0) {
            throw new IllegalArgumentException("Area of territory can't be smaller than 0");
        }
        this.areaOfTerritory = areaOfTerritory;
    }

    @Override
    public String toString() {
        return "Gardener " + super.toString() +
                " areaOfTerritory=" + areaOfTerritory;
    }
}
