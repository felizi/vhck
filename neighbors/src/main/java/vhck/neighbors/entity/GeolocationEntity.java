package vhck.neighbors.entity;

import javax.persistence.Embeddable;

@Embeddable
public class GeolocationEntity {
	private double latitude;
	private double longitude;

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
