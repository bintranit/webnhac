package webnhac.Service.Imp;

import java.util.List;

import webnhac.Dao.IbaihatDao;
import webnhac.Dao.Imp.baihatDao;
import webnhac.Model.baihatModel;
import webnhac.Model.baihatcasiModel;
import webnhac.Model.baihattheotheloaiModel;
import webnhac.Service.IbaihatService;

public class baihatService implements IbaihatService {
	private IbaihatDao baihat_Dao;
	public baihatService() {
		super();
		this.baihat_Dao = new baihatDao();
	}

	@Override
	public List<baihatModel> findAll_byIDtheloai(Integer id_theloai) {
		return this.baihat_Dao.findAll_byIDtheloai(id_theloai);
	}

	@Override
	public List<baihatcasiModel> findAll_byIDtheloai_limit(Integer id_theloai, Integer start, Integer sotheloai1trang) {
		return this.baihat_Dao.findAll_byIDtheloai_limit(id_theloai, start, sotheloai1trang);
	}

	@Override
	public List<baihatModel> findAll() {
		return this.baihat_Dao.findAll();
	}

	@Override
	public List<baihatcasiModel> findAll_limit(Integer start, Integer soluong1dong) {
		return this.baihat_Dao.findAll_limit(start, soluong1dong);
		
	}

	@Override
	public List<baihatcasiModel> find_byIDmusic(Integer id_baihat) {
		return this.baihat_Dao.find_byIDmusic(id_baihat);
	}

	@Override
	public List<baihatModel> findAll_nghenhieu() {
		return this.baihat_Dao.findAll_nghenhieu();
	}

	@Override
	public List<baihattheotheloaiModel> findAll_byIdcasi(Integer id_casi, Integer id_baihat) {
		return this.baihat_Dao.findAll_byIdcasi(id_casi, id_baihat);
	}

	@Override
	public List<baihatModel> findAll_byIDcasilist(Integer id_casi) {
		return this.baihat_Dao.findAll_byIDcasilist(id_casi);
	}

	@Override
	public List<baihatcasiModel> findALL_limitbaihattheocasi(Integer id_casi, Integer start, Integer sobai1trang) {
		return this.baihat_Dao.findALL_limitbaihattheocasi(id_casi, start, sobai1trang);
	}



	

	

}
