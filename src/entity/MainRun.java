package entity;

import java.util.Scanner;

public class MainRun {

	private static Teacher[] TEACHERS = new Teacher[100];
	private static Subject[] SUBJECTS = new Subject[100];
	private static Teaching[] TEACHING = new Teaching[100];

	public static void main(String[] args) {
		showMenu();
	}
	
    private static void showMenu() {
        while (true) {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    inputNewTeacher();
                    break;
                case 2:
                    showTeacher(TEACHERS);
                    break;
                case 3:
                    inputNewSubject();
                    break;
                case 4:
                    showSubject(SUBJECTS);
                    break;
                case 5:
                    createTeaching();
                    break;
                case 6:
                	showTeaching(TEACHING);
                    break;
                case 7:
                	showSortTeaching();
                    break;
                case 8:
                	showSalary();
                    break;
                case 9:
                    System.out.println("Xin cảm ơn đã sử dụng phần mềm của chúng tôi!");
                    return;
            }
        }
    }


	private static int functionChoice() {
		System.out.println("\n\n===== QUẢN LÝ TRẢ LƯƠNG CHO GIẢNG VIÊN THỈNH GIẢNG =====\n\n");
		System.out.println("1. Nhập danh sách môn học mới.");
		System.out.println("2. In ra danh sách môn học trong hệ thống.");
		System.out.println("3. Nhập danh sách giảng viên mới.");
		System.out.println("4. In ra danh sách giảng viên trong hệ thống.");
		System.out.println("5. Lập Bảng kê khai giảng dạy cho mỗi giảng viên");
		System.out.println("6. In ra danh sách kê khai");
		System.out.println("7. Sắp xếp danh sách kê khai giảng dạy");
		System.out.println("8. Tính toán và lập bảng tính tiền công cho mỗi giảng viên");
		System.out.println("9. Thoát chương trình");
		System.out.println("--------------------------------------");
		System.out.print("Xin mời nhập lựa chọn của bạn: ");
		int functionChoice = -1;
		do {
			functionChoice = new Scanner(System.in).nextInt();
			if (functionChoice >= 1 && functionChoice <= 9) {
				break;
			}
			System.out.print("Chức năng được chọn không hợp lệ, vui lòng chọn lại: ");
		} while (functionChoice > 9 || functionChoice < 1);
		return functionChoice;
	}
	
	/*
	 * Nhập hiện giảng viên
	 */	
	private static void inputNewTeacher() { 
		System.out.print("Nhập số lượng giảng viên mới muốn thêm: ");
        int newTeacherNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newTeacherNumber; i++) {
            System.out.println("Nhập thông tin cho giảng viên thứ " + (i + 1));
            Teacher teacher = new Teacher();
            teacher.inputInfo();
            saveTeacher(teacher);
        }
	}
	
	private static void saveTeacher(Teacher teacher) {
        for (int j = 0; j < TEACHERS.length; j++) {
            if (TEACHERS[j] == null) {
            	TEACHERS[j] = teacher;
                break;
            }
        }
    }
	
    private static void showTeacher(Teacher[] teachers) {
    	for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                continue;
            }
            System.out.println(teachers[i]);
        }
    }
    
	/*
	 * Nhập hiện môn học
	 */    
    private static void inputNewSubject() {
    	 System.out.print("Nhập số lượng môn học mới muốn thêm: ");
         int newSubjectNumber = new Scanner(System.in).nextInt();
         for (int i = 0; i < newSubjectNumber; i++) {
             System.out.println("Nhập thông tin cho môn học thứ " + (i + 1));
             Subject subject = new Subject();
             subject.inputInfo();
             saveSubject(subject);
         }
    }
    
    private static void saveSubject(Subject subject) {
        for (int j = 0; j < SUBJECTS.length; j++) {
            if (SUBJECTS[j] == null) {
            	SUBJECTS[j] = subject;
                break;
            }
        }
    }
    
    private static void showSubject(Subject[] subjects) {
    	for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] == null) {
                continue;
            }
            System.out.println(subjects[i]);
        }
    }

	/*
	 * Nhập hiện kê khai
	 */ 
    private static boolean checkTeacherData() {
		for (int i = 0; i < TEACHERS.length; i++) {
			if (TEACHERS[i] != null) {
				return true;
			}
		}
		return false;
    }
    
    private static boolean checkSubjectData() {
		for (int i = 0; i < SUBJECTS.length; i++) {
			if (SUBJECTS[i] != null) {
				return true;
			}
		}
		return false;
    }
    
    private static boolean checkTeachingData() {
		for (int i = 0; i < TEACHING.length; i++) {
			if (TEACHING[i] != null) {
				return true; // có dữ liệu
			}
		}
		return false; // k có dữ liệu
    }
    
    private static void createTeaching() {
    	if(!(checkTeacherData() && checkSubjectData())) {
    		System.out.println("Chưa có dữ liệu về giảng viên hoặc môn học để thao tác, vui lòng nhập dữ liệu trước đã!");
            return;
    	}
    	
    	do {
    		
    		// Dừng hoặc không
    		System.out.print("Tiếp tục nhập? (y/n): ");
    		String check = new Scanner(System.in).nextLine();
    		if(check.equalsIgnoreCase("n")) {
    			break;
    		}
    		
    		// nhập thiệt nè
    		
    		Teacher teacher = pushTeacher();

    		System.out.print("Nhập số lượng môn học mà giảng viên này dạy: ");
    		int subjectQuantity = new Scanner(System.in).nextInt();
    		for(int i = 0; i <subjectQuantity; i++) {
    			Subject subject = pushSubject(i);
    			if(!isTeachingExist(teacher.getId(), subject.getId())) {
    	    		System.out.print("Nhập số lượng lớp học của môn học này: ");
    	    		do {
    	    			int classesQuantity = new Scanner(System.in).nextInt();
    	    			if(classesQuantity > 0 && classesQuantity < 3) {
    	    				if(totalLessonsOfTeacher(teacher) + subject.getLessonsQuantity() * classesQuantity < 20) {
    	    		    		Teaching teaching = new Teaching();
    	    					teaching.setSubject(subject);
    	        	    		teaching.setTeacher(teacher);
	    	    				teaching.setClassesQuantity(classesQuantity);
	    	    	    		saveTeaching(teaching);
	    	    				break;
    	    				}
    	    				else {
    	    					System.out.println("Tổng số tiết giảng dạy của một giảng viên không được lớn hơn 20.");
    	    					break;
    	    				}
    	    			}
    	    			else System.out.print("Số lớp cho mỗi môn là số nguyên dương và không lớn hơn 3.  Vui lòng nhập lại: ");

    	    		} while(true);
    	    		
    			}
    			else {
    				System.out.println("Kê khai này đã tồn tại");
    				i--;
    			}
    		}
    		
    		//
    		System.out.println("---------------");
    		
    	} while(true);
    	
    }
    
    private static void saveTeaching(Teaching teaching) {
        for (int i = 0; i < TEACHING.length; i++) {
            if (TEACHING[i] == null) {
            	TEACHING[i] = teaching;
                return;
            }
        }
    }
    
    private static Teacher pushTeacher() {
    	System.out.print("Nhập mã giảng viên: ");
		int idTeacher;
		Teacher teacher = new Teacher();

		do {
			idTeacher = new Scanner(System.in).nextInt();
			teacher = searchTeacherById(idTeacher);
			if (teacher != null) {
				break;
			}
			System.out.print("Không tồn tại giảng viên có ID là " + idTeacher + ", vui lòng nhập lại: ");
		} while (true);
		
		return teacher; 
	}
    
    private static Subject pushSubject(int index) {
    	System.out.print("Nhập mã môn học thứ " + (index + 1) + ": ");
		int idSubject;
		Subject subject = new Subject();

		do {
			idSubject = new Scanner(System.in).nextInt();
			subject = searchSubjectById(idSubject);
			if (subject != null) {
				break;
			}
			System.out.print("Không tồn tại môn học có ID là " + idSubject + ", vui lòng nhập lại: ");
		} while (true);
		
		return subject; 
    }
    
    private static Teacher searchTeacherById(int idTeacher) {
		for (int i = 0; i < TEACHERS.length; i++) {
			Teacher teacher = TEACHERS[i];
			if (teacher != null && teacher.getId() == idTeacher) {
				return teacher;
			}
		}
		return null;
	}
    
    private static Subject searchSubjectById(int idSubject) {
		for (int i = 0; i < SUBJECTS.length; i++) {
			Subject subject = SUBJECTS[i];
			if (subject != null && subject.getId() == idSubject) {
				return subject;
			}
		}
		return null;
	}
    
    private static boolean isTeachingExist(int idTeacher, int idSubject) {
    	if(!checkTeachingData()) return false; 
    	for(int i=0; i < TEACHING.length; i++) {
    		if(TEACHING[i] != null) {
    			if(TEACHING[i].getTeacher().getId() == idTeacher && 
    					TEACHING[i].getSubject().getId() == idSubject) {
    				return true; // đã tồn tại
    			}
    		}
    	}
    	return false;
    }
    
    private static int totalLessonsOfTeacher(Teacher teacher) {
    	int sum = 0;
    	if(!checkTeachingData()) return 0; 
    	for(int i=0; i < TEACHING.length; i++) {
    		if(TEACHING[i] != null) {
    			if(TEACHING[i].getTeacher().getId() == teacher.getId() ) {
    				sum += (TEACHING[i].getSubject().getLessonsQuantity() * TEACHING[i].getClassesQuantity());
    			}
    		}
    	}
    	return sum;
    }
    
    private static void showTeaching(Teaching[] teaching) {
    	for (int i = 0; i < teaching.length; i++) {
            if (teaching[i] == null) {
                continue;
            }
            System.out.println(teaching[i]);
        }
    }

	/*
	 * Sắp xếp kê khai
	 */    
    private static void showSortTeaching() {
    	if(!checkTeachingData()) {
			System.out.println("Chưa có dữ liệu về danh sách mượn để thao tác, vui lòng nhập danh sách mượn trước đã!");
			return;
		}
    	
		System.out.println("---Sắp xếp danh sách theo---");
		System.out.println("1. Theo tên giảng viên");
		System.out.println("2. Theo số tiết giảng dạy mỗi môn giảm dần");
		System.out.println("--------------------------------------");
		System.out.print("Xin mời nhập lựa chọn của bạn: "); 
		
		int functionChoice = -1;
		do { 
			functionChoice = new Scanner(System.in).nextInt(); 
			if (functionChoice >= 1 && functionChoice <= 2) { 
				break; 
			}
			System.out.print("Chức năng được chọn không hợp lệ, vui lòng chọn lại: "); 
		} while (functionChoice > 2 || functionChoice < 1);
		
		switch (functionChoice) { 
			case 1: sortByTeacherName(); break;
			case 2: sortBySubjectClasses(); break; 
		}
		
    	
    	showTeaching(TEACHING);
    	
    }
    
    private static void sortByTeacherName() {
    	for(int i=0; i < TEACHING.length - 1; i++) {
    		for(int j= i+1; j < TEACHING.length; j++) {
    			if(TEACHING[i] != null && TEACHING[j] != null && TEACHING[i].getTeacher().getName().compareTo(
    					TEACHING[j].getTeacher().getName()) > 0) {
    				Teaching tmp = TEACHING[i];
    				TEACHING[i] = TEACHING[j];
    				TEACHING[j] = tmp;
    			}
    		}
    	}
    }
    
    private static void sortBySubjectClasses() {
    	for(int i=0; i < TEACHING.length - 1; i++) {
    		for(int j= i+1; j < TEACHING.length; j++) {
    			if(TEACHING[i] != null && TEACHING[j] != null) {
    	    		int lesson1 = TEACHING[i].getSubject().getLessonsQuantity() * TEACHING[i].getClassesQuantity();
            		int lesson2 = TEACHING[j].getSubject().getLessonsQuantity() * TEACHING[j].getClassesQuantity();
            		
            		if(lesson1 < lesson2) {
            			Teaching tmp = TEACHING[i];
        				TEACHING[i] = TEACHING[j];
        				TEACHING[j] = tmp;
            		}
    			}
    		}
    	}
    }
    
	/*
	 * Tính tiền công
	 */    
    
    private static void showSalary() {
    	for (int i = 0; i < TEACHERS.length; i++) {
			if (TEACHERS[i] != null) {
				System.out.println("Giảng viên id là " + TEACHERS[i].getId() + " có lương: "+ calculateSalary(TEACHERS[i]));
			}
		}
    }
    
    private static int calculateSalary(Teacher teacher) {
    	int salary = 0;
    	
    	for(int i=0; i<TEACHING.length; i++) {
    		if(TEACHING[i] != null) {
    			if(TEACHING[i].getTeacher().getId() == teacher.getId()) {
    				Subject teachSubject = TEACHING[i].getSubject();
    				salary += (
    						( (teachSubject.getLessonsQuantity() -  teachSubject.getTheoryClasses()) * 0.7 + 
    						teachSubject.getTheoryClasses() ) * teachSubject.getFunding() 
    						* TEACHING[i].getClassesQuantity());
    			}
    		}
    	}
    	
    	return salary;
    }
    
}
