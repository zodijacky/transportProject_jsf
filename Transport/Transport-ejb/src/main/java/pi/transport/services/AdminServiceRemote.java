package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Admin;
import pi.transport.persistance.Request;

@Remote
public interface AdminServiceRemote {
	
	Admin create(Admin admin);
	Admin find(Integer cin);
	void update(Admin admin);
	void delete(Admin admin);
	void delete(Integer cin);
	List<Admin> findAll();
	List<Admin> findAllSuperAdmins();
	List<Admin> findAllAdmins();

	public List<Request> getReservationsByAdmin(Admin admin);
	Admin findByLoginPassword(String login, String password);
}
