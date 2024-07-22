package airport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private int id;
    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    private String logo;


    @JsonIgnore
    private List<Plane> Planes = new ArrayList<>();

    public Airport() {}

    public Airport(int id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLogo() { return logo; }

    public void setLogo(String logo) { this.logo = logo; }

    public List<Plane> getPlanes() { return Planes; }

    public void setPlanes(List<Plane> Planes) { this.Planes = Planes; }

    public void addPlane(Plane c) { this.Planes.add(c); }

    @Override
    public String toString() {
        return "Airport{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }

}
