package com.ea.dao.impl;

import com.ea.dao.WorldDao;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WorldDaoImpl implements WorldDao {
    @Override
    public List<Map<String, Object>> getCity() {
        List<Map<String, Object>> maps = new ArrayList<>();
        try {
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?serverTimezone=UTC","root","root");
            PreparedStatement preStatement = con.prepareStatement("select * from city;");
            ResultSet rs = preStatement.executeQuery();
            while (rs.next()){
                Map<String, Object> city = new HashMap<>();
                city.put("ID",rs.getInt("ID"));
                city.put("Name",rs.getString("Name"));
                city.put("CountryCode",rs.getString("CountryCode"));
                city.put("District",rs.getString("District"));
                city.put("Population",rs.getInt("Population"));
                maps.add(city);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return maps;
    }
}
