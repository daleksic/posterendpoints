package com.posterendpoints;

import java.io.Serializable;
import java.sql.Timestamp;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Image implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8330219976328828433L;

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private Long androidId;
	
	@Persistent
	private String title;
	
	@Persistent
	private String location;
	
	@Persistent
	private String url;
	
	@Persistent
	private String dateCreated;
	
	@Persistent
	private String contentType;
	
	@Persistent
	private int width;
	
	@Persistent
	private int height;
	
	@Persistent
	private String lastTimeModified;
	
	@Persistent
	private String imageBlob;
	
	/*@Persistent
	private Album album;
	*/
	/*public Image() {}
	
	public Image(String title, Long androidId, String location, String url, String dateCreated, String contentType, int width, int height, String imageBlob) {
		super();
		this.androidId = androidId;
		this.title = title;
		this.location = location;
		this.url = url;
		this.dateCreated = dateCreated;
		this.contentType = contentType;
		this.width = width;
		this.height = height;
		this.imageBlob = imageBlob;
		//this.album = album;
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

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
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

	public String getLastTimeModified() {
		return lastTimeModified;
	}

	public void setLastTimeModified(String lastTimeModified) {
		this.lastTimeModified = lastTimeModified;
	}
		
	public String getImageBlob() {
		return imageBlob;
	}

	public void setImageBlob(String imageBlob) {
		this.imageBlob = imageBlob;
	}

	/*public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}*/
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
		Image other = (Image) obj;
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
		return "Image [id=" + key + ", title=" + title + ", url="
				+ url + "]";
	}
}
