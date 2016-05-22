package vhck.neighbors.dto;

public class ChannelDTO {

	private String id;
	private String name;
	
	public ChannelDTO(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
