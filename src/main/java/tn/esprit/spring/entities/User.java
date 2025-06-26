package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "T_USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@Enumerated(EnumType.STRING)
	private Role role;

	public User() {}

	public User(String firstName, String lastName, Date dateNaissance, Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateNaissance = dateNaissance;
		this.role = role;
	}

	public User(Long id, String firstName, String lastName, Date dateNaissance, Role role) {
		this(firstName, lastName, dateNaissance, role);
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName +
				", dateNaissance=" + dateNaissance + ", role=" + role + "]";
	}

	// Getters/Setters

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }

	public Date getDateNaissance() { return dateNaissance; }
	public void setDateNaissance(Date dateNaissance) { this.dateNaissance = dateNaissance; }

	public Role getRole() { return role; }
	public void setRole(Role role) { this.role = role; }

	// Alias
	public String getPrenom() { return this.firstName; }
	public void setPrenom(String prenom) { this.firstName = prenom; }
}
