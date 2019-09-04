package kr.co.mghan.domain;

public class EmpData
{
	// 샘플 데이터 세팅
	public EmpBean[] def_data()
	{
		// empno, ename, mgr, job, sal, comm,
		// hiredate, deptno
		// 각각의 사원들에 대한 정보 입력

		EmpBean eb = new EmpBean();

		eb.empno = 9999;
		// int empno = 9999;
		eb.ename = "Smith";
		// String ename = "Smith";
		eb.mgr = 1111;
		// int mgr = 1111;
		eb.job = "IT";
		// String job = "IT";
		eb.sal = 9800;
		// double sal = 9800;
		eb.comm = 9800 * 0.15;
		// double comm = 9800 * 0.15;
		eb.hiredate = "2019/09/03";
		// String hiredate = "2019/09/03";
		eb.deptno = 10;
		// int deptno = 10;

		EmpBean eb2 = new EmpBean();
		eb2.empno = 2222;
		// int empno = 9999;
		eb2.ename = "King";
		// String ename = "Smith";
		eb2.mgr = 2222;
		// int mgr = 1111;
		eb2.job = "IT";
		// String job = "IT";
		eb2.sal = 15000;
		// double sal = 9800;
		eb2.comm = 15000 * 0.15;
		// double comm = 9800 * 0.15;
		eb2.hiredate = "2015/05/09";
		// String hiredate = "2019/09/03";
		eb2.deptno = 20;
		// int deptno = 10;

		EmpBean eb3 = new EmpBean();
		eb3.empno = 3333;
		// int empno = 9999;
		eb3.ename = "LISS";
		// String ename = "Smith";
		eb3.mgr = 3333;
		// int mgr = 1111;
		eb3.job = "Maketing";
		// String job = "IT";
		eb3.sal = 12000;
		// double sal = 9800;
		eb3.comm = 12000 * 0.15;
		// double comm = 9800 * 0.15;
		eb3.hiredate = "2016/02/22";
		// String hiredate = "2019/09/03";
		eb3.deptno = 30;
		// int deptno = 10;

		EmpBean[] ebb =
		{ eb, eb2, eb3 };
		EmpBean[] ebb2 = null;
		ebb2 = new EmpBean[]
		{ eb, eb2, eb3 };
		EmpBean[] ebb3 = new EmpBean[4];
		ebb3[0] = eb;
		ebb3[1] = eb2;
		ebb3[2] = eb3;

		return ebb;
	} // def_data end

	// 특정 사원 정보 조회 후 값 세팅하기 (def_data() 에 갖고 있는 초기값)
	public EmpBean getEmp(int empno, EmpBean[] ar_eb)
	{
		for (int i = 0; i < ar_eb.length; i++)
		{
			if (ar_eb[i].empno == empno)
			{
				return ar_eb[i];
			}
		}
		return null;
	}

	// 사원 추가 시키기 (Menu -> empno, ename ) 받아서 사용
	public EmpBean[] ins_emp(String empno, String ename, String deptno, EmpBean[] ar_eb)
	{
		// 기존 사원 정보에서 매개변수에 입력된 정보 추가
		EmpBean[] old_ar_eb = ar_eb;
		// 추가된 공간 확보
		// 기존 공간수 + 1
		// 기존 공간수 확인
		EmpBean[] new_ar_eb = new EmpBean[old_ar_eb.length + 1];
		for (int i = 0; i < old_ar_eb.length; i++)
		{
			EmpBean eb = new EmpBean();
			eb.empno = old_ar_eb[i].empno;
			eb.ename = old_ar_eb[i].ename;
			eb.deptno = old_ar_eb[i].deptno;
			new_ar_eb[i] = eb;
		}
		// 추가된 값을 마지막 배열에 추가시킴
		EmpBean n_eb = new EmpBean();
		n_eb.empno = Integer.parseInt(empno);
		n_eb.ename = ename;
		n_eb.deptno = Integer.parseInt(deptno);
		new_ar_eb[new_ar_eb.length - 1] = n_eb;

		return new_ar_eb;
	}

	// 사원번호와 객체배열을 받아 삭제
	public EmpBean[] del_emp(String empno, EmpBean[] ar_eb) 
	{
		EmpBean[] old_ar_eb = ar_eb; // 현재 배열
		int target = 0; // 제거될 타겟의 인덱스
		int isEmp = 0; // 사원이 있는 지 체크
		
		// 전체를 돌면서 타겟의 인덱스를 찾고 찾으면 해당 객체를 NULL로 하고  사원체크변수를 증가한뒤 for문 정지
		for (target = 0; target < old_ar_eb.length; target++)
		{
			if (old_ar_eb[target].empno == Integer.parseInt(empno))
			{
				old_ar_eb[target] = null;
				isEmp++;
				break;
			}
		}		
		
		// 사원이 존재하면 아래를 실행
		if(isEmp > 0) {
			
			// 정렬로 NULL로 된 객체를 배열 제일 마지막으로 이동시킴
			for (int i = 0; i < old_ar_eb.length; i++)
			{
				for (int j = 0; j < old_ar_eb.length; j++)
				{
					EmpBean tmp = new EmpBean();
					if (old_ar_eb[j] == null)
					{
						if (j != (old_ar_eb.length - 1))
						{
							tmp = old_ar_eb[j];
							old_ar_eb[j] = old_ar_eb[j + 1];
							old_ar_eb[j + 1] = tmp;
						}					
					}
				}
			}

			// 새로운 객체배열 생성, 현재 배열보다 한칸 작게
			EmpBean[] new_ar_eb = new EmpBean[old_ar_eb.length - 1];
			
			// 새로운 객체배열에 현재배열의 값을 입력
			for (int j = 0; j < new_ar_eb.length; j++)
			{
				EmpBean eb = new EmpBean();
				eb.empno = old_ar_eb[j].empno;
				eb.ename = old_ar_eb[j].ename;
				eb.deptno = old_ar_eb[j].deptno;
				new_ar_eb[j] = eb;
			}

			// 새로운 객체배열 리턴
			return new_ar_eb;
		}
		
		// 사원번호체크 isEmp가 그대로일 경우 사원번호가 없음을 출력하고, 원래 객체배열을 다시 리턴
		else {
			System.out.println("사원번호가 없음.");
			return ar_eb;
		}		
	} // del_emp END

}
