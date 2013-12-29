package usermanager;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;
import model.UsersGroup;
import usermanager.DTO.UserDTO;

/**
 * Session Bean implementation class UserMgrBean
 */
@Stateless
public class UserMgrBean implements UserMgr {

	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
	

	@Override
	public void save(UserDTO user) {
		User newUser = new User(user);
		List<UsersGroup> groups = new ArrayList<UsersGroup>();
		groups.add(UsersGroup.USER);
		newUser.setGroups(groups);
		em.persist(newUser);
	}


	@Override
	@RolesAllowed({UsersGroup._USER,UsersGroup._ADMIN})
	public void update(UserDTO user) {
		em.merge(new User(user));
	}


	@Override
	@RolesAllowed({UsersGroup._USER,UsersGroup._ADMIN})
	public UserDTO getUserDTO() {
		UserDTO userDTO = convertToDTO(getPrincipalUser());
		return userDTO;
	}


	@Override
	@RolesAllowed({UsersGroup._USER})
	public void unregister() {
		remove(getPrincipalUser());
	}


	public User find(String email) {
    	return em.find(User.class, email);
    }
    
    public List<User> getAllUsers() {
    	return em.createNamedQuery(User.FIND_ALL, User.class)
                .getResultList();
    }

    public void remove(String email) {
		User user = find(email);
        em.remove(user);
	}
    
    public void remove(User user) {
    	em.remove(user);
	}
    
    
    public User getPrincipalUser() {
    	return find(getPrincipalEmail());
    }
	
    
    public String getPrincipalEmail() {
    	return context.getCallerPrincipal().getName();
    }

    private UserDTO convertToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(user.getEmailUtente());
		userDTO.setFirstName(user.getNome());
		userDTO.setLastName(user.getCgnome());
		return userDTO;
	}
}
