package vhck.neighbors.entity.group;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import vhck.neighbors.entity.GeolocationEntity;

@Entity
@Table(name = "event")
public class EventEntity extends GroupEntity {
	private static final long serialVersionUID = 1L;

	private GeolocationEntity geolocation;
}
