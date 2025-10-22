package com.azienda.spring_boot_02.repository;

import java.sql.SQLException;
import java.util.List;

public interface MacchinaRepositoryInterface <T> {
	public void create(T macchina) throws SQLException;
	public List<T> read() throws SQLException;
	public void update(T macchina) throws SQLException;
	public void delete(T macchina) throws SQLException;
}
