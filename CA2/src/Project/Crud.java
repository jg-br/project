package Project;
/* Student Name: John Brennan
 * Student ID:c00114371
 * Date: */
import java.sql.Array;   
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java . sql .Connection;
import java.sql.DatabaseMetaData;
import java . sql .DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java . sql .PreparedStatement;
import java . sql .SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java . sql .ResultSet ;
import java . sql .ResultSetMetaData;

public class Crud  implements Connection
{

	// New object for user and password
			Config t = new Config();
			// database URL
			final String DATABASE_URL = "jdbc:mysql://localhost:64000/CA3";
			Connection connection = null ;
			PreparedStatement pstat = null ;
			public Crud()
			{				
						
				try
					{
						connection = DriverManager.getConnection(DATABASE_URL, t.getUsername(), t.getPassword()); 
						
					}
				catch(SQLException ex) 
					{
						ErrorMessage err = new ErrorMessage("Error connecting to the Database"+ex);
						
					}
			}
			
			public void insertCustomer(String name, String address, String phone, String email, String password) 
			{
				try 
				{
					
					pstat = connection.prepareStatement("INSERT INTO Customer (CustomerName, CustomerAddress, CustomerPhone, CustomerEmail, CustomerPassword) VALUES (?,?,?,?,?)");
					pstat.setString (1, name ) ;
					pstat.setString (2, address);
					pstat.setString (3, phone);
					pstat.setString (4, email);
					pstat.setString (5, password);					
					// insert data into table
					
					int status = pstat.executeUpdate();
					String message = (status + " New account successfully created.");
					
					Info mess = new Info(message);
				}
				
			catch(SQLException sqlException) 
				{
					sqlException.printStackTrace () ;
				}
			finally 
				{
					try 
						{
							pstat.close () ;
							connection.close () ;
						}
					catch (Exception exception)
						{
							//exception.printStackTrace () ;
							ErrorMessage err = new ErrorMessage("Error creating Account");
						}
				}
				
			}
			public void displayCustomers()
			{
				ResultSet resultSet = null ;
				
				
				try
					{
						//connection = DriverManager.getConnection(DATABASE_URL, t.getUsername(), t.getPassword());
						pstat = connection.prepareStatement("SELECT CustomerName, CustomerAddress, CustomerPhone, CustomerEmail, CustomerPassword FROM Customer");
						// query data in the table
						resultSet = pstat.executeQuery();
						// process query results
						ResultSetMetaData metaData = resultSet.getMetaData();
						int numberOfColumns = metaData.getColumnCount();
						System.out. println ( "Authors Table of Books Database:\n" );
						for ( int i = 1; i <= numberOfColumns; i++ )
						System.out. print (metaData.getColumnName( i ) + "\t");
						System.out. println () ;
						while( resultSet .next() )
							{
								for ( int i = 1; i <= numberOfColumns; i++ )
								System.out. print ( resultSet .getObject( i ) + "\t\t");
								System.out. println () ;
							}
					
					}
				catch(SQLException sqlException ) 
					{
						sqlException . printStackTrace () ;
					}
				finally 
					{
						try
							{
								resultSet . close () ;
								pstat . close () ;
								connection. close () ;
							}
						catch (Exception exception)
							{
								exception . printStackTrace () ;
							}
					}
			}
			//	method to ensure that the email entered when creating an account does NOT already exist in the customer table.
			public boolean emailCheck(String email )
			{
				ResultSet resultSet = null ;
				
				
				try
					{
						//connection = DriverManager.getConnection(DATABASE_URL, t.getUsername(), t.getPassword());
						pstat = connection.prepareStatement("select * from Customer where customerEmail = ?");
						pstat.setString(1, email);
						// query data in the table
						resultSet = pstat.executeQuery();
						// process query results
						ResultSetMetaData metaData = resultSet.getMetaData();
						int numberOfColumns = metaData.getColumnCount();
						while( resultSet .next() )
							{
								
								if( resultSet .getObject(numberOfColumns).equals(email));
									{
										return true;
									}
							
							}
						return false;
					
					}
				catch(SQLException sqlException ) 
					{
						sqlException . printStackTrace () ;
					}
				finally 
					{
						try
							{
								resultSet . close () ;
								pstat . close () ;
								//connection. close () ;
							}
						catch (Exception exception)
							{
								exception . printStackTrace () ;
							}
					}
				return false;
			}
			//	verifying the customer credentials when logging in.
			public boolean loginVerify(String email , String password)
			{
				ResultSet resultSet = null ;
				
				
				try
					{
						// The prepared SQL statement to confirm that account details exist for the user attempting to login.
						pstat = connection.prepareStatement("select CustomerEmail, CustomerPassword from Customer where CustomerEmail = ? AND CustomerPassword = ?");
						pstat.setString(1, email);
						pstat.setString(2, password);
						// query data in the table
						resultSet = pstat.executeQuery();
						// process query results
						ResultSetMetaData metaData = resultSet.getMetaData();
						int numberOfColumns = metaData.getColumnCount();
						while( resultSet .next() )
							{
								if((resultSet .getObject(1).equals(email))&&(resultSet .getObject(numberOfColumns).equals(password)));
									{ 
										
										return true;	// returns true only if both username and password equal those entered on the login screen.
									}
								
							}
						
					
					}
				catch(SQLException sqlException ) 
					{
						//sqlException . printStackTrace () ;
						ErrorMessage err = new ErrorMessage("Account details not found");
					}
				finally 
					{
						try
							{
								resultSet . close () ;
								pstat . close () ;
								connection. close () ;
							}
						catch (Exception exception)
							{
								exception . printStackTrace () ;
							}
					}
				return false;
			}
			//	method to display customer details on the customer page when they log in.
			public String customerDetails(String email)
			{
				String result="";
				ResultSet resultSet = null ;
				
				
				try
					{
						// The prepared SQL statement to confirm that account details exist for the user attempting to login.
						pstat = connection.prepareStatement("select CustomerId, CustomerName, CustomerAddress, CustomerPhone from Customer where CustomerEmail = ?");
						pstat.setString(1, email);
						// query data in the table
						resultSet = pstat.executeQuery();
						// process query results
						ResultSetMetaData metaData = resultSet.getMetaData();
						int numberOfColumns = metaData.getColumnCount();
						
						
						while( resultSet .next() )
							{
								for ( int i = 1; i <= numberOfColumns; i++ )
									result +=resultSet.getObject(i)+",";	//	Concatenates  each column in the resultSet to the result string and returns it to the calling method in the customer page.
								
							}
						
						
					}
				catch(SQLException error) 
					{
						//sqlException . printStackTrace () ;
						ErrorMessage err = new ErrorMessage("Error retrieving Customer Details from the Database"+ error);
					}
				finally 
					{
						try
							{
								resultSet . close () ;
								pstat . close () ;
								connection. close () ;
							}
						catch (Exception ex)
							{
								//exception . printStackTrace () ;
								ErrorMessage err = new ErrorMessage("The database is unavailable "+ ex);
							}
					}
				return result;
			}
			//	Customer version of the Customer update method.
			public void customerUpdateDetails(String name, String address, String phone, String id ) 
			{
				try 
				{
					
					pstat = connection.prepareStatement("UPDATE Customer SET CustomerName=?, CustomerAddress=?, CustomerPhone=? WHERE CustomerId=?");
					pstat.setString (1, name ) ;
					pstat.setString (2, address);
					pstat.setString (3, phone);
					pstat.setString (4, id);
									
					// insert data into table
					
					int status = pstat.executeUpdate();
					String message = (status + " Details successfully updated");
					
					Info mess = new Info(message);
				}
				
			catch(SQLException sqlException) 
				{
					sqlException.printStackTrace () ;
				}
			finally 
				{
					try 
						{
							pstat.close () ;
							connection.close () ;
						}
					catch (Exception exception)
						{
							//exception.printStackTrace () ;
							ErrorMessage err = new ErrorMessage("Error creating Account");
						}
				}
				
			}
			
			
// Administrator methods
			
