package airport.repository;

import airport.model.Manufacturer;

import java.util.List;

public interface ManufacturerDao {

    List<Manufacturer> findAll();

    Manufacturer findById(int id);

    Manufacturer add(Manufacturer manufacturer);
}
