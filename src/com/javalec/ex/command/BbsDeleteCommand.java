package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BbsDAO;

public class BbsDeleteCommand implements BbsCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String bbsId = request.getParameter("bbsId");

		BbsDAO dao = new BbsDAO();
		dao.delete(bbsId);

	}

}
