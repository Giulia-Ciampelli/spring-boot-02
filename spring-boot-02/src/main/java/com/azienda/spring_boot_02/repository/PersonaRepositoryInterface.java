package com.azienda.spring_boot_02.repository;

import java.sql.SQLException;
import java.util.List;

public interface PersonaRepositoryInterface <T> {
	public void create(T persona) throws SQLException;
	public List<T> read() throws SQLException;
	public void update(T persona) throws SQLException;
	public void delete(T persona) throws SQLException;
}
