package bankSystem;

import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class MainOperation {
	Scanner sc=new Scanner(System.in);
	static int manuNum=0;
	String [] menuName= {"전체 고객 정보 조회", "고객ID로 특정 고객 정보 조회", "이름으로 특정 고객 정보 조회", "고객 추가", "고객 삭제", "고객 정보 수정",
			"전체 은행 브랜드 정보 조회", "은행ID로 특정 은행 브랜드 정보 조회", "브랜드명으로 특정 은행 브랜드 정보 조회", "은행 브랜드 추가", "은행 브랜드 삭제", "은행 브랜드 정보 수정",
			"전체 지점 정보 조회", "지점ID로 특정 지점 정보 조회", "지점 위치로 특정 지점 정보 조회", "은행 브랜드명으로 특정 지점 정보 조회", "지점 추가", "지점 삭제", "지점 정보 수정",
			"전체 계좌정보 조회", "계좌ID로 특정  계좌정보 조회", "고객 이름으로 특정  계좌정보 조회", "은행 이름으로 특정  계좌정보 조회", "계좌 추가", "계좌 삭제",
			"입금", "출금", "프로그램 종료"};
	
	String bound1="=======================================================================";
	String bound2="-----------------------------------------------------------------------";
	
	//메뉴 함수
	void printMenu() {
		//메뉴 출력
		System.out.println(bound1);
		System.out.println("<메인메뉴>");
		System.out.println(bound1);
		for(int i=0; i<menuName.length; i++) {
			//왼쪽정렬로 줄 맞추어 출력
			System.out.printf(String.format("%-50.50s" + "\t", Integer.toString(i+1)+"."+menuName[i]));
			
			//2개의 메뉴가 출력될때마다 줄바꿈
			if(i%2 != 0)
			System.out.println();
		}
		System.out.println();
		System.out.println(bound1);
		
		//사용자로부터 메뉴 입력받음
		System.out.print("작업할 메뉴 번호를 선택하세요: ");
		manuNum=sc.nextInt();
		
	}
	
	

	public static void main(String[] args) {
		MainOperation mainOp=new MainOperation();
		Customer cus=new Customer();
		BankBrand bbrand=new BankBrand();
		BankBranch bbranch=new BankBranch();
		
		while(manuNum != 26) {//프로그램 종료 메뉴가 아닌동안 반복
			mainOp.printMenu(); //메인메뉴 출력 및 메뉴 입력받음
			
			switch(manuNum) {
			case 1:
				//전체 고객 정보 조회
				cus.searchEntCus();
				break;
			case 2:
				//고객ID로 특정 고객 정보 조회
				cus.searchIDCus();
				break;
			case 3:
				//이름으로 특정 고객 정보 조회
				cus.searchNameCus();
				break;
			case 4:
				//고객 추가
				cus.createCus();
				break;
			case 5:
				//고객 삭제
				cus.deleteCus();
				break;
			case 6:
				//고객 정보 수정
				cus.modifyCus();
				break;
			case 7:
				//전체 은행 브랜드 정보 조회
				bbrand.searchEntBank();
				break;
			case 8:
				//은행ID로 특정 은행 브랜드 정보 조회
				bbrand.searchIDBank();
				break;
			case 9:
				//브랜드명으로 특정 은행 브랜드 정보 조회
				bbrand.searchNameBank();			
				break;
			case 10:
				//은행 브랜드 추가
				bbrand.createBank();
				break;
			case 11:
				//은행 브랜드 삭제
				bbrand.deleteBank();
				break;
			case 12:
				//은행 브랜드 정보 수정
				bbrand.modifyBank();
				break;
			case 13:
				//전체 지점 정보 조회
				bbranch.searchEntBranch();
				break;
			case 14:
				//지점ID로 특정 지점 정보 조회
				bbranch.searchIDBranch();
				break;
			case 15:
				//지점 위치로 특정 지점 정보 조회
				bbranch.searchLocBranch();
				break;
			case 16:
				//은행 브랜드명으로 특정 지점 정보 조회
				bbranch.searchBrandBranch();
				break;
			case 17:
				//은행 지점 추가
				bbranch.createBranch();
				break;
			case 18:
				
				break;
			case 19:
				
				break;
			case 20:
				
				break;
			case 21:
				
				break;
			case 22:
				
				break;
			case 23:
				
				break;
			case 24:
				
				break;
			case 25:
				
				break;
			case 26:
				
				break;
			case 27:
				
				break;
			case 28:
				//프로그램 종료
				System.exit(0);
				return;
			default:
				//잘못된 메뉴번호 입력한 경우
				System.out.println("에러! 존재하지 않는 메뉴 번호입니다. 다시 입력하세요.");
				break;
			}
			
		}
		
	
		return;
	}

}
