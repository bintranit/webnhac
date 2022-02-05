package webnhac.Dao;

import java.util.List;

import webnhac.Model.baihatModel;
import webnhac.Model.casiModel;
import webnhac.Model.theloaiModel;

public interface IcasiDao {
	List<casiModel> findAll_limit(Integer start, Integer soluong1dong );
	List<casiModel> findAll();
}
