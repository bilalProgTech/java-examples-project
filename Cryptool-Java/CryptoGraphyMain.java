package cryptoFolder;


import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JSpinner;

@SuppressWarnings("serial")
public class CryptoGraphyMain extends JFrame 
{
	private JPanel contentPane;
	private JTextField textFieldMsgCC;
	private JTextField textFieldCC;
	private JTextField textFieldMsgVC;
	private JTextField textFieldVC;
	private JTextField textFieldKeyVC;
	private JTextField textFieldMsgCoC;
	private JTextField textFieldCoC;
	private JTextField textFieldMsgMD5;
	private JTextField textFieldMD5;
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					CryptoGraphyMain frame = new CryptoGraphyMain();
					frame.setVisible(true);
					frame.setTitle("All In One CryptoGraphy");
					frame.setResizable(false);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("crypto.png")));
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	public static String encryptCaesarCipher(String plain, int key)
	{
		String cipher="";
		for(int i=0;i<plain.length();i++)
		{
			int p=plain.charAt(i);
			int c=p+(key%26);
			if(c>'z')
			{
				c=c-26;
			}
			cipher+=(char) c;
		}
		return cipher;
	}
	public static String decryptCaesarCipher(String cipher, int key)
	{
		String plain="";
		for(int i=0;i<cipher.length();i++)
		{
			int p=cipher.charAt(i);
			int c=p-(key%26);
			if(c>'z')
			{
				c=c-26;
			}
			plain+=(char) c;
		}
		return plain;
	}
	public static String encryptViginereCipher(String plain, String key)
	{
		int p,k,c,j=0;
		String cipher="";
		for(int i=0 ; i<plain.length() ; i++)
		{
			p=plain.charAt(i);
			if(p==32)
			{
				c=p;
			}
			else
			{
				if(j<key.length())
				{
					k=key.charAt(j);
					j++;
				}
				else
				{
					j=0;
					k=key.charAt(j);
					j++;
				}
				p=p-96;
				k=k-96;
				c=((p+k)-1)%26;
				if(c>26)
				{	
					c=c-26;
				}
				c=c+96;
			}
			cipher+=(char) c;
		}
		return cipher;
	}
	public static String encryptColumnerCipher(String plain, int key)
	{
		int p;
		String cipher="";
		for(int i=0;i<key;i++)
		{
			for(int j=i;j<plain.length();j+=key)
			{
				p=plain.charAt(j);
				cipher+=(char) p;
			}
		}
		return cipher;
	}
	public static String getMd5(String input)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[]  messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1,messageDigest);
			String hashtext = no.toString(16);
			while(hashtext.length()<32)
			{
				hashtext = "0" +hashtext;
			}
			return hashtext;
		}
		catch(NoSuchAlgorithmException e)
		{
			throw new RuntimeException(e);
		}
	}
	public CryptoGraphyMain() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 511);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panelCaesarCipher = new JPanel();
		panelCaesarCipher.setToolTipText("Caesar Cipher");
		panelCaesarCipher.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panelCaesarCipher.setBounds(22, 46, 294, 205);
		panelCaesarCipher.setLayout(null);
		contentPane.add(panelCaesarCipher);
		
		JRadioButton rdbtnEncryptCC = new JRadioButton("Encrypt");
		rdbtnEncryptCC.setFont(new Font("Times New Roman", Font.BOLD, 13));
		rdbtnEncryptCC.setBounds(29, 36, 102, 25);
		panelCaesarCipher.add(rdbtnEncryptCC);
		
		JRadioButton rdbtnDecryptCC = new JRadioButton("Decrypt");
		rdbtnDecryptCC.setFont(new Font("Times New Roman", Font.BOLD, 13));
		rdbtnDecryptCC.setBounds(160, 36, 102, 25);
		panelCaesarCipher.add(rdbtnDecryptCC);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnEncryptCC);
		bg.add(rdbtnDecryptCC);
		
		JLabel lblMsgCC = new JLabel("Enter Your Message:");
		lblMsgCC.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMsgCC.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgCC.setBounds(10, 68, 136, 25);
		panelCaesarCipher.add(lblMsgCC);
		
		textFieldMsgCC = new JTextField();
		textFieldMsgCC.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldMsgCC.setBounds(160, 70, 124, 20);
		panelCaesarCipher.add(textFieldMsgCC);
		textFieldMsgCC.setColumns(10);
		
		JLabel lblEnterYourKey = new JLabel("Enter Your Key:");
		lblEnterYourKey.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourKey.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEnterYourKey.setBounds(10, 104, 136, 25);
		panelCaesarCipher.add(lblEnterYourKey);
		
		JSpinner spinner = new JSpinner();
		spinner.setToolTipText("Set Key Here");
		spinner.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		spinner.setBounds(160, 101, 50, 20);
		panelCaesarCipher.add(spinner);
		
		JButton btnCC = new JButton("Result");
		btnCC.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(rdbtnEncryptCC.isSelected())
				{
					String msg = textFieldMsgCC.getText();
					int key = (int) spinner.getValue();
					String cipher = encryptCaesarCipher(msg, key);
					textFieldCC.setText(cipher);
				}
				if(rdbtnDecryptCC.isSelected())
				{
					String msg = textFieldMsgCC.getText();
					int key = (int) spinner.getValue();
					String cipher = decryptCaesarCipher(msg, key);
					textFieldCC.setText(cipher);
				}
			}
		});
		btnCC.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnCC.setBounds(103, 171, 89, 23);
		panelCaesarCipher.add(btnCC);
		
		JLabel lblYourResult = new JLabel("Your Result:");
		lblYourResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourResult.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblYourResult.setBounds(10, 135, 136, 25);
		panelCaesarCipher.add(lblYourResult);
		
		textFieldCC = new JTextField();
		textFieldCC.setEditable(false);
		textFieldCC.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldCC.setColumns(10);
		textFieldCC.setBounds(160, 140, 124, 20);
		panelCaesarCipher.add(textFieldCC);
		
		JLabel lblCCL = new JLabel("Caesar Cipher");
		lblCCL.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCCL.setHorizontalAlignment(SwingConstants.CENTER);
		lblCCL.setBounds(38, 11, 212, 20);
		panelCaesarCipher.add(lblCCL);
		
		
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Viginere Cipher");
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBounds(324, 46, 294, 182);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Enter Your Message:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label.setBounds(10, 42, 136, 25);
		panel.add(label);
		
		textFieldMsgVC = new JTextField();
		textFieldMsgVC.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldMsgVC.setColumns(10);
		textFieldMsgVC.setBounds(160, 44, 124, 20);
		panel.add(textFieldMsgVC);
		
		JLabel label_1 = new JLabel("Enter Your Key:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_1.setBounds(10, 78, 136, 25);
		panel.add(label_1);
		
		JButton btnEncryptVC = new JButton("Encrypt");
		btnEncryptVC.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String msg = textFieldMsgVC.getText();
				String key = textFieldKeyVC.getText();
				String cipher = encryptViginereCipher(msg, key);
				textFieldVC.setText(cipher);
			}
		});
		btnEncryptVC.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnEncryptVC.setBounds(102, 150, 89, 23);
		panel.add(btnEncryptVC);
		
		JLabel label_2 = new JLabel("Your Result:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_2.setBounds(10, 114, 136, 25);
		panel.add(label_2);
		
		textFieldVC = new JTextField();
		textFieldVC.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldVC.setEditable(false);
		textFieldVC.setColumns(10);
		textFieldVC.setBounds(160, 116, 124, 20);
		panel.add(textFieldVC);
		
		JLabel lblVCL = new JLabel("Viginere Cipher");
		lblVCL.setHorizontalAlignment(SwingConstants.CENTER);
		lblVCL.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblVCL.setBounds(38, 11, 212, 20);
		panel.add(lblVCL);
		
		textFieldKeyVC = new JTextField();
		textFieldKeyVC.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldKeyVC.setColumns(10);
		textFieldKeyVC.setBounds(160, 80, 124, 20);
		panel.add(textFieldKeyVC);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("Columner Cipher");
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1.setBounds(326, 239, 294, 182);
		contentPane.add(panel_1);
		
		JLabel label_3 = new JLabel("Enter Your Message:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_3.setBounds(10, 42, 136, 25);
		panel_1.add(label_3);
		
		textFieldMsgCoC = new JTextField();
		textFieldMsgCoC.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldMsgCoC.setColumns(10);
		textFieldMsgCoC.setBounds(160, 44, 124, 20);
		panel_1.add(textFieldMsgCoC);
		
		JLabel label_4 = new JLabel("Enter Your Key:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_4.setBounds(10, 78, 136, 25);
		panel_1.add(label_4);
		
		JComboBox<Integer> comboBoxCoC = new JComboBox<Integer>();
		comboBoxCoC.setBounds(160, 80, 52, 20);
		panel_1.add(comboBoxCoC);
		for(int i=1;i<=25;i++)
		{
			comboBoxCoC.addItem(i);
		}
		
		JButton buttonEncryptCoC = new JButton("Encrypt");
		buttonEncryptCoC.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				String msg = textFieldMsgCoC.getText();
				int key = (int) comboBoxCoC.getSelectedItem();
				String cipher = encryptColumnerCipher(msg, key);
				textFieldCoC.setText(cipher);
			}
		});
		buttonEncryptCoC.setFont(new Font("Times New Roman", Font.BOLD, 13));
		buttonEncryptCoC.setBounds(102, 150, 89, 23);
		panel_1.add(buttonEncryptCoC);
		
		JLabel label_5 = new JLabel("Your Result:");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_5.setBounds(10, 114, 136, 25);
		panel_1.add(label_5);
		
		textFieldCoC = new JTextField();
		textFieldCoC.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldCoC.setEditable(false);
		textFieldCoC.setColumns(10);
		textFieldCoC.setBounds(160, 116, 124, 20);
		panel_1.add(textFieldCoC);
		
		JLabel lblColumnerCipher = new JLabel("Columner Cipher");
		lblColumnerCipher.setHorizontalAlignment(SwingConstants.CENTER);
		lblColumnerCipher.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblColumnerCipher.setBounds(38, 11, 212, 20);
		panel_1.add(lblColumnerCipher);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("MD5");
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_2.setBounds(22, 257, 294, 164);
		contentPane.add(panel_2);
		
		JLabel label_6 = new JLabel("Enter Your Message:");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_6.setBounds(14, 42, 136, 25);
		panel_2.add(label_6);
		
		textFieldMsgMD5 = new JTextField();
		textFieldMsgMD5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldMsgMD5.setColumns(10);
		textFieldMsgMD5.setBounds(160, 44, 124, 20);
		panel_2.add(textFieldMsgMD5);
		
		JButton btnHashCode = new JButton("Hash Code");
		btnHashCode.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String msg = textFieldMsgMD5.getText();
				textFieldMD5.setText(getMd5(msg));
			}
		});
		btnHashCode.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnHashCode.setBounds(91, 130, 106, 23);
		panel_2.add(btnHashCode);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblResult.setBounds(10, 79, 76, 25);
		panel_2.add(lblResult);
		
		textFieldMD5 = new JTextField();
		textFieldMD5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldMD5.setEditable(false);
		textFieldMD5.setColumns(10);
		textFieldMD5.setBounds(91, 81, 193, 44);
		panel_2.add(textFieldMD5);
		
		JLabel lblMessageDigestMd = new JLabel("Message Digest MD5");
		lblMessageDigestMd.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageDigestMd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMessageDigestMd.setBounds(40, 11, 212, 20);
		panel_2.add(lblMessageDigestMd);
		
		JLabel lblNewLabel = new JLabel("Crypt Your Message");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(83, 11, 488, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				textFieldCC.setText("");
				textFieldCoC.setText("");
				textFieldKeyVC.setText("");
				textFieldMD5.setText("");
				textFieldMsgCC.setText("");
				textFieldMsgCoC.setText("");
				textFieldMsgMD5.setText("");
				textFieldMsgVC.setText("");
				textFieldVC.setText("");
				rdbtnEncryptCC.setSelected(false);
				rdbtnDecryptCC.setSelected(false);
				spinner.setValue(0);
				comboBoxCoC.setSelectedIndex(0);
			}
		});
		btnNewButton.setBounds(281, 438, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Developer");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_1.setBounds(529, 438, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}