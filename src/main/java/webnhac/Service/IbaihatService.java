package webnhac.Service;

import java.util.List;

import webnhac.Model.baihatModel;
import webnhac.Model.baihatcasiModel;
import webnhac.Model.baihattheotheloaiModel;

public interface IbaihatService {
	List<baihatModel> findAll();
	List<baihatModel> findAll_byIDtheloai(Integer id_theloai);
	List<baihatcasiModel> findAll_limit(Integer start, Integer soluong1dong );
	List<baihatcasiModel> findAll_byIDtheloai_limit(Integer id_theloai,Integer start, Integer sotheloai1trang );
	List<baihatcasiModel> find_byIDmusic(Integer id_baihat );
	List<baihatModel> findAll_nghenhieu();
	List<baihattheotheloaiModel> findAll_byIdcasi(Integer id_casi,Integer id_baihat);
	List<baihatModel> findAll_byIDcasilist(Integer id_casi);
	List<baihatcasiModel> findALL_limitbaihattheocasi(Integer id_casi, Integer start, Integer sobai1trang );
}
