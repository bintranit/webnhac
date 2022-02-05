package webnhac.Service.Imp;

import java.util.List;

import webnhac.Dao.IcommentDao;
import webnhac.Dao.Imp.CommentDao;
import webnhac.Model.commentModel;
import webnhac.Model.comment_userModel;
import webnhac.Service.IcommentService;

public class commentService implements IcommentService {

	private IcommentDao comment_Dao;

	public commentService() {
		super();
		this.comment_Dao = new CommentDao();
	}

	@Override
	public List<commentModel> findAll_byIdmusic(Integer id_music) {
		return this.comment_Dao.findAll_byIdmusic(id_music);
	}

	@Override
	public List<comment_userModel> findcmtALL_byIDmusic(Integer id_music) {
		return this.comment_Dao.findcmtALL_byIDmusic(id_music);
	}

	@Override
	public void save(Integer idacc, Integer idbaihat, String msg) {
		this.comment_Dao.save(idacc, idbaihat, msg);
		
	}

}
