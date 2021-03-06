package com.novellius.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.novellius.pojo.Admin;
import com.novellius.pojo.AdminRowMapper;

@Component("adminDao")
public class AdminDaoImpl implements AdminDao{
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public boolean save(Admin admin) {
//		MapSqlParameterSource paramMap = new MapSqlParameterSource();
//		paramMap.addValue("nombre", admin.getNombre());
//		paramMap.addValue("cargo", admin.getCargo());
//		paramMap.addValue("fechaCreacion", admin.getFechaCreacion());
		
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
		
		return jdbcTemplate.
				update("insert into Admin (carnet, estudiante, carrera, promedio, fechaCreacion) values (:carnet, :estudiante, :carrera, :promedio, :fechaCreacion)", paramMap) == 1;
	}

	@Override
	public List<Admin> findAll() {
		return jdbcTemplate.query("select * from Admin", new RowMapper<Admin>() {

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
		});
	}

	@Override
	public Admin findById(int id) {
//		return (Admin) jdbcTemplate.query("select * from Admin where idAd=:idAd", 
//				new MapSqlParameterSource("idAd", id) ,new AdminRowMapper());
		
		return jdbcTemplate.queryForObject("select * from Admin where idAd=:idAd", 
				new MapSqlParameterSource("idAd", id), new AdminRowMapper());
	}

	@Override
	public List<Admin> findByNombre(String nombre) {
		return jdbcTemplate.query("select * from Admin where nombre like :nombre", 
				new MapSqlParameterSource("nombre", "%" + nombre + "%"), new AdminRowMapper());
	}

	@Override
	public boolean update(Admin admin) {
		return jdbcTemplate.update("update Admin set carnet=:carnet, estudiante=:estudiante, carrera=:carrera, promedio=:promedio, fechaCreacion=:fechaCreacion where idAd=:idAd", 
				new BeanPropertySqlParameterSource(admin)) == 1;
	}

	@Override
	public boolean delete(int idAd) {
		return jdbcTemplate.update("delete from Admin where idAd=:idAd", new MapSqlParameterSource("idAd", idAd)) == 1;
	}

	@Transactional
	@Override
	public int[] saveAll(List<Admin> admins) {
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(admins.toArray());
		
		return jdbcTemplate.batchUpdate("insert into Admin (idAd, carnet, estudiante, carrera, promedio fechaCreacion) values (:idAd, :carnet, :estudiante, :carrera, :promedio, :fechaCreacion)", 
				batchArgs);
	}

	

}
