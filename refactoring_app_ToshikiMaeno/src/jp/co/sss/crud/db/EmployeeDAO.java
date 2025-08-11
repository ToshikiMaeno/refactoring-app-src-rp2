package jp.co.sss.crud.db;

import static jp.co.sss.crud.util.ConstantSQL.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;


/**
 * DB操作処理用のクラス
 *
 * @author System Shared
 */
public class EmployeeDAO implements IEmployeeDAO {

	/**
	 * 全ての社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	public static List<Employee> findAllDisplay() throws ClassNotFoundException, SQLException {
		List<Employee> employees = new ArrayList<>();
		Employee employee = null;
		Department department = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//resultSetの結果Setがない場合はfalse
			//if (!resultSet.isBeforeFirst()) {
			//	System.out.println("該当者はいませんでした");
			//	return employees;
			//}

			// レコードの取得
			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				department = new Department();
				department.setDeptName(resultSet.getString("dept_name"));
				employee.setDepartment(department);
				employees.add(employee);
			}

			System.out.println("");
		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
		return employees;
	}

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static List<Employee> findEmployeeName(String searchName) throws ClassNotFoundException, SQLException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Employee> employees = new ArrayList<>();
		Employee employee = null;
		Department department = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		// 社員名検索
		//System.out.print(ConstantMsg.MENU_MESSAGE_EMPLOYEE_NAME);

		// 検索ワード
		//String searchWord = br.readLine();

		

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(SQL_SELECT_BASIC);
			sql.append(SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			//preparedStatement.setString(1, "%" + searchWord + "%");
			preparedStatement.setString(1, "%" + searchName + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			//if (!resultSet.isBeforeFirst()) {
			//	System.out.println("該当者はいませんでした");
			//	return employees;
			//}

			// レコードの取得
			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				department = new Department();
				department.setDeptName(resultSet.getString("dept_name"));
				employee.setDepartment(department);
				employees.add(employee);
			}

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
		return employees;
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static List<Employee> findDeptId(int deptId) throws ClassNotFoundException, SQLException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Employee> employees = new ArrayList<>();
		Employee employee = null;
		Department department = null;
		
		//System.out.print(ConstantMsg.MENU_MESSAGE_DEPTID_INPUT);
		
		//String deptId2 = br.readLine();
		//int deptId = Integer.parseInt(deptId2);

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(SQL_SELECT_BASIC);
			sql.append(SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, deptId);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			
			//if (!resultSet.isBeforeFirst()) {
			//	System.out.println("該当者はいませんでした");
			//	return employees;
			//}

			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				department = new Department();
				department.setDeptName(resultSet.getString("dept_name"));
				employee.setDepartment(department);
				employees.add(employee);
			}

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
		return employees;
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday2 生年月日
	 * @param deptId 部署ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void insert(Employee employee)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//List<Employee> employees = new ArrayList<>();
		//Employee employee = null;
		//Department department = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		// 登録する値を入力
		//System.out.print(ConstantMsg.MENU_MESSAGE_EMPLOYEE_NAME);
		//String emp_name = br.readLine();
		//System.out.print(ConstantMsg.MENU_MESSAGE_GENERAL);
		//String Seibetsu = br.readLine();
		//int Seibetsu2 = Integer.parseInt(Seibetsu);
		//System.out.print(ConstantMsg.MENU_MESSAGE_BIRTHDAY);
		//String birthday = br.readLine();
		//String strDate = birthday.replaceAll("/", "-");
		//Date birthday2 = java.sql.Date.valueOf(strDate);
		//System.out.print(ConstantMsg.MENU_MESSAGE_DEPTID);
		//String deptIdInsert = br.readLine();
		//int deptIdInt2 = Integer.parseInt(deptIdInsert);		
		
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(SQL_INSERT);

			// 入力値をバインド
			//preparedStatement.setString(1, emp_name);
			//preparedStatement.setInt(2, Seibetsu2);
			//preparedStatement.setDate(3, birthday2);
			//preparedStatement.setInt(4, deptIdInt2);
			
			// 社員名をバインド
			preparedStatement.setString(1, employee.getEmpName());
			// 性別をバインド
			preparedStatement.setInt(2, employee.getGender());
			// 誕生日をバインド
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(employee.getBirthday()), Types.DATE);
			// 部署IDをバインド
			preparedStatement.setInt(4, employee.getDepartment().getDeptId());
			
			// SQL文を実行
			preparedStatement.executeUpdate();
			// 登録完了メッセージを出力
			System.out.println("社員情報を登録しました");
		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
		//return employees;
	}
	
	/**
	 * 社員情報を1件更新
	 * 
	 * @param empId 社員ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static Integer update(Employee employee)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//List<Employee> employees = new ArrayList<>();
		//Employee employee = null;
		//Department department = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Integer exeCount = null;
		
		// 更新する値を入力する
		//System.out.print(MENU_MESSAGE_EMPLOYEE_UPDATE_INPUT);
		//String empId_1 = br.readLine();
		//int empId = Integer.parseInt(empId_1);

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(SQL_UPDATE);

			//System.out.print("社員名：");
			//String emp_name = br.readLine();
			// 性別を入力
			//System.out.print("性別(0:回答しない, 1:男性, 2:女性, 9:その他):");
			//String gender2 = br.readLine();
			//int gender = Integer.parseInt(gender2);
			// 誕生日を入力
			//System.out.print("生年月日(西暦年/月/日)：");
			//String birthday2 = br.readLine();
			//String strDate = birthday2.replaceAll("/", "-");
			//Date birthday = java.sql.Date.valueOf(strDate);

			// 部署IDを入力
			//System.out.print("部署ID(1：営業部、2：経理部、3：総務部)：");
			//String deptId2 = br.readLine();
			//int deptId = Integer.parseInt(deptId2);

			// 入力値をバインド
			//preparedStatement.setString(1, emp_name);
			//preparedStatement.setInt(2, gender);
			//preparedStatement.setDate(3, birthday);
			//preparedStatement.setInt(4, deptId);
			//preparedStatement.setInt(5, empId);
			
			// 社員名をバインド
			preparedStatement.setString(1, employee.getEmpName());
			// 性別をバインド
			preparedStatement.setInt(2, employee.getGender());
			// 誕生日をバインド
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(employee.getBirthday()), Types.DATE);
			// 部署IDをバインド
			preparedStatement.setInt(4, employee.getDepartment().getDeptId());
			// WHERE句をバインド
			preparedStatement.setInt(5, employee.getEmpId());

			// SQL文の実行(失敗時は戻り値0)
			exeCount = preparedStatement.executeUpdate();
			//System.out.println(MENU_MESSAGE_EMPLOYEE_INFORMATION_UPDATE);

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
		return exeCount;
	}

	/**
	 * 社員情報を1件削除
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public Integer delete(Integer empId) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//List<Employee> employees = new ArrayList<>();
		//Employee employee = null;
		//Department department = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Integer exeCount = null;
		
		// 社員名検索
		//System.out.print(MENU_MESSAGE_EMPLOYEE_DELETE_INPUT);
		// 検索ワード
		
		//String empId2 = br.readLine();
		//int empId = Integer.parseInt(empId2);
		

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(SQL_DELETE);

			// 社員名をバインド
			preparedStatement.setInt(1, empId);

			// SQL文の実行(失敗時は戻り値0)
			exeCount = preparedStatement.executeUpdate();
			//System.out.println(MENU_MESSAGE_EMPLOYEE_INFORMATION_DELETE);

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			// Statementをクローズ
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}
		return exeCount;
	}
}
