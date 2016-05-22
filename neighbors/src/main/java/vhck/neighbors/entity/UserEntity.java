package vhck.neighbors.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserBuildEntity> userBuild;
	
	protected UserEntity() {
	}

	public UserEntity(String name, String email) {
		this();
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = this.encriptarPassword(password);
	}

	public List<UserBuildEntity> getUserBuild() {
		return userBuild;
	}

	public void setUserBuild(List<UserBuildEntity> userBuild) {
		this.userBuild = userBuild;
	}

	public String encriptarPassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(password.getBytes());
			BigInteger bi = new BigInteger(1, digest.digest());
			return bi.toString(16);

		} catch (NoSuchAlgorithmException ns) {
			return password;
		}
	}
}
