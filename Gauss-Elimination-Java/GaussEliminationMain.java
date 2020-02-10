package src;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("serial")
public class GaussEliminationMain extends JFrame 
{
	private JPanel contentPane;
	private JTextField x1;
	private JTextField y1;
	private JTextField z1;
	private JTextField c1;
	private JTextField x2;
	private JTextField y2;
	private JTextField z2;
	private JTextField c2;
	private JTextField x3;
	private JTextField y3;
	private JTextField z3;
	private JTextField c3;
	private static JLabel error;
	private static final double EPSILON = 1e-10;
	private JTextField Ans1;
	private JTextField Ans2;
	private JTextField Ans3;
	public static double[] calculateGaussElimination(double[][] A, double[] b) 
	{
		int N = b.length;
	    for (int p = 0; p < N; p++) 
	    {
	    	int max = p;
	        for (int i = p + 1; i < N; i++) 
	        {
	        	if (Math.abs(A[i][p]) > Math.abs(A[max][p])) 
	            {
	        		max = i;
	            }
	        }
	        double[] temp = A[p]; 
	        A[p] = A[max]; 
	        A[max] = temp;
	        double t = b[p]; 
	        b[p] = b[max]; 
	        b[max] = t;
	        if (Math.abs(A[p][p]) <= EPSILON) 
	        {
	        	error.setText("Matrix is singular or nearly singular");
	        }
	        for (int i = p + 1; i < N; i++) 
	        {
	        	double alpha = A[i][p] / A[p][p];
	            b[i] -= alpha * b[p];
	            for (int j = p; j < N; j++) 
	            {
	            	A[i][j] -= alpha * A[p][j];
	            }
	        }
	     }
	     double[] x = new double[N];
	     for (int i = N - 1; i >= 0; i--) 
	     {
	    	 double sum = 0.0;
	         for (int j = i + 1; j < N; j++) 
	         {
	        	 sum += A[i][j] * x[j];
	         }
	         x[i] = (b[i] - sum) / A[i][i];
	     }
	     return x;
	}
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException,NullPointerException
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GaussEliminationMain frame = new GaussEliminationMain();
					frame.setTitle("Gauss Elimination");
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("GE.png")));
					error = new JLabel("");
					error.setHorizontalAlignment(SwingConstants.CENTER);
					error.setBounds(218, 326, 223, 20);
					frame.getContentPane().add(error);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	public GaussEliminationMain() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 489);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Find Simultaneous Equation using Gauss Elimination");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 624, 34);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBounds(48, 81, 154, 176);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("X:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(22, 23, 24, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setHorizontalAlignment(SwingConstants.CENTER);
		lblY.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblY.setBounds(22, 61, 24, 18);
		panel.add(lblY);
		
		JLabel lblZ = new JLabel("Z:");
		lblZ.setHorizontalAlignment(SwingConstants.CENTER);
		lblZ.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblZ.setBounds(22, 98, 24, 18);
		panel.add(lblZ);
		
		x1 = new JTextField();
		x1.setBounds(69, 23, 56, 20);
		panel.add(x1);
		x1.setColumns(10);
		
		y1 = new JTextField();
		y1.setColumns(10);
		y1.setBounds(69, 60, 56, 20);
		panel.add(y1);
		
		z1 = new JTextField();
		z1.setColumns(10);
		z1.setBounds(69, 97, 56, 20);
		panel.add(z1);
		
		JLabel lblC = new JLabel("C:");
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblC.setBounds(22, 136, 24, 18);
		panel.add(lblC);
		
		c1 = new JTextField();
		c1.setColumns(10);
		c1.setBounds(69, 136, 56, 20);
		panel.add(c1);
		
		JLabel lblNewLabel_2 = new JLabel("C - Constant");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(542, 404, 92, 27);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1.setBounds(251, 81, 154, 176);
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("X:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label.setBounds(22, 23, 24, 18);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Y:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_1.setBounds(22, 61, 24, 18);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Z:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_2.setBounds(22, 98, 24, 18);
		panel_1.add(label_2);
		
		x2 = new JTextField();
		x2.setColumns(10);
		x2.setBounds(69, 23, 56, 20);
		panel_1.add(x2);
		
		y2 = new JTextField();
		y2.setColumns(10);
		y2.setBounds(69, 60, 56, 20);
		panel_1.add(y2);
		
		z2 = new JTextField();
		z2.setColumns(10);
		z2.setBounds(69, 97, 56, 20);
		panel_1.add(z2);
		
		JLabel label_3 = new JLabel("C:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_3.setBounds(22, 136, 24, 18);
		panel_1.add(label_3);
		
		c2 = new JTextField();
		c2.setColumns(10);
		c2.setBounds(69, 136, 56, 20);
		panel_1.add(c2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_2.setBounds(463, 81, 154, 176);
		contentPane.add(panel_2);
		
		JLabel label_4 = new JLabel("X:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_4.setBounds(22, 23, 24, 18);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Y:");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_5.setBounds(22, 61, 24, 18);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Z:");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_6.setBounds(22, 98, 24, 18);
		panel_2.add(label_6);
		
		x3 = new JTextField();
		x3.setColumns(10);
		x3.setBounds(69, 23, 56, 20);
		panel_2.add(x3);
		
		y3 = new JTextField();
		y3.setColumns(10);
		y3.setBounds(69, 60, 56, 20);
		panel_2.add(y3);
		
		z3 = new JTextField();
		z3.setColumns(10);
		z3.setBounds(69, 97, 56, 20);
		panel_2.add(z3);
		
		JLabel label_7 = new JLabel("C:");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_7.setBounds(22, 136, 24, 18);
		panel_2.add(label_7);
		
		c3 = new JTextField();
		c3.setColumns(10);
		c3.setBounds(69, 136, 56, 20);
		panel_2.add(c3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBounds(48, 357, 486, 74);
		panel_3.setLayout(null);
		contentPane.add(panel_3);
		
		JLabel lblX = new JLabel("x:");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblX.setBounds(27, 25, 24, 18);
		panel_3.add(lblX);
		
		JLabel lblY_1 = new JLabel("y:");
		lblY_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblY_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblY_1.setBounds(177, 25, 24, 18);
		panel_3.add(lblY_1);
		
		JLabel lblZ_1 = new JLabel("z:");
		lblZ_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblZ_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblZ_1.setBounds(326, 25, 24, 18);
		panel_3.add(lblZ_1);
		
		Ans1 = new JTextField();
		Ans1.setHorizontalAlignment(SwingConstants.CENTER);
		Ans1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		Ans1.setEditable(false);
		Ans1.setBounds(61, 25, 106, 20);
		panel_3.add(Ans1);
		Ans1.setColumns(10);
		
		Ans2 = new JTextField();
		Ans2.setHorizontalAlignment(SwingConstants.CENTER);
		Ans2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		Ans2.setEditable(false);
		Ans2.setColumns(10);
		Ans2.setBounds(211, 25, 105, 20);
		panel_3.add(Ans2);
		
		Ans3 = new JTextField();
		Ans3.setHorizontalAlignment(SwingConstants.CENTER);
		Ans3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		Ans3.setEditable(false);
		Ans3.setColumns(10);
		Ans3.setBounds(360, 25, 106, 20);
		panel_3.add(Ans3);
		
		JButton btnNewButton = new JButton("Generate a Result");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				double[][] A = new double[3][3];
				double[] b = new double[3];
				
				A[0][0]=Double.parseDouble(x1.getText());
				A[0][1]=Double.parseDouble(y1.getText());
				A[0][2]=Double.parseDouble(z1.getText());
				
				A[1][0]=Double.parseDouble(x2.getText());
				A[1][1]=Double.parseDouble(y2.getText());
				A[1][2]=Double.parseDouble(z2.getText());
				
				A[2][0]=Double.parseDouble(x3.getText());
				A[2][1]=Double.parseDouble(y3.getText());
				A[2][2]=Double.parseDouble(z3.getText());
				
				b[0]=Double.parseDouble(c1.getText());
				b[1]=Double.parseDouble(c2.getText());
				b[2]=Double.parseDouble(c3.getText());
				
				double[] x = new double[3];
				x = calculateGaussElimination(A, b);
				
				String a1 = Double.toString(x[0]);
				String a2 = Double.toString(x[1]);
				String a3 = Double.toString(x[2]);
				
				error.setText("Answer");
				
				Ans1.setText(a1);
				Ans2.setText(a2);
				Ans3.setText(a3);
			}
		});
		btnNewButton.setBounds(164, 278, 154, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				x1.setText("");
				y1.setText("");
				z1.setText("");
				
				x2.setText("");
				y2.setText("");
				z2.setText("");
				
				x3.setText("");
				y3.setText("");
				z3.setText("");
				
				c1.setText("");
				c2.setText("");
				c3.setText("");
				
				Ans1.setText("");
				Ans2.setText("");
				Ans3.setText("");
				error.setText("");
			}
		});
		btnNewButton_1.setBounds(370, 285, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("1st Equation");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(48, 56, 154, 17);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblndEquation = new JLabel("2nd Equation");
		lblndEquation.setHorizontalAlignment(SwingConstants.CENTER);
		lblndEquation.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblndEquation.setBounds(251, 56, 154, 17);
		contentPane.add(lblndEquation);
		
		JLabel lblrdEquation = new JLabel("3rd Equation");
		lblrdEquation.setHorizontalAlignment(SwingConstants.CENTER);
		lblrdEquation.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblrdEquation.setBounds(463, 53, 154, 17);
		contentPane.add(lblrdEquation);

	}
}
