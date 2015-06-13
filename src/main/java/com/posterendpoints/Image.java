package com.posterendpoints;

import java.sql.Timestamp;
import com.google.appengine.api.datastore.Key;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Image {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	
	@Persistent
	private String title;
	
	@Persistent
	private String location;
	
	@Persistent
	private String url;
	
	@Persistent
	private Timestamp dateCreated;
	
	@Persistent
	private String contentType;
	
	@Persistent
	private int width;
	
	@Persistent
	private int height;
	
	@Persistent
	private Timestamp lastTimeModified;
	
	@Persistent
	private Album album;
	
	public Image() {}
	
	public Image(String title, String location, String url, Timestamp dateCreated, String contentType, int width, int height, Album album, Timestamp lastTimeModified) {
		super();
		this.title = title;
		this.location = location;
		this.url = url;
		this.dateCreated = dateCreated;
		this.contentType = contentType;
		this.width = width;
		this.height = height;
		this.album = album;
		this.lastTimeModified = lastTimeModified;
	}	
	
	public Key getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Timestamp getLastTimeModified() {
		return lastTimeModified;
	}

	public void setLastTimeModified(Timestamp lastTimeModified) {
		this.lastTimeModified = lastTimeModified;
	}
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
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
		Image other = (Image) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
 
	@Override
	public String toString() {
		return "Image [id=" + id + ", title=" + title + ", url="
				+ url + "]";
	}
}
