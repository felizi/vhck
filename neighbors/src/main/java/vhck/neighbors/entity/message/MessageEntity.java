package vhck.neighbors.entity.message;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class MessageEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private SenderInterface sender;
	private RecipientInterface recipient;

	private Date dateTime;

	public Long getId() {
		return id;
	}

	public SenderInterface getSender() {
		return sender;
	}

	public RecipientInterface getRecipient() {
		return recipient;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSender(SenderInterface sender) {
		this.sender = sender;
	}

	public void setRecipient(RecipientInterface recipient) {
		this.recipient = recipient;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}
