package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.RailTransport;

@Remote
public interface RailTransportServiceRemote {
//	void add(RailTransport railtransport);
	void add(RailTransport railtransport);
	RailTransport  find(int id);
	void update(RailTransport railtransport);
	void Delete (RailTransport railtransport);
	void Delete(Integer id);
	List<RailTransport> findAll();
	void DeleteByImmatriculation(String nom);
	List<RailTransport> findByImmatriculation(String immatriculation);
	List<RailTransport> findByType(String type);
	List<RailTransport> findAllBySector(int id);
	long GStatistiques();

}
