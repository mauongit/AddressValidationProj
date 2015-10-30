package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vo.AddressVO;
import com.vo.ResultVO;

public class DataDao {
	private Connection connection;

	public DataDao() throws Exception {
		connection = DBUtility.getConnection();
	}

	public ResultVO getFrameWork(String frameWork) {
		PreparedStatement ps = null;
		String data;

		Map<String, List<AddressVO>> resultMap = new HashMap<String, List<AddressVO>>();
		List<AddressVO> addressVOList = null;
		Map<String, List<AddressVO>> currentStateAddressMap = new HashMap<>();
		ResultVO rVo = new ResultVO();
		try {
			ps = connection
					.prepareStatement("SELECT * FROM address  WHERE address1  LIKE ?");
			ps.setString(1, "%" + frameWork + "%");
			System.out.println(frameWork);
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				AddressVO addressVO = new AddressVO();
				if(currentStateAddressMap.get(rs.getString("country")) != null){
					addressVOList = currentStateAddressMap.get(rs.getString("country"));
				}else{
					addressVOList = new ArrayList<AddressVO>();
				}
				addressVO.setId(rs.getString("id"));
				addressVO.setAddress1(rs.getString("address1"));
				addressVO.setState(rs.getString("state"));
				addressVO.setCity(rs.getString("city"));
				addressVO.setPostalcode(rs.getString("postal_code"));
				addressVO.setCountry(rs.getString("country"));
				addressVOList.add(addressVO);
				currentStateAddressMap.put(rs.getString("country"),addressVOList);
				// resultMap.put(rs.getString("id"), addressVOSet);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		rVo.setStateAddressMap(currentStateAddressMap);
		return rVo;
	}
}
