package vhck.neighbors.jersey.config;

import org.glassfish.jersey.server.ResourceConfig;

import vhck.neighbors.jersey.filters.CorsResponseFilter;

public class AppConfig extends ResourceConfig {
	public AppConfig() {
		register(new CorsResponseFilter());
		packages(true, "vhck.neighbors.rest.resources");
	}
}