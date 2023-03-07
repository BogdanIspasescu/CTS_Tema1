package ro.ase.acs.cts.classes;

import ro.ase.acs.cts.interfaces.DataInsertor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class EmployeeDataInsertor implements DataInsertor {
    @Override
    public void inserData(Connection connection) throws Exception {
        String sqlInsert = "INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlInsert);
        statement.close();

        String sqlInsertWithParams = "INSERT INTO employees VALUES (?,?,?,?)";
        PreparedStatement preparedStatement =
                connection.prepareStatement(sqlInsertWithParams);
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, "Ionescu Vasile");
        preparedStatement.setString(3, "Brasov");
        preparedStatement.setDouble(4, 4500);
        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.commit();
    }
}
