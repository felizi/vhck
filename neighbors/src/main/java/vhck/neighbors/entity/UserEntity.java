package vhck.neighbors.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import vhck.neighbors.entity.message.RecipientInterface;
import vhck.neighbors.entity.message.SenderInterface;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable, SenderInterface, RecipientInterface {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String email;
	private String password;

}
