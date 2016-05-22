package vhck.neighbors.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import vhck.neighbors.enums.PrivacyEnum;

@Entity
@Table(name = "channel")
public class ChannelEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@OneToOne
	@JoinColumn(name = "id_owner")
	private UserEntity owner;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "channel_member", joinColumns = @JoinColumn(name = "channel_id"), 
				inverseJoinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id_user"), @JoinColumn(name="id_build", referencedColumnName = "id_build")})
	private List<UserBuildEntity> members;

	@Enumerated(EnumType.STRING)
	@Column(name = "privacy")
	private PrivacyEnum privacy;
	
	@OneToMany(mappedBy = "channelRecipient", fetch = FetchType.LAZY)
	private List<MessageRoutesEntity> messagesRoutes;
	
	protected ChannelEntity() {
		this.privacy = PrivacyEnum.PUBLIC;
	}

	public ChannelEntity(String name, UserEntity owner) {
		this.name = name;
		this.owner = owner;
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

	public UserEntity getOwner() {
		return owner;
	}

	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}

	public List<UserBuildEntity> getMembers() {
		return members;
	}

	public void setMembers(List<UserBuildEntity> members) {
		this.members = members;
	}

	public PrivacyEnum getPrivacy() {
		return privacy;
	}

	public void setPrivacy(PrivacyEnum privacy) {
		this.privacy = privacy;
	}

	public List<MessageRoutesEntity> getMessagesRoutes() {
		return messagesRoutes;
	}

	public void setMessagesRoutes(List<MessageRoutesEntity> messagesRoutes) {
		this.messagesRoutes = messagesRoutes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChannelEntity other = (ChannelEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
