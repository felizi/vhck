package vhck.neighbors.entity.group;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import vhck.neighbors.entity.UserEntity;
import vhck.neighbors.entity.message.RecipientInterface;
import vhck.neighbors.entity.message.SenderInterface;

@MappedSuperclass
public abstract class GroupEntity implements Serializable, RecipientInterface, SenderInterface {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "NAME", nullable = false, length = 255)
	private String name;

	@OneToOne
	@JoinColumn(name = "owner_id")
	private UserEntity owner;

	@Column(name = "members")
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "group_member", joinColumns = { @JoinColumn(name = "group_id") }, inverseJoinColumns = { @JoinColumn(name = "member_id") })
	private List<UserEntity> members;

	private Integer privacy; // Public Closed Secret -
								// https://www.facebook.com/help/220336891328465

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public UserEntity getOwner() {
		return owner;
	}

	public List<UserEntity> getMembers() {
		return members;
	}

	public Integer getPrivacy() {
		return privacy;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}

	public void setMembers(List<UserEntity> members) {
		this.members = members;
	}

	public void setPrivacy(Integer privacy) {
		this.privacy = privacy;
	}

}
