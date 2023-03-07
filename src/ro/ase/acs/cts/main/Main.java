package ro.ase.acs.cts.main;

import ro.ase.acs.cts.classes.EmployeeDataInsertor;
import ro.ase.acs.cts.classes.EmployeeReader;
import ro.ase.acs.cts.classes.EmployeeTableCreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            EmployeeTableCreator employeeTableCreator = new EmployeeTableCreator();
            employeeTableCreator.createTable(connection);

            EmployeeDataInsertor employeeDataInsertor = new EmployeeDataInsertor();
            employeeDataInsertor.inserData(connection);

            EmployeeReader employeeReader = new EmployeeReader();
            employeeReader.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}