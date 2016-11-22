package com.cs.myapps.DriverOnHireApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Servlet implementation class DriverServlet
 */
public class DriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Resource(name = "couchdb/cloudant-DriverSample")
    protected CouchDbInstance _db;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String dbname = "my_database";
    	try {
    		//creates a database with the specified name
    		CouchDbConnector dbc = _db.createConnector(dbname, true);
    		response.getWriter().println("Created database: " + dbname);
    		//create a simple doc to place into your new database
    		Map<String, Object> doc = new HashMap<String, Object>();
    		String id = UUID.randomUUID().toString();
    		doc.put("_id", id);
    		doc.put("season", "winter3");
    		doc.put("climate", "humid4");
    		dbc.create(doc);
    		Map oldMap = dbc.get(Map.class, id);
    		
    		response.getWriter().println("CH** val:Season:"+oldMap.get("season"));
    		response.getWriter().println("CH** val:climate:"+oldMap.get("climate"));
    		response.getWriter().println("Added a simple doc!");
    	} catch (Exception e) {
    		response.getWriter().println(e.getMessage());
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
