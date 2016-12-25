package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Admin;
import pi.transport.persistance.Student;
import pi.transport.persistance.Subscription;

@Remote
public interface SubscriptionServiceRemote {

	Subscription create(Subscription subscription);
	Subscription find(Integer id);
	void update(Subscription subscription);
	void delete(Subscription subscription);
	void delete(Integer id);
	List<Subscription> findAll();
	List<Subscription> getSubscriptionsByStudent(Student student);
}
