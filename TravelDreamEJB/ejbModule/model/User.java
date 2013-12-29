package model;







import java.io.Serializable;

import javax.persistence.*;

import org.apache.commons.codec.digest.DigestUtils;

import usermanager.DTO.UserDTO;


import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "User.findAll";
	@ElementCollection(targetClass = UsersGroup.class)
    @CollectionTable(name = "users_groups",
                    joinColumns = @JoinColumn(name = "email"))
    @Enumerated(EnumType.STRING)
    @Column(name="groupname")
    private List<UsersGroup> groups;
	
	@Id
	private int idUtente;

	private String cgnome;

	private String emailUtente;

	private String nome;

	private String password;

	private int residenza;

	private String userrname;
	
	
	public User(UserDTO user){
        
        this.emailUtente        = user.getEmail();
        this.nome    = user.getFirstName();
        this.cgnome     = user.getLastName();        
        this.password     = DigestUtils.sha512Hex(user.getPassword() );
        
    }
   
	//bi-directional many-to-one association to Acquistapacchetto
	@OneToMany(mappedBy="user")
	private List<Acquistapacchetto> acquistapacchettos;

	//bi-directional many-to-one association to Aderiscegiftlist
	@OneToMany(mappedBy="user")
	private List<Aderiscegiftlist> aderiscegiftlists;

	//bi-directional many-to-one association to Giftlist
	@OneToMany(mappedBy="user")
	private List<Giftlist> giftlists;

	//bi-directional many-to-one association to Pacchetto
	@OneToMany(mappedBy="user")
	private List<Pacchetto> pacchettos;

	//bi-directional many-to-one association to Partecipapacchetto
	@OneToMany(mappedBy="user")
	private List<Partecipapacchetto> partecipapacchettos;

	//bi-directional many-to-one association to UsersGroup


	public User() {
	}

	public int getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getCgnome() {
		return this.cgnome;
	}

	public void setCgnome(String cgnome) {
		this.cgnome = cgnome;
	}

	public String getEmailUtente() {
		return this.emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getResidenza() {
		return this.residenza;
	}

	public void setResidenza(int residenza) {
		this.residenza = residenza;
	}

	public String getUserrname() {
		return this.userrname;
	}

	public void setUserrname(String userrname) {
		this.userrname = userrname;
	}

	public List<Acquistapacchetto> getAcquistapacchettos() {
		return this.acquistapacchettos;
	}

	public void setAcquistapacchettos(List<Acquistapacchetto> acquistapacchettos) {
		this.acquistapacchettos = acquistapacchettos;
	}

	public Acquistapacchetto addAcquistapacchetto(Acquistapacchetto acquistapacchetto) {
		getAcquistapacchettos().add(acquistapacchetto);
		acquistapacchetto.setUser(this);

		return acquistapacchetto;
	}

	public Acquistapacchetto removeAcquistapacchetto(Acquistapacchetto acquistapacchetto) {
		getAcquistapacchettos().remove(acquistapacchetto);
		acquistapacchetto.setUser(null);

		return acquistapacchetto;
	}

	public List<Aderiscegiftlist> getAderiscegiftlists() {
		return this.aderiscegiftlists;
	}

	public void setAderiscegiftlists(List<Aderiscegiftlist> aderiscegiftlists) {
		this.aderiscegiftlists = aderiscegiftlists;
	}

	public Aderiscegiftlist addAderiscegiftlist(Aderiscegiftlist aderiscegiftlist) {
		getAderiscegiftlists().add(aderiscegiftlist);
		aderiscegiftlist.setUser(this);

		return aderiscegiftlist;
	}

	public Aderiscegiftlist removeAderiscegiftlist(Aderiscegiftlist aderiscegiftlist) {
		getAderiscegiftlists().remove(aderiscegiftlist);
		aderiscegiftlist.setUser(null);

		return aderiscegiftlist;
	}

	public List<Giftlist> getGiftlists() {
		return this.giftlists;
	}

	public void setGiftlists(List<Giftlist> giftlists) {
		this.giftlists = giftlists;
	}

	public Giftlist addGiftlist(Giftlist giftlist) {
		getGiftlists().add(giftlist);
		giftlist.setUser(this);

		return giftlist;
	}

	public Giftlist removeGiftlist(Giftlist giftlist) {
		getGiftlists().remove(giftlist);
		giftlist.setUser(null);

		return giftlist;
	}

	public List<Pacchetto> getPacchettos() {
		return this.pacchettos;
	}

	public void setPacchettos(List<Pacchetto> pacchettos) {
		this.pacchettos = pacchettos;
	}

	public Pacchetto addPacchetto(Pacchetto pacchetto) {
		getPacchettos().add(pacchetto);
		pacchetto.setUser(this);

		return pacchetto;
	}

	public Pacchetto removePacchetto(Pacchetto pacchetto) {
		getPacchettos().remove(pacchetto);
		pacchetto.setUser(null);

		return pacchetto;
	}

	public List<Partecipapacchetto> getPartecipapacchettos() {
		return this.partecipapacchettos;
	}

	public void setPartecipapacchettos(List<Partecipapacchetto> partecipapacchettos) {
		this.partecipapacchettos = partecipapacchettos;
	}

	public Partecipapacchetto addPartecipapacchetto(Partecipapacchetto partecipapacchetto) {
		getPartecipapacchettos().add(partecipapacchetto);
		partecipapacchetto.setUser(this);

		return partecipapacchetto;
	}

	public Partecipapacchetto removePartecipapacchetto(Partecipapacchetto partecipapacchetto) {
		getPartecipapacchettos().remove(partecipapacchetto);
		partecipapacchetto.setUser(null);

		return partecipapacchetto;
	}
	public List<UsersGroup> getGroups() {
        return groups;
    }
 
    public void setGroups(List<UsersGroup> groups) {
        this.groups = groups;
    }

	

}