			public boolean adminLogin(String email , String password)
			{
				ResultSet resultSet = null ;
				
				
				try
					{
						// The prepared SQL statement to confirm that account details exist for the user attempting to login.
						pstat = connection.prepareStatement("select AdminEmail, AdminPassword from Admin where AdminEmail = ? AND AdminPassword = ?");
						pstat.setString(1, email);
						pstat.setString(2, password);
						// query data in the table
						resultSet = pstat.executeQuery();
						// process query results
						ResultSetMetaData metaData = resultSet.getMetaData();
						int numberOfColumns = metaData.getColumnCount();
						while( resultSet .next() )
							{
								if((resultSet .getObject(1).equals(email))&&(resultSet .getObject(numberOfColumns).equals(password)));
									{ 
										
										return true;
									}
								
							}
						
					
					}
				catch(SQLException sqlException ) 
					{
						//	Error dialogue when an SQL error is caught
						ErrorMessage err = new ErrorMessage("Error Querying the Database"+ sqlException);
					}
				finally 
					{
						try
							{
								resultSet . close () ;
								pstat . close () ;	//	the connection is left open to check the credentials against the customer table next. (it is closed if returns true when generating the admin window
								//	if not it is closed when generating the customer window or when displaying the message that the account details are incorrect.
								//connection. close () ;
							}
						catch (Exception exception)
							{	
								//	Error dialogue to display catch any non_SQL Errors
								ErrorMessage err = new ErrorMessage("Error logging in");
							}
					}
				return false;
			}
			
