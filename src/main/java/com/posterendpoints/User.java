package com.posterendpoints;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4942446880572280041L;

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private Long androidId;
	
	@Persistent
	private String fullName;
	
	@Persistent
	private String email;
	
	@Persistent
	private String password;
	
	@Persistent
	private List<Album> albums  = new ArrayList<Album>();
	
	@Persistent
	private String lastTimeModified;
	
	/*public User() {}
	
	public User(Long androidId, String fullName, String email, String password) {
		super();
		this.androidId = androidId;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.albums = new ArrayList<Album>();
	}
*/
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	
	public Long getAndroidId() {
		return androidId;
	}

	public void setAndroidId(Long androidId) {
		this.androidId = androidId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public String getLastTimeModified() {
		return lastTimeModified;
	}

	public void setLastTimeModified(String lastTimeModified) {
		this.lastTimeModified = lastTimeModified;
	}
/*	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		User other = (User) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
 */
	@Override
	public String toString() {
		return "User [id=" + key + ", fullName=" + fullName + ", email="
				+ email + "]";
	}
}
