package jp.co.sss.crud.util;

/**
 * 設定値をまとめたクラス(SQL関連)
 * 20250807_Test3
 * @author System Shared
 *
 */
public class ConstantSQL {

	/** インスタンス化を禁止 */
	private ConstantSQL() {
	}

	
	// ***** SQL文 *****

	/** 全件表示 */
	public static final String SQL_ALL_SELECT = "SELECT e.emp_id, e.emp_name,e.gender, TO_CHAR(birthday, 'yyyy/MM/dd') AS birthday, e.birthday, d.dept_name "
			+ "FROM employee e INNER JOIN department d "
			+ "ON e.dept_id = d.dept_id " + "ORDER BY e.emp_id";

	/** 条件検索(ベース) */
	public static final String SQL_SELECT_BASIC = "SELECT e.emp_id, e.emp_name,e.gender, TO_CHAR(birthday, 'yyyy/MM/dd') AS birthday, e.birthday, d.dept_name "
			+ "FROM employee e INNER JOIN department d "
			+ "ON e.dept_id = d.dept_id ";

	/** 条件検索(社員名による条件) */
	public static final String SQL_SELECT_BY_EMP_NAME = "WHERE e.emp_name LIKE ? ORDER BY e.emp_id";

	/** 条件検索(部署IDによる条件) */
	public static final String SQL_SELECT_BY_DEPT_ID = "WHERE e.dept_id = ? ORDER BY e.emp_id";

	/** 登録 */
	//public static final String SQL_INSERT = "INSERT INTO employee VALUES(seq_emp.NEXTVAL, ?, ?, ?, ?)";
	public static final String SQL_INSERT = "INSERT INTO employee VALUES(nextval('seq_emp'), ?, ?, ?, ?)";

	/** 更新 */
	public static final String SQL_UPDATE = "UPDATE employee SET emp_name = ?, gender = ?, "
			+ "birthday = ?, dept_id = ? " + "WHERE emp_id = ?";
	
	//public static final String SQL_UPDATE = "UPDATE employee SET emp_name = '鈴木四郎', gender = 1, birthday = '1999/12/11', dept_id = 2 WHERE emp_id = 14";

	/** 削除 */
	public static final String SQL_DELETE = "DELETE FROM employee WHERE emp_id = ?";

}
