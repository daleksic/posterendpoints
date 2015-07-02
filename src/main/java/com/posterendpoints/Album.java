package com.posterendpoints;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Album {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	
	@Persistent
	private Long androidId;
	
	@Persistent
	private String title;
	
	@Persistent
	private String description;
	
	//@Persistent
	//private User user;
	
	@Persistent
	private List<Image> images;
	
	@Persistent
	private String lastTimeModified;
	
	public Album() {}
	
	public Album(Long androidId, String title, String description) {
		super();
		this.androidId = androidId;
		this.title = title;
		this.description = description;
		this.images = new ArrayList<Image>();
		//this.user = user;
	}	

	public Key getId() {
		return id;
	}
	
	public Long getAndroidId() {
		return androidId;
	}

	public void setAndroidId(Long androidId) {
		this.androidId = androidId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
*/
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getLastTimeModified() {
		return lastTimeModified;
	}

	public void setLastTimeModified(String lastTimeModified) {
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
		Album other = (Album) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
 
	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", description="
				+ description + "]";
	}
}
