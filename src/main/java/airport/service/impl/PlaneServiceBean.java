package airport.service.impl;

import airport.model.Plane;
import airport.model.Manufacturer;
import airport.model.Airport;
import airport.repository.PlaneDao;
import airport.repository.ManufacturerDao;
import airport.repository.AirportDao;
import airport.service.PlaneService;

import java.util.List;
import java.util.logging.Logger;

public class PlaneServiceBean implements PlaneService {

    private  static final Logger log = Logger.getLogger(PlaneService.class.getName());

    private PlaneDao planeDao;
    private ManufacturerDao manufacturerDao;
    private AirportDao airportDao;

    public PlaneServiceBean(PlaneDao planeDao, ManufacturerDao manufacturerDao, AirportDao airportDao) {
        log.info("creating plane service bean");
        this.planeDao = planeDao;
        this.manufacturerDao = manufacturerDao;
        this.airportDao = airportDao;
    }

    @Override
    public List<Plane> getAllPlanes() {
        log.info("searching all planes");
        return planeDao.findAll();
    }

    public List<Plane> getPlanesByAirport(Airport airport) {
        log.info("searching planes by airport " + airport.getId());
        return planeDao.findByAirport(airport);
    }

    @Override
    public Plane getPlaneById(int id) {
        log.info("searching plane by id " + id);
        return planeDao.findById(id);
    }

    @Override
    public Plane addPlane(Plane plane) {
        log.info("adding plane " + plane.getId());
        return planeDao.add(plane);
    }

    @Override
    public List<Plane> getPlanesByManufacturer(Manufacturer manufacturer) {
        log.info("searching planes by manufacturer " + manufacturer.getId());
        return planeDao.findByManufacturer(manufacturer);
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        log.info("searching all manufacturers");
        return manufacturerDao.findAll();
    }

    @Override
    public Manufacturer getManufacturerById(int id) {
        log.info("searching manufacturer by id " + id);
        return manufacturerDao.findById(id);
    }

    @Override
    public Manufacturer addManufacturer(Manufacturer manufacturer) {
        log.info("adding manufacturer " + manufacturer.getId());
        return manufacturerDao.add(manufacturer);
    }

    public  List<Airport> getAllAirports() {
        log.info("searching all airports");
        return airportDao.findAll();
    }

    public Airport getAirportById(int id) {
        log.info("searching airport by id " + id);
        return airportDao.findById(id);
    }

    public List<Plane> getPlanesInAirport(Airport airport) {
        log.info("searching planes in airport " + airport.getId());
        return planeDao.findByAirport(airport);
    }


}
