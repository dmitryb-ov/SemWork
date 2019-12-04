package com.company.dao.jdbc;

import com.company.dao.GroupDao;
import com.company.dao.RowMapper;
import com.company.model.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcGroupDaoImpl implements GroupDao {
    private Connection connection;

    public JdbcGroupDaoImpl(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<Group> groupRowMapper = resultSet -> new Group(
            resultSet.getInt("group_id"),
            resultSet.getString("group_number")
    );

    @Override
    public Group get(int id) {
        String SQL = "SELECT * FROM group_table WHERE group_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                Group g = null;
                if(resultSet.next()){
                    g = groupRowMapper.mapRow(resultSet);
                }
                return g;
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Group get(String groupNumber) {
        String SQL = "SELECT * FROM group_table WHERE group_number = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1, groupNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                Group g = null;
                if(resultSet.next()){
                    g = groupRowMapper.mapRow(resultSet);
                }
                return g;
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void add(Group group) {
        String SQL = "INSERT INTO group_table(group_number) VALUES(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1,group.getGroupNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void delete(String groupNumber) {
        String SQL = "DELETE FROM group_table WHERE group_number = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1,groupNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Group> getAll() {
        String SQL  = "SELECT * FROM group_table";
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(SQL);
            List<Group> groups = new ArrayList<>();
            while (resultSet.next()){
                Group g = groupRowMapper.mapRow(resultSet);
                groups.add(g);
            }
            return groups;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
