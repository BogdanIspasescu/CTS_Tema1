package ro.ase.acs.cts.interfaces;

import java.sql.Connection;

public interface TableCreator {
    public void createTable(Connection connection) throws Exception;
}
