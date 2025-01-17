package controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Product;
import service.Service;
import service.ServiceImpl;

/**
 * Servlet implementation class AddController
 */
@WebServlet("/seller/Add")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service service = new ServiceImpl();
		
		Product p = new Product();
		
		String img = "";
		
		int maxSize = 1024 * 1024 * 10;
		MultipartRequest multi = null;
	
		String uploadPath="C:\\Users\\KOSTA\\Desktop\\workspace2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\shop_img";
		
		try {
			p.setNum(service.makeNum());
			
			//request, 파일저장경로, 용량, 인코딩타입, 중복 파일명에 대한 기본 정책
			//new DefaultFileRenamePolicy() 중복되는 파일에서 이름 새로 생성 옵션
			multi = new MultipartRequest(request, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
			p.setName(multi.getParameter("name"));
			p.setQuantity(Integer.parseInt(multi.getParameter("quantity")));
			p.setPrice(Integer.parseInt(multi.getParameter("price")));
			p.setContent(multi.getParameter("content"));
			
			//전송한 전체 파일 이름들을 가져옴
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements()){
				//form 태크에서 name="여기에 지정한 이름"을 가져온다.
				String file1 = (String)files.nextElement();
				//그에 해당하는 실제 파일 이름을 가져옴
				//옵션1:: 파일 본래의 이름이 DB에 저장되며, 이미지만 새로운 네임으로 저장된다. 
				/* img = multi.getOriginalFileName(file1); */
				//옵션2:: 중복 파일 시 새로운 이름이 DB에 저장되며, 이미지도 새로운 네임으로 저장된다.
				img = multi.getFilesystemName(file1);
				//파일 업로드
				File file = multi.getFile(file1);
				
			}
			
			p.setImg("/shop_img/"+img);
			service.add(p);
	
			
			String path="/seller/List";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			if(dispatcher != null) {
				dispatcher.forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
