package com.AutoMarketdatabase.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.BeanProperty;
import java.util.List;


@Repository
public class AutoRepository {



    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Auto> getAll() {
        return jdbcTemplate.query("SELECT * FROM auto", BeanPropertyRowMapper.newInstance(Auto.class));
    }

    public Auto getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM auto WHERE id=?", BeanPropertyRowMapper.newInstance(Auto.class), id);
    }

    public int save(List<Auto> cars) {
        cars.forEach(auto -> jdbcTemplate.update("INSERT INTO auto(name, model, power) VALUES(?, ?, ?)",
                                            auto.getName(), auto.getModel(), auto.getPower()));
        return 1;
    }


}
