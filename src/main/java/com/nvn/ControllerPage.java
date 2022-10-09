package com.nvn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.jdbc.Blob;

@Controller
public class ControllerPage {
	@Autowired
	JdbcTemplate jt;

	// @GetMapping
	@RequestMapping("/getPepole")
	String getPepole(Model m) {
		m.addAttribute("name", "how are you");
		return "bootstrap";

	}

	@RequestMapping("/login")
	String login(Model m) {
		m.addAttribute("name", "how are you");
		return "login/Login";

	}

	@RequestMapping("/registration")
	String registration(Model m) {
		m.addAttribute("name", "how are you");
		return "login/registration";

	}
	
	@RequestMapping(path="/registrationform",method=RequestMethod.POST)
	String registrationform(@RequestParam("name") String name,@RequestParam("id") String id,@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("image") MultipartFile image) throws IOException {
		
				byte[] byt=image.getBytes();
				OutputStream targetFile = new FileOutputStream("E:\\pdf\\" + image.getOriginalFilename() + "");
			    targetFile.write(byt);
			    targetFile.close();
			    String byttimg=byt.toString();
			    String sql="insert into OnlineExamSystem.Registration(id,name,email,password,image) values(?,?,?,?,?)" ;
		  
			
			  int result=jt.update(sql, id,name,email,password,byt);
			  
			  if(result>0)
			  System.out.print("insert successfully");
			 
		 
			/*
			 * System.out.print(name); System.out.print(id); System.out.print(email);
			 * System.out.print(password); System.out.print(image);
			 */
		return"login/login";
		
	}
	
	@RequestMapping(path="/home",method=RequestMethod.POST)
	String loginform(Model m,@RequestParam("email") String email,@RequestParam("password") String password) throws IOException, SQLException {
		int test=0;
		System.out.print(email);
		 Connection con= connection();
		 PreparedStatement ps=con.prepareStatement("select * from onlineexamsystem.registration where  password='"+password+"' AND email='"+email+"'");
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
		 test=1;
		  }
		  if(test==1)
		  {
			  m.addAttribute("email", email);
			  m.addAttribute("password", password);
			  m.addAttribute("loginmassage","Successfully Massage");
			  return"home/Home";
  
		  }
		  else
		  {
			  m.addAttribute("loginmassage","Not Massage"); 
			  return"login/login";
		  }
		 		 
		
		
	}

	/*
	 * @RequestMapping(path="/registrationform",method=RequestMethod.POST) String
	 * registrationform(@RequestParam("name") String name,@RequestParam("id") String
	 * id,@RequestParam("email") String email,@RequestParam("password") String
	 * password,@RequestParam("image") String image) {
	 * 
	 * String
	 * sql="insert into Registration(id,name,email,password,image) values(?,?,?,?,?)"
	 * ; int result=jt.update(sql, id,name,email,password,image); if(result>0)
	 * System.out.print("insert successfully");
	 * 
	 * System.out.print(name); return"login/login";
	 * 
	 * }
	 */
	/*
	 * @RequestMapping("/home") String home(Model m) { m.addAttribute("name",
	 * "how are you"); return "home/Home";
	 * 
	 * }
	 */
	@RequestMapping("/singleprofile")
	String singleprofile(Model m) {
		m.addAttribute("name", "how are you");
		return "student/StudentPost";

	}
	@RequestMapping("/reset")
	String resetclasscode(Model m,@RequestParam("useremail") String useremail,@RequestParam("userpassword") String userpassword) throws SQLException {
		
		 Connection con= connection();
		 String classcode="."+randomstring();
		 String sql="update  onlineExamSystem.classes set classcode='"+classcode+"' where  userpassword='"+userpassword+"' AND useremail='"+useremail+"' " ;
		 PreparedStatement pst = con.prepareStatement(sql);
         pst.executeUpdate();
		
			m.addAttribute("classcode", classcode);
			m.addAttribute("useremail",useremail );
			m.addAttribute("userpassword",userpassword );
			m.addAttribute("invitelink", "http://localhost:8084/login");
			return "admin/AdminPost";

	}

	@RequestMapping("/assignmentpage")
	String assignmentpage(Model m) {
		m.addAttribute("name", "how are you");
		return "student/StudentAssignmentPage";

	}

	@RequestMapping("/adminprofile")
	String adminprofile(Model m,@RequestParam("name") String name,@RequestParam("section") String section,@RequestParam("subject") String subject,@RequestParam("useremail") String useremail,@RequestParam("userpassword") String userpassword) {
		
		 String sql="insert into onlineExamSystem.classes(name,section,subject,useremail,userpassword,classcode,invitelink) values(?,?,?,?,?,?,?)" ;
		  
		 String classcode=randomstring();
			String invitelink="http://localhost:8084/login";
			classcode="."+classcode;
		  int result=jt.update(sql,name,section,subject,useremail,userpassword,classcode,invitelink);
		  
		  if(result>0)
		m.addAttribute("useremail",useremail );
		m.addAttribute("userpassword",userpassword );
		m.addAttribute("classcode", classcode);
        m.addAttribute("invitelink", invitelink);
		return "admin/AdminPost";

	}

	@RequestMapping("/AssignmentViewResultPage")
	String AssignmentViewResultPage(Model m) {
		m.addAttribute("name", "how are you");
		return "admin/AssignmentViewResultPage";

	}

	@RequestMapping("/imageshow")
	public String databasedata(Model m) throws IOException, SQLException {
		
		 try {
		  Connection con= connection();
		  String namep="";
		  File file;
		  FileOutputStream fos = null;
		  byte b[] = null;
		  Blob blob;
		  PreparedStatement ps=con.prepareStatement("select name, image from onlineexamsystem.registration where id=6");
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
		  namep=rs.getString("name");  
		  blob=(Blob) rs.getBlob("image");
		  b=blob.getBytes(1,(int)blob.length());
		  file=new File("H:\\SpringBoot\\project forder\\OnlineExamSystem\\src\\main\\resources\\static\\image/"+namep+".png");
		  fos=new FileOutputStream(file);
		  fos.write(b);
		  }
		  m.addAttribute("name","/image/"+namep+".png");
		  ps.close();
		  fos.close();
		  con.close();
		  
		  } catch (SQLException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
		 
	
		return("student/img");
			

	}

//	@RequestMapping(path="/form",method=RequestMethod.POST)
//	public String form(HttpServletRequest re)
//	{
//		String email=re.getParameter("email");
//		String password=re.getParameter("password");
//		System.out.print(email);
//		System.out.print(password);
//		return "";
//		
//	}
	@RequestMapping(path = "/form", method = RequestMethod.POST)
	public String Form(@RequestParam("email") String email, @RequestParam("password") String password) {
		System.out.print(email);
		System.out.print(password);
		return "index";

	}
	String randomstring()
	{
		 int leftLimit = 48; // numeral '0'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 7;
		    Random random = new Random();

		    String classcode = random.ints(leftLimit, rightLimit + 1)
		      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		      .limit(targetStringLength)
		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		      .toString();
		    return classcode;
	}
	Connection connection() throws SQLException
	{
		return(DriverManager.getConnection("jdbc:mysql://localhost/onlineexamsystem","root","root"));
	}
}
