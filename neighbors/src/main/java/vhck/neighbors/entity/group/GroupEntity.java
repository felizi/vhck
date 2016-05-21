package vhck.neighbors.entity.group;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import vhck.neighbors.entity.UserEntity;
import vhck.neighbors.entity.message.RecipientInterface;
import vhck.neighbors.entity.message.SenderInterface;

@Entity
@Table(name = "group")
public abstract class GroupEntity implements Serializable, RecipientInterface, SenderInterface {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private UserEntity owner;
	private List<UserEntity> members;
	private Integer privacy; // Public Closed Secret -
								// https://www.facebook.com/help/220336891328465

}
