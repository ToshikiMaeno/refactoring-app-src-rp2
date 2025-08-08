package jp.co.sss.crud.dto;

public class Employee {
	private Integer empId;
	private String empName;
	private Integer gender;
	private String birthday;
	//private Department department;
	private Integer dept_id;
	public Employee(Integer empId, String empName, Integer gender, String birthday, Integer dept_id) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.birthday = birthday;
		this.dept_id = dept_id;
	}
	public Employee() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	//public Employee() {
		// TODO 自動生成されたコンストラクター・スタブ
	//}
	public void setEmpId(Integer empId) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	public void setGender(Integer int1) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	public void setEmpName(String empName) {
		// TODO 自動生成されたメソッド・スタブ
		this.empName = empName;
		
	}
	public void setBirthday(String string) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	public void setDeptId(Integer int1) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	public String getEmpName() {
		return empName;
	}
}
