package bankSystem;

import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class MainOperation {
	static Scanner sc=new Scanner(System.in);
	static int manuNum=0;
	String [] menuName= {"전체 고객 정보 조회", "고객ID로 특정 고객 정보 조회", "이름으로 특정 고객 정보 조회", "고객 추가", "고객 삭제", "고객 정보 수정",
			"전체 은행 브랜드 정보 조회", "브랜드ID로 특정 은행 브랜드 정보 조회", "브랜드명으로 특정 은행 브랜드 정보 조회", "은행 브랜드 추가", "은행 브랜드 삭제", "은행 브랜드 정보 수정",
			"전체 지점 정보 조회", "지점ID로 특정 지점 정보 조회", "지점 위치로 특정 지점 정보 조회", "은행 브랜드명으로 특정 지점 정보 조회", "지점 추가", "지점 삭제", "지점 정보 수정",
			"전체 계좌정보 조회", "계좌ID로 특정  계좌정보 조회", "고객 이름으로 특정  계좌정보 조회", "은행 브랜드명으로 특정  계좌정보 조회", "계좌 추가", "계좌 삭제", "계좌 정보 수정",
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
		sc.nextLine(); //버퍼에 남아있는 엔터값을 비움
		
	}
	
	

	public static void main(String[] args) {
		MainOperation mainOp=new MainOperation();
		Customer cus=new Customer();
		BankBrand bbrand=new BankBrand();
		BankBranch bbranch=new BankBranch();
		Account account=new Account();
		
		while(manuNum != 29) {//프로그램 종료 메뉴가 아닌동안 반복
			mainOp.printMenu(); //메인메뉴 출력 및 메뉴 입력받음
			
			switch(manuNum) {
			case 1:
				//전체 고객 정보 조회
				cus.searchEntCus();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 2:
				//고객ID로 특정 고객 정보 조회
				cus.searchIDCus();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 3:
				//이름으로 특정 고객 정보 조회
				cus.searchNameCus();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 4:
				//고객 추가
				cus.createCus();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 5:
				//고객 삭제
				cus.deleteCus();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 6:
				//고객 정보 수정
				cus.modifyCus();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 7:
				//전체 은행 브랜드 정보 조회
				bbrand.searchEntBank();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 8:
				//브랜드ID로 특정 은행 브랜드 정보 조회
				bbrand.searchIDBank();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 9:
				//브랜드명으로 특정 은행 브랜드 정보 조회
				bbrand.searchNameBank();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 10:
				//은행 브랜드 추가
				bbrand.createBank();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 11:
				//은행 브랜드 삭제
				bbrand.deleteBank();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 12:
				//은행 브랜드 정보 수정
				bbrand.modifyBank();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 13:
				//전체 지점 정보 조회
				bbranch.searchEntBranch();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 14:
				//지점ID로 특정 지점 정보 조회
				bbranch.searchIDBranch();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 15:
				//지점 위치로 특정 지점 정보 조회
				bbranch.searchLocBranch();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 16:
				//은행 브랜드명으로 특정 지점 정보 조회
				bbranch.searchBrandBranch();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 17:
				//은행 지점 추가
				bbranch.createBranch();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 18:
				//지점 삭제
				bbranch.deleteBranch();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 19:
				//지점 정보 수정
				bbranch.modifyBranch();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 20:
				//전체 계좌 정보 조회
				account.searchEntAcct();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 21:
				//계좌ID로 특정 계좌정보 조회
				account.searchIDAcct();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 22:
				//고객 이름으로 특정 계좌정보 조회
				account.searchNameAcct();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 23:
				//은행 브랜드명으로 특정 계좌정보 조회
				account.searchBrandAcct();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 24:
				//계좌 추가
				account.createAcct();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 25:
				//계좌 삭제
				account.deleteAcct();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 26:
				//계좌 정보 수정
				account.modifyAcct();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 27:
				//입금
				account.deposit();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 28:
				//출금
				account.withdraw();
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			case 29:
				//프로그램 종료
				System.exit(0);
				return;
			default:
				//잘못된 메뉴번호 입력한 경우
				System.out.println("에러! 존재하지 않는 메뉴 번호입니다. 다시 입력하세요.");
				
				//사용자로 부터 엔터를 입력받으면 다시 메인메뉴로 돌아감
				System.out.println("다른 작업을 위해 메인메뉴로 돌아가려면 엔터를 누르세요!");
				sc.nextLine();
				break;
			}
			
		}
		
	
		return;
	}

}
