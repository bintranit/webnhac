package webnhac.Dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webnhac.Dao.IbaihatDao;
import webnhac.Model.baihatModel;
import webnhac.Model.baihatcasiModel;
import webnhac.Model.baihattheotheloaiModel;


public class baihatDao extends AbstractDao implements IbaihatDao {

	@Override
	public List<baihatModel> findAll_byIDtheloai(Integer id_theloai) {
		List<baihatModel> ds= new ArrayList<baihatModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT * FROM music WHERE idtheloai = ? ";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, id_theloai);
			rs=ps.executeQuery();			
			while (rs.next()) {
	    		  baihatModel baihat = new baihatModel();
	    		  baihat.setId(rs.getInt(1));	
	    			baihat.setIdcasi(rs.getInt(2));
	    			baihat.setIdtheloai(rs.getInt(3));
	    			baihat.setNgaytao(rs.getString(4));
	    			baihat.setLuotnghe(rs.getInt(5));
	    			baihat.setLinkhinhanh(rs.getString(6));	
	    			baihat.setTennhac(rs.getString(7));	
	    			baihat.setLinknhac(rs.getString(8));	
	    			baihat.setLoibaihat(rs.getString(9));
	    		
	    			

	              ds.add(baihat);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		} 	 
	}

	@Override
	public List<baihatcasiModel> findAll_byIDtheloai_limit(Integer id_theloai, Integer start, Integer sotheloai1trang) {
		List<baihatcasiModel> ds= new ArrayList<baihatcasiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT music.*, casi.tencasi , casi.mota, casi.hinhanh FROM music INNER JOIN casi on music.idcasi=casi.id WHERE idtheloai=? LIMIT ?,?;";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, id_theloai);
			ps.setInt(2, start);
			ps.setInt(3, sotheloai1trang);
			rs=ps.executeQuery();			
			while (rs.next()) {
				baihatcasiModel baihat = new baihatcasiModel();
				baihat.setId(rs.getInt(1));
				baihat.setIdcasi(rs.getInt(2));
				baihat.setIdtheloai(rs.getInt(3));
				baihat.setNgaytao(rs.getString(4));
				baihat.setLuotnghe(rs.getInt(5));
				baihat.setLinkhinhanh(rs.getString(6));
				baihat.setTennhac(rs.getString(7));
				baihat.setLinknhac(rs.getString(8));
				baihat.setLoibaihat(rs.getString(9));
				baihat.setTencasi(rs.getString(10));
				baihat.setMotacasi(rs.getString(11));
				baihat.setHinhanhcasi(rs.getString(12));
				ds.add(baihat);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}    	 
	}

	@Override
	public List<baihatModel> findAll() {
		List<baihatModel> ds= new ArrayList<baihatModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT * FROM music ORDER BY RAND();  ";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			rs=ps.executeQuery();			
			while (rs.next()) {
				baihatModel baihat = new baihatModel();
				baihat.setId(rs.getInt(1));
				baihat.setIdcasi(rs.getInt(2));
				baihat.setIdtheloai(rs.getInt(3));
				baihat.setNgaytao(rs.getString(4));
				baihat.setLuotnghe(rs.getInt(5));
				baihat.setLinkhinhanh(rs.getString(6));
				baihat.setTennhac(rs.getString(7));
				baihat.setLinknhac(rs.getString(8));
				baihat.setLoibaihat(rs.getString(9));
				ds.add(baihat);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		} 	 
		
	}

	@Override
	public List<baihatcasiModel> findAll_limit(Integer start, Integer soluong1dong) {
		
		List<baihatcasiModel> ds= new ArrayList<baihatcasiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT music.*, casi.tencasi , casi.mota, casi.hinhanh FROM music INNER JOIN casi on music.idcasi=casi.id  LIMIT ?,?;";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);		
			ps.setInt(1, start);
			ps.setInt(2, soluong1dong);
			rs=ps.executeQuery();			
			while (rs.next()) {
				baihatcasiModel baihat = new baihatcasiModel();
				baihat.setId(rs.getInt(1));
				baihat.setIdcasi(rs.getInt(2));
				baihat.setIdtheloai(rs.getInt(3));
				baihat.setNgaytao(rs.getString(4));
				baihat.setLuotnghe(rs.getInt(5));
				baihat.setLinkhinhanh(rs.getString(6));
				baihat.setTennhac(rs.getString(7));
				baihat.setLinknhac(rs.getString(8));
				baihat.setLoibaihat(rs.getString(9));
				baihat.setTencasi(rs.getString(10));				
				baihat.setMotacasi(rs.getString(11));
				baihat.setHinhanhcasi(rs.getString(12));
				ds.add(baihat);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		} 
		
	}

	@Override
	public List<baihatcasiModel> find_byIDmusic(Integer id_baihat) {
		List<baihatcasiModel> ds= new ArrayList<baihatcasiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
	    String sql = "SELECT music.*, casi.tencasi , casi.mota, casi.hinhanh FROM music INNER JOIN casi on music.idcasi=casi.id  WHERE music.id = ?";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);		
			ps.setInt(1, id_baihat);

