package vhck.neighbors.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class UserBuildEntityId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="id_user")
    private Long user;
	
    @Column(name="id_build")
    private Long build;
    
    public UserBuildEntityId() {
    }

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Long getBuild() {
		return build;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((build == null) ? 0 : build.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBuildEntityId other = (UserBuildEntityId) obj;
		if (build == null) {
			if (other.build != null)
				return false;
		} else if (!build.equals(other.build))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public void setBuild(Long build) {
		this.build = build;
	}
}
