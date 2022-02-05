package webnhac.Dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webnhac.Dao.IcasiDao;
import webnhac.Model.casiModel;
public class casiDao extends AbstractDao implements IcasiDao {

	@Override
	public List<casiModel> findAll_limit(Integer start, Integer soluong1dong) {
		List<casiModel> ds= new ArrayList<casiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT * FROM casi LIMIT ?,?  ";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, soluong1dong);
			rs=ps.executeQuery();			
			while (rs.next()) {
				casiModel casi = new casiModel();
				casi.setId(rs.getInt(1));
				casi.setTencasi(rs.getString(2));
				casi.setMota(rs.getString(3));
				casi.setHinhanh(rs.getString(4));
	              ds.add(casi);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}    	
	}

	@Override
	public List<casiModel> findAll() {
		List<casiModel> ds= new ArrayList<casiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT * FROM casi   ";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			rs=ps.executeQuery();			
			while (rs.next()) {
				casiModel casi = new casiModel();
				casi.setId(rs.getInt(1));
				casi.setTencasi(rs.getString(2));
				casi.setMota(rs.getString(3));
				casi.setHinhanh(rs.getString(4));
	              ds.add(casi);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}    	
	}

	

}
