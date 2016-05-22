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

import vhck.neighbors.enums.OccurrenceTypeEnum;

@Entity
@Table(name = "occurrence")
public class OccurrenceEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "occurrence")
	private OccurrenceTypeEnum occurrenceType;

	@NotNull
	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@OneToOne
	@JoinColumn(name = "id_owner")
	private UserEntity owner;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation")
	private Date creation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update")
	private Date update;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "description", length = 4000)
	private String description;

	@OneToMany(mappedBy = "occurrenceEntity", fetch = FetchType.LAZY)
	private List<MessageRoutesEntity> messagesRoutes;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "occurrence_flame", joinColumns = { @JoinColumn(name = "occurrence_id") }, inverseJoinColumns = { @JoinColumn(name = "flame_id") })
	private List<FlameEntity> flames;

	public OccurrenceEntity() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MessageRoutesEntity> getMessagesRoutes() {
		return messagesRoutes;
	}

	public void setMessagesRoutes(List<MessageRoutesEntity> messagesRoutes) {
		this.messagesRoutes = messagesRoutes;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public OccurrenceTypeEnum getOccurrenceType() {
		return occurrenceType;
	}

	public Date getUpdate() {
		return update;
	}

	public List<FlameEntity> getFlames() {
		return flames;
	}

	public void setOccurrenceType(OccurrenceTypeEnum occurrenceType) {
		this.occurrenceType = occurrenceType;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public void setFlames(List<FlameEntity> flames) {
		this.flames = flames;
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
		OccurrenceEntity other = (OccurrenceEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
