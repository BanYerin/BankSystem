package bankSystem;

import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class Account {
	Scanner sc=new Scanner(System.in);
	BankBranch bankBranch=new BankBranch();
	int accID;
	int branchID;
	int custID;
	String createDate;
	int asset=0;
	
	//계좌 추가
	void createAcct() {
		//추가할 계좌 정보 입력받음
		System.out.println("추가할 계좌 정보를 입력하세요.");
		System.out.print("계좌를 개설한 지점ID(예: 1): ");
		branchID=sc.nextInt();
		System.out.print("계좌 주인의 고객ID(예: 1): ");
		custID=sc.nextInt();
		System.out.print("계좌 초기 잔액(예: 20000): ");
		asset=sc.nextInt();
		
		
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
		    
		    //입력받은 계좌 정보를 DB에 추기
		    stmt=conn.prepareStatement("insert into Account(branchid, custid, asset, createdate) values(?,?,?,now())");
		    stmt.setInt(1,branchID);
		    stmt.setInt(2,custID);
		    stmt.setInt(3,asset);
		    
		    if(stmt.executeUpdate()==1){//데이터 추가 실행 후 결과가 참이면
		    	System.out.println("작성한 계좌 데이터를 DB에 추가 완료\n");
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
	
	//계좌 삭제
	void deleteAcct() {
		//삭제할 계좌 정보에 대한 계좌ID를 입력받음
		System.out.print("삭제할 계좌 정보에 대한 계좌ID를 입력하세요(예: 1): ");
		accID=sc.nextInt();
		
				
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
		    
		    //입력받은 계좌ID에 해당하는 정보를 DB에서 삭제
		    stmt=conn.prepareStatement("delete from Account where accid=?");
		    stmt.setInt(1, accID);
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

	//계좌 정보 수정
	void modifyAcct() {
		//수정할 은행 지점 정보에 대한 지점ID를 입력받음
		System.out.print("수정할 계좌 정보에 대한 계좌ID를 입력하세요(예: 1): ");
		accID=sc.nextInt();
		
		//수정할 계좌 정보 입력받음
		System.out.println("수정할 계좌에 대한 정보를 입력하세요.");
		System.out.print("계좌를 개설한 지점ID(예: 1): ");
		branchID=sc.nextInt();
		System.out.print("계좌 주인의 고객ID(예: 1): ");
		custID=sc.nextInt();
		System.out.print("계좌 초기 잔액(예: 20000): ");
		asset=sc.nextInt();
				
								
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
		    
		    //입력받은 계좌ID에 해당하는 정보를 DB에서 수정
		    stmt=conn.prepareStatement("update Account set branchid=?, custid=?, asset=? where accid=?");
		    stmt.setInt(1,branchID);
		    stmt.setInt(2,custID);
		    stmt.setInt(3,asset);
		    stmt.setInt(4,accID);
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
	
	//전체 계좌정보 조회
	void searchEntAcct() {
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
		    
		    //Account, Customer, BankBranch, BankBrand를 조인한 테이블로 부터 모든 계좌정보를 조회하여 결과객체에 가져옴
		    stmt=conn.prepareStatement("select accid, account.custid, cname, account.branchid, bname, loc, asset, account.createdate from Account account, BankBranch branch, BankBrand brand, Customer customer where account.branchid=branch.branchid and account.custid=customer.custid and branch.bankid=brand.bankid");
		    rs=stmt.executeQuery();
		    
		    System.out.println("=======================================================================================");
		    System.out.println("계좌ID	고객ID	고객 이름	지점ID	브랜드	지점위치	잔액		개설날짜");
		    System.out.println("---------------------------------------------------------------------------------------");
		    
		    //결과객체에 정보가 존재하는동안 반복하여 출력
		    while(rs.next())
				System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getString(4)+"	"+rs.getString(5)+"	"+rs.getString(6)+"	"+rs.getString(7)+"		"+rs.getString(8));
		    
		    System.out.println("=======================================================================================");
		    
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
	
	//고객 이름으로 특정 계좌정보 조회
	void searchNameAcct() {
		//검색할  계좌 정보에 대한  고객명을 입력받음
		System.out.print("검색할 계좌 정보에 대한 고객명을 입력하세요(예: 도라에몽): ");
		String cName=sc.nextLine();
		
		
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
		    
		    //입력받은 고객명에 해당하는 레코드를 Account, Customer, BankBranch, BankBrand를 조인한 테이블로 부터 조회하여 결과객체에 가져옴
		    stmt=conn.prepareStatement("select accid, account.custid, cname, account.branchid, bname, loc, asset, account.createdate from Account account, BankBranch branch, BankBrand brand, Customer customer where account.branchid=branch.branchid and account.custid=customer.custid and branch.bankid=brand.bankid and cname=?");
		    stmt.setString(1, cName);
		    rs=stmt.executeQuery();
		    
		    System.out.println("=======================================================================================");
		    System.out.println("계좌ID	고객ID	고객 이름	지점ID	브랜드	지점위치	잔액		개설날짜");
		    System.out.println("---------------------------------------------------------------------------------------");
		    
		    //결과객체에 정보가 존재하는동안 반복하여 출력
		    while(rs.next())
		    	System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getString(4)+"	"+rs.getString(5)+"	"+rs.getString(6)+"	"+rs.getString(7)+"		"+rs.getString(8));
		    
		    System.out.println("=======================================================================================");
					    
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
	
	//계좌ID로 특정 계좌정보 조회
	void searchIDAcct() {
		//검색할  계좌 정보에 대한  계좌ID를 입력받음
		System.out.print("검색할 계좌 정보에 대한 계좌ID를 입력하세요(예: 1): ");
		accID=sc.nextInt();
		
		
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
		    
		    //입력받은 계좌ID에 해당하는 레코드를 Account, Customer, BankBranch, BankBrand를 조인한 테이블로 부터 조회하여 결과객체에 가져옴
		    stmt=conn.prepareStatement("select accid, account.custid, cname, account.branchid, bname, loc, asset, account.createdate from Account account, BankBranch branch, BankBrand brand, Customer customer where account.branchid=branch.branchid and account.custid=customer.custid and branch.bankid=brand.bankid and accid=?");
		    stmt.setInt(1, accID);
		    rs=stmt.executeQuery();
		    
		    System.out.println("=======================================================================================");
		    System.out.println("계좌ID	고객ID	고객 이름	지점ID	브랜드	지점위치	잔액		개설날짜");
		    System.out.println("---------------------------------------------------------------------------------------");
		    
		    //결과객체에 정보가 존재하는동안 반복하여 출력
		    while(rs.next())
		    	System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getString(4)+"	"+rs.getString(5)+"	"+rs.getString(6)+"	"+rs.getString(7)+"		"+rs.getString(8));
		    
		    System.out.println("=======================================================================================");
					    
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
	
	//은행 브랜드명으로 특정 계좌정보 조회
	void searchBrandAcct() {
		//검색할  계좌 정보에 대한  은행 브랜드명을 입력받음
		System.out.print("검색할 계좌 정보가 속한 은행 브랜드명을 입력하세요(예: 농협): ");
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
		    
		    //입력받은 브랜드명에 해당하는 레코드를 Account, Customer, BankBranch, BankBrand를 조인한 테이블로 부터 조회하여 결과객체에 가져옴
		    stmt=conn.prepareStatement("select accid, account.custid, cname, account.branchid, bname, loc, asset, account.createdate from Account account, BankBranch branch, BankBrand brand, Customer customer where account.branchid=branch.branchid and account.custid=customer.custid and branch.bankid=brand.bankid and bname=?");
		    stmt.setString(1, bName);
		    rs=stmt.executeQuery();
		    
		    System.out.println("=======================================================================================");
		    System.out.println("계좌ID	고객ID	고객 이름	지점ID	브랜드	지점위치	잔액		개설날짜");
		    System.out.println("---------------------------------------------------------------------------------------");
		    
		    //결과객체에 정보가 존재하는동안 반복하여 출력
		    while(rs.next())
		    	System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getString(4)+"	"+rs.getString(5)+"	"+rs.getString(6)+"	"+rs.getString(7)+"		"+rs.getString(8));
		    
		    System.out.println("=======================================================================================");
					    
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
	
	//입금
	void deposit() {
		
		
		return;
	}
	
	//출금
	void withdraw() {
		
		return;
	}
	
}
