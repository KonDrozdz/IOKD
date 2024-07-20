package airport.repository.mem;

import airport.model.Airport;
import airport.model.Plane;
import airport.model.Manufacturer;
import airport.repository.PlaneDao;

import java.util.List;
import java.util.stream.Collectors;

public class MemPlaneDao implements PlaneDao {
    @Override
    public List<Plane> findAll() {
        return SampleData.Planes;
    }

    @Override
    public Plane findById(int id) {
        return SampleData.Planes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Plane add(Plane Plane) {
        int max = SampleData.Planes.stream().max((c1, c2) -> c1.getId() - c2.getId()).get().getId();
        Plane.setId(++max);
        SampleData.Planes.add(Plane);
        return Plane;
    }

    @Override
    public List<Plane> findByManufacturer(Manufacturer manufacturer) {
        return SampleData.Planes.stream().filter(c -> c.getManufacturer().equals(manufacturer)).collect(Collectors.toList());
    }

    @Override
    public List<Plane> findByAirport(Airport airport) {
        return SampleData.Planes.stream().filter(c -> c.getAirports().equals(airport)).collect(Collectors.toList());
    }
}
