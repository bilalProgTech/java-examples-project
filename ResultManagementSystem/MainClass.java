package miniproject;
import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@SuppressWarnings("serial")
class BilalException extends Exception
{
	BilalException(String msg)
	{
		super(msg);
	}
}
class d
{
	static void s(String msg)
	{
		System.out.println(msg);
	}
}
class Student
{
	int enrl,sem,year,n,sum;
	int m[]=new int[5];
	int per;
	String rn,name,dept,div,years,sems,status;
	String TSem[]={"AMS","DSU","RDM","ETE","DTE"};
	String FSem[]={"EST","CHM","CNE","MAP","OOP"};
	String fSem[]={"OSY","SEN","CSE","JPR"};
	String SSem[]={"MAN","AJP","STE","AMP"};
	DataInputStream in = new DataInputStream(System.in);
	/*Insert Data*/
	public static void insertData(String r,String n,String d,int e,String di,String y,String s,int t,int p) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MiniProject"
				, "", "");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("insert into student values(\'"+r+"\',\'"+n+"\',\'"+d+"\',\'"+e+"\',\'"+di+"\',\'"+y+"\',\'"+s+"\',\'"+t+"\',\'"+p+"\')");
	}
	@SuppressWarnings("deprecation")
	void EnterMarks() throws Exception
	{
		try
		{
			d.s("Enter Roll No.: ");
			rn=(in.readLine());
			d.s("Enter Name of the Student: ");
			name=in.readLine();
			dept="Computer Engineering";
			d.s("Enter Enrollment No.: ");
			enrl=Integer.parseInt(in.readLine());
			d.s("Enter Student Class & Division: ");
			div=in.readLine();
			d.s("Which Year is Student From: ");
			d.s("1. 2nd Year \n2. 3rd Year");
			year=Integer.parseInt(in.readLine());
			if(year==1)
				years="2nd Year";
			else
				years="3rd Year";
			switch(year)
			{
				case 1:
					d.s("Which Semester: ");
					d.s("1. Third Sem\n2. Fourth Sem");
					sem=Integer.parseInt(in.readLine());
					if(sem==1)
						sems="3rd Semester";
					else
						sems="4th Semester";
					break;
				case 2:
					d.s("Which Semester");
					d.s("1. Fifth Sem\n2. Sixth Sem");
					sem=Integer.parseInt(in.readLine());
					if(sem==1)
						sems="5th Semester";
					else
						sems="6th Semester";
					break;
				default:
					throw new BilalException("Enter valid Year(between 2nd or 3rd)");
			}
			if(sems.equals("3rd Semester"))
			{
				for(int i=0;i<TSem.length;i++)
				{
					System.out.println("Enter Marks for " + TSem[i] + " : ");
					int temp=Integer.parseInt(in.readLine());
					m[i]=temp;
				}
			}
			else if(sems.equals("4th Semester"))
			{
				for(int i=0;i<FSem.length;i++)
				{
					System.out.println("Enter Marks " + FSem[i] + " : ");
					int temp=Integer.parseInt(in.readLine());
					m[i]=temp;
				}
			}
			else if(sems.equals("5th Semester"))
			{
				for(int i=0;i<fSem.length;i++)
				{
					System.out.println("Enter Marks " + fSem[i] + " : ");
					int temp=Integer.parseInt(in.readLine());
					m[i]=temp;
				}
			}
			else if(sems.equals("6th Semester"))
			{
				for(int i=0;i<SSem.length;i++)
				{
					System.out.println("Enter Marks " + SSem[i] + " : ");
					int temp=Integer.parseInt(in.readLine());
					m[i]=temp;
				}
			}
			for(int i=0;i<m.length;i++)
			{
				sum=sum+m[i];
			}
			per=(sum * 100)/125;
			//System.out.println(grade + status +per);
			insertData(rn,name,dept,enrl,div,years,sems,sum,per);
		}
		finally
		{
		}
	}
	public static void ShowAllTable() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MiniProject"
				, "", "");
		Statement stmt = con.createStatement();
		String query="select * from student";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next())
		{
			String rn =rs.getString(1);
			String name =rs.getString(2);
			String dept =rs.getString(3);
			int enrl=(rs.getInt(4));
			String div =rs.getString(5);
			String year =rs.getString(6);
			String sem=rs.getString(7);
			int total=(rs.getInt(8));
			int per=(rs.getInt(9));
			d.s("----------***PPT Marksheet of Student***-----------");
			System.out.print("\n\nDepartment: "+dept);
			System.out.print("\n\nRoll No:\t"+rn+"\t\tEnrollment No.:\t"+enrl);
			System.out.print("\nName:\t\t"+name+"\t\tYear:\t\t"+year);
			System.out.print("\nClass:\t\t"+div+"\t\t\tSemester:\t"+sem);
			d.s("\n--------------===============================---------------");
			System.out.print("\nTotal: "+total+"\n-------Percentage------:\n"+per+"\n\n");
		}
	}
	public static void ShowTable(int e) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MiniProject"
				, "root", "root");
		Statement stmt = con.createStatement();
		String query="select * from student where enrl =" +e;
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next())
		{
			int enrl=(rs.getInt(4));
			if(enrl==e)
			{
				String rn =rs.getString(1);
				String name =rs.getString(2);
				String dept =rs.getString(3);
				String div =rs.getString(5);
				String year =rs.getString(6);
				String sem=rs.getString(7);
				int total=(rs.getInt(8));
				int per=(rs.getInt(9));
				d.s("----------***PPT Marksheet of Student***-----------");
				System.out.print("\n\nDepartment: "+dept);
				System.out.print("\n\nRoll No:\t"+rn+"\t\tEnrollment No.:\t"+enrl);
				System.out.print("\nName:\t\t"+name+"\t\tYear:\t\t"+year);
				System.out.print("\nClass:\t\t"+div+"\t\t\tSemester:\t"+sem);
				d.s("\n--------------===============================---------------");
				System.out.print("\nTotal: "+total+"\n-------Percentage------:\n"+per+"\n\n");
			}
			else
			{
				d.s("Not Present");
			}
		}
	}
	void ShowContent() throws Exception
	{
		ShowAllTable();
	}
	void SearchContent(int e) throws Exception
	{
		ShowTable(e);
	}
}
public class MainClass 
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception 
	{
		int input,enrl;
		Student s = new Student();
		DataInputStream in = new DataInputStream(System.in);
		try
		{
			do
			{
				System.out.println("1.Enter Marks of a Student.");
				System.out.println("2.Show Student Marks.");
				System.out.println("3.Search Student.");
				System.out.println("4.Exit");
				System.out.println("What do you want to do: ");
				input=Integer.parseInt(in.readLine());
				switch (input) 
				{
					case 1:
						s.EnterMarks();
						break;
					case 2:
						s.ShowContent();
						break;
					case 3:
						d.s("Enter Enrollment No. to Search: ");
						enrl=Integer.parseInt(in.readLine());
						s.SearchContent(enrl);
						break;
					case 4:
						System.exit(1);
					default:
						throw new BilalException("Invalid Choice...");
				}
			}while(input!=4);
		}
		catch(BilalException b)
		{
			System.out.println(b);
		}
		finally
		{}
	}
}
