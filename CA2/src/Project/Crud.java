package Project;
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
				catch(Exception exception) 
					{
						ErrorMessage err = new ErrorMessage("Error connecting to the Database");
						//sqlException.printStackTrace () ;
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
										
										return true;
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
								//connection. close () ;
							}
						catch (Exception exception)
							{
								exception . printStackTrace () ;
							}
					}
				return false;
			}
			
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
									result +=resultSet.getObject(i)+",";
								
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
								//connection. close () ;
							}
						catch (Exception ex)
							{
								//exception . printStackTrace () ;
								ErrorMessage err = new ErrorMessage("The database is unavailable "+ ex);
							}
					}
				return result;
			}
			
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



