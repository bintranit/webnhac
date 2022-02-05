package webnhac.Service.Imp;



import java.util.List;

import webnhac.Dao.ItheloaiDao;
import webnhac.Dao.Imp.theloaiDao;
import webnhac.Model.theloaiModel;
import webnhac.Service.ItheloaiService;

public class theloaiService implements ItheloaiService{

	private ItheloaiDao theloai_Dao;
	
	public theloaiService() {
		super();
		this.theloai_Dao = new theloaiDao();
	}
	@Override
	public List<theloaiModel> findALL() {
		return this.theloai_Dao.findAll();
	}
	@Override
	public List<theloaiModel> findAll_limit(Integer start, Integer sotheloai1trang) {
		return this.theloai_Dao.findAll_limit(start, sotheloai1trang);
	}
	@Override
	public List<theloaiModel> find_byIDtheloai(Integer id_theloai) {
		return this.theloai_Dao.find_byIDtheloai(id_theloai);
	}
	
	

}
