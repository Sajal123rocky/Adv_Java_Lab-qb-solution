import java.sql.*;
public class pr1{
	public static void main(String[] args) {
		try {
			
			    String f2,f3,f4;
			    int f1,f5;
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");
	            Statement stmt=con.createStatement();
	            ResultSet rs=stmt.executeQuery("select * from emp");
	            System.out.println("Details of all employees are:");
	           while(rs.next())
	            {
	            	f1=rs.getInt(1);
	            	f2=rs.getString(2);
	            	f3=rs.getString(3);
	            	f4=rs.getString(4);
	            	f5=rs.getInt(5);
	            	System.out.println(f1+" "+f2+" "+" "+f3+" "+f4+" "+f5);
	            }
	            rs=stmt.executeQuery("select * from emp");
	            System.out.println("Details of employee who works in web dev");
	            while(rs.next())
	            {
	            	f1=rs.getInt(1);
	            	f2=rs.getString(2);
	            	f3=rs.getString(3);
	            	//f4=rs.getString(4);
	            	f5=rs.getInt(5);
	            	f4=rs.getString("project");
	            	if(f4.equals("web dev"))
	            	System.out.println(f1+" "+f2+" "+f3+" "+f4+" "+f5);
	            }
	            rs=stmt.executeQuery("select * from emp");
	            System.out.println("Details of employee who works in web dev and have salary>75000");
	            while(rs.next())
	            {
	            	f1=rs.getInt(1);
	            	f2=rs.getString(2);
	            	f3=rs.getString(3);
	            	f4=rs.getString(4);
	            	f5=rs.getInt(5);
	            	if(f5>75000&&f4.equals("web dev"))
	            	System.out.println(f1);
	            }
	            rs=stmt.executeQuery("select * from emp");
	            int c=0;
	            while(rs.next())
	            {
	            	f1=rs.getInt(1);
	            	f2=rs.getString(2);
	            	f3=rs.getString(3);
	            	f4=rs.getString(4);
	            	f5=rs.getInt(5);
	            	if(f5<50000)
	            	c++;
	            }
	            System.out.println("No. of employess whose salary <50000 is="+c);
	            
	          
	            
	            con.close();
		}
		catch(Exception e)
		{
			System.out.println("Error "+e);
		}
	}
}
