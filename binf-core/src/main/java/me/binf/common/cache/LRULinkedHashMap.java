package me.binf.common.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = -1829839503370130308L;
	private final int maxCapacity;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;

	public LRULinkedHashMap(int maxCapacity) {
		super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
		this.maxCapacity = maxCapacity;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > maxCapacity;
	}

	@Override
	public V get(Object key) {
		return super.get(key);
	}

	@Override
	public V put(K key, V value) {
		return super.put(key, value);
	}

	@Override
	public V remove(Object key) {
		return super.remove(key);
	}

	@Override
	public void clear() {
		super.clear();
	}

	public static void main(String[] args) throws Exception {
		Map<Integer, String> map = new LRULinkedHashMap<Integer, String>(2);
		map.put(1, "1");
		map.put(2, "2");

		map.get(1);
		map.put(3, "3");

		for (Map.Entry<Integer, String> e : map.entrySet()) {
			System.out.println(e.getKey());
		}
	}
}
