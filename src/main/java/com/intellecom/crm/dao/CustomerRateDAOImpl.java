package com.intellecom.crm.dao;

import com.intellecom.crm.model.CustomerRate;
import org.springframework.jdbc.core.JdbcTemplate;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by MKrasnyi on 06.05.2016.
 */
public class CustomerRateDAOImpl implements CustomerRateDAO {

    private JdbcTemplate jdbcTemplate;

    public CustomerRateDAOImpl(BasicDataSource dataSource) throws SQLException {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<CustomerRate> list(int start, int end) {
        String sql = "select  * from (select row_number() over (order by r.eff_date desc) rn ,a.accountnumber,\n" +
                "       a.accountname,\n" +
                "       b.prefbs as bs,\n" +
                "       to_char(r.eff_date,'dd.mm.yyyy hh24:mi')as dt,\n" +
                "       r.type,\n" +
                "       r.rate,\n" +
                "       r.cust_comment,\n" +
                "       r.staff, \n" +
                "       max(rownum)over()as max_rn\n " +
                "  from crestelviews.bvaccount a\n" +
                "  left join mv_preffered_cell b\n" +
                "    on a.accountnumber = b.accountnumber, T_RATECUSTOMERS r\n" +
                " where a.ACCOUNTNUMBER = r.accountnumber and r.rate>0\n" +
                " order by r.eff_date desc) where rn BETWEEN ? and ?";

        List<CustomerRate> listCustomer = jdbcTemplate.query(sql, new Object[]{start, end},
                (rs, rownum) -> new CustomerRate(rs.getInt("rn"),
                        rs.getString("accountnumber"),
                        rs.getString("accountname"),
                        rs.getString("bs"),
                        rs.getString("staff"),
                        rs.getInt("rate"),
                        rs.getInt("type"),
                        rs.getString("cust_comment"),
                        rs.getString("dt"),
                        rs.getInt("max_rn")));

        return listCustomer;
    }
}
