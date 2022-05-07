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
        this.areaOfTerritory = areaOfTerritory;
    }
}
