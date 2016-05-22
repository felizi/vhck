package vhck.neighbors.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "flame")
public class FlameEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation")
	private Date creation;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "flame_user", joinColumns = { @JoinColumn(name = "flame_id") }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private List<UserEntity> userList;

	public Long getId() {
		return id;
	}

	public Date getCreation() {
		return creation;
	}

	public List<UserEntity> getUserList() {
		return userList;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
	}
}
