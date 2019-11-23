package bankSystem;

import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class BankBrand {
	Scanner sc=new Scanner(System.in);
	int bankID;
	String bName;

	//은행 브랜드 추가
	void createBank() {
		//추가할 은행 브랜드 정보 입력받음
		System.out.println("추가할 은행 브랜드 정보를 입력하세요.");
		System.out.print("은행 브랜드 이름(예: 농협): ");
		bName=sc.nextLine();
		
		//입력받은 은행 브랜드 정보를 DB에 추가
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
		    
		    //입력받은 은행 브랜드 정보를 DB에 추가
		    stmt=conn.prepareStatement("insert into BankBrand(bname, createdate) values(?, now())");
		    stmt.setString(1,bName);
		    if(stmt.executeUpdate()==1){//데이터 추가 실행 후 결과가 참이면
		    	System.out.println("작성한 은행 브랜드 데이터를 DB에 추가 완료\n");
		    }else {//데이터 추가 실행 후 결과가 거짓이면
		    	System.out.println("은행 브랜드 추가 ERROR! 잘못된 데이터를 입력하셨습니다.\n");
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
	
	//은행 브랜드 삭제
	void deleteBank() {
		//삭제할 은행 브랜드 정보에 해당하는 은행 브랜드ID 입력받음
		System.out.print("삭제할 은행 브랜드 정보에 대한 은행 브랜드ID를 입력하세요(예: 1): ");
		bankID=sc.nextInt();
		
		
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
		    
		    //입력받은 은행ID에 해당하는 정보를 DB에서 삭제
		    stmt=conn.prepareStatement("delete from BankBrand where bankid=?");
		    stmt.setInt(1, bankID);
		    if(stmt.executeUpdate()==1){//삭제 실행 후 결과가 참이면
		    	System.out.println("삭제 완료\n");
		    }else {//삭제 실행 후 결과가 거짓이면
		    	System.out.println("은행 브랜드 삭제 ERROR! 잘못된 브랜드ID를 입력하셨습니다.\n");
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

	//은행 브랜드 정보 수정
	void modifyBank() {
		//수정할 은행 브랜드 정보에 해당하는 은행 브랜드ID 입력받음
		System.out.print("수정할 은행 브랜드 정보에 대한 은행 브랜드ID를 입력하세요(예: 1): ");
		bankID=sc.nextInt();
		
		//수정할 정보를 입력받음
		System.out.println("은행 브랜드 정보를 수정하여 입력하세요.");
		sc.nextLine(); //버퍼에 남아있는 엔터값을 비움
		System.out.print("은행 브랜드 이름(예: 농협): ");
		bName=sc.nextLine();
		
		
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
		    
		    //입력받은 은행 브랜드ID에 해당하는 정보를 DB에서 수정
		    stmt=conn.prepareStatement("update BankBrand set bname=? where bankid=?");
		    stmt.setString(1,bName);
		    stmt.setInt(2,bankID);
		    if(stmt.executeUpdate()==1){//수정 실행 후 결과가 참이면
		    	System.out.println("수정 완료\n");
		    }else {//수정 실행 후 결과가 거짓이면
		    	System.out.println("은행 브랜드 정보 수정 ERROR! 잘못된 브랜드ID를 입력하셨습니다.\n");
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
	
	//전체 은행 브랜드 정보 조회
	void searchEntBank() {
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
		    
		    //BankBrand테이블로 부터 모든 은행 브랜드 정보를 조회하여 결과객체에 가져옴
		    stmt=conn.prepareStatement("select * from BankBrand");
		    rs=stmt.executeQuery();
		    
		    System.out.println("=======================================================================");
		    System.out.println("은행ID	은행 이름		생성날짜");
		    System.out.println("-----------------------------------------------------------------------");
		    
		    //결과객체에 정보가 존재하는동안 반복하여 출력
		    while(rs.next())
				System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"		"+rs.getString(3));
		    
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
	
	//은행 브랜드명으로 특정 은행 브랜드 정보 조회
	void searchNameBank() {
		//검색할 은행 브랜드 정보에 해당하는 브랜드명을 입력받음
		System.out.print("검색할 은행 브랜드 정보에 해당하는 브랜드명을 입력하세요(예: 농협): ");
		bName=sc.nextLine();
		
		
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
		    
			//입력받은 브랜드명에 해당하는 레코드를 BankBrand테이블로부터 조회하여 결과객체에 가져옴
		    stmt=conn.prepareStatement("select * from BankBrand where bname=?");
		    stmt.setString(1, bName);
		    rs=stmt.executeQuery();
		    
		    System.out.println("=======================================================================");
		    System.out.println("은행ID	은행 이름		생성날짜");
		    System.out.println("-----------------------------------------------------------------------");
		    
		    //결과객체에 정보가 존재하는동안 반복하여 출력
		    while(rs.next())
		    		System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"		"+rs.getString(3));
				    
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
	
	//은행ID로 특정 은행 브랜드 정보 조회
	void searchIDBank() {
		//검색할 은행 브랜드 정보에 해당하는 은행ID 입력받음
		System.out.print("검색할 은행 브랜드 정보에 해당하는 은행ID를 입력하세요(예: 1): ");
		bankID=sc.nextInt();
		
		
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
		    
			//입력받은 은행ID에 해당하는 레코드를 BankBrand테이블로부터 조회하여 결과객체에 가져옴
		    stmt=conn.prepareStatement("select * from BankBrand where bankid=?");
		    stmt.setInt(1, bankID);
		    rs=stmt.executeQuery();
		    
		    System.out.println("=======================================================================");
		    System.out.println("은행ID	은행 이름		생성날짜");
		    System.out.println("-----------------------------------------------------------------------");
		    
		    //결과객체에 정보가 존재하는동안 반복하여 출력
		    while(rs.next())
		    		System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"		"+rs.getString(3));
				    
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

