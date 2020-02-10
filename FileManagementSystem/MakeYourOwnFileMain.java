package OwnFileSystem;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.JRadioButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings("serial")
public class MakeYourOwnFileMain extends JFrame 
{
	private JPanel contentPane;
	private JTextField textFieldCreateFileorDirectory;
	private JTextField textFieldApproval;
	private JTextField textFieldCopyApproval;
	private final static String pathname = "C:/Users/hungu/OneDrive/Documents/MyNewFileSoftware/";
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MakeYourOwnFileMain frame = new MakeYourOwnFileMain();
					frame.setVisible(true);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("filesys.png")));
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	public MakeYourOwnFileMain() 
	{
		setTitle("MakeYourOwnFileSystem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 465);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 2, 3, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(22, 57, 343, 287);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JRadioButton rdbtnMakeYourFile = new JRadioButton("Make Your File");
		rdbtnMakeYourFile.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnMakeYourFile.setBounds(35, 18, 123, 23);
		panel.add(rdbtnMakeYourFile);
		
		JRadioButton rdbtnDirectory = new JRadioButton("Make Your Directory");
		rdbtnDirectory.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnDirectory.setBounds(160, 18, 157, 23);
		panel.add(rdbtnDirectory);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnDirectory);
		bg.add(rdbtnMakeYourFile);
		
		JLabel lblEnterYourFiledirectory = new JLabel("Enter Your File/Directory Name(with Extension):");
		lblEnterYourFiledirectory.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourFiledirectory.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEnterYourFiledirectory.setBounds(16, 57, 283, 29);
		panel.add(lblEnterYourFiledirectory);
		
		textFieldCreateFileorDirectory = new JTextField();
		textFieldCreateFileorDirectory.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldCreateFileorDirectory.setBounds(16, 102, 234, 29);
		panel.add(textFieldCreateFileorDirectory);
		textFieldCreateFileorDirectory.setColumns(10);
		
		JButton btnMakeIT = new JButton("Make IT");
		btnMakeIT.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(rdbtnMakeYourFile.isSelected())
				{
					String filename = textFieldCreateFileorDirectory.getText();
					try
					{
						File f = new File(pathname+filename);
						if(f.createNewFile())
							textFieldApproval.setText("File Created");
						else
							textFieldApproval.setText("File Note Created. Problem Occur");
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				if(rdbtnDirectory.isSelected())
				{
					String directoryname = textFieldCreateFileorDirectory.getText();
					try
					{
						File file = new File(pathname+directoryname);
						if(file.mkdir())
							textFieldApproval.setText("Directory Created");
						else
							textFieldApproval.setText("Directory Creates Something's Wrong");
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		btnMakeIT.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnMakeIT.setBounds(123, 150, 99, 23);
		panel.add(btnMakeIT);
		
		JLabel lblDoYouWant = new JLabel("Do You Want To Open IT");
		lblDoYouWant.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoYouWant.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDoYouWant.setBounds(98, 219, 165, 29);
		panel.add(lblDoYouWant);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnYes.setBounds(98, 255, 57, 23);
		panel.add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnNo.setBounds(215, 255, 48, 23);
		panel.add(rdbtnNo);
		rdbtnYes.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				String fd = textFieldCreateFileorDirectory.getText();
				File file = new File(pathname+fd);
				if(!Desktop.isDesktopSupported())
				{
					
				}
				else
				{
					Desktop desk = Desktop.getDesktop();
					if(file.exists())
					{
						try 
						{
							desk.open(file);
							
						} 
						catch (IOException ioe) 
						{
							ioe.printStackTrace();
						}
					}
					else if(!file.exists())
					{
						textFieldApproval.setText("Not Yet File Created Please Check It");
					}
				}
			}
		});
		
		rdbtnNo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(rdbtnDirectory.isSelected())
					textFieldApproval.setText("No Problem Just Check Later On");
				if(rdbtnMakeYourFile.isSelected())
					textFieldApproval.setText("No Problem Just Check in Read Block");
			}
		});
		
		textFieldApproval = new JTextField();
		textFieldApproval.setEditable(false);
		textFieldApproval.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldApproval.setColumns(10);
		textFieldApproval.setBounds(16, 184, 317, 23);
		panel.add(textFieldApproval);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "CopyYourFile", TitledBorder.LEADING, TitledBorder.TOP, new Font("Times New Roman", Font.BOLD, 14), new Color(0, 0, 0)));
		panel_1.setBounds(375, 11, 307, 252);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Source File Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(23, 28, 160, 21);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblEnterDestinationFile = new JLabel("Enter Destination File Name:");
		lblEnterDestinationFile.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEnterDestinationFile.setBounds(23, 91, 160, 21);
		panel_1.add(lblEnterDestinationFile);
		
		JComboBox<String> SourceFile = new JComboBox<String>();
		SourceFile.setBounds(23, 60, 160, 20);
		panel_1.add(SourceFile);
		
		JComboBox<String> DestinationFile = new JComboBox<String>();
		DestinationFile.setBounds(23, 123, 160, 20);
		panel_1.add(DestinationFile);
		
		JButton btnSourceDest = new JButton("Copy IT");
		btnSourceDest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String source = (String) SourceFile.getSelectedItem();
				String destination = (String) DestinationFile.getSelectedItem();
				FileInputStream in = null;
				FileOutputStream out = null;
				try
				{
					in  = new FileInputStream(pathname+source);
					out = new FileOutputStream(pathname+destination);
					int c;
					while((c=in.read())!=-1)
					{
						out.write(c);
					}
					textFieldCopyApproval.setText("File Copied Successfully");
				}
				catch(Exception e)
				{
					if(in!=null)
					{
						try 
						{
							in.close();
						} 
						catch (IOException e1) 
						{
							e1.printStackTrace();
						}
					}
					if(out!=null)
					{
						try 
						{
							out.close();
						} 
						catch (IOException e1) 
						{
							e1.printStackTrace();
						}
					}
				}

						
			}
		});
		btnSourceDest.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnSourceDest.setBounds(166, 154, 89, 23);
		panel_1.add(btnSourceDest);
		
		textFieldCopyApproval = new JTextField();
		textFieldCopyApproval.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCopyApproval.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textFieldCopyApproval.setEditable(false);
		textFieldCopyApproval.setColumns(10);
		textFieldCopyApproval.setBounds(70, 187, 175, 20);
		panel_1.add(textFieldCopyApproval);
		
		JToggleButton tglbtnOpen = new JToggleButton("Just See IT");
		tglbtnOpen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tglbtnOpen.setBounds(97, 218, 121, 23);
		panel_1.add(tglbtnOpen);
		
		JButton btnRefresh_1 = new JButton("Refresh");
		btnRefresh_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				SourceFile.removeAllItems();
				DestinationFile.removeAllItems();
				File file = new File(pathname);
				String[] path = new String[40];
				path=file.list();
				for(String p:path)
				{
					SourceFile.addItem(p);
					DestinationFile.addItem(p);
				}
			}
		});
		btnRefresh_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnRefresh_1.setBounds(52, 154, 89, 23);
		panel_1.add(btnRefresh_1);
		
		tglbtnOpen.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String fd = (String) DestinationFile.getSelectedItem();
				File file = new File(pathname+fd);
				if(!Desktop.isDesktopSupported())
				{
					
				}
				else
				{
					Desktop desk = Desktop.getDesktop();
					if(file.exists())
					{
						try 
						{
							desk.open(file);
						} 
						catch (IOException ioe) 
						{
							ioe.printStackTrace();
						}
					}
					if(!file.exists())
					{
						textFieldApproval.setText("File Not Exist");
					}
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Manipulate With Files");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(22, 11, 343, 35);
		contentPane.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "ReadYourFiles", TitledBorder.LEADING, TitledBorder.TOP, new Font("Times New Roman", Font.BOLD, 14), null));
		panel_2.setBounds(375, 287, 307, 137);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(63, 25, 171, 25);
		panel_2.add(comboBox);
		
		JButton btnReadOpen = new JButton("Open IT");
		btnReadOpen.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String filename = (String) comboBox.getSelectedItem();
				File file = new File(pathname+filename);
				if(!Desktop.isDesktopSupported())
				{
					
				}
				else
				{
					Desktop desk = Desktop.getDesktop();
					if(file.exists())
					{
						try 
						{
							desk.open(file);
						} 
						catch (IOException ioe) 
						{
							ioe.printStackTrace();
						}
					}
					if(!file.exists())
					{
						textFieldApproval.setText("File Not Exist");
						
					}
				}
				
			}
		});
		btnReadOpen.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnReadOpen.setBounds(154, 70, 104, 23);
		panel_2.add(btnReadOpen);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				comboBox.removeAllItems();
				File file = new File(pathname);
				String[] path = new String[40];
				path=file.list();
				for(String p:path)
				{
					comboBox.addItem(p);
				}
			}
		});
		btnRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnRefresh.setBounds(55, 69, 89, 23);
		panel_2.add(btnRefresh);
		
		JButton btnDeleteIt = new JButton("Delete IT");
		btnDeleteIt.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String filename = (String) comboBox.getSelectedItem();
				File file = new File(pathname+filename);
				if (file.delete()) 
				{
					textFieldApproval.setText("File Deleted Sucessfully");
				}
				else if(!file.exists())
				{
					textFieldApproval.setText("File Not Exist");
				}
				else
					textFieldApproval.setText("Something went Wrong");
			}
		});
		btnDeleteIt.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDeleteIt.setBounds(104, 104, 104, 23);
		panel_2.add(btnDeleteIt);
		
		JButton btnReset = new JButton("Reset All");
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				textFieldApproval.setText("");
				textFieldCopyApproval.setText("");
				textFieldCreateFileorDirectory.setText("");
				comboBox.removeAllItems();
				DestinationFile.removeAllItems();
				SourceFile.removeAllItems();
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnReset.setBounds(135, 363, 112, 39);
		contentPane.add(btnReset);
	}
}