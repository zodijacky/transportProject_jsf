package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Admin;
import pi.transport.persistance.Student;
import pi.transport.persistance.Subscription;

@Remote
public interface StudentServiceRemote {
	
	Student create(Student student);
	Student find(Integer cin);
	void update(Student student);
	void delete(Student student);
	void delete(Integer cin);
	List<Student> findAll();
	Student findByLoginPassword(String login, String password);
}
