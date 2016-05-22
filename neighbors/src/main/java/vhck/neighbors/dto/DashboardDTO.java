package vhck.neighbors.dto;

import java.util.List;

import vhck.neighbors.entity.EventEntity;
import vhck.neighbors.entity.OccurrenceEntity;

public class DashboardDTO {
	private List<EventEntity> events;
	private List<OccurrenceEntity> occurrences;

	public DashboardDTO(List<EventEntity> events, List<OccurrenceEntity> occurrences) {
		super();
		this.events = events;
		this.occurrences = occurrences;
	}

	public List<EventEntity> getEvents() {
		return events;
	}

	public List<OccurrenceEntity> getOccurrences() {
		return occurrences;
	}

}
