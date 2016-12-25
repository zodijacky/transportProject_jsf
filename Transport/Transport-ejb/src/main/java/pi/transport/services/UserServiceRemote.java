package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.User;

@Remote
public interface UserServiceRemote {

	
	

	User findUsrById(Integer id);

 public User authentificate  (String login,String password);
 public void create(User user);
 public User find(Integer id);
 public void update(User user);
 public void delete(User user);
 public void delete(Integer id);
 public List<User> findAll();
 public User FindUserByName(String name);

 public List<User> FindUserLikeName(String name);
User findUserByLogin(String login);
public String  getRoleById(String id);
public User getuserr(String id) ;
 

}