package vhck.neighbors.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import vhck.neighbors.enums.PrivacyEnum;
import vhck.neighbors.jersey.translator.constants.BasicConstants;

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
	
	@ManyToOne
    @JoinColumn(name = "id_user_owner", referencedColumnName = "id")
    private UserEntity userOwner;

	@ManyToOne
    @JoinColumn(name = "id_build", referencedColumnName = "id")
	private BuildEntity build;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "channel_member", joinColumns = @JoinColumn(name="id_channel"), inverseJoinColumns = @JoinColumn(name="id_user"))
	private List<UserEntity> members;

	@Enumerated(EnumType.STRING)
	@Column(name = "privacy")
	private PrivacyEnum privacy;
	
	@OneToMany(mappedBy = "channelRecipient", fetch = FetchType.LAZY)
	private List<MessageRoutesEntity> messagesRoutes;
	
	protected ChannelEntity() {
		this.privacy = PrivacyEnum.PUBLIC;
	}

	public ChannelEntity(String name, UserBuildEntity owner) {
		this.name = name;
		this.userOwner = owner.getUser();
		this.build = owner.getBuild();
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

	public UserEntity getUserOwner() {
		return userOwner;
	}

	public void setUserOwner(UserEntity userOwner) {
		this.userOwner = userOwner;
	}

	public BuildEntity getBuild() {
		return build;
	}

	public void setBuild(BuildEntity build) {
		this.build = build;
	}

	public List<UserEntity> getMembers() {
		return members;
	}

	public void setMembers(List<UserEntity> members) {
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

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		map.put(BasicConstants.ID, this.getId());
		map.put(BasicConstants.NAME, this.getName());
		return map;
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
