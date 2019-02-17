package com.project.models;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import com.project.controllers.ConnectionProvider;

public class UserModel {
	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	 Date today = Calendar.getInstance().getTime();
	
	
	private String un;
	private String up;
	private String fn;
	private String ln;
	private String ts;
	private String tc;
	private String ti;
	private String te;
	private String tt;
	private float attendance;
	private String sem;
	private int rank;
	private String status;
	private String batch;
	private String regdate;
	private String regupto;
	private int seq;
	private String dob;
	private String gender;
	private String email;
	private String contactno;
	private String address;
	private String city;
	private String state;

	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContactno() {
		return contactno;
	}


	public void setContactno(String contactno) {
		this.contactno = contactno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getBatch() {
		return batch;
	}


	public void setBatch(String batch) {
		this.batch = batch;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	public String getRegupto() {
		return regupto;
	}


	public void setRegupto(String regupto) {
		this.regupto = regupto;
	}


	public String getTs() {
		return ts;
	}


	public void setTs(String ts) {
		this.ts = ts;
	}


	public String getTc() {
		return tc;
	}


	public void setTc(String tc) {
		this.tc = tc;
	}


	public String getTi() {
		return ti;
	}


	public void setTi(String ti) {
		this.ti = ti;
	}


	public String getTe() {
		return te;
	}


	public void setTe(String te) {
		this.te = te;
	}


	public String getTt() {
		return tt;
	}


	public void setTt(String tt) {
		this.tt = tt;
	}

	



	
	
	public float getAttendance() {
		return attendance;
	}


	public void setAttendance(float attendance) {
		this.attendance = attendance;
	}


	public String getSem() {
		return sem;
	}


	public void setSem(String sem) {
		this.sem = sem;
	}


	
	public String getUn() {
		return un;
	}


	public void setUn(String un) {
		this.un = un;
	}


	public String getUp() {
		return up;
	}


	public void setUp(String up) {
		this.up = up;
	}


	public String getFn() {
		return fn;
	}


	public void setFn(String fn) {
		this.fn = fn;
	}


	public String getLn() {
		return ln;
	}


	public void setLn(String ln) {
		this.ln = ln;
	}

	String m;
	String fullname;
	String a[]=new String[3];
	String chpass;
	public String[] login()
	{
	
	
			try {
				Connection conn = ConnectionProvider.getConn();
				PreparedStatement ps = conn.prepareStatement("select * from login_table where username=? and password=?");
				ps.setString(1,getUn());
				ps.setString(2,getUp());
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					fullname=rs.getString(3)+ " " +rs.getString(4);;
					chpass=rs.getString(2);
					m="success";
					a[0]=m;
					a[1]=fullname;
					a[2]=chpass;
				}
				else{
					
					m="failed";
					a[0]=m;
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return a;
		}
	
	
	public String password()
	{
		try
		{
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("update login_table set password=? where username=?");
			ps.setString(1,getUp());
			ps.setString(2,getUn());
			int i=ps.executeUpdate();
			if(i==0)
			{
				m="failed";
			}
			else
			{
				m="success";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}
	
	
	public String register()
	{
		try{
		
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("insert into login_table values(?,?,?,?,?)");
			ps.setString(1,getUn());
			ps.setString(2,getUp());
			ps.setString(3,getFn());
			ps.setString(4,getLn());
			ps.setString(5, formatter.format(today));
			int i=ps.executeUpdate();
			if(i==0)
			{
				m="failed";
			}
			else
			{
				m="success";
			}			
		}catch(Exception e)
		{
			m="failed1";
		}
		return m;
	}
	
	public String alter()
	{
		try{
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("update login_table set password=?,firstname=?,lastname=? where username=?");
			ps.setString(1,getUp());
			ps.setString(2,getFn());
			ps.setString(3,getLn());
			ps.setString(4,getUn());
			int i=ps.executeUpdate();
			if(i==0)
			{
				m="failed";
			}
			else
			{
				m="success";
			}		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}
	public String delete()
	{
		try{
			//Deleting user details from course table
			
			
			Connection conn10 = ConnectionProvider.getConn();
			PreparedStatement ps10 = conn10.prepareStatement("delete from course_detail where username=?");
			ps10.setString(1,getUn());
			ps10.executeUpdate();
			
			
			//Deleting profile picture
			
			Connection conn19 = ConnectionProvider.getConn();
			PreparedStatement ps19 = conn19.prepareStatement("delete from userdp where username=?");
			ps19.setString(1,getUn());
			ps19.executeUpdate();
			
			//Deleting user details from student table
			
			Connection conn11 = ConnectionProvider.getConn();
			PreparedStatement ps11 = conn11.prepareStatement("delete from student_detail where username=?");
			ps11.setString(1,getUn());
			ps11.executeUpdate();
			
			//Deleting user details from attendance table
			
			Connection conn12 = ConnectionProvider.getConn();
			PreparedStatement ps12 = conn12.prepareStatement("delete from attendance_detail where username=?");
			ps12.setString(1,getUn());
			ps12.executeUpdate();
			
			//Deleting User Data from Result Table
			Connection conn13 = ConnectionProvider.getConn();
			PreparedStatement ps13 = conn13.prepareStatement("delete from result_table where username=?");
			ps13.setString(1,getUn());
			ps13.executeUpdate();
			
			
			//Finally Deleting from Login Table
			Connection conn20 = ConnectionProvider.getConn();
			PreparedStatement ps20 = conn20.prepareStatement("alter table login_table disable primary key cascade");
			ps20.executeUpdate();
			Connection conn1 = ConnectionProvider.getConn();
			PreparedStatement ps1 = conn1.prepareStatement("delete from login_table where username=?");
			ps1.setString(1,getUn());
			
			int i=ps1.executeUpdate();
			if(i==0)
			{
				m="failed";
			}
			else
			{
				
				Connection conn21 = ConnectionProvider.getConn();
				PreparedStatement ps21 = conn21.prepareStatement("alter table login_table enable primary key");
				ps21.executeUpdate();
				
				m="success";
			}		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}
	
	public String photo()
	{
		try{
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("insert into user_dp values(?,?)");
			ps.setString(1,getUn());
			
			int i=ps.executeUpdate();
			if(i==0)
			{
				m="failed";
			}
			else
			{
				m="success";
			}		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}
	
	public String uploadattendance()
	{
		try
	
		{
			Connection conn = ConnectionProvider.getConn();
			
			
			String sql="insert into attendance_detail values('"+getUn()+"','"+getSem()+"',"+getAttendance()+")";

			
			PreparedStatement ps = conn.prepareStatement("insert into attendance_detail values(?,?,?)");
			
			System.out.println("Attendance : "+getAttendance());
			System.out.println("User Name : "+getUn()+" "+getUn().length());
			System.out.println("Semester : "+getSem());
			
			
			ps.setString(1,getUn());
			ps.setString(2,getSem());
			
			ps.setFloat(3,getAttendance());
			System.out.println(getUn());
			
			System.out.println(getSem());
			System.out.println(getAttendance());
			
			int i=ps.executeUpdate();
			if(i==0)
			{
				m="failed";
			}
			else
			{
				m="success";
			}		
		}catch(Exception e)
		{
			e.printStackTrace();
			m="failed1";
		}
		return m;
	}
	
	public String modifyattendance()
	{
		try
		{
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("update attendance_detail set attendance=? where username=? and semester=?");
			ps.setFloat(1,getAttendance());
			ps.setString(2,getUn());
			ps.setString(3,getSem());
			System.out.println(getAttendance());
			System.out.println(getUn());
			System.out.println(getSem());
			int i=ps.executeUpdate();
			if(i==0)
			{
				m="failed";
			}
			else
			{
				m="success";
			}		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}
	public String uploadResult()
	{
		try
		{
			Connection conn1=ConnectionProvider.getConn();
			PreparedStatement ps1=conn1.prepareStatement("select username,course from course_detail where username=? and course=?");
			ps1.setString(1,getUn());
			ps1.setString(2,getTc());
			ResultSet rs=ps1.executeQuery();
			if(rs.next())
			{
				
					Connection conn=ConnectionProvider.getConn();
					PreparedStatement ps=conn.prepareStatement("insert into result_table values(?,?,?,?,?,?)");
					ps.setString(1,getUn());
					ps.setString(2,getTs());
					ps.setString(3,getTc());
					ps.setString(4,getTi());
					ps.setString(5,getTe());
					ps.setString(6,getTt());
					
					int i=ps.executeUpdate();
					if(i==0)
					{
						m="failed";
						
					}
					else
					{
						m="success";
					}
				}
			else
			{
				m="failed2";
			}
		}
		catch(Exception e)
		{
			m="failed1";
		}
		return m;
	}
	public String modifyResult()
	{
		try
		{
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("update result_table set internal=?,external=?,total=? where username=?");
		
		
			ps.setString(1,getTi());
			ps.setString(2,getTe());
			ps.setString(3,getTt());
			ps.setString(4,getUn());
			
			int i=ps.executeUpdate();
			if(i!=0)
			{
				m="Success";
			}
			else
			{
				m="Failed";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}
	public String courseReg()
	{
		try
		{
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("insert into course_detail values(?,?,?,?,?,?,?,?)");
			ps.setString(1,getUn());
			ps.setString(2,getTc());
			ps.setInt(3,getRank());
			ps.setString(4,getStatus());
			ps.setString(5,getTs());
			ps.setString(6,getBatch());
			ps.setString(7,getRegdate());
			ps.setString(8,getRegupto());
			
			int i=ps.executeUpdate();
			if(i==0)
			{
				m="Failed";
			}
			else
			{
				m="Success";
			}
		}
		catch(Exception e)
		{
			m="failed1";
		}
		return m;
	}
	
	
	public String deleterule()
	{
		try
		{
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("delete photo from rule_table where contact_id='1'");
			int i=ps.executeUpdate();
			if(i==0)
			{
				m="Failed";
			}
			else
			{
				m="Success";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}
	public String deletesyllabus()
	{
		try
		{
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("delete from syllabus_detail where contact_id=?");
			ps.setInt(1,getSeq());
			int i=ps.executeUpdate();
			if(i==0)
			{
				m="failed";
			}
			else
			{
				m="success";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}
	 
	
	public String personalReg()
	{
		try
		{
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("insert into student_detail values(?,?,?,?,?,?,?,?)");
			ps.setString(1,getUn());
			ps.setString(2,getDob());
			ps.setString(3,getGender());
			ps.setString(4,getEmail());
			ps.setString(5,getContactno());
			ps.setString(6,getAddress());
			ps.setString(7,getCity());
			ps.setString(8,getState());
			
			int i=ps.executeUpdate();
			if(i!=0)
			{
				m="success";
			}
			else
			{
				m="failed";
			}
		}
		catch(Exception e)
		{
			m="failed1";
		}
		return m;
	}
}
