package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BbsDAO;
import com.javalec.ex.dto.Bbs;

public class BbsReplyCommand implements BbsCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

//		String bbsId = request.getParameter("bbsId");
        String bbsName = request.getParameter("bbsName");
        String bbsTitle = request.getParameter("bbsTitle");
        String bbsContent = request.getParameter("bbsContent");
        String bbsGroup = request.getParameter("bbsGroup");
        String bbsStep = request.getParameter("bbsStep");
        String bbsIndent = request.getParameter("bbsIndet");
        
        BbsDAO dao = new BbsDAO();
        dao.reply(bbsName, bbsTitle, bbsContent, bbsGroup, bbsStep, bbsIndent);

	}

}
