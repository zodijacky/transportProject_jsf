package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Bus;
import pi.transport.persistance.Route;

@Remote
public interface BusServiceRemote {
	public Bus create(Bus bus);
	public void delete(Integer immat);
	public Bus find(Integer id);
	public void delete(Bus b);
	public List<Bus> findAll();
	public void update(Bus b);
	List<Bus> findBusesByRoute(Route r);
	List<Bus> findBusesNotInRoute(Route r);
	List<Bus> findBussLike(String str);

}
