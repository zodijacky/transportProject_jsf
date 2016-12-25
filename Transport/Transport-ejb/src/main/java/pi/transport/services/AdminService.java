package pi.transport.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.transport.persistance.Admin;
import pi.transport.persistance.Admin.AdminLevels;
import pi.transport.persistance.Request;

/**
 * Session Bean implementation class AdminService
 */
@Stateless
@LocalBean
public class AdminService implements AdminServiceRemote {


	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Admin create(Admin admin) {
		em.persist(admin);
		
		return admin;
	}

	@Override
	public Admin find(Integer cin) {
		
		return em.find(Admin.class, cin);
	}

	@Override
	public void update(Admin admin) {
		em.merge(admin);
		
	}

	@Override
	public void delete(Admin admin) {
		em.remove(em.merge(admin));
		
	}

	@Override
	public void delete(Integer cin) {
		try {
			Admin admin = em.find(Admin.class, cin);
			em.remove(admin);
			
		} catch (Exception e) {
			
		}
	}
	
	@Override
	public List<Admin> findAll() {
		
		return em.createQuery("select a from Admin a", Admin.class)
				.getResultList();
	}
	
	
    /**
     * Default constructor. 
     */
    public AdminService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Request> getReservationsByAdmin(Admin admin) {
		return em
				.createQuery("select r from Request r where r.author=:x", Request.class)
				.setParameter("x", admin)
				.getResultList();
	}

	@Override
	public List<Admin> findAllSuperAdmins() {
		return em
				.createQuery("SELECT a FROM Admin a where a.level=:x", Admin.class)
				.setParameter("x", AdminLevels.superAdmin)
				.getResultList();
	}

	@Override
	public List<Admin> findAllAdmins() {
		return em
				.createQuery("SELECT a FROM Admin a where a.level=:x", Admin.class)
				.setParameter("x", AdminLevels.admin)
				.getResultList();
	}
	
	@Override
	public Admin findByLoginPassword(String login, String password) {
		
		Admin admin = em.createQuery("SELECT s FROM Admin s WHERE s.login = '" + login + "' AND s.passWord = '" + password + "'", Admin.class)
		.getSingleResult();
		
		return admin;
	}}