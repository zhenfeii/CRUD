package com.wyu.ui.dao;

import com.wyu.ui.entity.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@Repository
public class MovieDao {
    @Resource
    JdbcTemplate jdbcTemplate;


    public List<Map<String,Object>> getAll(){
        return jdbcTemplate.queryForList("select * from movie");
    }

    public void insertByMovie(Movie movie) {
        jdbcTemplate.update("INSERT INTO movie VALUE (?,?,?,?)",new Object[]{movie.getId(),movie.getMoviename(),new Date(),"delete"});
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM movie WHERE id=?",id);
    }

    public Object findById(Long id) {
        Movie movie = new Movie();
        jdbcTemplate.query("select * from movie where id=?", new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                movie.setId(rs.getLong("id"));
                movie.setMoviename(rs.getString("moviename"));
                movie.setCreatdate(rs.getDate("creatdate"));
                movie.setOperation(rs.getString("operation"));
            }
        });
        return movie;
    }

    public void update(Movie movie) {
        jdbcTemplate.update("UPDATE movie SET moviename=? WHERE id=?",new Object[]{movie.getMoviename(),movie.getId()});
    }
}
