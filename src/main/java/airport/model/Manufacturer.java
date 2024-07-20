package airport.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Manufacturer {
    @JsonIgnore
    private int id;
    private String name;
    private String country;

    @JsonIgnore
    private List<Plane> Planes = new ArrayList<>();

    public Manufacturer() {}

    public Manufacturer(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public List<Plane> getPlanes() { return Planes; }

    public void setPlanes(List<Plane> Planes) { this.Planes = Planes; }

    public void addPlane(Plane c) { this.Planes.add(c); }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
