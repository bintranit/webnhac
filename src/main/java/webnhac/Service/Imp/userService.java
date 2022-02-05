package webnhac.Service.Imp;

import java.util.List;

import webnhac.Dao.IuserDao;
import webnhac.Dao.Imp.userDao;
import webnhac.Model.userModel;
import webnhac.Service.IuserService;

public class userService implements IuserService {
	private IuserDao user_Dao;

	public userService() {
		super();
		this.user_Dao = new userDao();
	}

	@Override
	public List<userModel> find_taikhoan(String tentaikhoan, String matkhau) {
		return this.user_Dao.find_taikhoan(tentaikhoan, matkhau);
	}



	@Override
	public void addtaikhoan(String newusername, String newpassword, String hoten) {
		 this.user_Dao.addtaikhoan(newusername, newpassword, hoten);
	}

	@Override
	public void edittaikhoan(Integer id_taikhoan, String hoten) {
		this.user_Dao.edittaikhoan(id_taikhoan, hoten);
		
		
	}

}
