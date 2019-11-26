/*
만든이: 2017038023 반예린
해당 소스파일 정보: 은행 지점에 대한 기능.
			 지점 추가, 지점 삭제, 지점 정보 수정, 지점 정보 조회에 대한 기능 구현
*/

package bankSystem;

import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class BankBranch {
	Scanner sc=new Scanner(System.in);
	BankBrand bankBrand=new BankBrand();
	int branchID;
	int bankID;
	String location;
	String tel;
	
	
	//지점 추가
	void createBranch() {
		//추가할 은행 지점 정보 입력받음
		System.out.println("추가할 은행 지점에 대한 정보를 입력하세요.");
		System.out.print("은행 브랜드ID(예: 1): ");
		bankID=sc.nextInt();
		sc.nextLine(); //버퍼에 남아있는 엔터값을 비움
		System.out.print("지점 위치(예: 충북): ");
		location=sc.nextLine();
		System.out.print("지점 전화번호(예: 043-123-1234): ");
		tel=sc.nextLine();
		
		
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
		    
		    //입력받은 지점 정보를 DB에 추기
		    stmt=conn.prepareStatement("insert into BankBranch(bankid, loc, tel, createdate) values(?,?,?,now())");
		    stmt.setInt(1,bankID);
		    stmt.setString(2,location);
		    stmt.setString(3,tel);
		    if(stmt.executeUpdate()==1){//데이터 추가 실행 후 결과가 참이면
		    	System.out.println("작성한 지점 데이터를 DB에 추가 완료\n");
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
	
	//지점 삭제
	void deleteBranch() {
		//삭제할 은행 지점 정보에 대한 지점ID를 입력받음
		System.out.print("삭제할 은행 지점 정보에 대한 지점ID를 입력하세요(예: 1): ");
		branchID=sc.nextInt();
		sc.nextLine(); //버퍼에 남아있는 엔터값을 비움
		
				
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
		    
		    //입력받은 지점ID에 해당하는 정보를 DB에서 삭제
		    stmt=conn.prepareStatement("delete from BankBranch where branchid=?");
		    stmt.setInt(1, branchID);
		    if(stmt.executeUpdate()==1){//삭제 실행 후 결과가 참이면
		    	System.out.println("삭제 완료\n");
		    }else {//삭제 실행 후 결과가 거짓이면
		    	System.out.println("지점 삭제 ERROR! 잘못된 지점ID를 입력하셨습니다.\n");
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

	//지점 정보 수정
	void modifyBranch() {
		//수정할 은행 지점 정보에 대한 지점ID를 입력받음
		System.out.print("수정할 은행 지점 정보에 대한 지점ID를 입력하세요(예: 1): ");
		branchID=sc.nextInt();
		sc.nextLine(); //버퍼에 남아있는 엔터값을 비움
		
		//수정할 은행 지점 정보 입력받음
		System.out.println("수정할 은행 지점에 대한 정보를 입력하세요.");
		System.out.print("은행 브랜드ID(예: 1): ");
		bankID=sc.nextInt();
		sc.nextLine(); //버퍼에 남아있는 엔터값을 비움
		System.out.print("지점 위치(예: 충북): ");
		location=sc.nextLine();
		System.out.print("지점 전화번호(예: 043-123-1234): ");
		tel=sc.nextLine();
				
						
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
		    
		    //입력받은 은행 지점ID에 해당하는 정보를 DB에서 수정
		    stmt=conn.prepareStatement("update BankBranch set bankid=?, loc=?, tel=? where branchid=?");
		    stmt.setInt(1,bankID);
		    stmt.setString(2,location);
		    stmt.setString(3,tel);
		    stmt.setInt(4,branchID);
		    if(stmt.executeUpdate()==1){//수정 실행 후 결과가 참이면
		    	System.out.println("수정 완료\n");
		    }else {//수정 실행 후 결과가 거짓이면
		    	System.out.println("지점 정보 수정 ERROR! 잘못된 지점ID를 입력하셨습니다.\n");
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
	
	//전체 지점 정보 조회
	void searchEntBranch() {
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
		    
		    //BankBranch와 BankBrand를 조인한 테이블로 부터 모든 지점정보를 조회하여 결과객체에 가져옴
		    stmt=conn.prepareStatement("select branchid, bname, loc, tel, branch.createdate from BankBranch branch, BankBrand brand where branch.bankid=brand.bankid");
		    rs=stmt.executeQuery();
		    
		    System.out.println("=======================================================================");
		    System.out.println("지점ID	브랜드	위치	전화번호		개설날짜");
		    System.out.println("-----------------------------------------------------------------------");
		    
		    //결과객체에 정보가 존재하는동안 반복하여 출력
		    while(rs.next())
				System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getString(4)+"	"+rs.getString(5));
		    
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
	
	//지점 위치로 특정 지점 정보 조회
	void searchLocBranch() {
		//검색할 은행 지점 정보에 대한 위치를 입력받음
		System.out.print("검색할 은행 지점 정보에 대한 위치를 입력하세요(예: 충북): ");
		location=sc.nextLine();
				
		
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
		    
		    //입력받은 위치에 해당하는 레코드를 BankBranch와 BankBrand를 조인한 테이블로 부터 조회하여 결과객체에 가져옴
		    stmt=conn.prepareStatement("select branchid, bname, loc, tel, branch.createdate from BankBranch branch, BankBrand brand where branch.bankid=brand.bankid and loc=?");
		    stmt.setString(1, location);
		    rs=stmt.executeQuery();
		    
		    System.out.println("=======================================================================");
		    System.out.println("지점ID	브랜드	위치	전화번호		개설날짜");
		    System.out.println("-----------------------------------------------------------------------");
		    
		    //결과객체에 정보가 존재하는동안 반복하여 출력
		    while(rs.next())
		    	System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getString(4)+"	"+rs.getString(5));
				    
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
	
	//은행 지점이 속한 브랜드명으로 특정 지점 정보 조회
	void searchBrandBranch() {
		//검색할 은행 지점 정보가 속한 브랜드명을 입력받음
		System.out.print("검색할 은행 지점 정보가 속한 브랜드명을 입력하세요(예: 농협): ");
		String bName=sc.nextLine();
		
		
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
		    
		    //입력받은 브랜드명 해당하는 레코드를 BankBranch와 BankBrand를 조인한 테이블로 부터 조회하여 결과객체에 가져옴
		    stmt=conn.prepareStatement("select branchid, bname, loc, tel, branch.createdate from BankBranch branch, BankBrand brand where branch.bankid=brand.bankid and bname=?");
		    stmt.setString(1, bName);
		    rs=stmt.executeQuery();
		    
		    System.out.println("=======================================================================");
		    System.out.println("지점ID	브랜드	위치	전화번호		개설날짜");
		    System.out.println("-----------------------------------------------------------------------");
		    
		    //결과객체에 정보가 존재하는동안 반복하여 출력
		    while(rs.next())
		    	System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getString(4)+"	"+rs.getString(5));
				    
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
	
	//지점ID로 특정 지점 정보 조회
	void searchIDBranch() {
		//검색할 지점 정보에 해당하는 지점ID를 입력받음
		System.out.print("검색할 지점 정보에 해당하는 지점ID를 입력하세요(예: 1): ");
		branchID=sc.nextInt();
		sc.nextLine(); //버퍼에 남아있는 엔터값을 비움
		
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
		    
		    //입력받은 지점ID에 해당하는 레코드를 BankBranch와 BankBrand를 조인한 테이블로 부터 조회하여 결과객체에 가져옴
		    stmt=conn.prepareStatement("select branchid, bname, loc, tel, branch.createdate from BankBranch branch, BankBrand brand where branch.bankid=brand.bankid and branchid=?");
		    stmt.setInt(1, branchID);
		    rs=stmt.executeQuery();
		    
		    System.out.println("=======================================================================");
		    System.out.println("지점ID	브랜드	위치	전화번호		개설날짜");
		    System.out.println("-----------------------------------------------------------------------");
		    
		    //결과객체에 정보가 존재하는동안 반복하여 출력
		    while(rs.next())
		    	System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getString(4)+"	"+rs.getString(5));
				    
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
