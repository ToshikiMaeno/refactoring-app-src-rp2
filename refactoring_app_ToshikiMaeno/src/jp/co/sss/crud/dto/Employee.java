package jp.co.sss.crud.dto;
import static jp.co.sss.crud.util.ConstantMsg.*;

public class Employee {
	private Integer empId;
	private String empName;
	private Integer gender;
	private String birthday;
	//private Department department;
	private Department department;
	public Employee(Integer empId, String empName, Integer gender, String birthday, Department department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.birthday = birthday;
		this.department = department;
	}
	public Employee() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
		
	}
	public void setGender(Integer gender) {
		this.gender = gender;
		
	}
	public void setEmpName(String empName) {
		// TODO 自動生成されたメソッド・スタブ
		this.empName = empName;
		
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
		
	}
	public void setDepartment(Department department) {
		this.department = department;
		
	}
	
	
	public Integer getEmpId() {
		return empId;
	}
	public Integer getGender() {
		return gender;
	}
	public String getEmpName() {
		return empName;
	}
	public String getBirthday() {
		return birthday;
	}
	public Department getDepartment() {
		return department;
	}
	
	
	public String toString() {
		String gender_ja = "";
		if (this.gender == 1) {
			gender_ja = MALE;
		} else if (this.gender == 2) {
			gender_ja = FEMALE;
		} else if (this.gender == 0) {
			gender_ja = NO_ANSWER;
		} else if (this.gender == 9) {
			gender_ja = OTHER;
		}

		return empId + "\t" + empName + "\t" + gender_ja + "\t" + birthday
				+ "\t" + department.getDeptName() + "\n";
	}
	
	
	
}
