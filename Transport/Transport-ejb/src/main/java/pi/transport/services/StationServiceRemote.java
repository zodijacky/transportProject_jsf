package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Station;

@Remote
public interface StationServiceRemote {
	void add(Station station);
	Station find(Integer id);
	void update(Station station);
	void Delete (Station station);
	void Delete(Integer id);
	List<Station> findAll();
}
