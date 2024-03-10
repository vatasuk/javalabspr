package com.example.javalabspr.data;

import com.example.javalabspr.Entity.City;
import com.example.javalabspr.Entity.Park;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JDBCParkRepository implements ParkRepository {
    private JdbcTemplate jdbcTemplate;
    public  JDBCParkRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Park> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM park ORDER BY parkname ASC", BeanPropertyRowMapper.newInstance(Park.class));
    }

    @Override
    public Park findById(int id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject(
                "SELECT * FROM park where id = ?",args,BeanPropertyRowMapper.newInstance(Park.class));
    }

    @Override
    public List<Park> findByCityId(int id) {
        Object[] args = {id};
        return jdbcTemplate.query(
                "SELECT id,cityid,pl,water,parktype,parkname,parkdate FROM park WHERE cityid = ?",args, BeanPropertyRowMapper.newInstance(Park.class));
    }

    @Override
    public Park save(Park park) {
        jdbcTemplate.update(
                "INSERT INTO park(cityid,pl,water,parktype,parkname,parkdate) VALUES (?,?,?,?,?,?) ",
                park.getCityid(),park.getPl(),park.getWater(),park.getParktype(),park.getParkname(),park.getParkdate());
        return park;
    }
    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from park where id = ?", id);

    }
    @Override
    public int findCityId(int id){
        Object[] args = {id};
      return  jdbcTemplate.queryForObject("select cityid from park where id = ?", args, Integer.class);
    }
    public void update(Park park) {
        Object[] args = {park.getCityid(),park.getPl(),park.getWater(),park.getParktype(),park.getParkname(),park.getParkdate(),park.getId()};
        jdbcTemplate.update("UPDATE park SET cityid = ?,pl = ?,water = ?,parktype = ?,parkname = ?,parkdate = ? WHERE id=?",args );
    }
}
