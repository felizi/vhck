package vhck.neighbors.entity;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BuildEntityTest {
	private UserEntity user;
	private BuildEntity build;
	private GeolocationEntity geolocation;
	private String name;

	private double latitudeVancouver = 49.2496600;
	private double longitudeVancouver = -123.1193400;

	@Before
	public void setup() {
		this.name = "Burle Marx";

		this.user = new UserEntity();

		this.build = new BuildEntity();
		this.build.setName(this.name);

		this.geolocation = new GeolocationEntity();
		this.geolocation.setLatitude(this.latitudeVancouver);
		this.geolocation.setLongitude(this.longitudeVancouver);
		this.build.setGeolocation(this.geolocation);

		this.build.setOwner(this.user);
		this.build.setLandlord(Arrays.asList(this.user));
	}

	@Test
	public void mustHaveName() {
		Assert.assertEquals(this.name, this.build.getName());
	}

	@Test
	public void mustHaveGeolocationLatitudeAndLongitude() {
		Assert.assertEquals(this.latitudeVancouver, this.build.getGeolocation().getLatitude(), 0);
		Assert.assertEquals(this.longitudeVancouver, this.build.getGeolocation().getLongitude(), 0);
	}
}
