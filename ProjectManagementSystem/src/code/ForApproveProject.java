package code;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

@WebServlet("/ForApproveProject")
public class ForApproveProject extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String gid = request.getParameter("gid");
		String projT = "", projA = "";
		String guide = "", reference = "", query = "";
		String sid[] = new String[4];
		String name[] = new String[4];
		String email[] = new String[4];
		String date = "";
		String coord = "Mr. Nilesh Ghavathe";
		
		int pid = 0,i=0;
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try 
		{
			Connection con = DBConnect.initializeDatabase();
			
			st = con.prepareStatement("select curdate()");
			rs = st.executeQuery();
			while(rs.next())
			{
				date = rs.getString(1);
			}
			
			st = con.prepareStatement("update reservation set dateA='"+date+"',approve='Yes' where G_ID='"+gid+"'");
			st.executeUpdate();
			
			st = con.prepareStatement("select p_id from reservation where G_ID='"+gid+"'");
			rs = st.executeQuery();
			
			while(rs.next())
			{
				pid = Integer.parseInt(rs.getString(1));
			}
			
			if(pid >= 2017101)
			{
				st = con.prepareStatement("select * from AddProjectByStudent where P_ID="+pid+";");
				rs = st.executeQuery();
				while(rs.next())
				{
					pid = rs.getInt(1);
					projT = rs.getString(2);
					projA = rs.getString(3);
					reference = rs.getString(4);
					guide = rs.getString(5);
				}
			}
			else if(pid >= 201701)
			{
				st = con.prepareStatement("select * from AddProjectByFaculty where P_ID="+pid+";");
				rs = st.executeQuery();
				while(rs.next())
				{
					pid = rs.getInt(1);
					projT = rs.getString(2);
					projA = rs.getString(3);
					System.out.println(projT+" - "+projA);
					reference = rs.getString(4);
					guide = rs.getString(5);
				}
			}
			else
			{
				response.sendRedirect("ErrorPage.html");
			}
			XWPFDocument doc = new XWPFDocument();
			String filePath = "C:/Users/rizwan/Documents/"+gid+".doc";
			File f = new File(filePath);
			FileOutputStream out = new FileOutputStream(f);
	    
		    XWPFParagraph title = doc.createParagraph();
		    title.setBorderBottom(Borders.BASIC_BLACK_DASHES);
		    title.setBorderLeft(Borders.BASIC_BLACK_DASHES);
		    title.setBorderRight(Borders.BASIC_BLACK_DASHES);
		    title.setBorderTop(Borders.BASIC_BLACK_DASHES);
		    title.setAlignment(ParagraphAlignment.CENTER);
		    XWPFRun titleR=title.createRun();
		    titleR.setFontFamily("Times New Roman");
		    titleR.setFontSize(16);
		    titleR.setCapitalized(true);
		    titleR.setBold(true);
		    titleR.setText(projT);
		    
		    XWPFParagraph gidpid = doc.createParagraph();
		    gidpid.setBorderBottom(Borders.BASIC_BLACK_DASHES);
		    XWPFRun gp=gidpid.createRun();
		    gp.setBold(true);
		    gp.setFontFamily("Times New Roman");
		    gp.setFontSize(12);
		    gp.setText("Group ID: "+gid);
		    gp.addBreak();
		    gp.setText("Project ID: "+pid);
		    
		    XWPFParagraph abstractP = doc.createParagraph();
		    abstractP.setBorderBottom(Borders.BASIC_BLACK_DASHES);
		    XWPFRun ap = abstractP.createRun();
		    ap.setItalic(true);
		    ap.setFontSize(12);
		    ap.setFontFamily("Times New Roman");
		    ap.setText("Abstract: -	"+projA);
		    
		    XWPFParagraph guideP = doc.createParagraph();
		    XWPFRun g = guideP.createRun();
		    g.setFontFamily("Times New Roman");
		    g.setFontSize(12);
		    g.setUnderline(UnderlinePatterns.DOUBLE);
		    g.setText("Project Guide: "+guide);
		    
		    XWPFParagraph meme = doc.createParagraph();
		    meme.setBorderTop(Borders.BASIC_BLACK_DASHES);
		    meme.setAlignment(ParagraphAlignment.CENTER);
		    XWPFRun mem = meme.createRun();
		    mem.setFontFamily("Times New Roman");
		    mem.setBold(true);
		    mem.setFontSize(14);
		    mem.setText("Member Information: ");
		    
		    st = con.prepareStatement("select s_id,name,email from student where g_id='"+gid+"'");
		    rs = st.executeQuery();
		    while(rs.next() && i < 4)
		    {
		    	sid[i] = Integer.toString(rs.getInt(1));
		    	name[i] = rs.getString(2);
		    	email[i] = rs.getString(3);
		    	i = i + 1;
		    }
		    
		    XWPFParagraph names = doc.createParagraph();
		    names.setBorderBottom(Borders.BASIC_BLACK_DASHES);
		    XWPFRun nameR = names.createRun();
		    nameR.setFontFamily("Times New Roman");
		    nameR.setFontSize(12);
		    nameR.setText("ID: "+sid[0]+" & Name: "+name[0]);
		    nameR.addBreak();
		    nameR.setText("ID: "+sid[1]+" & Name: "+name[1]);
		    nameR.addBreak();
		    nameR.setText("ID: "+sid[2]+" & Name: "+name[2]);
		    nameR.addBreak();
		    nameR.setText("ID: "+sid[3]+" & Name: "+name[3]);
		    nameR.addBreak();
		    nameR.addBreak();
		    nameR.setText("Reference E-Mail ID: "+email[0]);
		    nameR.addBreak();
		    nameR.setText("Team Leader: "+name[0]);
		    
		    XWPFParagraph refer = doc.createParagraph();
		    refer.setBorderTop(Borders.BASIC_BLACK_DASHES);
		    XWPFRun ref = refer.createRun();
		    ref.setFontFamily("Times New Roman");
		    ref.setFontSize(12);
		    ref.setBold(true);
		    ref.setText("References: "+reference);
		    ref.addBreak();
		    
		    st = con.prepareStatement("select query from query where G_ID='"+gid+"'");
		    rs = st.executeQuery();
		    while(rs.next())
		    {
		    	query = rs.getString(1);
		    }
		    XWPFParagraph q = doc.createParagraph();
		    q.setBorderTop(Borders.BASIC_BLACK_DASHES);
		    XWPFRun que = refer.createRun();
		    que.setFontFamily("Times New Roman");
		    que.setFontSize(12);
		    que.setBold(true);
		    que.setText("Any Queries?: "+query);
		    
		    XWPFParagraph sign = doc.createParagraph();
		    sign.setAlignment(ParagraphAlignment.RIGHT);
		    XWPFRun signR = sign.createRun();
		    signR.setItalic(true);
		    signR.setFontFamily("Times New Roman");
		    signR.setFontSize(12);
		    signR.setText("Project Coordinator");
		    signR.addBreak();
		    signR.setText(coord);
		    
		    doc.write(out);
		    out.close();

		    String to = email[0];
		    String from = "hungundb401@gmail.com";
		    
		    Properties prop = new Properties();
		    prop.put("mail.smtp.host", "smtp.gmail.com");
		    prop.put("mail.smtp.socketFactory.port", "465");
		    prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		    prop.put("mail.smtp.auth", "true");
		    prop.put("mail.smtp.port", "805");
		    
		    
		    Session sess = Session.getDefaultInstance(prop, 
		    	new javax.mail.Authenticator() 
		    	{
		    		@Override
		    		protected PasswordAuthentication getPasswordAuthentication() 
		    		{
		    			return new PasswordAuthentication(from, "iaminco4@#");
		    		}
		    	});
		   
		    try 
		    {
		    	MimeMessage message = new MimeMessage(sess);
		    	message.setFrom(new InternetAddress(from));
		    	message.addRecipient(RecipientType.TO, new InternetAddress(to));
		    	message.setSubject("Your Project \""+projT+"\" is Approved & Verified");
		    	
		    	BodyPart bp = new MimeBodyPart();
		    	bp.setText("Your Group ID is "+gid);
		    	bp.setText("Project Guide is "+guide);
		    	
		    	Multipart mp = new javax.mail.internet.MimeMultipart();
		    	mp.addBodyPart(bp);
		    	
		    	bp = new MimeBodyPart();
		    	DataSource source = new FileDataSource(filePath);
		    	bp.setDataHandler(new DataHandler(source));
		    	bp.setFileName(filePath);
		    	
		    	mp.addBodyPart(bp);
		    	
		    	message.setContent(mp);
		    	
		    	Transport.send(message);
		    	
		    	System.out.println("Send Successfully......");
			} 
		    catch (Exception e) 
		    {
		    	e.printStackTrace();
			}
		    
		    response.sendRedirect("FacultyApproved.jsp");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			response.sendRedirect("ErrorPage.html");
		}
	}
}