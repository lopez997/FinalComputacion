package co.edu.icesi.ci.talleres.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

import co.edu.icesi.ci.talleres.model.Tmio1Bus;
import co.edu.icesi.ci.talleres.model.Tmio1Conductore;
import co.edu.icesi.ci.talleres.model.Tmio1Ruta;
import co.edu.icesi.ci.talleres.model.Tmio1Servicio;
import co.edu.icesi.ci.talleres.model.Tmio1ServicioPK;

public interface ServiceServiceIn {

	public void saveService(Tmio1ServicioPK serice);
	public void validarService(Tmio1Servicio service) throws Exception;
	public Optional<Tmio1Servicio> findById(Tmio1ServicioPK id);
	public void saveService2(Tmio1Servicio service);
	public Iterable<Tmio1Bus> findAllBuses();
	public Iterable<Tmio1Conductore> findAllDrivers();
	public Iterable<Tmio1Ruta> findAllRoutes();
	public Iterable<Tmio1Servicio> findAllServices();
	public Optional<Tmio1Bus> findByBusId(Integer busId);
	public Optional<Tmio1Conductore> findByDriverId(String driverId);
	public Optional<Tmio1Ruta> findByRouteId(Integer routeId);
	public Optional<Tmio1ServicioPK> findPKId(String id);
	public Iterable<Tmio1Servicio> filtrar(LocalDate fechaInicio);
	
}
