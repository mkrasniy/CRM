package com.intellecom.crm.dao;

import com.intellecom.crm.model.BillPay;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by MKrasnyi on 11.05.2016.
 */
public class BillPayDAOImpl implements BillPayDAO {

    private JdbcTemplate jdbcTemplate;
    public BillPayDAOImpl(BasicDataSource dataSource) throws SQLException {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<BillPay> getBillPay(String accnumber) {
        String sql =  "select s.realcustomer, s.documentname, \n" +
                "  decode(s.documentname, 'Bill', 'Рахунок', 'Advance payment', 'Платіж', 'Payment', 'Платіж', 'Коригування') doc_typ, \n" +
                "  to_char(s.real_dat, 'dd.mm.yyyy hh24:mi') real_dat_str, (0-s.psum) psum, nvl(s.comments, ' ') comments, \n" +
                "  sum(0-s.psum) over(order by real_dat, realcustomer desc, s.docnum desc) balance\n" +
                "  from reporter.vw_saldo_current_detalization s\n" +
                "  where s.CustomerID = ? \n" +
                "  order by real_dat desc, realcustomer";

        List<BillPay> bplist = jdbcTemplate.query(sql,new Object[]{accnumber}, new RowMapper<BillPay>() {
            @Override
            public BillPay mapRow(ResultSet rs, int rowNum) throws SQLException {
                BillPay bp = new BillPay();
                bp.setREALCUSTOMER(rs.getString("realcustomer"));
                bp.setDOCUMENTNAME(rs.getString("documentname"));
                bp.setDOC_TYP(rs.getString("DOC_TYP"));
                bp.setREAL_DAT_STR(rs.getString("REAL_DAT_STR"));
                bp.setPSUM(rs.getFloat("PSUM"));
                bp.setCOMMENTS(rs.getString("COMMENTS"));
                bp.setBALANCE(rs.getFloat("BALANCE"));
                return bp;
            }

        });

        return bplist;
    }

}
