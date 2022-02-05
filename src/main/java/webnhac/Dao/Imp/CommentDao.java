package webnhac.Dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webnhac.Dao.IcommentDao;
import webnhac.Model.commentModel;
import webnhac.Model.comment_userModel;

public class CommentDao extends AbstractDao implements IcommentDao  {

	@Override
	public List<commentModel> findAll_byIdmusic(Integer id_music) {
		List<commentModel> ds= new ArrayList<commentModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT * FROM comment WHERE idmusic = ?  ";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1,id_music );
			rs=ps.executeQuery();			
			while (rs.next()) {
				commentModel comment = new commentModel();
				comment.setId(rs.getInt(1));
				comment.setIdMusic(rs.getInt(2));
				comment.setIdUser(rs.getInt(3));
				comment.setTextComment(rs.getString(4));
				
				ds.add(comment);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		} 	 
	}

	@Override
	public void addcomment(Integer idbaihat, Integer casi, String txtcomment) {
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vấn;
	    String sql ="INSERT INTO comment (idMusic, idUser , textComment) VALUES (?,?,?) ";
	    
	    	CON=this.getConnection();
	    	try {
				ps=CON.prepareStatement(sql);
				ps.setInt(1, idbaihat);
				ps.setInt(2, casi);
				ps.setString(3, txtcomment);
				ps.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}

	@Override
	public List<comment_userModel> findcmtALL_byIDmusic(Integer id_music) {
		List<comment_userModel> ds= new ArrayList<comment_userModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT comment.*,user.tentk,user.matkhau,user.hinhanh FROM `comment` INNER JOIN user on comment.idUser = user.id WHERE comment.idMusic = ?";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, id_music);
			rs=ps.executeQuery();			
			while (rs.next()) {
				comment_userModel comment = new comment_userModel();
	    		  	comment.setId(rs.getInt(1));	
	    			comment.setIdMusic(rs.getInt(2));
	    			comment.setIdUser(rs.getInt(3));
	    			comment.setTextComment(rs.getString(4));
	    			comment.setTentk(rs.getString(5));;
	    			comment.setMatkhau(rs.getString(6));
	    			comment.setHinhanh_user(rs.getString(7));
	    			
	              ds.add(comment);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}    	 
	}

	@Override
	public void save(Integer idacc, Integer idbaihat, String msg) {
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps = null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql = "INSERT INTO `comment` (`id`, `idMusic`, `idUser`, `textComment`) VALUES (NULL,?,?,?)";
		 
		  try {
			  CON = this.getConnection();
			  ps = CON.prepareStatement(sql);
			ps.setInt(1,(int) idbaihat);
			ps.setInt(2,(int) idacc);
			ps.setString(3,(String) msg);
			 ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
