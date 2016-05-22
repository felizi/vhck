package vhck.neighbors.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import vhck.neighbors.enums.PrivacyEnum;

@Entity
@Table(name = "event")
public class EventEntity implements Serializable {
	
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
	@JoinTable(name = "event_member", joinColumns = @JoinColumn(name = "group_id"), 
			   inverseJoinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id_user"), @JoinColumn(name="id_build", referencedColumnName = "id_build")})
	private List<UserBuildEntity> members;

	@Enumerated(EnumType.STRING)
	@Column(name = "privacy")
	private PrivacyEnum privacy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_time")
	private Date dateTime;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name="description", length = 4000)
	private String description;
	
	@OneToMany(mappedBy = "eventRecipient", fetch = FetchType.LAZY)
	private List<MessageEntity> messages;
	
	public EventEntity() {
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<MessageEntity> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageEntity> messages) {
		this.messages = messages;
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
		EventEntity other = (EventEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}