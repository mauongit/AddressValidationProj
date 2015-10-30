package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cache.CacheManager;
import com.cache.CacheTestManager;
import com.cache.CachedObject;
import com.dao.DataDao;
import com.google.gson.Gson;
import com.vo.AddressVO;
import com.vo.ResultVO;

public class Controller extends HttpServlet {
        private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {
        	CacheTestManager cacheManagerTestProgram1 = new  CacheTestManager();
                response.setContentType("application/json");
                try {
                        String term = request.getParameter("term");
                        System.out.println("doGet: Data from ajax call " + term);
                        CachedObject cObject = cacheManagerTestProgram1.isTermCached(term);
                        if(cObject == null){
                        	System.out.println("doGet: cache null : Querying and  begin caching");
                        	 DataDao dataDao = new DataDao();
                        	 ResultVO rVo = dataDao.getFrameWork(term);
                             String searchedJson = new Gson().toJson(rVo);
                             cacheManagerTestProgram1.getCacheObject(term,searchedJson);
                             System.out.println("doGet: end caching");
                             response.getWriter().write(searchedJson);
                        }else{
                        	/* Try to retrieve the object from the cache! */
                        	CachedObject o = (CachedObject) CacheManager.getCache(term);
                        	if(o != null){
                        		response.getWriter().write(((String) o.object).toString());
                        	}
                        	System.out.println("doGet: term is cached so getting item from the cache");
                        }
                } catch (Exception e) {
                        System.err.println(e.getMessage());
                }
        }
}
