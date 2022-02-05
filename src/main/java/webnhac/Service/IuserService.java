package webnhac.Service;

import java.util.List;

import webnhac.Model.userModel;

public interface IuserService {
	List<userModel> find_taikhoan(String tentaikhoan, String matkhau);
	void addtaikhoan(String newusername,String newpassword,String hoten);
	void edittaikhoan(Integer id_taikhoan,String hoten);
}
