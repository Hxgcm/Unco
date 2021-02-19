package com.unco.client.dao.daoImpl;


import com.unco.client.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author HeXianGang
 * @create 2020-06-10 15:29
 */
public abstract class BaseDao {

    //使用DBUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update() 方法用来执行：Insert\Update\Delete语句
     * @return  如果返回-1，说明执行失败，返回其他表示影响的行数
     */
    public int update(String sql,Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }


    /**
     *  查询返回一个javaBean的sql语句
     * @param type  返回的对象类型
     * @param sql   执行的sql语句
     * @param args  sql对应的参数
     * @param <T>   返回的类型的泛型
     * @return  如果为空，则没有查询
     */
    public <T> T queryForOne(Class<T> type, String sql, Object ... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     *  查询返回多个javaBean的sql语句
     * @param type  返回的对象类型
     * @param sql   执行的sql语句
     * @param args  sql对应的参数
     * @param <T>   返回的类型的泛型
     * @return  如果为空，则没有查询
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 执行返回一行一列的SQL语句
     * @param sql   执行的sql语句
     * @param args  sql对应的参数值
     * @return
     */
    public Object queryForSingleCValue(String sql, Object ... args){

        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

}