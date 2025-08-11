package jp.co.sss.crud.db;

import static jp.co.sss.crud.util.ConstantMsg.*;
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
import jp.co.sss.crud.exception.SystemErrorException;


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
	public static List<Employee> findAllDisplay() throws SystemErrorException, SQLException {
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
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);

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
	public static List<Employee> findEmployeeName(String searchName) throws SystemErrorException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Employee> employees = new ArrayList<>();
		Employee employee = null;
		Department department = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();
			// SQL文を準備
			StringBuffer sql = new StringBuffer(SQL_SELECT_BASIC);
			sql.append(SQL_SELECT_BY_EMP_NAME);
			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());
			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + searchName + "%");
			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

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

		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);

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
	public static List<Employee> findDeptId(int deptId) throws SystemErrorException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Employee> employees = new ArrayList<>();
		Employee employee = null;
		Department department = null;
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

		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);

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
			throws SystemErrorException, ParseException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			// DBに接続
			connection = DBManager.getConnection();
			// ステートメントを作成
			preparedStatement = connection.prepareStatement(SQL_INSERT);
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
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);

		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
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
			throws SystemErrorException, ParseException, SQLException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Integer exeCount = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();
			// ステートメントの作成
			preparedStatement = connection.prepareStatement(SQL_UPDATE);
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

		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);

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
	public Integer delete(Integer empId) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Integer exeCount = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();
			// ステートメントの作成
			preparedStatement = connection.prepareStatement(SQL_DELETE);
			// 社員名をバインド
			preparedStatement.setInt(1, empId);
			// SQL文の実行(失敗時は戻り値0)
			exeCount = preparedStatement.executeUpdate();

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
