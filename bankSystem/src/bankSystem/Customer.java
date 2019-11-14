package bankSystem;

import java.sql.*;
import java.io.*;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Customer {
	Scanner sc=new Scanner(System.in);
	int custID;
	String cName;
	String gender;
	String tel;
	String addr;
	
	void createCus() {
		//추가할 고객 정보 입력받음
		System.out.println("추가할 고객 정보를 입력하세요.");
		System.out.print("이름: ");
		cName=sc.nextLine();
		System.out.print("성별(남 or 여): ");
		gender=sc.nextLine();
		System.out.print("전화번호(예:010-1234-1234): ");
		tel=sc.nextLine();
		System.out.print("주소(예:충북): ");
		addr=sc.nextLine();
		
		
		//DB연결을 위한 설정
		String dbUrl = "jdbc:mysql://192.168.56.101:4567/bank_system";
		String dbUser = "xlvl98";
		String dbPw = "0520";
		Connection conn = null;
		PreparedStatement stmt=null; //SQL문을 사용하기위한 객체
		ResultSet rs=null; //결과객체
		
		try {
			//DB연결 작업
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
		    System.out.println("DB연결완료");
		    
		    //입력받은 고객 정보를 DB에 추가
		    stmt=conn.prepareStatement("insert into Customer(cname, gender, tel, addr, joindate) values(?,?,?,?,now())");
		    stmt.setString(1,cName);
		    stmt.setString(2,gender);
		    stmt.setString(3,tel);
		    stmt.setString(4,addr);
		    if(stmt.executeUpdate()==1){//데이터 추가 실행 후 결과가 참이면
		    	System.out.println("작성한 고객 데이터를 DB에 추가 완료\n");
		    }
		} catch(Exception e) {
			System.out.println(e);
		    System.out.println("DB ERROR!");
		} finally {
		    try {stmt.close();} catch(Exception e){}
		    try {conn.close();} catch(Exception e){}
		}
		
		return;
	}
	
	void deleteCus() {
		//삭제할 고객 정보에 해당하는 고객ID 입력받음
		System.out.print("삭제할 고객 정보에 대한 고객ID를 입력하세요(예: 1): ");
		custID=sc.nextInt();
		
		
		//DB연결을 위한 설정
		String dbUrl = "jdbc:mysql://192.168.56.101:4567/bank_system";
		String dbUser = "xlvl98";
		String dbPw = "0520";
		Connection conn = null;
		PreparedStatement stmt=null; //SQL문을 사용하기위한 객체
		ResultSet rs=null; //결과객체
		
		try {
			//DB연결 작업
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
		    System.out.println("DB연결완료");
		    
		    //입력받은 고객ID에 해당하는 정보를 DB에서 삭제
		    stmt=conn.prepareStatement("delete from Customer where custid=?");
		    stmt.setInt(1, custID);
		    if(stmt.executeUpdate()==1){//삭제 실행 후 결과가 참이면
		    	System.out.println("삭제 완료\n");
		    }
		    
		    
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("DB ERROR!");
		} finally {
			try {stmt.close();} catch(Exception e){}
			try {conn.close();} catch(Exception e){}
		}		
		
		return;
	}

	void modifyCus() {
		//수정할 고객 정보에 해당하는 고객ID 입력받음
		System.out.print("수정할 고객 정보에 대한 고객ID를 입력하세요(예: 1): ");
		custID=sc.nextInt();
		
		//수정할 정보를 입력받음
		System.out.println("고객 정보를 수정하여 입력하세요.");
		sc.nextLine(); //버퍼에 남아있는 엔터값을 비움
		System.out.print("이름: ");
		cName=sc.nextLine();
		System.out.print("성별(남 or 여): ");
		gender=sc.nextLine();
		System.out.print("전화번호(예:010-1234-1234): ");
		tel=sc.nextLine();
		System.out.print("주소(예:충북): ");
		addr=sc.nextLine();
		
		
		//DB연결을 위한 설정
		String dbUrl = "jdbc:mysql://192.168.56.101:4567/bank_system";
		String dbUser = "xlvl98";
		String dbPw = "0520";
		Connection conn = null;
		PreparedStatement stmt=null; //SQL문을 사용하기위한 객체
		ResultSet rs=null; //결과객체
		
		try {
			//DB연결 작업
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
		    System.out.println("DB연결완료");
		    
		    //입력받은 고객ID에 해당하는 정보를 DB에서 수정
		    stmt=conn.prepareStatement("update Customer set cname=?, gender=?, tel=?, addr=? where custid=?");
		    stmt.setString(1,cName);
		    stmt.setString(2,gender);
		    stmt.setString(3,tel);
		    stmt.setString(4,addr);
		    stmt.setInt(5,custID);
		    if(stmt.executeUpdate()==1){//수정 실행 후 결과가 참이면
		    	System.out.println("수정 완료\n");
		    }
		} catch(Exception e) {
			System.out.println(e);
		    System.out.println("DB ERROR!");
		} finally {
		    try {stmt.close();} catch(Exception e){}
		    try {conn.close();} catch(Exception e){}
		}
		
		return;
	}
	
	//전체 고객 정보 조회
	void searchEntCus() {
		//DB연결을 위한 설정
		String dbUrl = "jdbc:mysql://192.168.56.101:4567/bank_system";
		String dbUser = "xlvl98";
		String dbPw = "0520";
		Connection conn = null;
		PreparedStatement stmt=null; //SQL문을 사용하기위한 객체
		ResultSet rs=null; //결과객체
		
		try {
			//DB연결 작업
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
		    System.out.println("DB연결완료");
		    
		    //Customer테이블로 부터 모든 고객정보를 조회하여 결과객체에 가져옴
		    stmt=conn.prepareStatement("select * from Customer");
		    rs=stmt.executeQuery();
		    
		    System.out.println("=======================================================================");
		    System.out.println("고객ID	고객 이름	성별		가입날짜		전화번호		주소");
		    System.out.println("-----------------------------------------------------------------------");
		    
		    //결과객체에 정보가 존재하는동안 반복하여 출력
		    while(rs.next())
				System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getString(4)+"	"+rs.getString(5)+"	"+rs.getString(6));
		    
		    System.out.println("=======================================================================");
		    
		    System.out.println("조회 완료\n"); 
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("DB ERROR!");
		} finally {
			try {stmt.close();} catch(Exception e){}
			try {conn.close();} catch(Exception e){}
		}
		return;
	}

	//고객 이름으로 특정 고객 정보 조회
	void searchNameCus() {
		//검색할 고객 정보에 해당하는 고객이름 입력받음
		System.out.print("검색할 고객 정보에 해당하는 고객 이름을 입력하세요(예: 도라에몽): ");
		cName=sc.nextLine();
		
		
		//DB연결을 위한 설정
		String dbUrl = "jdbc:mysql://192.168.56.101:4567/bank_system";
		String dbUser = "xlvl98";
		String dbPw = "0520";
		Connection conn = null;
		PreparedStatement stmt=null; //SQL문을 사용하기위한 객체
		ResultSet rs=null; //결과객체
		
		try {
			//DB연결 작업
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
		    System.out.println("DB연결완료");
		    
			//입력받은 고객이름에 해당하는 레코드를 Customer테이블로부터 조회하여 결과객체에 가져옴
		    stmt=conn.prepareStatement("select * from Customer where cname=?");
		    stmt.setString(1, cName);
		    rs=stmt.executeQuery();
		    
		    System.out.println("=======================================================================");
		    System.out.println("고객ID	고객 이름	성별		가입날짜		전화번호		주소");
		    System.out.println("-----------------------------------------------------------------------");
		    
		    //결과객체에 정보가 존재하는동안 반복하여 출력
		    while(rs.next())
		    	System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getString(4)+"	"+rs.getString(5)+"	"+rs.getString(6));
				    
				    System.out.println("=======================================================================");
				    
				    System.out.println("조회 완료!\n"); 
				} catch(Exception e) {
					System.out.println(e);
					System.out.println("DB ERROR!");
				} finally {
					try {stmt.close();} catch(Exception e){}
					try {conn.close();} catch(Exception e){}
				}
		
		return;
	}
	
	//고객ID로 특정 고객 정보 조회
	void searchIDCus() {
		//검색할 고객 정보에 해당하는 고객ID 입력받음
		System.out.print("검색할 고객 정보에 해당하는 고객ID를 입력하세요(예: 1): ");
		custID=sc.nextInt();
		
		
		//DB연결을 위한 설정
		String dbUrl = "jdbc:mysql://192.168.56.101:4567/bank_system";
		String dbUser = "xlvl98";
		String dbPw = "0520";
		Connection conn = null;
		PreparedStatement stmt=null; //SQL문을 사용하기위한 객체
		ResultSet rs=null; //결과객체
		
		try {
			//DB연결 작업
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
		    System.out.println("DB연결완료");
		    
			//입력받은 고객ID에 해당하는 레코드를 Customer테이블로부터 조회하여 결과객체에 가져옴
		    stmt=conn.prepareStatement("select * from Customer where custid=?");
		    stmt.setInt(1, custID);
		    rs=stmt.executeQuery();
		    
		    System.out.println("=======================================================================");
		    System.out.println("고객ID	고객 이름	성별		가입날짜		전화번호		주소");
		    System.out.println("-----------------------------------------------------------------------");
		    
		    //결과객체에 정보가 존재하는동안 반복하여 출력
		    while(rs.next())
		    	System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getString(4)+"	"+rs.getString(5)+"	"+rs.getString(6));
				    
				    System.out.println("=======================================================================");
				    
				    System.out.println("조회 완료!\n"); 
				} catch(Exception e) {
					System.out.println(e);
					System.out.println("DB ERROR!");
				} finally {
					try {stmt.close();} catch(Exception e){}
					try {conn.close();} catch(Exception e){}
				}
		
		return;
	}
}
