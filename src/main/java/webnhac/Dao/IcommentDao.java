package webnhac.Dao;

import java.util.List;

import webnhac.Model.commentModel;
import webnhac.Model.comment_userModel;

public interface IcommentDao {
	List<commentModel> findAll_byIdmusic(Integer id_music);
	List<comment_userModel> findcmtALL_byIDmusic(Integer id_music);
	void addcomment(Integer idbaihat,Integer casi,String txtcomment);
	void save(Integer idacc, Integer idbaihat, String msg);
}
