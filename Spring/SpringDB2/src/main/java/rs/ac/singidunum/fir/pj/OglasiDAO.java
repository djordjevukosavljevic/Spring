package rs.ac.singidunum.fir.pj;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

// DAO - DATA ACCESS OBJECT
@Component("dao")
public class OglasiDAO{
	
	private NamedParameterJdbcTemplate jdbc;
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	// Dohvatanje svih oglasa iz baze podataka
	public List<Oglas> getOglasi() {
		return jdbc.query("SELECT * FROM oglasi", new RowMapper<Oglas>() {
			
			public Oglas mapRow(ResultSet rs, int rowNum) throws SQLException{
					Oglas oglas = new Oglas();
					
					oglas.setId(rs.getInt("id"));
					oglas.setIme(rs.getString("ime"));
					oglas.setEmail(rs.getString("email"));
					oglas.setTekst(rs.getString("tekst"));
					
					return oglas;
			}
		});
	}
	
	// Dohvatanje samo jednog oglasa po ID-ju
	public Oglas getOglasbyID(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.queryForObject("SELECT * FROM oglasi WHERE id=:id", params, new RowMapper<Oglas>() {
			public Oglas mapRow(ResultSet rs, int rowNum) throws SQLException {
				Oglas oglas = new Oglas();
				oglas.setId(rs.getInt("id"));
				oglas.setIme(rs.getString("ime"));
				oglas.setEmail(rs.getString("email"));
				oglas.setTekst(rs.getString("tekst"));
				return oglas;
			}
		});
	}
	
	// DELETE po ID-ju
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.update("DELETE FROM oglasi WHERE id=:id", params) == 1;
	}
	
	// INSERT
	public boolean insert(Oglas oglas) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(oglas);
		return jdbc.update("INSERT INTO oglasi (id, ime, email, tekst) VALUES (:id, :ime, :email, :tekst)", params) == 1;
	}
	
}
