package com.cache;

public interface Cacheable {
	
	public boolean isExpired();
	public Object getIdentifier();

}
