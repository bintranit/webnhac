package webnhac.Service;

import java.util.List;

import webnhac.Model.casiModel;

public interface IcasiService {
	List<casiModel> findAll_limit(Integer start, Integer soluong1dong );
	List<casiModel> findAll();
}
