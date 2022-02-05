package webnhac.Service.Imp;

import java.util.List;

import webnhac.Dao.IcasiDao;
import webnhac.Dao.Imp.casiDao;
import webnhac.Model.casiModel;
import webnhac.Service.IcasiService;

public class casiService implements IcasiService {
	private IcasiDao casi_Dao;
	public casiService() {
		super();
		this.casi_Dao = new casiDao();
	} 

	@Override
	public List<casiModel> findAll_limit(Integer start, Integer soluong1dong) {
		return this.casi_Dao.findAll_limit(start, soluong1dong);
	}

	@Override
	public List<casiModel> findAll() {
		return this.casi_Dao.findAll();
	}
	
	
	

}
