

package me.binf.common.cache.item;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public abstract class CacheItem implements Serializable ,Cloneable{
	
	private static final long serialVersionUID = -8973365766702827873L;
	private Date timestamp;
	
	public CacheItem() {
		timestamp = new Date();
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public abstract CacheItem clone();
}
