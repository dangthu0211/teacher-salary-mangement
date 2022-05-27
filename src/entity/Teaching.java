package entity;

public class Teaching {
	private Teacher teacher;
	private Subject subject;
	private int classesQuantity;
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getClassesQuantity() {
		return classesQuantity;
	}
	public void setClassesQuantity(int classesQuantity) {
		this.classesQuantity = classesQuantity;
	}
	
	public String toString() {
        return "entity.Teaching{" +
                "teacher=" + teacher +
                ", subject='" + subject + '\'' +
                ", classesQuantity='" + classesQuantity + '\'';
    }
}
