package airport.service.impl;

import airport.model.Plane;
import airport.model.Airport;
import airport.repository.PlaneDao;
import airport.repository.AirportDao;
import airport.service.AirportService;

import java.util.List;
import java.util.logging.Logger;

public class AirportServiceBean implements AirportService {

    private static final Logger log = Logger.getLogger(AirportService.class.getName());

    private AirportDao airportDao;
    private PlaneDao planeDao;

    public AirportServiceBean(AirportDao airportDao, PlaneDao planeDao) {
        log.info("creating airport service bean");
        this.airportDao = airportDao;
        this.planeDao = planeDao;
    }

    @Override
    public Airport getAirportById(int id) {
        log.info("searching airport by id " + id);
        return airportDao.findById(id);
    }

    @Override
    public List<Airport> getAllAirports() {
        log.info("searching all airports");
        return airportDao.findAll();
    }

    @Override
    public List<Airport> getAirportsByPlane(Plane plane) {
        log.info("searching airports by plane " + plane.getId());
        return airportDao.findByPlane(plane);
    }

    @Override
    public List<Plane> getPlanesInAirport(Airport airport) {
        log.info("searching planes in airport " + airport.getId());
        return planeDao.findByAirport(airport);
    }
}

