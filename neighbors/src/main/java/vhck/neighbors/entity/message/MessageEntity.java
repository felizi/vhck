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

	private Date dateTime;

	public Long getId() {
		return id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}
