package vhck.neighbors.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_build")
@IdClass(UserBuildEntityId.class)
public class UserBuildEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_user", referencedColumnName = "id")
	private UserEntity user;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_build", referencedColumnName = "id")
	private BuildEntity build;

	@Column(name = "landlord", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
	private Boolean landlord;

	protected UserBuildEntity() {
		this.landlord = Boolean.FALSE;
	}

	public UserBuildEntity(UserEntity user, BuildEntity build) {
		this();
		this.user = user;
		this.build = build;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public BuildEntity getBuild() {
		return build;
	}

	public void setBuild(BuildEntity build) {
		this.build = build;
	}

	public Boolean getLandlord() {
		return landlord;
	}

	public void setLandlord(Boolean landlord) {
		this.landlord = landlord;
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
		UserBuildEntity other = (UserBuildEntity) obj;
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
}
