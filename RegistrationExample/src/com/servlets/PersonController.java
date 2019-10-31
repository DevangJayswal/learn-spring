package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Person;
import com.beans.PersonDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/PersonController")
public class PersonController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/person.jsp";
	private static String LIST = "/personList.jsp";
	private PersonDAO persondao;

	public PersonController() {
		super();
		persondao = new PersonDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			try {
				int personId = Integer.valueOf(request.getParameter("personId"));
				persondao.deletePerson(personId);
				forward = LIST;
				request.setAttribute("persons", persondao.getAllPersons());
			} catch (SQLException ex) {
				Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int personId = Integer.valueOf(request.getParameter("personId"));
			Person person;
			try {
				person = persondao.getPersonById(personId);
				request.setAttribute("person", person);
			} catch (SQLException ex) {
				Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
			}

		} else if (action.equalsIgnoreCase("listPerson")) {
			forward = LIST;
			try {
				request.setAttribute("persons", persondao.getAllPersons());
			} catch (SQLException ex) {
				Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int personId = 0;
		Person person = new Person();

		System.out.println("inside do post" + personId);
		personId = Integer.valueOf(request.getParameter("personId"));
		System.out.println("inside do post" + personId);
//                try {
//                    person = persondao.getPersonById(personId);
//                } catch (SQLException ex) {
//                    Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
//                }

		person.setId(personId);
		person.setFirstName(request.getParameter("firstName"));
		person.setLastName(request.getParameter("lastName"));
		person.setCity(request.getParameter("city"));
		person.setEmail(request.getParameter("email"));
		person.setPhone(request.getParameter("phone"));

		try {
			// persondao.checkPerson(person);
			System.out.println("personId..." + personId);
			
			System.out.println("doPost try main");
//			System.out.println("persondao.getPersonById(personId)..." + persondao.getPersonById(personId).getId());
			System.out.println("doPost try XYZ");
			
//			persondao.addPerson(person);
			
			if (!(persondao.getPersonById(personId).getId() == 0)) {
				System.out.println("doPost try if");
				persondao.updatePerson(person);
			}

			else {
				System.out.println("doPost try else");
				persondao.addPerson(person);
			}

		} catch (SQLException ex) {
			Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
		}

		List<Person> persons;
		try {
			persons = persondao.getAllPersons();
			request.setAttribute("persons", persons);
		} catch (SQLException ex) {
			Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
		}

		RequestDispatcher view = request.getRequestDispatcher(LIST);

		view.forward(request, response);
	}

}
