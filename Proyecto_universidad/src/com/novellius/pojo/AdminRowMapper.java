package com.novellius.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AdminRowMapper implements RowMapper<Admin>{

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin = new Admin();
		
		admin.setIdAd(rs.getInt("idAd"));
		admin.setCarnet(rs.getInt("carnet"));
		admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
		admin.setEstudiante(rs.getString("estudiante"));
		admin.setCarrera(rs.getString("carrera"));
		admin.setPromedio(rs.getInt("promedio"));
		
		return admin;
	}

}
