package kr.co.mghan.view;

import kr.co.mghan.domain.EmpBean;


public class SearchHR
{
	// 사원 조회를 위한 View 객체
	// 사원의 정보를 가져다가 구성함.
	public void all_View(EmpBean[] ar_eb)
	{	
		System.out.println("------조회된 사원 결과------");
		for (int i = 0; i < ar_eb.length; i++)
		{
			System.out.println((i + 1) + "번째 사원 정보----");
			System.out.println("사원번호 : " + ar_eb[i].empno);
			System.out.println("사원이름 : " + ar_eb[i].ename);
			System.out.println("부서번호 : " + ar_eb[i].deptno);
			System.out.println();
		} // for end		
	
	}// all_View end

	// 특정사원 번호 조회를 통한 사원 정보 출력
	public void emp_View(EmpBean eb)
	{
		if (eb == null)
		{
			System.out.println("조회된 값이 없습니다.");
		}
		else
		{
			System.out.println("사원 정보는 다음과 같습니다.");
			System.out.println("사원번호 : " + eb.empno);
			System.out.println("이름 : " + eb.ename);
			System.out.println("부서 : " + eb.deptno);
			System.out.println();
		}
	}

} // SearchHR end