			//	Administrator version of the customer update method.
			public void adminCustomerUpdateDetails(String name, String address, String phone,String email, String id ) 
			{
				try 
				{
					
					pstat = connection.prepareStatement("UPDATE Customer SET CustomerName=?, CustomerAddress=?, CustomerPhone=?, CustomerEmail=?  WHERE CustomerId=?");
					pstat.setString (1, name ) ;
					pstat.setString (2, address);
					pstat.setString (3, phone);
					pstat.setString(4, email);
					pstat.setString (5, id);
									
					// insert data into table
					
					int status = pstat.executeUpdate();
					String message = (status + " Details successfully updated");
					
					Info mess = new Info(message);
				}
				
			catch(SQLException sqlException) 
				{
					sqlException.printStackTrace () ;
				}
			finally 
				{
					try 
						{
							pstat.close () ;
							connection.close () ;
						}
					catch (Exception exception)
						{
							//	Error dialogue to display catch any non_SQL Errors
							ErrorMessage err = new ErrorMessage("Error Updating Account details");
						}
				}
				
			}
			
			public void adminProductUpdateDetails(String supplier, String model, String desc,String qty,String cost, String retail, String id ) 
			{
				try 
				{
					
					pstat = connection.prepareStatement( "UPDATE Product SET SupplierId=?, ModelNo=?, Description=?, QuantityInStock=?, ProductCost=?, ProductRetail=? where ProductID = ?");
					pstat.setString (1, supplier ) ;
					pstat.setString (2, model);
					pstat.setString (3, desc);
					pstat.setString(4, qty);
					pstat.setString(5, cost);
					pstat.setString(6, retail);
					pstat.setString (7, id);
									
					// insert data into table
					
					int status = pstat.executeUpdate();
					String message = (status + " Details successfully updated");
					
					Info mess = new Info(message);
				}
				
			catch(SQLException sqlException) 
				{
					sqlException.printStackTrace () ;
				}
			finally 
				{
					try 
						{
							pstat.close () ;
							connection.close () ;
						}
					catch (Exception exception)
						{
							//	Error dialogue to display catch any non_SQL Errors.
							ErrorMessage err = new ErrorMessage("Error creating Account");
						}
				}
				
			}
			