			rs=ps.executeQuery();			
			while (rs.next()) {
				baihatcasiModel baihat = new baihatcasiModel();
				baihat.setId(rs.getInt(1));
				baihat.setIdcasi(rs.getInt(2));
				baihat.setIdtheloai(rs.getInt(3));
				baihat.setNgaytao(rs.getString(4));
				baihat.setLuotnghe(rs.getInt(5));
				baihat.setLinkhinhanh(rs.getString(6));
				baihat.setTennhac(rs.getString(7));
				baihat.setLinknhac(rs.getString(8));
				baihat.setLoibaihat(rs.getString(9));
				baihat.setTencasi(rs.getString(10));				
				baihat.setMotacasi(rs.getString(11));
				baihat.setHinhanhcasi(rs.getString(12));
				ds.add(baihat);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public List<baihatModel> findAll_nghenhieu() {
		List<baihatModel> ds= new ArrayList<baihatModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT * FROM music WHERE luotnghe > 30 ";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			rs=ps.executeQuery();			
			while (rs.next()) {
	    		  baihatModel baihat = new baihatModel();
	    		  baihat.setId(rs.getInt(1));	
	    			baihat.setIdcasi(rs.getInt(2));
	    			baihat.setIdtheloai(rs.getInt(3));
	    			baihat.setNgaytao(rs.getString(4));
	    			baihat.setLuotnghe(rs.getInt(5));
	    			baihat.setLinkhinhanh(rs.getString(6));	
	    			baihat.setTennhac(rs.getString(7));	
	    			baihat.setLinknhac(rs.getString(8));	
	    			baihat.setLoibaihat(rs.getString(9));
	    		
	    			

	              ds.add(baihat);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		} 	 
	}

	@Override
	public List<baihattheotheloaiModel> findAll_byIdcasi(Integer id_casi, Integer id_baihat) {
		List<baihattheotheloaiModel> ds= new ArrayList<baihattheotheloaiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
	    String sql = "SELECT music.*,theloai.tentheloai FROM `music` INNER JOIN theloai ON music.idtheloai = theloai.id  WHERE music.idcasi = ? and NOT music.id = ? LIMIT 0,3";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);		
			ps.setInt(1, id_casi);
			ps.setInt(2, id_baihat);
			rs=ps.executeQuery();			
			while (rs.next()) {
				baihattheotheloaiModel baihat = new baihattheotheloaiModel();
				baihat.setId(rs.getInt(1));
				baihat.setIdcasi(rs.getInt(2));
				baihat.setIdtheloai(rs.getInt(3));
				baihat.setNgaytao(rs.getString(4));
				baihat.setLuotnghe(rs.getInt(5));
				baihat.setLinkhinhanh(rs.getString(6));
				baihat.setTennhac(rs.getString(7));
				baihat.setLinknhac(rs.getString(8));
				baihat.setLoibaihat(rs.getString(9));
				baihat.setTentheloai(rs.getString(10));
				ds.add(baihat);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public List<baihatModel> findAll_byIDcasilist(Integer id_casi) {
		List<baihatModel> ds= new ArrayList<baihatModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
	    String sql = "SELECT * FROM music WHERE idcasi = ?";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);		
			ps.setInt(1, id_casi);
			rs=ps.executeQuery();			
			while (rs.next()) {
				baihatModel baihat = new baihatModel();
	    		  baihat.setId(rs.getInt(1));	
	    			baihat.setIdcasi(rs.getInt(2));
	    			baihat.setIdtheloai(rs.getInt(3));
	    			baihat.setNgaytao(rs.getString(4));
	    			baihat.setLuotnghe(rs.getInt(5));
	    			baihat.setLinkhinhanh(rs.getString(6));	
	    			baihat.setTennhac(rs.getString(7));	
	    			baihat.setLinknhac(rs.getString(8));	
	    			baihat.setLoibaihat(rs.getString(9));
				ds.add(baihat);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public List<baihatcasiModel> findALL_limitbaihattheocasi(Integer id_casi, Integer start, Integer sobai1trang) {
		List<baihatcasiModel> ds= new ArrayList<baihatcasiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT music.*, casi.tencasi , casi.mota, casi.hinhanh FROM music INNER JOIN casi on music.idcasi=casi.id WHERE idcasi=? LIMIT ?,?;";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, id_casi);
			ps.setInt(2, start);
			ps.setInt(3, sobai1trang);
			rs=ps.executeQuery();			
			while (rs.next()) {
				baihatcasiModel baihat = new baihatcasiModel();
				baihat.setId(rs.getInt(1));
				baihat.setIdcasi(rs.getInt(2));
				baihat.setIdtheloai(rs.getInt(3));
				baihat.setNgaytao(rs.getString(4));
				baihat.setLuotnghe(rs.getInt(5));
				baihat.setLinkhinhanh(rs.getString(6));
				baihat.setTennhac(rs.getString(7));
				baihat.setLinknhac(rs.getString(8));
				baihat.setLoibaihat(rs.getString(9));
				baihat.setTencasi(rs.getString(10));
				baihat.setMotacasi(rs.getString(11));
				baihat.setHinhanhcasi(rs.getString(12));
				ds.add(baihat);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}   
	}

}
