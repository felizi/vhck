package vhck.neighbors.bo;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import vhck.neighbors.dao.ChannelDAO;
import vhck.neighbors.entity.ChannelEntity;

@Stateless
public class ChannelBO {

	@Inject private ChannelDAO channelDAO;
	
	public void include(ChannelEntity channel) {
		channelDAO.include(channel);
	}
	
	public void change(ChannelEntity channel){
		channelDAO.change(channel);
	}
	
	public void remove(ChannelEntity channel) {
		channelDAO.remove(channel);
	}
	
	public ChannelEntity findById(Long id) {
		return channelDAO.findById(id);
	}
	
	public void removeById(Long id) {
		channelDAO.removeById(id);
	}
	
	public Long countTotalOfChannelRegistered() {
		return channelDAO.count();
	}
	
	public List<ChannelEntity> findAll() {
		return channelDAO.findAll();
	}
}
