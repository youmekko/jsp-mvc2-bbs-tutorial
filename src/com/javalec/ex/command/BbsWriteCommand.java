package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BbsDAO;

public class BbsWriteCommand implements BbsCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String bbsName = request.getParameter("bbsName");
		String bbsTitle = request.getParameter("bbsTitle");
		String bbsContent = request.getParameter("bbsContent");

		BbsDAO dao = new BbsDAO();
		dao.write(bbsName, bbsTitle, bbsContent);

	}

}
