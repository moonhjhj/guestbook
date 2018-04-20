package com.javaex.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

/**
 * Servlet implementation class GuestbookController
 */
@WebServlet("/gb")
public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("controller");
		String cmd = request.getParameter("a");

		if ("add".equals(cmd)) {

			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");
			GuestbookVo vo = new GuestbookVo(name, password, content);
			GuestbookDao dao = new GuestbookDao();
			dao.insert(vo);
			List<GuestbookVo> list = dao.getList();
			request.setAttribute("list", list);
			System.out.println("삽입 완료");
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
			
//
//			DateFormat reg_date = new SimpleDateFormat("yy/MM/dd");
//			Date d;
//			try {
//				d = (Date) reg_date.parse("yy/MM/dd");
//
//				GuestbookVo vo = new GuestbookVo(name, password, content, d);
//				// GuestbookVo vo = new GuestbookVo(name, password, content, reg_date);
//				GuestbookDao dao = new GuestbookDao();
//				dao.insert(vo);
//				List<GuestbookVo> list = dao.getList();
//
//				request.setAttribute("list", list);
//				// RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
//				// rd.forward(request, response);
//
//				System.out.println("삽입 완료");
//				response.sendRedirect("/guestbook/gb");
//
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		} else if ("delete".equals(cmd)) {

		} else {
			String no = request.getParameter("no");
			
			 GuestbookDao dao = new GuestbookDao();
			 
//			 List<GuestbookVo> list = dao.delete(no);
			
			 request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);

		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
