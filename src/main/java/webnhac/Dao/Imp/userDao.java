package webnhac.Dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webnhac.Dao.IuserDao;
import webnhac.Model.userModel;

public class userDao extends AbstractDao implements IuserDao {

	@Override
	public List<userModel> find_taikhoan(String tentaikhoan, String matkhau) {
		List<userModel> ds= new ArrayList<userModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vấn;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
	    String sql ="SELECT * FROM user WHERE tentk = ? AND matkhau = ? ";
	    
	    	CON=this.getConnection();
	    	try {
				ps=CON.prepareStatement(sql);
				ps.setString(1, tentaikhoan);
				ps.setString(2, matkhau);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					userModel user = new userModel();
					user.setId(rs.getInt(1));
					user.setTentk(rs.getString(2));
					user.setMatkhau(rs.getString(3));
					user.setHoten(rs.getString(4));
					user.setHinhanh(rs.getString(5));
					user.setQuyen(rs.getInt(6));
					
		    		ds.add(user);
		    		}
				return ds;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}



	@Override
	public void addtaikhoan(String newusername, String newpassword, String hoten) {
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vấn;
	    String sql ="INSERT INTO user (tentk, matkhau, hoten) VALUES (?,?,?) ";
	    
	    	CON=this.getConnection();
	    	try {
				ps=CON.prepareStatement(sql);
				ps.setString(1, newusername);
				ps.setString(2, newpassword);
				ps.setString(3, hoten);
				ps.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}



	@Override
	public void edittaikhoan(Integer id_taikhoan, String hoten) {
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vấn;
	    String sql ="UPDATE user SET hoten = ? WHERE id = ? ";
	    
	    	CON=this.getConnection();
	    	try {
				ps=CON.prepareStatement(sql);
				ps.setString(1, hoten);
				ps.setInt(2, id_taikhoan);
				ps.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
	}



	



	

}
