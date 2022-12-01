import java.util.*;
import java.sql.*;
public class pr2{
	public static void main(String[] args) {
		try {
			String f2,f4;
		    int f1,f3,f5;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Department", "root", "");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from dept");
           /* while(rs.next())
            {
            	f1=rs.getInt(1);
            	f2=rs.getString(2);
            	f3=rs.getInt(3);
            	f4=rs.getString(4);
            	f5=rs.getInt(5);
            	System.out.println(f1+" "+f2+" "+f3+" "+f4+" "+f5);
            }*/
            Scanner inp=new Scanner(System.in);
            //int a=inp.nextInt();
            //PreparedStatement pstmt=con.prepareStatement("select * from dept where year=?");
           
            /*pstmt.setInt(1,a);
            ResultSet rsp=pstmt.executeQuery();
            int c=0;
            while(rsp.next())
            {
            	//f3=rsp.getInt(3);
            	System.out.println(rsp.getInt("year"));
            	c=c+1;
            }
            
            
            if(c==0)
            	System.out.println("no data");*/
           /** int did=inp.nextInt();
            inp.nextLine();
            String dname=inp.nextLine();
            PreparedStatement pstmt2=con.prepareStatement("select * from dept where id=? and name=?");
            pstmt2.setInt(1,did);
            pstmt2.setString(2, dname);
            ResultSet rsp=pstmt2.executeQuery();
            int c=0;
            while(rsp.next()) {
            	f1=rsp.getInt(1);
            	f2=rsp.getString(2);
            	System.out.println(f1+" "+f2);
            	c++;
            }
            if(c==0)
            	System.out.println("no such data");*/
            int id=inp.nextInt();
            inp.nextLine();
            String name=inp.nextLine();
            int year=inp.nextInt();
            inp.nextLine();
            String head=inp.nextLine();
            int num=inp.nextInt();
            PreparedStatement pstmt3=con.prepareStatement("insert into dept values(?,?,?,?,?)");
            pstmt3.setInt(1, id);
            pstmt3.setString(2, name);
            pstmt3.setInt(3, year);
            pstmt3.setString(4, head);
            pstmt3.setInt(5, num);
            int i=pstmt3.executeUpdate();
            System.out.println(i+"records inserted");
            pstmt3=con.prepareStatement("select * from dept");
            ResultSet rsp=pstmt3.executeQuery();
            while(rsp.next())
            {
            	f1=rsp.getInt(1);
            	f2=rsp.getString(2);
            	f3=rsp.getInt(3);
            	f4=rsp.getString(4);
            	f5=rsp.getInt(5);
            	System.out.println(f1+" "+f2+" "+f3+" "+f4+" "+f5);
            }
            
            
		}
		catch(Exception e)
		{
			System.out.println("error "+e);
		}
	}
}
