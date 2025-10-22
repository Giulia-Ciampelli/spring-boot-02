package com.azienda.spring_boot_02.repository;

import java.sql.SQLException;
import java.util.List;

import com.azienda.spring_boot_02.model.Macchina;

public interface MacchinaRepositoryInterface <T> {
	public void create(T macchina) throws SQLException;
	public List<T> readAll() throws SQLException;
	public Macchina read(Integer id) throws SQLException;
	public void update(T macchina) throws SQLException;
	public void delete(T macchina) throws SQLException;
}
