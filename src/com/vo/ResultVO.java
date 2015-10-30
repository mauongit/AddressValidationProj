package com.vo;

import java.util.List;
import java.util.Map;

public class ResultVO {
	private Map<String, List<AddressVO>> stateAddressMap;
	private String status;
	
	public Map<String, List<AddressVO>> getStateAddressMap() {
		return stateAddressMap;
	}
	public void setStateAddressMap(Map<String, List<AddressVO>> stateAddressMap) {
		this.stateAddressMap = stateAddressMap;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
