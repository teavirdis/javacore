/*package by.bsuir.houses.server.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.houses.model.entities.Person;

public class _PersonDAO extends AbstractDAO<Person> {

	public _PersonDAO() throws InterruptedException, SQLException {
		super();

	}

	@Override
	public List<Person> findAll() throws HouseApplicationSQLException {
		PreparedStatement st = null;
		ArrayList<Person> list = new ArrayList<Person>();
		try {
			st = getConnection().prepareStatement(Constants.SQL_SELECT_NEWS);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Person person = this.newsFromResultSet(rs);
				list.add(person);
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
	public Person findEntityById(int id) throws HouseApplicationSQLException {
		PreparedStatement st = null;
		Person person = new Person();
		try {
			st = getConnection().prepareStatement(
					Constants.SQL_SELECT_NEWS_BY_ID);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs != null) {
				rs.next();
				person = this.newsFromResultSet(rs);
			}
		} catch (SQLException e) {
			throw new HouseApplicationSQLException(e.getMessage());
		} finally {
			close(st);
			closeConnection();
		}
		return person;
	}

	@Override
	public boolean delete(int id) throws HouseApplicationSQLException {
		PreparedStatement st = null;
		boolean flag = false;
		try {
			st = getConnection().prepareStatement(
					Constants.SQL_DELETE_NEWS_BY_ID);
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
	public boolean delete(Person entity) throws HouseApplicationSQLException {
		PreparedStatement st = null;
		boolean result = false;
		try {
			st = getConnection().prepareStatement(
					Constants.SQL_DELETE_NEWS_BY_CONTENT);
			st.setString(1, entity.getTitle());
			st.setString(2, entity.getBrief());
			st.setDate(3, entity.getDate());
			st.setString(4, entity.getContent());
			result = st.execute();
		} catch (SQLException e) {

			throw new HouseApplicationSQLException(e.getMessage());
		} finally {
			close(st);
			closeConnection();
		}
		return result;
	}

	@Override
	public Person create(Person entity) throws HouseApplicationSQLException {
		PreparedStatement st = null;

		try {
			st = getConnection().prepareStatement(Constants.SQL_CREATE_NEWS,
					new String[] { Constants.NEWS_ID });
			st.setInt(1, entity.getId());
			st.setString(2, entity.getTitle());
			st.setString(3, entity.getBrief());
			st.setDate(4, entity.getDate());
			st.setString(5, entity.getContent());
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
	public Person update(Person entity) throws HouseApplicationSQLException {
		PreparedStatement st = null;
		try {
			st = getConnection().prepareStatement(Constants.SQL_UPDATE_NEWS);
			st.setString(1, entity.getTitle());
			st.setString(2, entity.getBrief());
			st.setDate(3, entity.getDate());
			st.setString(4, entity.getContent());
			st.setInt(5, entity.getId());
			st.executeUpdate();
			st.executeUpdate();
		} catch (SQLException e) {

			throw new HouseApplicationSQLException(e.getMessage());
		} finally {
			close(st);
			closeConnection();
		}
		return entity;

	}

	private Person newsFromResultSet(ResultSet rs) throws SQLException {
		Person Person = new News();
		news.setId(rs.getInt(Constants.NEWS_ID));
		news.setTitle(rs.getString(Constants.NEWS_TITLE));
		news.setBrief(rs.getString(Constants.NEWS_BRIEF));
		news.setDate(rs.getDate(Constants.NEWS_DATE));
		news.setContent(rs.getString(Constants.NEWS_CONTENT));
		return news;
	}

	public boolean multiDelete(String[] id) throws HouseApplicationSQLException {
		StringBuilder sb = new StringBuilder();
		sb.append(Constants.SQL_MULTIDELETE_NEWS_BY_ID);
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
*/