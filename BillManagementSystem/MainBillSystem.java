package billing;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
class d
{
	static void s(String msg)
	{
		System.out.println(msg);
	}
}
class BillSystem
{
	DataInputStream in = new DataInputStream(System.in);
  	int tabno,order,quantity,foodn,i,j,input,rs,sum;
  	String food;
  	String fooda[]=new String[13];
  	int r[] = new int[13];
  	int quan[]=new int[13];
  	GregorianCalendar date = new GregorianCalendar();
  	int day=date.get(Calendar.DAY_OF_MONTH);
  	int month=date.get(Calendar.MONTH);
  	int year=date.get(Calendar.YEAR);
  	static int quan(int q,int r)
  	{
  		r=r*q;
  		return r;
  	}
	@SuppressWarnings("deprecation")
	void createBill() throws Exception, IOException
	{
		try
		{
			d.s("Enter Table no.");
			tabno=Integer.parseInt(in.readLine());
			d.s("Enter How many item they order: ");
			order=Integer.parseInt(in.readLine());
			d.s("\t\t\t\tMenu\t\t\tRs.");
			d.s("\t\t1.Papa - The Dhaba Special\t\t180");
			d.s("\t\t2.Chole Bhature\t\t\t\t90");
			d.s("\t\t3.Paneer Masala Special\t\t\t100");
			d.s("\t\t4.Paneer Tikka\t\t\t\t100");
			d.s("\t\t5.Éclair\t\t\t\t150");
			d.s("\t\t6.Mille-feuilles\t\t\t250");
			d.s("\t\t7.Macarons\t\t\t\t200");
			d.s("\t\t8.Chicken Lollypop\t\t\t100");
			d.s("\t\t9.Chicken Hakka Noodles\t\t\t80");
			d.s("\t\t10.Chicken Rice\t\t\t\t80");
			d.s("\t\t11.Dry Schezwan Chicken\t\t\t150");
			d.s("\t\t12.Chapati\t\t\t\t10");
			d.s("\t\t13.ColdDrinks\t\t\t\t10");
			j=0;
			for(i=0;i<order;i++)
			{
				d.s("Enter food Name: ");
				foodn=Integer.parseInt(in.readLine());
				d.s("Enter quantity: ");
				quantity=Integer.parseInt(in.readLine());
				switch(foodn)
				{
					case 1:
						food="Papa - The Dhaba Special\t";
						rs=quan(quantity,180);
						break;
					case 2:
						food="Chole Bhature Special\t\t";
						rs=quan(quantity,90);
						break;
					case 3:
						food="Paneer Masala Special\t\t";
						rs=quan(quantity,100);
						break;
					case 4:
						food="Paneer Tikka\t\t\t";
						rs=quan(quantity,100);
						break;
					case 5:
						food="Éclair\t\t\t\t";
						rs=quan(quantity,150);
						break;
					case 6:
						food="Mille-feuilles\t\t\t";
						rs=quan(quantity,250);
						break;
					case 7:
						food="Macarons\t\t\t";
						rs=quan(quantity,200);
						break;
					case 8:
						food="Chicken Lollypop\t\t";
						rs=quan(quantity,100);
						break;
					case 9:
						food="Chicken Hakka Noodles\t\t";
						rs=quan(quantity,80);
						break;
					case 10:
						food="Chicken Rice\t\t\t";
						rs=quan(quantity,80);
						break;
					case 11:
						food="Dry Shezwan Chicken\t\t";
						rs=quan(quantity,150);
						break;
					case 12:
						food="Chapati\t\t\t\t";
						rs=quan(quantity,10);
						break;
					case 13:
						food="Cold Drinks\t\t\t";
						rs=quan(quantity,10);
						break;
					default:
						d.s("Invalid Food....");
				}
				fooda[j]=food;
				r[j]=rs;
				quan[j]=quantity;
				j++;
			}
		}
		catch(Exception e)
		{	
		}
	}
	void showBill() throws Exception
	{
		d.s("/*------------------------------------------------------------------------------------------------*/");
		d.s("\t\t\t\t\tPapa - The Dhaba");
		d.s("\t\t\t\tKoral Park, Dist. Bhiwandi 411222");
		System.out.println("Bill by Mr Ankur Singh\t\t\t\t\t\t\t\t" + day+"-"+(month+1)+"-"+year);
		System.out.println("Table No.: " + tabno);
		System.out.println("\tOrder\t\t\t\t\tQuantity\t\t\t\tRupees\n");
		for(i=0;i<order;i++)
		{
			System.out.print(fooda[i]);
			System.out.print("\t\t\t\t"+quan[i]);
			System.out.print("\t\t\t\t"+r[i]+"\n");
			
		}
		for(i=0;i<order;i++)
		{
			sum=sum+r[i];
		}
		d.s("----------------------------------------------------------------------------------------------------");
		d.s("\t\t\t\t\t\t\t\t\t\tTotal: "+sum);
		d.s("Paid = Yes");
		d.s("\t\t\t\tApproved");
	}
}
public class MainBillSystem 
{
	@SuppressWarnings("deprecation")
	public static void main(String args[])
	{
		int value;
		DataInputStream in = new DataInputStream(System.in);
		BillSystem b = new BillSystem();
		try
		{
			do{
				d.s("\t\t\tDo you want a Bill");
				d.s("Enter your choice (Press 1 for Yes)(Press 2 for No): ");
				value=Integer.parseInt(in.readLine());
				switch(value)
				{
					case 1:
						b.createBill();
						b.showBill();
						break;
					case 2:
						System.exit(1);
					default:
						d.s("Invalid Choice...");
				}
			}while(value!=2);
		}
		catch(Exception e)
		{
		}
	}
}