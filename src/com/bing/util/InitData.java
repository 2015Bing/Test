package com.bing.util;

import java.util.ArrayList;
import java.util.List;

import com.bing.bean.Menu;

public class InitData {
	private static List<Menu> menus=new ArrayList<Menu>();
	public static List<Menu> initMenu(){
		Menu menu1=new Menu(1,-1,"博安达");
		Menu menu2=new Menu(2,1,"产品研发部");
		Menu menu3=new Menu(3,2,"黄健兵");
		menus.add(menu1);
		menus.add(menu2);
		menus.add(menu3);
		return menus;
	}
	public static List<Menu> getMenu(int pid){
		InitData.initMenu();
		List<Menu> result=new ArrayList<Menu>();
		for(Menu menu:menus){
			if(menu.getPid()==pid)result.add(menu);
		}
		return result;
	}
}
