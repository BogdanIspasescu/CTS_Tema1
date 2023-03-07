package ro.ase.acs.cts.main;

import ro.ase.acs.cts.classes.EmployeeDataInsertor;
import ro.ase.acs.cts.classes.EmployeeReader;
import ro.ase.acs.cts.classes.EmployeeTableCreator;
import ro.ase.acs.cts.classes.SqliteConnectionManager;
import ro.ase.acs.cts.interfaces.ConnectionManager;
import ro.ase.acs.cts.interfaces.DataInsertor;
import ro.ase.acs.cts.interfaces.DataReader;
import ro.ase.acs.cts.interfaces.TableCreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            ConnectionManager connectionManager = new SqliteConnectionManager();
            Connection connection = connectionManager.getConnection();


            TableCreator employeeTableCreator = new EmployeeTableCreator();
            employeeTableCreator.createTable(connection);

            DataInsertor employeeDataInsertor = new EmployeeDataInsertor();
            employeeDataInsertor.inserData(connection);

            DataReader employeeReader = new EmployeeReader();
            employeeReader.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}