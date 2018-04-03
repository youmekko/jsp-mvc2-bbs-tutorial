package com.javalec.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BbsDAO;
import com.javalec.ex.dto.Bbs;

public class BbsListCommand implements BbsCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		BbsDAO dao = new BbsDAO();
		ArrayList<Bbs> bbss = dao.list();
		request.setAttribute("list", bbss);
		

	}

}
