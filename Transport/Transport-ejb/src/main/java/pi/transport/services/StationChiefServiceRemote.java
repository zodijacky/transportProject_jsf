package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.StationChief;

@Remote
public interface StationChiefServiceRemote {
	public void create(StationChief stationChief);
	
	public void delete(StationChief stationChief);
	public void delete(Integer id);
	public List<StationChief> findAll();
	public void update(StationChief stationChief);
	public StationChief find(Integer id);
	
}
