

package me.binf.common.cache.item;


import java.util.ArrayList;


/**
 * 
 */
public class CommonCacheItem<T> extends CacheItem {
	
	private static final long serialVersionUID = 1565334268995487318L;
	private T value;
	private boolean isPut;
	
	public CommonCacheItem() {
	}
	
	public CommonCacheItem(T value) {
		this.value=value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public boolean isPut() {
		return isPut;
	}

	public void setPut(boolean isPut) {
		this.isPut = isPut;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CommonCacheItem<T> clone(){
		CommonCacheItem<T> item=new CommonCacheItem<T>();
		item.setPut(isPut());
		T value=getValue();
		if(value instanceof ArrayList){
			ArrayList list=((ArrayList)value);
			item.setValue((T)list.clone());
		}else if(value instanceof CacheItemCloneAble){
			item.setValue((T)((CacheItemCloneAble) value).clone());
		}else{
			item.setValue(value);
		}
		item.setTimestamp(this.getTimestamp());
		return item;
	}
}
