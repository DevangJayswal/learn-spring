package com.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PersonDAO {

    Connection connection = null;
    String url;

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        if (connection == null) {
            url ="jdbc:oracle:thin:@localhost:1521:XE";
        }
        Connection connection
                = DriverManager.getConnection(url,"hr","oracle");
        connection.setAutoCommit(true);
        return connection;
    }
    
        
  


    public void addPerson(Person person) throws ClassNotFoundException {
        try {
            //  Connection con= getConnection();
            String insert = "INSERT INTO person(id,firstname,lastname,city,email,phone) VALUES (?,?,?,?,?,?)";

            
            System.out.println("inside addPerson");
            
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getCity());
            preparedStatement.setString(5, person.getEmail());
            preparedStatement.setString(6, person.getPhone());

            preparedStatement.executeUpdate();
            // connection.commit();

            preparedStatement.close();
            closeConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void updatePerson(Person person) throws ClassNotFoundException {
        try {
            //  Connection con= getConnection();
            String update = "update person "
                    + " set firstname = ?, "
                    + "  lastname = ? , "
                    + "   city = ?, "
                    + "   phone = ?,"
                    + "   email = ?   where id = ?";
            System.out.println("ypdate " + update);
            PreparedStatement preparedStatement = getConnection().prepareStatement(update);
            preparedStatement.setInt(6, person.getId());
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getCity());
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.setString(5, person.getPhone());

            preparedStatement.executeUpdate();
            // connection.commit();

            preparedStatement.close();
            closeConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public List<Person> getAllPersons() throws SQLException, ClassNotFoundException {
        List<Person> persons = new ArrayList<Person>();
        //   Connection con= getConnection();
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM person");

        Person person = null;
        
        while (resultSet.next()) {
            person = new Person();
            person.setId(Integer.parseInt(resultSet.getString("id")));
            person.setFirstName(resultSet.getString("firstname"));
            person.setLastName(resultSet.getString("lastname"));
            person.setCity(resultSet.getString("city"));
            person.setEmail(resultSet.getString("email"));
            person.setPhone(resultSet.getString("phone"));
            persons.add(person);
        }
        resultSet.close();
        statement.close();

        System.out.println(persons);
        closeConnection();
        return persons;
    }

    public Person getPersonById(int byId) throws SQLException, ClassNotFoundException {
        Person person = new Person();
        //   Connection con= getConnection();
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM person where id=" + byId);

        while (resultSet.next()) {
            person = new Person();
            person.setId(Integer.parseInt(resultSet.getString("id")));
            person.setFirstName(resultSet.getString("firstname"));
            person.setLastName(resultSet.getString("firstname"));
            person.setCity(resultSet.getString("city"));
            person.setEmail(resultSet.getString("email"));
            person.setPhone(resultSet.getString("phone"));

        }
        resultSet.close();
        statement.close();

        // System.out.println(persons);
        closeConnection();
        return person;
    }

    public void deletePerson(int byId) throws SQLException, ClassNotFoundException {
        Person person = new Person();
        //   Connection con= getConnection();
        Statement statement = getConnection().createStatement();
        int result = statement.executeUpdate("DELETE person where id=" + byId);

        statement.close();

        // System.out.println(persons);
        closeConnection();

    }

    public void closeConnection() throws SQLException {

        if (connection != null) {
            connection.close();
        }

    }

    @Override
    public String toString() {
        return "PersonDAO{" + "connection=" + connection + '}';
    }

}
