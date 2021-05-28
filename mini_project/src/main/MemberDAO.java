package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;




/**
 * 
 * MemberDAO클래스 - db 접근하기 위한 클래스
 * <ol>
 * <li>싱글톤 사용<li>
 * <li>회원 추가<li>
 * <li>아이디 중복 확인<li>
 * <li>이메일, 패스워드, 닉네임 전체 삭제<li>
 * <li>로그인 확인<li>
 * <ol>
 */
public class MemberDAO extends JFrame{
	
	
	private static MemberDAO instance;
	public MemberDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	
	
//	private static final String LOGIN_E = "아이디";
//	private static final String LOGIN_PASSWORD = "비밀번호";
	
	
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver"; // Driver 클래스 풀네임 (JQFN)
	private static final String DB_URL = "jdbc:mysql://localhost:3306/memberlistDB?" + "useUnicode=true" + "&characterEncoding=utf8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "1234";

	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ps;

	
	public void insertMember(MemberDTO dto) {  // 회원 추가
		String sql = "INSERT INTO member(email, password, nickName) "
				+ "VALUES(?, ?, ?)";
		
		try {
		
			conn = getConnection();
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getEmail());
			ps.setString(2, dto.getPassword());
			ps.setString(3, dto.getNickName());
			ps.executeUpdate();

			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn,ps,null);
		}
		
	}

	List<MemberDTO> findAll(){
		String sql = "SELECT * FROM member";
		List<MemberDTO> list = new ArrayList<>();
		MemberDTO dto = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new MemberDTO();
				dto.setEmail(rs.getString(1));
				dto.setPassword(rs.getString(2));
				dto.setNickName(rs.getString(3));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return list.isEmpty() ? null : list;
	}
	
	
	
	public int confirmEmail(String email) { //아이디 중복 확인
		String sql;
		boolean check = false;
		try {
			conn = getConnection();
			sql = "SELECT email FROM member WHERE email = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			check = rs.next();
			if(check == true) {
				return 1;	//가입완료
			}else {
				JOptionPane.showMessageDialog(null, "사용가능");
				return 0;
			}
				
		}catch(Exception e){
			
			System.out.println(e.toString());
		}finally {
			close(conn,ps,rs);
			
		}
		return -1; 
	}
	
	
	public int delete(String email){ // 이메일, 패스워드, 닉네임 전체 삭제
		String sql = "DELETE FROM member WHERE email = ?"; 
		int deletedRow = 0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			deletedRow = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, null); 
		}
		return deletedRow;
	}
	 public int login(String email,String password) { // 로그인 확인
	        String sql = "SELECT email, password FROM member WHERE email = ?";
	        try {
	        	conn = getConnection();
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, email);
	            rs = ps.executeQuery();
	            if(rs.next()) {
	                if(rs.getString("password").equals(password)) {
	              
	                    return 1; //확인
	                }
	                else {
	                	
	                    return 0; // 틀림
	                }
	            }
	            return -1;    // 오류
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
	        return -2;
	    }
	
	

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	}
	
	private void close(Connection conn, PreparedStatement ps) {
		close(conn, ps, null); 
	}
	
	private void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) { rs.close(); }
			if(ps != null) { ps.close(); }
			if(conn != null) { conn.close(); }
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
		
		
		public static void main(String[] args) {
			MemberDAO dao = MemberDAO.getInstance();
			MemberDTO dto = new MemberDTO();
			
			System.out.println(dto.getEmail());
					}
		
		
	}
	

