package vhck.neighbors.bo;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import vhck.neighbors.dao.MessageDAO;
import vhck.neighbors.entity.message.MessageEntity;

@Stateless
public class MessageBO {

	@Inject private MessageDAO messageDAO;
	
	public void include(MessageEntity message) {
		messageDAO.include(message);
	}
	
	public void change(MessageEntity message){
		messageDAO.change(message);
	}
	
	public void remove(MessageEntity message) {
		messageDAO.remove(message);
	}
	
	public MessageEntity findById(Long id) {
		return messageDAO.findById(id);
	}
	
	public void removeById(Long id) {
		messageDAO.removeById(id);
	}
	
	public Long countTotalOfMessageRegistered() {
		return messageDAO.count();
	}
	
	public List<MessageEntity> findAll() {
		return messageDAO.findAll();
	}
}
