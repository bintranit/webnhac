package webnhac.Dao;

import java.util.List;

import webnhac.Model.theloaiModel;

public interface ItheloaiDao {
	List<theloaiModel> findAll();
	List<theloaiModel> findAll_limit(Integer start, Integer soluong1dong );
	List<theloaiModel> find_byIDtheloai(Integer id_theloai );

}
