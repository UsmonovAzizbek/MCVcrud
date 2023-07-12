import sun.util.resources.cldr.ml.CalendarData_ml_IN;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dbservice {
    private String URL = "jdbc:postgresql://localhost:5432/teamproject";
    private String DBUser = "postgres";

    private String DBPassword = "1";

    public Users loginUser(String username, String password) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(URL, DBUser, DBPassword);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from userslist where username=? and password=?;");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username1 = resultSet.getString("username");
                String password1 = resultSet.getString("password");
                String address = resultSet.getString("address");
                boolean admin = resultSet.getBoolean("admin");
                Users userList = new Users(id, username1, password1, address, admin);
                return userList;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Users createUser(String username, String password, String address, boolean admin) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(URL, DBUser, DBPassword);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into  userslist(username,password,address, admin) values(?,?,?,?);");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, address);
            preparedStatement.setBoolean(4, admin);
            preparedStatement.executeUpdate();
            return new Users(username, password, address, admin);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Users> list() {
        try {
            Connection connection = DriverManager.getConnection(URL, DBUser, DBPassword);
            Statement statement = connection.createStatement();
            String query = "select * from userslist";
            ResultSet resultSet = statement.executeQuery(query);
            List<Users> usersList = new ArrayList<>();
            while (resultSet.next()){
                Users users = new Users();
                users.setId(resultSet.getInt("id"));
                users.setUsername(resultSet.getString("username"));
                users.setPassword(resultSet.getString("password"));
                users.setAddress(resultSet.getString("address"));
                users.setAdmin(resultSet.getBoolean("admin"));
                usersList.add(users);
            }
            return usersList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Users update(Users users) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            String query = "update userslist set username = ?,password = ?,address = ? where id = "+users.getId();
            Connection connection = DriverManager.getConnection(URL, DBUser, DBPassword);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, users.getUsername());
            preparedStatement.setString(2, users.getPassword());
            preparedStatement.setString(3, users.getAddress());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
public  void deleteUser(int id) throws SQLException {
        try {
             String query = "delete from userslist where id= " + id + ";";
             Connection connection = DriverManager.getConnection(URL, DBUser, DBPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             preparedStatement.executeQuery();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
}

}