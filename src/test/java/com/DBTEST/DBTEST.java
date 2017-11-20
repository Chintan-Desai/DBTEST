package com.DBTEST;
import org.testng.annotations.Test;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTEST {
	
	@Test
	public void selectDBdata() throws ClassNotFoundException, SQLException{
		
		String query = "SELECT * FROM seleniumusers";
		String query1 = "SELECT name FROM seleniumusers where id=101";
		DataBase dataBase = new DataBase();
		ResultSet data = dataBase.getData(query);
		System.out.println(data);
		while(data.next()){
			System.out.println("ID: "+data.getString(1));
			System.out.println(" First Name: "+data.getString(2));
			System.out.println(" Last Name: "+data.getString(3));
			System.out.println(" Email: "+data.getString(4));
			System.out.println();
		}
	}
	
	@Test
	public void insertDBdata() throws ClassNotFoundException, SQLException{
		String query = "insert into seleniumusers values('105','bhnau12','pratap','testing123@gmail.com')";
		DataBase dataBase = new DataBase();
		dataBase.insertData(query);
		System.out.println("Data Insert into Table Successfully.");
	}
	@Test
	public void updateDBdata() throws ClassNotFoundException, SQLException{
		String query = "update seleniumusers set firstname='John' where emalil='testing123@gmail.com'";
		DataBase dataBase = new DataBase();
		dataBase.updateData(query);
		System.out.println("Database Updated Successfully.");
	}
	@Test
	public void IsStoredInDB()
	{
		String query = "select * from seleniumusers ORDER BY ID DESC";
		DataBase dataBase = new DataBase();
		try {
			ResultSet data = dataBase.getData(query);

			data.next();
			if (data.getString(2).equalsIgnoreCase("John"))
			{
				System.out.println("Record Updated in Table Successfully.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
