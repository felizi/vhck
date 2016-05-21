package vhck.neighbors.entity.group;

import javax.persistence.Entity;
import javax.persistence.Table;

import vhck.neighbors.entity.GeolocationEntity;

@Entity
@Table(name = "event")
public class EventEntity extends GroupEntity {
	private static final long serialVersionUID = 1L;

	private GeolocationEntity geolocation;

	public GeolocationEntity getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(GeolocationEntity geolocation) {
		this.geolocation = geolocation;
	}

}
