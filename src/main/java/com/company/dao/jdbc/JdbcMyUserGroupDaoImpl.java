package com.company.dao.jdbc;

import com.company.dao.MyUserGroupDao;
import com.company.dao.RowMapper;
import com.company.model.Group;
import com.company.model.MyUserGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcMyUserGroupDaoImpl implements MyUserGroupDao {
    private Connection connection;

    public JdbcMyUserGroupDaoImpl(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<MyUserGroup> roleRowMapper = resultSet-> new MyUserGroup(
            resultSet.getString("user_mail"),
            resultSet.getString("group_number")
    );

    @Override
    public MyUserGroup get(String id) {
        String SQL = "SELECT * FROM user_groups WHERE group_number = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1,id);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                MyUserGroup role = null;
                if(resultSet.next()){
                    role = roleRowMapper.mapRow(resultSet);
                }
                return role;
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void saveUserGroup(String userMail, MyUserGroup group){
        String SQL = "INSERT INTO user_groups(user_mail,group_number) VALUES(?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1,userMail);
            preparedStatement.setString(2,group.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
