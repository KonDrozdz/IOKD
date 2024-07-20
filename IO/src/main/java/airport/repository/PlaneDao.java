package airport.repository;

import airport.model.Airport;
import airport.model.Plane;
import airport.model.Manufacturer;

import java.util.List;

public interface PlaneDao {

    List<Plane> findAll();

    Plane findById(int id);

    List<Plane> findByManufacturer(Manufacturer manufacturer);

    List<Plane> findByAirport(Airport airport);

    Plane add(Plane Plane);
}
