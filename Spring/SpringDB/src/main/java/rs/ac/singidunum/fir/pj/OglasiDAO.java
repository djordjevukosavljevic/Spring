package rs.ac.singidunum.fir.pj;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

// DAO - DATA ACCESS OBJECT
@Component("oglasDao")
public class OglasiDAO{
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	// dohvatanje svih oglasa iz baze podataka
	public List<Oglas> getOglasi(){
		return jdbc.query("SELECT * FROM oglasi", new RowMapper<Oglas>() {
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
	
}
