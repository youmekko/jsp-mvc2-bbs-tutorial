package com.javalec.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.command.*;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("actionDo");

		request.setCharacterEncoding("UTF-8");

		String viewPage = null;
		BbsCommand bbsCommand = null;

		// request.getRequestURI()는 웹전체 경로(프로젝트명+ 파일 경로)까지 반환한다.
		// 요청 : http://localhost:8080/example/test.jsp
		// 리턴값 : /example/test.jsp

		// 내경우는 20180403_MVCboard/write_view.do
		String uri = request.getRequestURI();

		// request.getContextPath()는 프로젝트의 Context path명을 반환한다.
		// 요청 : http://localhost:8080/example/test.jsp
		// 리턴값 : /example

		// 내 경우는 /20180403_MVCboard
		String conPath = request.getContextPath();

		// uri에서 string을 짤라내는데 conpath의 길이만큼잘라내고 그 다음인덱스부터가 시작 인덱스이다.
		// 그럼 딱 필요한 명령만큼만 남음
		// /write_view.do
		String command = uri.substring(conPath.length());

		if (command.equals("/write_view.do")) {
			System.out.println("go write_view.jsp");
			viewPage = "write_view.jsp";

		} else if (command.equals("/write.do")) {
			bbsCommand = new BbsWriteCommand();
			bbsCommand.execute(request, response);
			System.out.println("go list.do");
			viewPage = "list.do";

		} else if (command.equals("/list.do")) {
			bbsCommand = new BbsListCommand();
			bbsCommand.execute(request, response);
			System.out.println("go list.jsp");
			viewPage = "list.jsp";

		} else if (command.equals("/content_view.do")) {
			bbsCommand = new BbsContentCommand();
			bbsCommand.execute(request, response);
			viewPage = "content_view.jsp";

		} else if (command.equals("/modify.do")) {
			bbsCommand = new BbsModifyCommand();
			bbsCommand.execute(request, response);
			viewPage = "list.do";

		} else if (command.equals("/delete.do")) {
			bbsCommand = new BbsDeleteCommand();
			bbsCommand.execute(request, response);
			viewPage = "list.do";

		} else if (command.equals("/reply_view.do")) {
			bbsCommand = new BbsReplyViewCommand();
			bbsCommand.execute(request, response);
			viewPage = "reply_view.jsp";

		} else if (command.equals("/reply.do")) {
			bbsCommand = new BbsReplyCommand();
			bbsCommand.execute(request, response);
			viewPage = "list.do";
		}

		// request -> response 단계에서 forward와 sendRedirect 방식이 있다.
		// forward 방식에서는 A.jsp -> Servlet -> B.jsp로 파라미터 정보가 넘어가지만
		// snedRedirect 방식에서는 정보를 제외한 단순히 페이지만 호출한다는 차이가있다.
		// forward만 하게되면 따로 처리를 해주지 않을 시 B 다음 단계에서의 A 파리미터가 소실된다.
		// RequestDistpatcher는 정보유지를 위해 사용된다.
		// 즉 request에 n이란는 이름의 attribute를 저장 후 forward 시킨다는 의미이다.

		// Dispacther의 사전적 의미는 발송자 라는 뜻이 있다.
		// 즉 RequestDispatcher 은 요청을 보내주는 클래스라고 할수 있다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

		// dispatcher의 메소드는 2가지가 있다.
		// 1.include(HttpServletRequest request, HttpServletResponse response)
		// 클라이언트로 부터의 요청과 응답정보를 넘겨 실행한 결과를 포함한다.

		// 2.forward(HttpServletRequest request, HttpServletResponse response)
		// 클라이언트로부터의 요청과 응답정보를 아규먼트로 모든 제어를 넘겨버린다.

		// sendRedirect와의 차이점은 sendRedirect는 페이지를 이동시키긴 하지만 바인딩을 하지 않으므로
		// 데이터를 가져가지않는다.
		// RequestDispatcher방식은 바인딩을 하여 데이터까지 해당주소로 넘겨버린다.

		// 여기서 바인딩이란.. ?

	}

}
