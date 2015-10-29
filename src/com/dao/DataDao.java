package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vo.AddressVO;

public class DataDao {
        private Connection connection;

        public DataDao() throws Exception {
                 connection = DBUtility.getConnection();
        }

        public List <String> getFrameWork(String frameWork) {
        ArrayList<String> list = new ArrayList<String>();
        PreparedStatement ps = null;
        String data;
        
		Map<String, List<AddressVO>> resultMap= new HashMap<String, List<AddressVO>>();
		List <AddressVO> addressVOList = new ArrayList<AddressVO>();
        try {
        ps = connection.prepareStatement("SELECT * FROM address  WHERE address1  LIKE ?");
                ps.setString(1, "%"+frameWork + "%");
                System.out.println(frameWork);
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                	AddressVO  addressVO = new AddressVO();
                    
                	addressVO.setId(rs.getString("id"));
    				addressVO.setAddress1(rs.getString("address1"));/*
    				addressVO.setAddress2(rs.getString("address2"));
    				addressVO.setAddress3(rs.getString("address3"));*/
    				addressVO.setState(rs.getString("state"));
    				addressVO.setCity(rs.getString("city"));
    				addressVO.setPostalcode(rs.getString("postal_code"));
    				addressVO.setCountry(rs.getString("country"));
    				addressVOList.add(addressVO);
    				list.add(rs.getString("address1"));
    				//resultMap.put(rs.getString("id"), addressVOSet);
                }
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
        return list;
}
}
