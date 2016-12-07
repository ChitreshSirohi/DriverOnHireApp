package com.cs.myapps.DriverOnHireApp.dao;


import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.ViewQuery;

import javax.naming.InitialContext;

import com.cs.myapps.DriverOnHireApp.beans.Driver;

public class DriverDao {

	//@Resource(name = "couchdb/cloudant-DriverSample")
	protected CouchDbInstance _db = null;

	private CouchDbConnector createConnection()
	{
		String dbname = "my_database";
		try {
			//creates a database with the specified name
			_db = (CouchDbInstance) new InitialContext().lookup("java:comp/env/couchdb/cloudant-DriverSample");
			
			System.out.println("CH** About to create DB");
			CouchDbConnector dbc = _db.createConnector(dbname, true);
			
			return dbc;
		}
		catch (Exception e) {e.printStackTrace();
		return null;
		}
		//create a simple doc to place into your new database

	}

	public void save(Driver driver)
	{
		CouchDbConnector dbc = createConnection();
		System.out.println("CH** dbcreated");
		//String id = driver.getId();
		//System.out.println("ID:"+id);
		//driver.set_id(driver.getEmail());
		dbc.create(driver);
		//Driver dr = dbc.get(Driver.class, id);

		//System.out.println("Id:"+dr.get_id()+" City:"+dr.getCity());

	}


	public Driver getDriver(String id)
	{
		System.out.println("Id:"+id);
		CouchDbConnector dbc = createConnection();
		return dbc.get(Driver.class, id);
	}
	
	public List<Driver> getAllDrivers()
	{
		CouchDbConnector dbc = createConnection();
		List<String> list = dbc.getAllDocIds();
		LinkedList<Driver> driverList = new LinkedList<Driver>();
		for (String driverId : list)
		{
			System.out.println("CH** driverId:"+driverId);
			if(driverId.contains("@"))
				driverList.add(dbc.get(Driver.class, driverId));
		}
		return driverList;
	}
	
	public List<Driver> getAllAvailableDrivers()
	{
		CouchDbConnector dbc = createConnection();
		ViewQuery query = new ViewQuery().designDocId("_design/isAvailable").viewName("isAvailable").includeDocs(true);
		return dbc.queryView(query,Driver.class);

	}


}
