package com.example.javalabspr.data;
import com.example.javalabspr.Entity.City;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCCityRepository implements CityRepository {
    private JdbcTemplate jdbcTemplate;

    public JDBCCityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<City> findAll() {
        return jdbcTemplate.query(
                "SELECT id, cityname, pop FROM city ORDER BY cityname ASC", BeanPropertyRowMapper.newInstance(City.class));
    }

    @Override
    public City findById(int id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject(
                "SELECT id, cityname, pop FROM city WHERE id = ?", args, BeanPropertyRowMapper.newInstance(City.class));
    }

    @Override
    public City save(City city) {
        jdbcTemplate.update(
                "INSERT INTO city(cityname,pop) VALUES(?,?)", city.getCityname(), city.getPop());
        return city;
    }
    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from park where cityid = ?", id);
        jdbcTemplate.update("DELETE FROM city WHERE id = ?", id);

    }
    public void update(City city) {
        Object[] args = {city.getCityname(), city.getPop(),city.getId()};
        jdbcTemplate.update("UPDATE city SET cityname = ?,pop = ? WHERE id=?",args );
    }

}