			public void adminSuppliertUpdateDetails(String name, String address, String phone,String email, String id ) 
			{
				try 
				{
					
					pstat = connection.prepareStatement( "UPDATE Supplier SET SupplierName=?, SupplierAddress=?, SupplierPhoneNo=?, SupplierEmail=? where SupplierID = ?");
					pstat.setString (1, name ) ;
					pstat.setString (2, address);
					pstat.setString (3, phone);
					pstat.setString(4, email);					
					pstat.setString (5, id);
									
					// insert data into table
					
					int status = pstat.executeUpdate();
					String message = (status + " Details successfully updated");
					
					Info mess = new Info(message);
				}
				
			catch(SQLException sqlException) 
				{
					sqlException.printStackTrace () ;
				}
			finally 
				{
					try 
						{
							pstat.close () ;
							connection.close () ;
						}
					catch (Exception exception)
						{
							//	Error dialogue to display catch any non_SQL Errors.
							ErrorMessage err = new ErrorMessage("Error creating Account");
						}
				}
				
			}
			//	delete a customer/product/supplier
			public void adminDelete(String query, String id)
			{
				try 
				{
					
					pstat = connection.prepareStatement(query);				
					pstat.setString (1, id);
									
					// Delete Customer from Customer table
					
					int status = pstat.executeUpdate();
					String message = (status + " Account Successfully Deleted");
					
					Info mess = new Info(message);
				}
				
			catch(SQLException sqlException) 
				{
					ErrorMessage err = new ErrorMessage("Error Deleting Account "+sqlException);
					
				}
			finally 
				{
					try 
						{
							pstat.close () ;
							connection.close () ;
						}
					catch (Exception exception)
						{
//							Error dialogue to display catch any non_SQL Errors.
							ErrorMessage err = new ErrorMessage("Error Deleting Account "+ exception);
						}
				}
			}
			
		
			
			//	Method to check if the supplier ID entered exists in the supplier table
			public boolean supplierCheck(String supplierId)
			{
				ResultSet resultSet = null ;
				
				
				try
					{
						// The prepared SQL statement to confirm that account details exist for the user attempting to login.
						pstat = connection.prepareStatement("select SupplierID from Supplier where SupplierID= ?");
						pstat.setString(1, supplierId);
						// query data in the table
						resultSet = pstat.executeQuery();
						while( resultSet .next() )
							{
								if(supplierId.equals(resultSet.getString(1))) //	returns true only if the supplier ID entered in the add product window exists in the supplier table.
								{
									return true;
								}
								
							}
						
						
					}
				catch(SQLException error) 
					{
						//	Displays an error dialogue with the SQL exception error.
						ErrorMessage err = new ErrorMessage("Error retrieving Customer Details from the Database"+ error);
					}
				finally 
					{
						try
							{
								resultSet . close () ;
								pstat . close () ;
								connection. close () ;	//	Closes the resultSet, pstat,and connection objectsS
							}
						catch (Exception ex)
							{
								//	Error dialogue to display catch any non_SQL Errors.
								ErrorMessage err = new ErrorMessage("The database is unavailable "+ ex);
							}
					}
				return false;
			}
			
			//	insert product method
			public void insertProduct(String sId, String model, String desc, String qty, String cost,String retail) 
			{
				try 
				{
					
					pstat = connection.prepareStatement("INSERT INTO Product (SupplierID, ModelNo, Description,QuantityInStock, ProductCost, ProductRetail) VALUES (?,?,?,?,?,?)");
					pstat.setString (1, sId ) ;
					pstat.setString (2, model);
					pstat.setString (3, desc);
					pstat.setString (4, qty);
					pstat.setString (5, cost);	
					pstat.setString(6, retail);
					// insert data into table
					
					int status = pstat.executeUpdate();	//	Executing the query
					String message = (status + " New Product record successfully created.");
					
					Info mess = new Info(message);	//	Displays a message upon successful insertion of a product reecord into the database 
				}
				
			catch(SQLException sqlEx) 
				{
				ErrorMessage err = new ErrorMessage("Database error" + sqlEx);	//	displays an error dialogue with the SQL error
				}
			finally 
				{
					try 
						{	//	Closes the prepared statement and the connection object.
							pstat.close () ;
							connection.close () ;
						}
					catch (Exception ex)
						{
							//exception.printStackTrace () ;
							ErrorMessage err = new ErrorMessage("Error creating Product record" + ex);	//	Displays an error dialogue for non-SQL errors.
						}
				}
				
			}
			
			
			
