package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;



@Entity
public class Employe implements Serializable {
	
	private static final long serialVersionUID = -1396669830860400871L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter private int id;
	
	@Getter @Setter private String prenom;
	
	@Getter @Setter private String nom;
	
	//@Column(unique=true)
	@Getter @Setter private String email;

	@Getter @Setter private boolean isActif;
	
	@Enumerated(EnumType.STRING)
	//@NotNull
	@Getter @Setter private Role role;
	
	//@JsonBackReference  
	@JsonIgnore
	@ManyToMany(mappedBy="employes",fetch=FetchType.EAGER )
	//@NotNull
	@Getter @Setter private List<Departement> departements;
	
	@JsonIgnore
	//@JsonBackReference
	@OneToOne(mappedBy="employe")
	@Getter @Setter private Contrat contrat;
	
	@JsonIgnore
	//@JsonBackReference
	@OneToMany(mappedBy="employe")
	@Getter @Setter private List<Timesheet> timesheets;
	
	
	public Employe() {
		super();
	}
	
	public Employe(String nom, String prenom, String email, boolean isActif, Role role) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.isActif = isActif;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public List<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
	
	
}
