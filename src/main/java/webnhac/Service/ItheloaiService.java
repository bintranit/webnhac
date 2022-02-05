package webnhac.Service;

import java.util.List;

import webnhac.Model.theloaiModel;

public interface ItheloaiService {
	List<theloaiModel> findALL();
	List<theloaiModel> findAll_limit(Integer start, Integer sotheloai1trang );
	List<theloaiModel> find_byIDtheloai(Integer id_theloai );
}
