package webnhac.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mvel2.util.ThisLiteral;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import webnhac.Model.baihatcasiModel;
import webnhac.Model.userModel;
import webnhac.Service.IbaihatService;
import webnhac.Service.IcasiService;
import webnhac.Service.IcommentService;
import webnhac.Service.ItheloaiService;
import webnhac.Service.IuserService;
import webnhac.Service.Imp.baihatService;
import webnhac.Service.Imp.casiService;
import webnhac.Service.Imp.commentService;
import webnhac.Service.Imp.theloaiService;
import webnhac.Service.Imp.userService;

@Controller
public class HomeController {
	private ItheloaiService theloai_Service;
	private IbaihatService baihat_Service;
	private IcasiService casi_Service;
	private IuserService user_Service;
	private IcommentService comment_Service;
	public HomeController() {
		super();
		this.theloai_Service = new theloaiService();
		this.baihat_Service = new baihatService();
		this.casi_Service = new casiService();
		this.user_Service = new userService();
		this.comment_Service = new commentService();
	}
	// Trang dang nhap

	@RequestMapping(value = { "/", "/login" })
	public String login() {
		return "dangnhap";
	}
	@RequestMapping(value = "/dangxuat", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "dangnhap";
	}


	@RequestMapping(value = { "/xulydangnhap" }, method = RequestMethod.POST)
	public String xulydangnhap(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam(value = "page", defaultValue = "1") int page, HttpSession session, ModelMap md) {

		Integer Userdb = this.user_Service.find_taikhoan(username, password).size();// trả về số lương ca sĩ
//		Integer getquyen = this.user_Service.find_taikhoan(username, password).get(0).getQuyen();
		
		
		if (Userdb > 0 && this.user_Service.find_taikhoan(username, password).get(0).getQuyen() == 1) {
			session.setAttribute("username", username);
			return "index_admin";
		} else if (Userdb > 0 && this.user_Service.find_taikhoan(username, password).get(0).getQuyen() == 0) {
			session.setAttribute("username", username);
			Integer sobai1trang = 12;
			Integer tongbai = this.baihat_Service.findAll().size(); // Tra ve tong so luong
			Integer tongsotrang = 0;

			// set gia tri tong so trang
			if (tongbai % sobai1trang != 0)
				tongsotrang = tongbai / sobai1trang + 1;

			else
				tongsotrang = tongbai / sobai1trang;

			// Vi tri limit muon lay
			Integer start = (page - 1) * sobai1trang;
			String tenacc= this.user_Service.find_taikhoan(username,password).get(0).getHoten();
			String avtacc= this.user_Service.find_taikhoan(username,password).get(0).getHinhanh();
			Integer idacc= this.user_Service.find_taikhoan(username,password).get(0).getId();
			session.setAttribute("tenacc", tenacc);
			session.setAttribute("avtacc", avtacc);
			session.setAttribute("idacc", idacc);
			md.addAttribute("theloai", this.theloai_Service.findALL()); // Tra ve list
			md.addAttribute("dulieutrang", this.baihat_Service.findAll_limit(start, sobai1trang));// lấy tất cả bài hát
			md.addAttribute("dulieubaihattop", this.baihat_Service.findAll_nghenhieu());
			md.addAttribute("trang", page);
			md.addAttribute("tongsotrang", tongsotrang);
			return "index_user";
		} else {
			md.addAttribute("error", "Đăng nhập thất bại");
			return "dangnhap";
		}

	}

	@RequestMapping(value = { "/dangky" })
	public String dangky() {
		return "dangky";
	}

