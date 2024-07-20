package airport.model;

import java.util.ArrayList;
import java.util.List;

public class Plane {
    private int id;
    private String name;
    private String PlaneImage;
    private Manufacturer manufacturer;
    private int year;
    private int price;
    private List<Airport> airports = new ArrayList<>();

    public Plane() {}

    public Plane(int id, String name, String PlaneImage, Manufacturer manufacturer, int year, int price) {
        this.id = id;
        this.name = name;
        this.PlaneImage = PlaneImage;
        this.manufacturer = manufacturer;
        this.year = year;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaneImage() { return PlaneImage; }

    public void setPlaneImage(String PlaneImage) { this.PlaneImage = PlaneImage; }

    public Manufacturer getManufacturer() { return manufacturer; }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) { this.airports = airports; }

    public void addAirport(Airport s) { this.airports.add(s); }

    @Override
    public String toString() {
        return "Plane{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer=" + manufacturer +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
