package model;

import javax.ejb.Local;

import model.dto.UserDTO;



@Local
public interface UserMgr {
	
	public void save(UserDTO user);
	
	public void update(UserDTO user);
	
	public void unregister();
	
	public UserDTO getUserDTO();
	public UserDTO returnUser(String username,String password);
}