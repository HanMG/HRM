package kr.co.mghan.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import kr.co.mghan.domain.EmpBean;
import kr.co.mghan.domain.EmpData;

//KITRI Human Resource Management System에 오신것을 환영합니다.
//다음 수행하고자 하는 메뉴 번호를 누르세요.
//	1. 사원정보조회
//	2. 사원추가
//	3. 사원수정
//	4. 사원삭제
//	5. 부서정보조회
//	6. 종료

public class Menu
{
	EmpBean[] ar_eb = null;
	public void main_menu()
	{
		// Data값 초기화
		ar_eb = new EmpData().def_data();
		
		// 메뉴 반복 코드 값 추가
		boolean top_menu_bool = true;

		while (top_menu_bool)
		{
			System.out.println("-- KITRI Human Resource Management System에 오신것을 환영합니다.");
			System.out.println("-- 다음 수행하고자 하는 메뉴 번호를 누르세요.");
			System.out.println("- 1. 사원정보조회");
			System.out.println("- 2. 사원추가");
			System.out.println("- 3. 사원수정");
			System.out.println("- 4. 사원삭제");
			System.out.println("- 5. 부서정보조회");
			System.out.println("- 6. 종료");
			System.out.print("값을 입력하세요. => ");
			// 입력값 받을 수 있는 기능 수행			
			String menu = input_msg();			
			System.out.println("입력하신 값은 " + menu + " 입니다.");
			if (menu.equals("6"))
			{ // OR Integer.parseInt
				System.out.println("------------종료-----------");
				top_menu_bool = false;
			} // if 6 종료 end

			// 1번 메뉴 발생 시킬 수 있도록 구성하기
			else if (menu.equals("1"))
			{
				// 1번 세부 메뉴 실행 시킬 수 있도록 구성하기
				first_menu();
			} // else if first end
			
			else if (menu.equals("2")){
				// 2번 메뉴 (사원 추가 실행시킬 수 있도록 구성하기)
				second_menu();
			}// else if second end
			else if (menu.equals("4")) {
				// 4번 메뉴 ( 사원 삭제)
				fourth_menu();
			}
			
		} // while end

	}// main end

	// 1번 메뉴 메소드 생성
	public void first_menu()
	{

		boolean top_menu_bool = true;

		while (top_menu_bool)
		{
			System.out.println("------------------------------");
			System.out.println("----------사원정보조회 메뉴---------");
			System.out.println("------------------------------");
			System.out.println("@ 수행하고자 하는 메뉴 번호를 누르세요.");
			System.out.println("a. 사원정보조회");
			System.out.println("b. 특정사원조회");
			System.out.println("exit. 종료");
			System.out.print("값을 입력하세요. => ");
			// 입력값 받을 수 있는 기능 수행
			String menu = input_msg();			
			
			if (menu.equals("exit")) // 사원조회 나가기
			{ 
				System.out.println("------------1번 메뉴 종료-----------");
				top_menu_bool = false;
			} // if exit end , exit시 종료
			else if(menu.equals("a")) {  //전체사원조회				
				//SearchHR shr = new SearchHR();
				new SearchHR().all_View(ar_eb);
			} // else if 'a' END
			else if(menu.equals("b")) {  // 특정인물 조회
				
				System.out.println("사원번호를 입력하세요.");
				String empno = input_msg();				
				
				// SeachHR에 검색된 결과값 전달 후 화면 보이기
				// String empno => int 바꿀 필요가 있음
				EmpBean eb = null;
				int i_empno = Integer.parseInt(empno);
				eb = new EmpData().getEmp(i_empno, ar_eb);
				new SearchHR().emp_View(eb);				
			} // else if 'b' END
		} // while end
	} // first_menu end
	
	// 2번 메뉴 메소드 생성
	public void second_menu() { // 사원추가
		System.out.println("추가하고자 하는 사원의 번호를 입력하세요.");
		String empno = input_msg();
		System.out.println("추가하고자 하는 사원의 이름을 입력하세요.");
		String ename = input_msg();
		System.out.println("추가하고자 하는 사원의 부서번호을 입력하세요.");
		String deptno = input_msg();
		
		// 2가지 값을 전달해 추가
		EmpData ed = new EmpData();
		ar_eb = ed.ins_emp(empno, ename, deptno, ar_eb);
	}
	
	
	// 4번 메뉴 메소드 생성
	public void fourth_menu() {
		System.out.println("삭제하고자 하는 사원의 번호를 입력하세요.");
		String empno = input_msg(); 
		
		//  사원번호를 받아 삭제
		EmpData ed = new EmpData(); 
		ar_eb = ed.del_emp(empno, ar_eb);  // 삭제된 객체배열을 리턴 받아 재정의 		
		
	}
	
	
	// 입력값 받을 수 있도록 구성하는 메소드
	private String input_msg() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String menu = null;
		try
		{
			menu = br.readLine();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return menu;
	}
	
} // class menu end
