package com.service.impl;

import com.service.TopSearchService;
import com.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TopSearchServiceImpl implements TopSearchService {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet = null;

    @Override
    public List<String> list() {
        String sql = "select top 10 ts_key from topSearch order by ts_count desc";
        List<String> list = new ArrayList<>(10);
        try {
            connection = DBUtil.getConn();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(resultSet.getString("ts_key"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<String> list(String key) {
        String sql = "select top 10 info_title from info where info_title like ? order by info_clickCount desc";
        List<String> list = new ArrayList<>(10);
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"%"+key+"%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("info_title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, resultSet);
        }
        return list;
    }
}
