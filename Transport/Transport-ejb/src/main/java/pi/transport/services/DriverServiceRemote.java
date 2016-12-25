package pi.transport.services;

import pi.transport.persistance.Driver;
import java.util.List;

import javax.ejb.Remote;



@Remote
public interface DriverServiceRemote {
	public void create(Driver driver);
	 public Driver find(Integer id);
	 public void update(Driver driver);
	 public void delete(Driver driver);
	 public void delete(Integer id);
	 public List<Driver> findAll();
	 public Driver FindDriverByName(String name);

}
