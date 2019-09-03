package kr.co.mghan.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	public void main_menu()
	{
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
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String menu = null;
			try
			{
				menu = br.readLine();
			} catch (IOException e)
			{
				// IO 예외상황이 발생하면 별도의 처리를 할 수 있도록 함
				menu = " ";
			} catch (NullPointerException npe)
			{
				System.out.println("널! 값 누락!");
			} finally
			{
				// try 구문이 실행되고 Exception이 발생을 하든 안하든
				// try 종료ㅣ셍 실행되는 명령 라인

			}
			System.out.println("입력하신 값은 " + menu + " 입니다.");
			if (menu.equals("6"))
			{ // OR Integer.parseInt
				System.out.println("------------종료-----------");
				top_menu_bool = false;
			} // if end

			// 1번 메뉴 발생 시킬 수 있도록 구성하기
			else if (menu.equals("1"))
			{
				// 1번 세부 메뉴 실행 시킬 수 있도록 구성하기
				first_menu();

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
			System.out.println("--수행하고자 하는 메뉴 번호를 누르세요.");
			System.out.println("a. 사원정보조회");
			System.out.println("b. 사원추가");
			System.out.println("exit. 종료");
			System.out.print("값을 입력하세요. => ");
			// 입력값 받을 수 있는 기능 수행
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String menu = null;
			try
			{
				menu = br.readLine();
			} catch (IOException e)
			{
				// IO 예외상황이 발생하면 별도의 처리를 할 수 있도록 함
				menu = " ";
			} catch (NullPointerException npe)
			{
				System.out.println("널! 값 누락!");
			} finally
			{
				// try 구문이 실행되고 Exception이 발생을 하든 안하든
				// try 종료ㅣ셍 실행되는 명령 라인

			}
			System.out.println("입력하신 값은 " + menu + " 입니다.");
			if (menu.equals("exit"))
			{ // OR Integer.parseInt
				System.out.println("------------1번 메뉴 종료-----------");
				top_menu_bool = false;
			} // if end , exit시 종료
		} // while end
	} // first_menu end
} // class menu end