	@RequestMapping(value = {"/xulydangky"}, method = RequestMethod.POST)
	public String xulydangky(ModelMap md, @RequestParam("newusername") String newusername,
										@RequestParam("newpassword") String newpassword,
										@RequestParam("renewpassword") String renewpassword,
										@RequestParam("hoten") String hoten
										) {
		
		Integer Userdb = this.user_Service.find_taikhoan(newusername, newpassword).size();

		if(Userdb == 0 && newpassword.equals(renewpassword)) {
			this.user_Service.addtaikhoan(newusername,newpassword,hoten);
			md.addAttribute("tk", Userdb);
			
			return "dangnhap";
		}
		else {
			md.put("loidangky", "Đăng ký thất bại");
			return "dangky";
			
		}						
	}
	@RequestMapping(value = { "/caidat" })
	public String caidat() {
		return "thongtintaikhoan";
	}
	@RequestMapping(value = { "/xuly" })
	public String xuly(ModelMap md, @RequestParam("hoten") String hoten, 
			@RequestParam(value = "id_taikhoan", defaultValue = "1") int id_taikhoan ) {
		
		md.addAttribute("idtk",id_taikhoan);
//		this.user_Service.edittaikhoan(idtaikhoan, hoten);
		
		return "dangnhap";
	}


	@RequestMapping(value = { "/admin-index" })
	public String adminindex() {
		return "admincasi";
	}

	@RequestMapping(value = { "/admin-index/theloai" })
	public String admintheloai() {
		return "admintheloai";
	}

	@RequestMapping(value = { "/admin-index/baihat" })
	public String adminbaihat() {
		return "adminbaihat";
	}

// Trang index
	@RequestMapping(value = { "/trangchu" }, method = RequestMethod.GET) // Đường dẫn
	public String index(ModelMap md, @RequestParam(value = "page", defaultValue = "1") int page) {
		Integer sobai1trang = 12;
		Integer tongbai = this.baihat_Service.findAll().size(); // Tra ve tong so luong
		Integer tongsotrang = 0;

		// set gia tri tong so trang
		if (tongbai % sobai1trang != 0)
			tongsotrang = tongbai / sobai1trang + 1;

		else
			tongsotrang = tongbai / sobai1trang;

		// Vi tri limit muon lay
		Integer start = (page - 1) * sobai1trang;

		md.addAttribute("theloai", this.theloai_Service.findALL()); // Tra ve list
		md.addAttribute("dulieutrang", this.baihat_Service.findAll_limit(start, sobai1trang));// lấy tất cả bài hát
		md.addAttribute("dulieubaihattop", this.baihat_Service.findAll_nghenhieu());
		md.addAttribute("trang", page);
		md.addAttribute("tongsotrang", tongsotrang);
		return "index_user"; // tra ve giao dien
	}

	@RequestMapping(value = { "/theloai" }, method = RequestMethod.GET) // duog dan trang the loai
	public String category(ModelMap md, @RequestParam(value = "idtheloai", defaultValue = "1") int idtheloai,
			@RequestParam(value = "page", defaultValue = "1") int page) {

		Integer sonhac1trang = 12;
		Integer tongnhac = this.baihat_Service.findAll_byIDtheloai(idtheloai).size(); // Tra ve tong so luong bai hat
																						// cua 1 the loai
		Integer tongsotrang = 0;

		// set gia tri tong so trang
		if (tongnhac % sonhac1trang != 0)
			tongsotrang = tongnhac / sonhac1trang + 1;

		else
			tongsotrang = tongnhac / sonhac1trang;

		// Vi tri limit muon lay
		Integer start = (page - 1) * sonhac1trang;

		md.addAttribute("theloai", this.theloai_Service.findALL()); // Tra ve list
		md.addAttribute("dulieutrang", this.baihat_Service.findAll_byIDtheloai_limit(idtheloai, start, sonhac1trang));
		md.addAttribute("trang", page);
		md.addAttribute("tentheloai", this.theloai_Service.find_byIDtheloai(idtheloai).get(0));
		md.addAttribute("tongsotrang", tongsotrang);
		md.addAttribute("idtheloai", idtheloai);

		return "category";
	}

