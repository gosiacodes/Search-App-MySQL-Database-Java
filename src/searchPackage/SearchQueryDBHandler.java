package searchPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchQueryDBHandler {

	public static ResultSet ikeaDBResult(String searchVal) {
		// % -> makes that it can be anything before or anything after the searching word
		// ? -> placeholder
		ResultSet rs = null;
		Connection conn = MySQLConnection.connectSQL();

		try {
			String sql = "SELECT * FROM `ikea_names` WHERE ikea_names.name LIKE ? OR ikea_names.description LIKE ? "
					+ "OR ikea_names.Column_3 LIKE ? OR ikea_names.Column_4 LIKE ? OR ikea_names.Column_5 LIKE ?";
			String query = "%" + searchVal + "%";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, query);
			ps.setString(2, query);
			ps.setString(3, query);
			ps.setString(4, query);
			ps.setString(5, query);

			rs = ps.executeQuery();
			System.out.println("********** Searching in ikea database done! **********");

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return rs;

	}

	public static ResultSet bearDBResult(String searchVal) {
		ResultSet rs = null;
		Connection conn = MySQLConnection.connectSQL();

		try {
			String sql = "SELECT * FROM `bearbase` WHERE bearbase.Character LIKE ? OR bearbase.Origin LIKE ? "
					+ "OR bearbase.Creator LIKE ? OR bearbase.Notes LIKE ?";
			String query = "%" + searchVal + "%";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, query);
			ps.setString(2, query);
			ps.setString(3, query);
			ps.setString(4, query);

			rs = ps.executeQuery();
			System.out.println("********** Searching in bear database done! **********");

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return rs;

	}

	public static ResultSet masterscpDBResult(String searchVal) {
		ResultSet rs = null;
		Connection conn = MySQLConnection.connectSQL();

		try {
			String sql = "SELECT * FROM `masterscplist` WHERE masterscplist.SCP LIKE ? OR masterscplist.Title LIKE ? "
					+ "OR masterscplist.rating LIKE ? OR masterscplist.Classification LIKE ? OR masterscplist.Type LIKE ? "
					+ "OR masterscplist.Related_GOI_s LIKE ? OR masterscplist.Location_Notes LIKE ? OR masterscplist.Author LIKE ? "
					+ "OR masterscplist.Leaked_Info LIKE ? OR masterscplist.Humanoid_or_Structure LIKE ? "
					+ "OR masterscplist.Animal_Computer_or_Extradimensional LIKE ?  OR masterscplist.Autonomous_or_Cognitohazard LIKE ? "
					+ "OR masterscplist.Artifact_Location_or_Sentient LIKE ? OR masterscplist.Summary LIKE ? "
					+ "OR masterscplist.Gender LIKE ? OR masterscplist.None LIKE ? OR masterscplist.Ethnicity_Origins LIKE ?";

			String query = "%" + searchVal + "%";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, query);
			ps.setString(2, query);
			ps.setString(3, query);
			ps.setString(4, query);
			ps.setString(5, query);
			ps.setString(6, query);
			ps.setString(7, query);
			ps.setString(8, query);
			ps.setString(9, query);
			ps.setString(10, query);
			ps.setString(11, query);
			ps.setString(12, query);
			ps.setString(13, query);
			ps.setString(14, query);
			ps.setString(15, query);
			ps.setString(16, query);
			ps.setString(17, query);

			rs = ps.executeQuery();
			System.out.println("********** Searching in master database done! **********");

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return rs;
	}

}