			//	insert supplier method.
			public void insertSupplier(String name, String address, String phone, String email) 
			{
				try 
				{
					//	Insert statement for supplier 
					pstat = connection.prepareStatement("INSERT INTO Supplier (SupplierName, SupplierAddress, SupplierPhoneNo,SupplierEmail) VALUES (?,?,?,?)");
					pstat.setString (1, name ) ;
					pstat.setString (2, address);
					pstat.setString (3, phone);
					pstat.setString (4, email);
					
					// insert data into table
					
					int status = pstat.executeUpdate();
					String message = (status + " New Supplier record successfully created.");
					
					Info mess = new Info(message);
				}
				
			catch(SQLException sqlEx) 
				{
					ErrorMessage err = new ErrorMessage("Database error" + sqlEx);	//	displays an error dialogue box with the SQL error message
				}
			finally 
				{
					try 
						{
							pstat.close () ;
							connection.close () ;
						}
					catch (Exception ex)
						{
							//exception.printStackTrace () ;
							ErrorMessage err = new ErrorMessage("Error creating Product record" + ex);	//	Displays an error dialogue with any non-SQL errors 
						}
				}
				
			}
			
			//	Basket operations
			public void insertBasket(String prodID, String qty) 
			{
				try 
				{
					//	Insert statement for supplier 
					pstat = connection.prepareStatement("INSERT INTO Basket (ProductID,Quantity) VALUES (?,?)");
					pstat.setString (1, prodID ) ;
					pstat.setString (2, qty);
					
					// insert data into table
					
					int status = pstat.executeUpdate();
					String message = (status + " New item(s) added to basket");
					
					Info mess = new Info(message);
				}
				
			catch(SQLException sqlEx) 
				{
					ErrorMessage err = new ErrorMessage("Database error" + sqlEx);	//	displays an error dialogue box with the SQL error message
				}
			finally 
				{
					try 
						{
							pstat.close () ;
							connection.close () ;
						}
					catch (Exception ex)
						{
							//exception.printStackTrace () ;
							ErrorMessage err = new ErrorMessage("Error adding item to basket" + ex);	//	Displays an error dialogue with any non-SQL errors 
						}
				}
			}
			
			@Override
			public <T> T unwrap(Class<T> iface) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public boolean isWrapperFor(Class<?> iface) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}
			@Override
			public Statement createStatement() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public PreparedStatement prepareStatement(String sql) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public CallableStatement prepareCall(String sql) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public String nativeSQL(String sql) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public void setAutoCommit(boolean autoCommit) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public boolean getAutoCommit() throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}
			@Override
			public void commit() throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void rollback() throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void close() throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public boolean isClosed() throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}
			@Override
			public DatabaseMetaData getMetaData() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public void setReadOnly(boolean readOnly) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public boolean isReadOnly() throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}
			@Override
			public void setCatalog(String catalog) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public String getCatalog() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public void setTransactionIsolation(int level) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public int getTransactionIsolation() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}
			@Override
			public SQLWarning getWarnings() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public void clearWarnings() throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
					throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
					throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public Map<String, Class<?>> getTypeMap() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void setHoldability(int holdability) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public int getHoldability() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}
			@Override
			public Savepoint setSavepoint() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public Savepoint setSavepoint(String name) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public void rollback(Savepoint savepoint) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void releaseSavepoint(Savepoint savepoint) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
					throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
					int resultSetHoldability) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
					int resultSetHoldability) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public Clob createClob() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public Blob createBlob() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public NClob createNClob() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public SQLXML createSQLXML() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public boolean isValid(int timeout) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}
			@Override
			public void setClientInfo(String name, String value) throws SQLClientInfoException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void setClientInfo(Properties properties) throws SQLClientInfoException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public String getClientInfo(String name) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public Properties getClientInfo() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public void setSchema(String schema) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public String getSchema() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public void abort(Executor executor) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public int getNetworkTimeout() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}	
		
}



