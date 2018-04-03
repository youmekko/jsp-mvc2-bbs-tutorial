package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BbsDAO;
import com.javalec.ex.dto.Bbs;

public class BbsContentCommand implements BbsCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		
		String bbsId = request.getParameter("bbsId");
		BbsDAO dao = new BbsDAO();
		Bbs bbs = dao.contentView(bbsId);
		
		request.setAttribute("content_view", bbs);
		
	}

}
