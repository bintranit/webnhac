package webnhac.Dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webnhac.Dao.ItheloaiDao;
import webnhac.Model.theloaiModel;

public class theloaiDao extends AbstractDao implements ItheloaiDao {

	@Override
	public List<theloaiModel> findAll() {
		List<theloaiModel> ds= new ArrayList<theloaiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vấn;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
	    String sql ="SELECT * FROM theloai";
	    
	    	CON=this.getConnection();
	    	try {
				ps=CON.prepareStatement(sql);
//				ps.setLong(1, 1);
				rs = ps.executeQuery();
				
				while(rs.next()) {
		    		theloaiModel theloai = new theloaiModel();
		    		theloai.setId(rs.getInt(1));
		    		theloai.setHinhanh(rs.getString(2));
		    		theloai.setTentheloai(rs.getString(3));
		    		ds.add(theloai);
		    		}
				return ds;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}

	@Override
	public List<theloaiModel> findAll_limit(Integer start, Integer soluong1dong) {
		List<theloaiModel> ds= new ArrayList<theloaiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT * FROM theloai LIMIT ?,?  ";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, soluong1dong);
			rs=ps.executeQuery();			
			while (rs.next()) {
	    		  theloaiModel theloai = new theloaiModel();
	    		  theloai.setId(rs.getInt(1));
	    		  theloai.setHinhanh(rs.getString(2));
	    		  theloai.setTentheloai(rs.getString(3));
	              ds.add(theloai);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}    	 
		
	}

	@Override
	public List<theloaiModel> find_byIDtheloai(Integer id_theloai) {
		List<theloaiModel> ds= new ArrayList<theloaiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vấn;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
	    String sql ="SELECT * FROM theloai WHERE id =?";
	    
	    	CON=this.getConnection();
	    	try {
				ps=CON.prepareStatement(sql);
				ps.setInt(1, id_theloai);
				rs = ps.executeQuery();
				
				while(rs.next()) {
		    		theloaiModel theloai = new theloaiModel();
		    		theloai.setId(rs.getInt(1));
		    		theloai.setHinhanh(rs.getString(2));
		    		theloai.setTentheloai(rs.getString(3));
		    		ds.add(theloai);
		    		}
				return ds;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}




	

}
