package ro.ase.acs.cts.interfaces;

import java.sql.Connection;

public interface TableCreator {
    void createTable(Connection connection) throws Exception;
}
