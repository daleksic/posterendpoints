package com.posterendpoints;

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
public class User {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	
	@Persistent
	private Integer androidId;
	
	@Persistent
	private String fullName;
	
	@Persistent
	private String email;
	
	@Persistent
	private String password;
	
	@Persistent(mappedBy="user")
	private List<Album> albums;
	
	@Persistent
	private Timestamp lastTimeModified;
	
	public User() {}
	
	public User(Integer androidId, String fullName, String email, String password) {
		super();
		this.androidId = androidId;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.albums = new ArrayList<Album>();
	}

	public Key getId() {
		return id;
	}
	
	public Integer getAndroidId() {
		return androidId;
	}

	public void setAndroidId(Integer androidId) {
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

	public Timestamp getLastTimeModified() {
		return lastTimeModified;
	}

	public void setLastTimeModified(Timestamp lastTimeModified) {
		this.lastTimeModified = lastTimeModified;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
 
	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", email="
				+ email + "]";
	}
}
