package vhck.neighbors.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import vhck.neighbors.entity.message.RecipientInterface;
import vhck.neighbors.entity.message.SenderInterface;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable, SenderInterface, RecipientInterface {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;

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
