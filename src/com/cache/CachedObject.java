package com.cache;

import java.util.Calendar;
import java.util.Date;

public class CachedObject implements Cacheable {
	private Date dateOfExpiration=null;
	private Object identifier=null;
	public Object object=null;
	
	public CachedObject(Object obj,Object id, int minutesToLive){
		this.object=obj;
		this.identifier=id;
		if(minutesToLive!=0){
			dateOfExpiration=new Date();
			Calendar cal=Calendar.getInstance();
			cal.setTime(dateOfExpiration);
			cal.add(cal.MINUTE, minutesToLive);
			dateOfExpiration=cal.getTime();
		}
	}
	@Override
	public boolean isExpired() {
		if(dateOfExpiration!=null){
			if(dateOfExpiration.before(new Date())){
				System.out.println("Expired from Cache: expire Time"+dateOfExpiration.toString());
				return true;
			}else{
				System.out.println("Expired not from Cache!");
				return false;	
			}
		}else{
			return false;
		}
		
	}

	@Override
	public Object getIdentifier() {
		return identifier;
	}

}
