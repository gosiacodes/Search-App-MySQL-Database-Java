package searchPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String searchVal = request.getParameter("searchVal");
		
		// Check if search phrase is empty
		if (searchVal.isEmpty()) {
			out.println("<h2 align='center'> You have to enter search phrase! </h2>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}

		else {
			
			ResultSet rs = (ResultSet) SearchQueryDBHandler.ikeaDBResult(searchVal);
			ResultSet rs2 = (ResultSet) SearchQueryDBHandler.bearDBResult(searchVal);
			ResultSet rs3 = (ResultSet) SearchQueryDBHandler.masterscpDBResult(searchVal);

			// Check if there are any results
			try {
				// If no results or incorrect search phrase 
				if (!rs.isBeforeFirst() & !rs2.isBeforeFirst() & !rs3.isBeforeFirst()) {
					out.print("<h2 align='center'>No matches found or inccorect search phrase!</h2>");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.include(request, response);
				}

				else {
					// Print html table with results
					out.println("<button onclick=\"document.location='index.jsp'\">Search again</button>");
					out.println("<h2 align='center'>Searching result for '" + searchVal + "': </h2>");
					out.println("<table align='center' border='1' style=width:600px><tr>"
							+ "<th>Name / Character / SCP</th><th>Description / Origin / Title</th>"
							+ "<th>Column3 / Creator / Rating</th><th>Column4 / Notes / Classification</th>"
							+ "<th>Column5 / Type</th><th>Related GOIs</th><th>Location Notes</th>"
							+ "<th>Author</th><th>Leaked Info</th><th>Humanoid or Structure</th>"
							+ "<th>Animal Computer or Extradimensional</th><th>Autonomous or Cognitohazard</th>"
							+ "<th>Artifact Location or Sentient</th><th>Summary</th><th>Gender</th>"
							+ "<th>None</th><th>Ethnicity Origins</th></tr>");
					
					
					// Print result from ikea database
					try {
						System.out.println("********** Result from ikea database. **********");
						while (rs.next()) {
							out.println("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) 
								+ "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) 
								+ "</td><td>" + rs.getString(5) + "</td><td></td><td></td><td></td><td></td>"
								+ "<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
						}

					} catch (SQLException ex) {
						ex.printStackTrace();
						System.out.println("SQLException: " + ex.getMessage());
						System.out.println("SQLState: " + ex.getSQLState());
						System.out.println("VendorError: " + ex.getErrorCode());
					}

					// Print result from bear database
					try {
						System.out.println("********** Result from bear database. **********");
						while (rs2.next()) {
							out.println("<tr><td>" + rs2.getString(1) + "</td><td>" + rs2.getString(2) + "</td><td>"
									+ rs2.getString(3) + "</td><td>" + rs2.getString(4) + "</td><td></td><td></td>"
									+ "<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>"
									+ "<td></td><td></td><td></td><tr>");
						}

					} catch (SQLException ex) {
						ex.printStackTrace();
						System.out.println("SQLException: " + ex.getMessage());
						System.out.println("SQLState: " + ex.getSQLState());
						System.out.println("VendorError: " + ex.getErrorCode());
					}

					// Prints result from masterscp database
					try {
						System.out.println("********** Result from masterscp database. **********");
						while (rs3.next()) {
							out.println("<tr><td>" + rs3.getString(1) + "</td><td>" + rs3.getString(2) 
								+ "</td><td>" + rs3.getString(3) + "</td><td>" + rs3.getString(4) 
								+ "</td><td>" + rs3.getString(5) + "</td><td>" + rs3.getString(6) 
								+ "</td><td>" + rs3.getString(7) + "</td><td>" + rs3.getString(8) 
								+ "</td><td>" + rs3.getString(9) + "</td><td>" + rs3.getString(10) 
								+ "</td><td>" + rs3.getString(11) + "</td><td>" + rs3.getString(12) 
								+ "</td><td>" + rs3.getString(13) + "</td><td>" + rs3.getString(14) 
								+ "</td><td>" + rs3.getString(15) + "</td><td>" + rs3.getString(16) 
								+ "</td><td>" + rs3.getString(17) + "</td><tr>");
						}

					} catch (SQLException ex) {
						ex.printStackTrace();
						System.out.println("SQLException: " + ex.getMessage());
						System.out.println("SQLState: " + ex.getSQLState());
						System.out.println("VendorError: " + ex.getErrorCode());
					}

					System.out.println("********** End of table. **********");
					out.print("</table>");

				}

			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
