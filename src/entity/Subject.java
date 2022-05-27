package entity;

import java.util.Scanner;

public class Subject implements Information{
	
	private static int AUTO_ID = -1;
	
	private int id;
	private String name;
	private int lessonsQuantity;
	private int theoryClasses;
	private int funding;
    
    public Subject() {
        if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
    }
    
    public Subject(String name, int lessonsQuantity, int theoryClasses, int funding) {
    	if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
        this.lessonsQuantity = lessonsQuantity;
        this.theoryClasses = theoryClasses;
        this.funding = funding;
    }

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLessonsQuantity() {
		return lessonsQuantity;
	}

	public void setLessonsQuantity(int lessonsQuantity) {
		this.lessonsQuantity = lessonsQuantity;
	}

	public int getTheoryClasses() {
		return theoryClasses;
	}

	public void setTheoryClasses(int theoryClasses) {
		this.theoryClasses = theoryClasses;
	}

	public int getFunding() {
		return funding;
	}

	public void setFunding(int funding) {
		this.funding = funding;
	}

	public String toString() {
        return "entity.Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lessonsQuantity='" + lessonsQuantity + '\'' +
                ", theoryClasses='" + theoryClasses + '\'' + 
                ", funding='" + funding + '\'' +'}';
    }
	
	public void inputInfo() {
        System.out.print("Nhập tên môn học: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Nhập tổng số tiết: ");
        this.lessonsQuantity = new Scanner(System.in).nextInt();
        System.out.print("Nhập số tiết lý thuyết: ");
        this.theoryClasses = new Scanner(System.in).nextInt();
        System.out.print("Nhập mức kinh phí: ");
        this.funding = new Scanner(System.in).nextInt();
    }
}
