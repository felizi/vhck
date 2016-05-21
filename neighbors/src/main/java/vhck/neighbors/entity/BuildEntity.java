package vhck.neighbors.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "build")
public class BuildEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UserEntity owner;

	@Column(name = "landlord")
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "build_landlord", joinColumns = { @JoinColumn(name = "build_id") }, inverseJoinColumns = { @JoinColumn(name = "landlord_id") })
	private List<UserEntity> landlord;

	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "NAME", nullable = false, length = 255)
	private String name;

	private GeolocationEntity geolocation;

	public Long getId() {
		return id;
	}

	public UserEntity getOwner() {
		return owner;
	}

	public List<UserEntity> getLandlord() {
		return landlord;
	}

	public String getName() {
		return name;
	}

	public GeolocationEntity getGeolocation() {
		return geolocation;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}

	public void setLandlord(List<UserEntity> landlord) {
		this.landlord = landlord;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGeolocation(GeolocationEntity geolocation) {
		this.geolocation = geolocation;
	}
}
