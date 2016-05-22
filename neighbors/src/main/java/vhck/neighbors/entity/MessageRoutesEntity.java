package vhck.neighbors.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message_route")
public class MessageRoutesEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "id_user", referencedColumnName = "id_user"),
		@JoinColumn(name = "id_build", referencedColumnName = "id_build")})
	private UserBuildEntity sender;
	
	@ManyToOne
    @JoinColumn(name = "id_event", referencedColumnName = "id")
	private EventEntity eventRecipient;
	
	@ManyToOne
    @JoinColumn(name = "id_channel", referencedColumnName = "id")
	private ChannelEntity channelRecipient;
	
	@ManyToOne
    @JoinColumn(name = "id_occurrence", referencedColumnName = "id")
	private OccurrenceEntity occurrenceEntity; 
	
	@OneToOne(mappedBy="messageRoutes", cascade = CascadeType.ALL)
    private MessageEntity messageEntity;
	
	protected MessageRoutesEntity() {
	}
	
	public MessageRoutesEntity(UserBuildEntity sender, EventEntity recipient) {
		this();
		this.sender = sender;
		this.eventRecipient = recipient; 
	}
	
	public MessageRoutesEntity(UserBuildEntity sender, ChannelEntity recipient) {
		this();
		this.sender = sender;
		this.channelRecipient = recipient; 
	}
	
	public MessageRoutesEntity(UserBuildEntity sender, OccurrenceEntity occurrence) {
		this();
		this.sender = sender;
		this.occurrenceEntity = occurrence;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public OccurrenceEntity getOccurrenceEntity() {
		return occurrenceEntity;
	}

	public void setOccurrenceEntity(OccurrenceEntity occurrenceEntity) {
		this.occurrenceEntity = occurrenceEntity;
	}

	public MessageEntity getMessageEntity() {
		return messageEntity;
	}

	public void setMessageEntity(MessageEntity messageEntity) {
		this.messageEntity = messageEntity;
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
		MessageRoutesEntity other = (MessageRoutesEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
