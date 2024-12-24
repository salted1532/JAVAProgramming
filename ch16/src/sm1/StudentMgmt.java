package sm1;

import java.util.Vector;
import java.util.Scanner;

public class StudentMgmt {
	
	StudentDAO dao = null;
	
	public StudentMgmt() {
		dao = new StudentDAO();
	}
	
	public void getList() {
		Vector<StudentBean> list = dao.studentList();
		for(StudentBean s : list) {
			System.out.println(s);
		}
	}
	
	public void doInsert(Scanner sc) {
		System.out.println("추가할 학생 정보를 입력해주세요.");
		System.out.print("id: ");
		String id = sc.next();
		System.out.print("name: ");
		String name = sc.next();
		System.out.print("dept: ");
		String dept = sc.next();
		
		boolean success = dao.insertStudent(new StudentBean(id, name, dept));
		if(success) {
			System.out.println("학생 정보 추가 성공");
		} else {
			System.out.println("학생 정보 추가 실패");
		}
		
	}
	
	public void doUpdate(Scanner sc) {
		System.out.println("수정할 학생 정보를 입력해주세요.");
		System.out.print("id: ");
		String id = sc.next();
		System.out.print("name: ");
		String name = sc.next();
		System.out.print("dept: ");
		String dept = sc.next();
		
		boolean success = dao.updateStudent(new StudentBean(id, name, dept));
		if(success) {
			System.out.println("학생 정보 수정 성공");
		} else {
			System.out.println("학생 정보 수정 실패");
		}
		
	}
	
	public void doDelete(Scanner sc) {
		System.out.println("삭제할 학생 정보를 입력해주세요.");
		System.out.print("id: ");
		String id = sc.next();
		
		boolean success = dao.deleteStudent(id);
		if(success) {
			System.out.println("학생 정보 삭제 성공");
		} else {
			System.out.println("학생 정보 삭제 실패");
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean stop = false;
		StudentMgmt studentMgmt = new StudentMgmt();
		
		do {
			System.out.println("\n===== 학생 관리 프로그램 =====");
			System.out.println("1. 학생 리스트");
			System.out.println("2. 학생 정보 추가");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 삭제");
			System.out.println("5. 종료");
			System.out.print("메뉴 선택: ");
			
			int menu = sc.nextInt();
			switch(menu) {
			case 1: studentMgmt.getList();
					break;
			case 2: studentMgmt.doInsert(sc);
					break;
			case 3: studentMgmt.doUpdate(sc);
					break;
			case 4: studentMgmt.doDelete(sc);
					break;
			case 5: System.out.println("프로그램 종료");
					System.exit(0);
					break;
			default:
				System.out.println("메뉴는 1 ~ 5번까지 선택가능합니다.");
			}
		} while(!stop);
		
		sc.close();
	}//main();
}
