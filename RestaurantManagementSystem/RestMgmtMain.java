package RestMgmtPackage;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
@SuppressWarnings("serial")
public class RestMgmtMain extends JFrame 
{
	private double HOMEDELIVERY = 2.2;
	private double TAX = 8.7;
	private JPanel contentPane;
	private JTextField dnTF;
	private JTextField dkTF;
	private JTextField FoodCost;
	private JTextField Tax;
	private JTextField TotalCost;
	private JTextField textField;
	int rs,quan,total=0;
	String[] colHeads = {"Food Name","Price"};
	Object[][] data =
		{ 
			{"Chicken Meal", 125},
			{"Veg Meal",100},
			{"Chidren Special",150},
			{"Mc Aloo Tikki",25},
			{"Maharaja Mac",75},
			{"French Fries",85},
			{"Potato Wedges",50},
			{"Chicken Tikka",100},
			{"Nuggets",35},
			{"Coke/Fanta/Sprite",35},
			{"McFlurry",85},
			{"Coke with Cream",50}
		};
		
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					RestMgmtMain frame = new RestMgmtMain();
					frame.setVisible(true);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images.png")));
					frame.setTitle("Payment of Food");
					frame.setResizable(false);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	static int getQuantity(int q,int r)
  	{
  		r=r*q;
  		return r;
  	}
	public RestMgmtMain() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 492);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Payment");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(314, 11, 205, 31);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBounds(20, 89, 242, 117);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JCheckBox CM = new JCheckBox("Chicken Meal");
		CM.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		CM.setBounds(16, 7, 109, 30);
		panel.add(CM);
		
		JCheckBox VM = new JCheckBox("Veg Meal");
		VM.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		VM.setBounds(16, 40, 109, 30);
		panel.add(VM);
		
		JCheckBox CS = new JCheckBox("Children Special");
		CS.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		CS.setBounds(16, 73, 133, 30);
		panel.add(CS);
		
		JComboBox<Integer> cmCB = new JComboBox<Integer>();
		cmCB.setBounds(166, 13, 66, 20);
		panel.add(cmCB);
		
		JComboBox<Integer> vmCB = new JComboBox<Integer>();
		vmCB.setBounds(166, 46, 66, 20);
		panel.add(vmCB);
		
		JComboBox<Integer> csCB = new JComboBox<Integer>();
		csCB.setBounds(166, 79, 66, 20);
		panel.add(csCB);
		
		for(int i=0;i<10;i++)
		{
			cmCB.addItem(i);
			vmCB.addItem(i);
			csCB.addItem(i);
		}
		JTabbedPane tb = new JTabbedPane();
		JPanel calcP = new JPanel();
		JLabel input1 = new JLabel("Enter No. 1:");
		input1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		JLabel input2 = new JLabel("Enter No. 2:");
		input2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		JLabel result = new JLabel("Result: ");
		result.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JButton addi = new JButton("Addition");
		addi.setFont(new Font("Times New Roman", Font.BOLD, 13));
		JButton sub = new JButton("Subtraction");
		sub.setFont(new Font("Times New Roman", Font.BOLD, 13));
		JButton mul = new JButton("Multiply");
		mul.setFont(new Font("Times New Roman", Font.BOLD, 13));
		JButton div = new JButton("Division");
		div.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JTextField in1 = new JTextField();
		in1.setHorizontalAlignment(SwingConstants.CENTER);
		in1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		JTextField in2 = new JTextField();
		in2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		in2.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField in3 = new JTextField();
		in3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		in3.setHorizontalAlignment(SwingConstants.CENTER);
		in3.setEditable(false);
		calcP.setLayout(new GridLayout(9,7));
		
		addi.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int s1=Integer.parseInt(in1.getText());
				int s2=Integer.parseInt(in2.getText());
				int sum=s1+s2;
				in3.setText(Integer.toString(sum));
			}
		});
		
		sub.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int s1=Integer.parseInt(in1.getText());
				int s2=Integer.parseInt(in2.getText());
				int sum=s1-s2;
				in3.setText(Integer.toString(sum));
			}
		});
		
		mul.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int s1=Integer.parseInt(in1.getText());
				int s2=Integer.parseInt(in2.getText());
				int sum=s1*s2;
				in3.setText(Integer.toString(sum));
			}
		});
		
		div.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int s1=Integer.parseInt(in1.getText());
				int s2=Integer.parseInt(in2.getText());
				float sum= (float) s1/s2;
				in3.setText(Float.toString(sum));
			}
		});
		calcP.add(input1);
		calcP.add(in1);
		calcP.add(input2);
		calcP.add(in2);
		calcP.add(addi);
		calcP.add(sub);
		calcP.add(mul);
		calcP.add(div);
		calcP.add(result);
		calcP.add(in3);
		
		JPanel menu = new JPanel(new GridLayout());     
		JTable jt = new JTable(data,colHeads);
		jt.setShowGrid(false);
		jt.getColumnModel().getColumn(0).setPreferredWidth(101);
		jt.getColumnModel().getColumn(1).setPreferredWidth(38);
		jt.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		menu.add(jt); 
		tb.addTab("Calculator", calcP);
		tb.addTab("Menu", menu);
		
	
		JPanel Reciept = new JPanel();
		Reciept.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		Reciept.setBounds(557, 60, 219, 349);
		Reciept.setLayout(new GridLayout());
		Reciept.add(tb);
		contentPane.add(Reciept);
		
		JLabel lblSpecialMeals = new JLabel("Special Meals");
		lblSpecialMeals.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSpecialMeals.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpecialMeals.setBounds(20, 59, 242, 26);
		contentPane.add(lblSpecialMeals);
		
		JLabel lblAnyThingElse = new JLabel("Any Thing Else");
		lblAnyThingElse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnyThingElse.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAnyThingElse.setBounds(37, 229, 242, 26);
		contentPane.add(lblAnyThingElse);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(20, 266, 527, 143);
		panel_2.setLayout(null);
		contentPane.add(panel_2);
		
		JComboBox<String> dnCB = new JComboBox<String>();
		dnCB.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		dnCB.setBounds(153, 11, 142, 26);
		panel_2.add(dnCB);
		
		dnCB.addItem("Select Food");
		dnCB.addItem("Mc Aloo Tikki");
		dnCB.addItem("Maharaja Mac");
		dnCB.addItem("French Fries");
		dnCB.addItem("Potato Wedges");
		dnCB.addItem("Chicken Tikka");
		dnCB.addItem("Nuggets");
		
		JLabel lblDishName = new JLabel("Dish Name:");
		lblDishName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDishName.setHorizontalAlignment(SwingConstants.CENTER);
		lblDishName.setBounds(10, 11, 109, 26);
		panel_2.add(lblDishName);
		
		JComboBox<String> dkCB = new JComboBox<String>();
		dkCB.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		dkCB.setBounds(153, 58, 142, 26);
		panel_2.add(dkCB);
		
		dkCB.addItem("Select Drink");
		dkCB.addItem("Coke/Fanta/Sprite");
		dkCB.addItem("Mc Flurry");
		dkCB.addItem("Coke with Cream");
		
		JLabel lblDrinks = new JLabel("Drink(s):");
		lblDrinks.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrinks.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDrinks.setBounds(10, 57, 109, 26);
		panel_2.add(lblDrinks);
		
		dnTF = new JTextField();
		dnTF.setHorizontalAlignment(SwingConstants.CENTER);
		dnTF.setFont(new Font("Times New Roman", Font.BOLD, 12));
		dnTF.setColumns(10);
		dnTF.setBounds(324, 14, 66, 20);
		panel_2.add(dnTF);
		
		dkTF = new JTextField();
		dkTF.setHorizontalAlignment(SwingConstants.CENTER);
		dkTF.setFont(new Font("Times New Roman", Font.BOLD, 12));
		dkTF.setColumns(10);
		dkTF.setBounds(324, 61, 66, 20);
		panel_2.add(dkTF);
		
		JButton ateB = new JButton("Add");
		ateB.setToolTipText("Click Here for adding food");
		ateB.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ateB.setBounds(69, 95, 109, 35);
		panel_2.add(ateB);
		
		JRadioButton homedeli = new JRadioButton("Home Delivery");
		homedeli.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		homedeli.setBounds(237, 102, 118, 23);
		panel_2.add(homedeli);
		
		JRadioButton TaxRB = new JRadioButton("Tax");
		TaxRB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		TaxRB.setBounds(382, 102, 109, 23);
		panel_2.add(TaxRB);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(homedeli);
		bg.add(TaxRB);
		
		JButton btnNewButton_2 = new JButton("Menu");
		btnNewButton_2.setBounds(404, 36, 113, 23);
		panel_2.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBounds(289, 73, 242, 171);
		panel_3.setLayout(null);
		contentPane.add(panel_3);
		
		JLabel lblTotalFoodCost = new JLabel("Total Food Cost");
		lblTotalFoodCost.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalFoodCost.setBounds(10, 11, 113, 31);
		panel_3.add(lblTotalFoodCost);
		
		FoodCost = new JTextField();
		FoodCost.setHorizontalAlignment(SwingConstants.CENTER);
		FoodCost.setEditable(false);
		FoodCost.setFont(new Font("Times New Roman", Font.BOLD, 12));
		FoodCost.setBounds(133, 17, 86, 20);
		panel_3.add(FoodCost);
		FoodCost.setColumns(10);
		
		JLabel lblTaxRate = new JLabel("Tax Rate");
		lblTaxRate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTaxRate.setBounds(10, 53, 113, 31);
		panel_3.add(lblTaxRate);
		
		Tax = new JTextField();
		Tax.setEditable(false);
		Tax.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Tax.setHorizontalAlignment(SwingConstants.CENTER);
		Tax.setColumns(10);
		Tax.setBounds(133, 59, 86, 20);
		panel_3.add(Tax);
		
		JLabel lblTotalCost = new JLabel("Total Cost");
		lblTotalCost.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalCost.setBounds(10, 95, 113, 31);
		panel_3.add(lblTotalCost);
		
		TotalCost = new JTextField();
		TotalCost.setHorizontalAlignment(SwingConstants.CENTER);
		TotalCost.setEditable(false);
		TotalCost.setFont(new Font("Times New Roman", Font.BOLD, 12));
		TotalCost.setColumns(10);
		TotalCost.setBounds(133, 101, 86, 20);
		panel_3.add(TotalCost);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				FoodCost.setText(Integer.toString(total));
				double fc = Double.parseDouble(FoodCost.getText());
				double tr = Double.parseDouble(Tax.getText());
				double sum = fc+tr;
				TotalCost.setText(Double.toString(sum));
			}
		});
		btnTotal.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnTotal.setBounds(74, 137, 103, 23);
		panel_3.add(btnTotal);
		
		JLabel lblTotalBill = new JLabel("Total Bill");
		lblTotalBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalBill.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalBill.setBounds(289, 41, 242, 26);
		contentPane.add(lblTotalBill);
		
		JComboBox<String> oname = new JComboBox<String>();
		oname.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		oname.setBounds(147, 18, 139, 24);
		contentPane.add(oname);
		
		oname.addItem("Mr. Shayan Shaikh");
		oname.addItem("Mr. Bilal Hungund");
		oname.addItem("Mr. Akram Ansari");
		oname.addItem("Mr. Suleman Shaikh");
		oname.addItem("Mr. Arshad Shaikh");
		oname.addItem("Mr. Saif Khan");
		
		JLabel lblNewLabel_1 = new JLabel("Operator Name:");
		lblNewLabel_1.setBounds(20, 13, 109, 31);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 12));
		textField.setBounds(531, 18, 260, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Date date = new Date();
		SimpleDateFormat dateF = new SimpleDateFormat("EEEE, MMMM d, hh:mm a, dd-MM-yyyy");
		String Date = dateF.format(date);
		textField.setText(Date);
		
		JButton btnNewButton = new JButton("Reset All");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(327, 420, 89, 23);
		contentPane.add(btnNewButton);
		
		homedeli.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				Tax.setText(Double.toString(HOMEDELIVERY));
			}
		});
		
		TaxRB.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				Tax.setText(Double.toString(TAX));
			}
		});
		
		ateB.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(CM.isSelected())
				{
					rs=125;
					quan=(int) cmCB.getSelectedItem();
					total = total+getQuantity(quan, rs);
				}
				if(VM.isSelected())
				{
					rs=100;
					quan=(int) vmCB.getSelectedItem();
					total = total+getQuantity(quan, rs);
				}
				if(CS.isSelected())
				{
					rs=150;
					quan=(int) csCB.getSelectedItem();
					total = total+getQuantity(quan, rs);
				}
				
				int foodno = dnCB.getSelectedIndex();
				if(foodno==1)
				{
					rs=25;
					quan=Integer.parseInt(dnTF.getText());
					total = total+getQuantity(quan, rs);
				}
				if(foodno==2)
				{
					rs=75;
					quan=Integer.parseInt(dnTF.getText());
					total = total+getQuantity(quan, rs);
				}
				if(foodno==3)
				{
					rs=85;
					quan=Integer.parseInt(dnTF.getText());
					total = total+getQuantity(quan, rs);
				}
				if(foodno==4)
				{
					rs=50;
					quan=Integer.parseInt(dnTF.getText());
					total = total+getQuantity(quan, rs);
				}
				if(foodno==5)
				{
					rs=100;
					quan=Integer.parseInt(dnTF.getText());
					total = total+getQuantity(quan, rs);
				}
				if(foodno==6)
				{
					rs=35;
					quan=Integer.parseInt(dnTF.getText());
					total = total+getQuantity(quan, rs);
				}
				
				int drinkno = dkCB.getSelectedIndex();
				if(drinkno==1)
				{
					rs=35;
					quan=Integer.parseInt(dkTF.getText());
					total = total+getQuantity(quan, rs);
				}
				if(drinkno==2)
				{
					rs=85;
					quan=Integer.parseInt(dkTF.getText());
					total = total+getQuantity(quan, rs);
				}
				if(drinkno==3)
				{
					rs=50;
					quan=Integer.parseInt(dkTF.getText());
					total = total+getQuantity(quan, rs);
				}
				
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CM.setSelected(false);
				VM.setSelected(false);
				CS.setSelected(false);
				cmCB.setSelectedIndex(0);
				vmCB.setSelectedIndex(0);
				csCB.setSelectedIndex(0);
				dkCB.setSelectedIndex(0);
				dnCB.setSelectedIndex(0);
				dnTF.setText("");
				dkTF.setText("");
				FoodCost.setText("");
				Tax.setText("");
				TotalCost.setText("");
				homedeli.setSelected(false);
				TaxRB.setSelected(false);
				total=0;
				bg.clearSelection();
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				tb.setSelectedComponent(menu);
			}
		});
	}
}
