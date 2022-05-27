package entity;

import java.util.Scanner;

public class Teacher extends Human implements Information{

	public static final String GS = "GS-TS";
	public static final String PGS = "PGS-TS";
	public static final String GVC = "Giảng viên chính";
	public static final String TS = "Thạc sĩ";
	
    private static int AUTO_ID = -1;
    
    private int id;
    private String literacy;
    
    public Teacher() {
        if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
    }
    
    public Teacher(String name, String address, String phoneNumber, String literacy) {
    	super(name, address, phoneNumber);
    	if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
        this.literacy = literacy;
    }

	public int getId() {
        return id;
    }

    public String getLiteracy() {
		return literacy;
	}

	public void setLiteracy(String literacy) {
		this.literacy = literacy;
	}
	
	public String toString() {
        return "entity.Teacher{" +
                "id=" + id +
                ", name='" + super.getName() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' + 
                ", literacy='" + literacy + '\'' +'}';
    }
	
	public void inputInfo() {
        super.inputInfo();
        System.out.println("Nhập trình độ là 1 trong các lựa chọn dưới đây: ");
        System.out.println("1. GS-TS");
        System.out.println("2. PCS-TS");
        System.out.println("3. Giảng viên chính");
        System.out.println("4. Thạc sỹ");
        System.out.print("Xin mời nhập lựa chọn của bạn: ");
        int choice = -1;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 4) {
                break;
            }
            System.out.print("Lựa chọn loại khách hàng không hợp lệ, vui lòng chọn lại: ");
        } while (choice > 4 || choice < 1);
        switch (choice) {
            case 1:
                this.literacy = Teacher.GS;
                break;
            case 2:
                this.literacy = Teacher.PGS;
                break;
            case 3:
                this.literacy = Teacher.GVC;
                break;
            case 4:
                this.literacy = Teacher.TS;
                break;
        }
    }

}
