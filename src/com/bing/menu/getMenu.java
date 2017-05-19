package com.bing.menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bing.bean.Menu;


import net.sf.json.JSONArray;

/**
 * Servlet implementation class getMenu
 */
@WebServlet("/getMenu")
public class getMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Menu> menus=new ArrayList<Menu>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
        PrintWriter out = response.getWriter();
        String pid=request.getParameter("pid");
        List<Menu> list=getMenu(Integer.parseInt(pid));
        for(Menu menu:list){
        	if(!getMenu(menu.getId()).isEmpty()){
        		menu.setState("closed");
        	}else{
        		menu.setState("open");
        	}
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        out.println(jsonArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		Menu menu1=new Menu(1,-1,"博安达");
		Menu menu2=new Menu(2,1,"产品研发部");
		Menu menu3=new Menu(3,2,"黄健兵");
		menus.add(menu1);
		menus.add(menu2);
		menus.add(menu3);
	}

	public List<Menu> getMenu(int pid){
		List<Menu> result=new ArrayList<Menu>();
		for(Menu menu:menus){
			if(menu.getPid()==pid)result.add(menu);
		}
		return result;
	}
}
