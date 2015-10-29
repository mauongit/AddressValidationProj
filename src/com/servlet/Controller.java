package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cache.CacheTestManager;
import com.dao.DataDao;
import com.google.gson.Gson;
import com.vo.AddressVO;

public class Controller extends HttpServlet {
        private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {

                response.setContentType("application/json");
                try {
                        String term = request.getParameter("term");
                        System.out.println("Data from ajax call " + term);

                        DataDao dataDao = new DataDao();
                        List <String> addressVOList = dataDao.getFrameWork(term);

                        String searchList = new Gson().toJson(addressVOList);
                        
                        CacheTestManager cacheManagerTestProgram1 = new  CacheTestManager();
                        System.out.println("begin caching");
                        cacheManagerTestProgram1.getCacheObject(term,searchList);
                        System.out.println("end caching");
                        response.getWriter().write(searchList);
                } catch (Exception e) {
                        System.err.println(e.getMessage());
                }
        }
}
