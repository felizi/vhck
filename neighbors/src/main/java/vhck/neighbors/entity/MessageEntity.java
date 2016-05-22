package vhck.neighbors.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "message")
public class MessageEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_creation")
	private Date dateCreation;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "id_user", referencedColumnName = "id_user"), @JoinColumn(name = "id_build", referencedColumnName = "id_build") })
	private UserBuildEntity sender;

	@ManyToOne
	@JoinColumn(name = "id_event", referencedColumnName = "id")
	private EventEntity eventRecipient;

	@ManyToOne
	@JoinColumn(name = "id_channel", referencedColumnName = "id")
	private ChannelEntity channelRecipient;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "message", length = 4000)
	private String message;

	protected MessageEntity() {
	}

	public MessageEntity(UserBuildEntity sender, EventEntity recipient) {
		this();
		this.sender = sender;
		this.eventRecipient = recipient;
	}

	public MessageEntity(UserBuildEntity sender, ChannelEntity recipient) {
		this();
		this.sender = sender;
		this.channelRecipient = recipient;
	}

	public Long getId() {
		return id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public UserBuildEntity getSender() {
		return sender;
	}

	public void setSender(UserBuildEntity sender) {
		this.sender = sender;
	}

	public EventEntity getEventRecipient() {
		return eventRecipient;
	}

	public void setEventRecipient(EventEntity eventRecipient) {
		this.eventRecipient = eventRecipient;
	}

	public ChannelEntity getChannelRecipient() {
		return channelRecipient;
	}

	public void setChannelRecipient(ChannelEntity channelRecipient) {
		this.channelRecipient = channelRecipient;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
		MessageEntity other = (MessageEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
