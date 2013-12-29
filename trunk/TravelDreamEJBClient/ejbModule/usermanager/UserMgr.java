package usermanager;



import javax.ejb.Local;

import usermanager.DTO.UserDTO;

@Local
public interface UserMgr {
	
	public void save(UserDTO user);
	
	public void update(UserDTO user);
	
	public void unregister();
	
	public UserDTO getUserDTO();

}