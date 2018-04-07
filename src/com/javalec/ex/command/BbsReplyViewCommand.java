package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BbsDAO;
import com.javalec.ex.dto.Bbs;

public class BbsReplyViewCommand implements BbsCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String bbsId = request.getParameter("bbsId");

		BbsDAO dao = new BbsDAO();
		Bbs bbs = dao.reply_view(bbsId);
		
		request.setAttribute("reply_view", bbs);

	}

}
