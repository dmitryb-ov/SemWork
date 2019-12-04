package com.company.dao.jdbc;

import com.company.dao.MyUserDao;
import com.company.dao.RowMapper;
import com.company.model.MyUser;
import com.company.role.MyRoleEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMyUserDaoImpl implements MyUserDao {
    private Connection connection;

    public JdbcMyUserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<MyUser> userRowMapper = resultSet -> new MyUser(
            resultSet.getInt("id"),
            resultSet.getString("email"),
            resultSet.getString("password"),
            resultSet.getString("name"),
            resultSet.getString("secondName"),
            resultSet.getString("group_id"),
            resultSet.getInt("points"),
            MyRoleEnum.valueOf(resultSet.getString("role"))
    );


    @Override
    public MyUser get(String email) {
        String SQL = "SELECT * FROM my_user_table WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                MyUser u = null;
                if (resultSet.next()) {
                    u = userRowMapper.mapRow(resultSet);
                }
                return u;
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<MyUser> getAll() {
        String SQL = "SELECT * FROM my_user_table";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            List<MyUser> users = new ArrayList<>();
            while (resultSet.next()) {
                MyUser u = userRowMapper.mapRow(resultSet);
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void create(MyUser item) {
        String SQL = "INSERT INTO my_user_table(email,password,name,secondName," +
                "group_id,points,role) VALUES(?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1,item.getEmail());
            preparedStatement.setString(2,item.getPassword());
            preparedStatement.setString(3,item.getName());
            preparedStatement.setString(4,item.getSecondName());
            preparedStatement.setString(5,item.getGroupId());
            preparedStatement.setInt(6,item.getPoints());
            preparedStatement.setString(7,item.getRole().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(String email, MyUser userItem) {
        String SQL = "UPDATE my_user_table SET name = ?," +
                "secondName = ?, group_id = ?, points = ?, role = ? WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1, userItem.getName());
            preparedStatement.setString(2, userItem.getSecondName());
            preparedStatement.setString(3,userItem.getGroupId());
            preparedStatement.setInt(4,userItem.getPoints());
            preparedStatement.setString(5,userItem.getRole().toString());
            preparedStatement.setString(6,email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void delete(String email) {
        String SQL = "DELETE FROM my_user_table WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1,email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
