package jp.co.sss.crud.dto;

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
	//public Employee() {
		// TODO 自動生成されたコンストラクター・スタブ
	//}
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
}
