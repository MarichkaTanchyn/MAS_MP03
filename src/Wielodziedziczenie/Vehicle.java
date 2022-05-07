package Wielodziedziczenie;

public abstract class Vehicle {
    private long id;
    private String serialNumber;
    private String manufacturer;

    public Vehicle(long id, String serialNumber, String manufacturer) {
        super();
        setId(id);
        setSerialNumber(serialNumber);
        setManufacturer(manufacturer);
    }

    public abstract String getTechnicalDetails();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id cannot be less than or equal to 0.");
        }
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
