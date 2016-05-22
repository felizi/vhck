package vhck.neighbors.jersey.translator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import vhck.neighbors.entity.ChannelEntity;

public class ChannelTranslator {

	public List<Map<String,Object>> convertListChannelEntityToListMaps(List<ChannelEntity> channels){
		List<Map<String,Object>> listChannelsMap = new ArrayList<>();
		for(ChannelEntity channel : channels) {
			listChannelsMap.add(channel.toMap());
		}
		return listChannelsMap;
	}
}
