package by.bsuir.houses.server.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.houses.model.entities.House;

public class HouseDAO extends AbstractDAO<House> {

	private static final String SQL_SELECT_HOUSES = "select * from house;";
	private static final String SQL_SELECT_HOUSES_BY_ID = "select * from house where idhouse = ?;";
	private static final String SQL_DELETE_HOUSES_BY_ID = "delete from house where idhouse = ?;";
	private final static String SQL_CREATE_HOUSES = "insert into house(housename, houseaddr, housesize) values (?,?,?)";
	private final static String SQL_UPDATE_HOUSES = "update house set housename=?, houseaddr=?, housesize=?  where idhouse=?";
	private final static String SQL_MULTIDELETE_HOUSES_BY_ID = "delete from house where idhouse in (";
	
	public final static String HOUSES_ID = "idhouse";

	public HouseDAO() throws InterruptedException, SQLException {
		super();

	}

	@Override
	public List<House> findAll() throws HouseApplicationSQLException {
		PreparedStatement st = null;
		ArrayList<House> list = new ArrayList<House>();
		try {
			st = getConnection().prepareStatement(SQL_SELECT_HOUSES);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				House house = this.newsFromResultSet(rs);
				list.add(house);
			}
		} catch (SQLException e) {
			throw new HouseApplicationSQLException(e.getMessage());
		} finally {
			close(st);
			closeConnection();
		}
		return list;
	}

	@Override
	public House findEntityById(int id) throws HouseApplicationSQLException {
		PreparedStatement st = null;
		House house = new House();
		try {
			st = getConnection().prepareStatement(SQL_SELECT_HOUSES_BY_ID);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs != null) {
				rs.next();
				house = this.newsFromResultSet(rs);
			}
		} catch (SQLException e) {
			throw new HouseApplicationSQLException(e.getMessage());
		} finally {
			close(st);
			closeConnection();
		}
		return house;
	}

	@Override
	public boolean delete(int id) throws HouseApplicationSQLException {
		PreparedStatement st = null;
		boolean flag = false;
		try {
			st = getConnection().prepareStatement(SQL_DELETE_HOUSES_BY_ID);
			st.setInt(1, id);
			flag = st.execute();
		} catch (SQLException e) {

			throw new HouseApplicationSQLException(e.getMessage());
		} finally {
			close(st);
			closeConnection();
		}

		return flag;
	}

	@Override
	public House create(House entity) throws HouseApplicationSQLException {
		PreparedStatement st = null;

		try {
			st = getConnection().prepareStatement(SQL_CREATE_HOUSES,
					new String[] { HOUSES_ID });
			st.setString(1, "defaultName");//TODO: add a new field
			st.setString(2, entity.getAddress());
			st.setInt(3, entity.getSize());
			st.execute();
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				entity.setId(rs.getInt(1));
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new HouseApplicationSQLException(e.getMessage());
		} catch (SQLException e) {
			throw new HouseApplicationSQLException(e.getMessage());
		} finally {
			close(st);
			closeConnection();
		}
		return entity;
	}

	@Override
	public House update(House entity) throws HouseApplicationSQLException {
		PreparedStatement st = null;
		try {
			st = getConnection().prepareStatement(SQL_UPDATE_HOUSES);
			st.setString(1, "defName");//TODO: create 
			st.setString(2, entity.getAddress());
			st.setInt(3, entity.getSize());
			st.executeUpdate();
		} catch (SQLException e) {

			throw new HouseApplicationSQLException(e.getMessage());
		} finally {
			close(st);
			closeConnection();
		}
		return entity;

	}

	private House newsFromResultSet(ResultSet rs) throws SQLException {
		House house = new House();
		house.setId(rs.getInt(HOUSES_ID));
		house.setAddress(rs.getString("hoseaddr"));
		house.setSize(rs.getInt("housesize"));
		return house;
	}

	public boolean multiDelete(String[] id) throws HouseApplicationSQLException {
		StringBuilder sb = new StringBuilder();
		sb.append(SQL_MULTIDELETE_HOUSES_BY_ID);
		for (int i = 0; i < id.length; i++) {
			sb.append(id[i]);
			sb.append(",");
		}
		int comma = sb.lastIndexOf(",");
		sb.deleteCharAt(comma);
		sb.append(")");
		PreparedStatement st = null;
		boolean result = false;
		try {
			st = getConnection().prepareStatement(sb.toString());
			result = st.execute();
		} catch (SQLException e) {
			throw new HouseApplicationSQLException(e.getMessage());
		} finally {
			close(st);
			closeConnection();
		}
		return result;
	}

}
