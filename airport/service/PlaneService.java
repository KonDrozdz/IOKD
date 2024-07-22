package airport.service;

import airport.model.Plane;
import airport.model.Manufacturer;

import java.util.List;

public interface PlaneService {

    List<Plane> getAllPlanes();

    List<Plane> getPlanesByManufacturer(Manufacturer manufacturer);

    Plane getPlaneById(int id);

    Plane addPlane(Plane plane);


    List<Manufacturer> getAllManufacturers();

    Manufacturer getManufacturerById(int id);

    Manufacturer addManufacturer(Manufacturer manufacturer);
}
