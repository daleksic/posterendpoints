package com.posterendpoints.api;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JDOCursorHelper;
import com.posterendpoints.Album;
import com.posterendpoints.Image;
import com.posterendpoints.User;

@Api(name = "posterendpoint", namespace = @ApiNamespace(ownerDomain = "poster.com", ownerName = "poster.com", packagePath = "api"))
public class PosterEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listUser")
	public CollectionResponse<User> listUser(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<User> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(User.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<User>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (User obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<User> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getUser")
	public User getUser(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		User user = null;
		try {
			user = mgr.getObjectById(User.class, id);
		} finally {
			mgr.close();
		}
		return user;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param user the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertUser")
	public User insertUser(User user) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			 if (user.getId() != null) {
				if (containsUser(user)) {
					throw new EntityExistsException("Object already exists");
				}
			 }
			mgr.makePersistent(user);
		} finally {
			mgr.close();
		}
		return user;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param user the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateUser")
	public User updateUser(User user) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			 if (user.getId() != null) {
				if (!containsUser(user)) {
					throw new EntityNotFoundException("Object does not exist");
				}
			 }
			mgr.makePersistent(user);
		} finally {
			mgr.close();
		}
		return user;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeUser")
	public void removeUser(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			User user = mgr.getObjectById(User.class, id);
			mgr.deletePersistent(user);
		} finally {
			mgr.close();
		}
	}

	private boolean containsUser(User user) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(User.class, user.getId());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}
	

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listAlbum")
	public CollectionResponse<Album> listAlbum(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<Album> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(Album.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<Album>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Album obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Album> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getAlbum")
	public Album getAlbum(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Album album = null;
		try {
			album = mgr.getObjectById(Album.class, id);
		} finally {
			mgr.close();
		}
		return album;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param album the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertAlbum")
	public Album insertAlbum(Album album) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (album.getId() != null) {
				if (containsAlbum(album)) {
					throw new EntityExistsException("Object already exists");
				}
			}
			mgr.makePersistent(album);
		} finally {
			mgr.close();
		}
		return album;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param album the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateAlbum")
	public Album updateAlbum(Album album) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (album.getId() != null) {
				if (!containsAlbum(album)) {
					throw new EntityNotFoundException("Object does not exist");
				}
			}
			mgr.makePersistent(album);
		} finally {
			mgr.close();
		}
		return album;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeAlbum")
	public void removeAlbum(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Album album = mgr.getObjectById(Album.class, id);
			mgr.deletePersistent(album);
		} finally {
			mgr.close();
		}
	}

	private boolean containsAlbum(Album album) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Album.class, album.getId());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}
	

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listImage")
	public CollectionResponse<Image> listImage(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<Image> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(Image.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<Image>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Image obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Image> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getImage")
	public Image getImage(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Image image = null;
		try {
			image = mgr.getObjectById(Image.class, id);
		} finally {
			mgr.close();
		}
		return image;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param image the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertImage")
	public Image insertImage(Image image) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (image.getId() != null) {
				if (containsImage(image)) {
					throw new EntityExistsException("Object already exists");
				}
			}
			mgr.makePersistent(image);
		} finally {
			mgr.close();
		}
		return image;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param image the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateImage")
	public Image updateImage(Image image) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (image.getId() != null) {
				if (!containsImage(image)) {
					throw new EntityNotFoundException("Object does not exist");
				}
			}
			mgr.makePersistent(image);
		} finally {
			mgr.close();
		}
		return image;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeImage")
	public void removeImage(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Image image = mgr.getObjectById(Image.class, id);
			mgr.deletePersistent(image);
		} finally {
			mgr.close();
		}
	}

	private boolean containsImage(Image image) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Image.class, image.getId());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}



	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}


}
