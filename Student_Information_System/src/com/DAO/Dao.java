package com.DAO;

import java.sql.SQLException;


public interface Dao {
    void insert(Object obj) throws SQLException;
    void update(int id,Object obj) throws SQLException;
    void delete(int id) throws SQLException;
}