	@RequestMapping(value = { "/baihat" }, method = RequestMethod.GET)
	public String baihat(ModelMap md, @RequestParam(value = "idbaihat", defaultValue = "1") int idbaihat) {

		try {
			baihatcasiModel infobaihatcs = this.baihat_Service.find_byIDmusic(idbaihat).get(0); // lay ve 1 bai hat voi
																								// id truyen vao
			md.addAttribute("chitietbaihat", infobaihatcs); // dat chitietbaihat = bien infobaihat
			md.addAttribute("tentheloai", this.theloai_Service.find_byIDtheloai(infobaihatcs.getIdtheloai()).get(0)); 
			md.addAttribute("baihatcungcasi", this.baihat_Service.findAll_byIdcasi(infobaihatcs.getIdcasi(), idbaihat));
			md.addAttribute("baihatcmt", this.comment_Service.findcmtALL_byIDmusic(idbaihat));
			md.addAttribute("id_baihat", idbaihat);
		} catch (Exception e) {
			// ...
		}
		
		md.addAttribute("theloai", this.theloai_Service.findALL()); // Tra ve list
		md.addAttribute("theloai", this.theloai_Service.findALL());
		return "playsong";
	}
//	@RequestMapping(value = { "/baihat/binhluan" }, method = RequestMethod.POST)
//	public String baihatbinhluan(ModelMap md, @RequestParam(value = "idbaihat", defaultValue = "null") String idbaihat
//			) {
//
//return new 
//}
//	

	@RequestMapping(value = { "/casi" }, method = RequestMethod.GET)
	public String casi(ModelMap md, @RequestParam(value = "page", defaultValue = "1") int page) {
		Integer casi1trang = 12;
		Integer tongcasi = this.casi_Service.findAll().size(); // Tra ve tong so luong
		Integer tongsotrang = 0;

		// set gia tri tong so trang
		if (tongcasi % casi1trang != 0)
			tongsotrang = tongcasi / casi1trang + 1;

		else
			tongsotrang = tongcasi / casi1trang;

		// Vi tri limit muon lay
		Integer start = (page - 1) * casi1trang;

		md.addAttribute("casi", this.casi_Service.findAll()); // Tra ve list
		md.addAttribute("dulieutrang", this.casi_Service.findAll_limit(start, casi1trang));// lấy tất cả bài hát
		md.addAttribute("trang", page);
		md.addAttribute("tongsotrang", tongsotrang);
		md.addAttribute("theloai", this.theloai_Service.findALL());

		return "casi";
	}

	@RequestMapping(value = { "/infocasi" }, method = RequestMethod.GET) // duog dan trang the loai
	public String infocasi(ModelMap md, @RequestParam(value = "idcasi", defaultValue = "1") int idcasi,
			@RequestParam(value = "page", defaultValue = "1") int page) {

		Integer sonhac1trang = 12;
		Integer tongnhac = this.baihat_Service.findAll_byIDcasilist(idcasi).size(); // Tra ve tong so luong bai hat cua
																					// 1 the loai
		Integer tongsotrang = 0;

		// set gia tri tong so trang
		if (tongnhac % sonhac1trang != 0)
			tongsotrang = tongnhac / sonhac1trang + 1;

		else
			tongsotrang = tongnhac / sonhac1trang;

		// Vi tri limit muon lay
		Integer start = (page - 1) * sonhac1trang;

		md.addAttribute("dulieutrang", this.baihat_Service.findALL_limitbaihattheocasi(idcasi, start, sonhac1trang));
		md.addAttribute("trang", page);
		md.addAttribute("tongsotrang", tongsotrang);
		md.addAttribute("idcasi", idcasi);
		md.addAttribute("tencasi", this.baihat_Service.findALL_limitbaihattheocasi(idcasi, start, sonhac1trang).get(0));
		md.addAttribute("theloai", this.theloai_Service.findALL());

		return "infocasi";
	}
	
	@RequestMapping(value = "/xulycomment/{id_baihat}", method = RequestMethod.GET)
	public RedirectView xulycomment(@PathVariable(value = "id_baihat") Integer id_baihat, 
									@RequestParam( value = "comment") String msg,
									RedirectAttributes redirectAttributes,
									HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Integer idacc = (Integer) session.getAttribute("idacc");
		this.comment_Service.save(idacc,id_baihat,msg );
		return new RedirectView("http://localhost:8088/webnhac/baihat?idbaihat="+id_baihat);
	}

}
