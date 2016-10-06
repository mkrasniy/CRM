package com.intellecom.crm.dao;

import com.intellecom.crm.model.AccountHistory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by MKrasnyi on 11.05.2016.
 */
public class AccountHistoryDAOImpl implements AccountHistoryDAO {


    private JdbcTemplate jdbcTemplate;
    public AccountHistoryDAOImpl(BasicDataSource dataSource) throws SQLException {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<AccountHistory> listHistory(String accountnumber) {
        String sql =  "select h.CHANGEDATE, \n" +
                "       h.ACCOUNTNUMBER,\n" +
                "       to_char(h.CHANGEDATE, 'dd.mm.yyyy hh24:mi') CHANGEDATE_s,\n" +
                "       h.ATTRIBUTENAME,\n" +
                "       nvl(h.CHANGEREASON, '-') CHANGEREASON,\n" +
                "       nvl(h.CHANGEVALUE, '-') CHANGEVALUE,\n" +
                "       nvl(h.OLDVALUE, '-') OLDVALUE,\n" +
                "       h.CHANGEBYSTAFFNAME,\n" +
                "       nvl(r.name, '-') name\n" +
                "  from crestelviews.vwaccounthistory      h,\n" +
                "       jispbilcorbillingprd501.tblmreason r\n" +
                " where h.ACCOUNTNUMBER = ? \n" +
                "   and nvl(h.OLDVALUE, '-') not in ('Unlimited Rate Card Group', 'Free')\n" +
                "   and nvl(h.ATTRIBUTENAME, '-') not in ('Update Demographic Information','Update Account')\n" +
                "   and r.reasonid(+) = h.REASONID\n" +
                "   union all\n" +
                " select t.EFF_DATE,\n" +
                "       ACCOUNTNUMBER,\n" +
                "       to_char(t.EFF_DATE, 'dd.mm.yyyy hh24:mi') CHANGEDATE_s,\n" +
                "       t.action as ATTRIBUTENAME,\n" +
                "       case when t.action in ('PACKAGE:CONTINUE','PROMO') then 'Days:' || t.days ||', Balace:'||t.balance||', exp_date:'||to_char(t.exp_date,'dd.mm.yyyy hh24:mi:ss') \n" +
                "            when t.action = 'PACKAGE:TRAFFIC' then 'Balance:'||t.balance\n" +
                "         else '-' end CHANGEREASON,\n" +
                "       '-' CHANGEVALUE,\n" +
                "       '-' OLDVALUE,\n" +
                "       'Prep Agent' CHANGEBYSTAFFNAME,\n" +
                "       '-' NAME\n" +
                "  from prep_agent.TRANSACTIONS t\n" +
                " where t.accountnumber = ? and \n" +
                "   t.action not in ( 'PAYMENT', 'BALANCE CORRECTION', 'PROLONGATION')\n" +
                " order by 1 desc";

        List<AccountHistory> ahlist = jdbcTemplate.query(sql,new Object[]{accountnumber,accountnumber}, new RowMapper<AccountHistory>() {
            @Override
            public AccountHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccountHistory ah = new AccountHistory();
                ah.setATTRIBUTENAME(rs.getString("ATTRIBUTENAME"));
                ah.setACCOUNTNUMBER(rs.getString("ACCOUNTNUMBER"));
                ah.setCHANGEDATE(rs.getString("CHANGEDATE_s"));
                ah.setCHANGEREASON(rs.getString("CHANGEREASON"));
                ah.setCHANGEVALUE(rs.getString("CHANGEVALUE"));
                ah.setOLDVALUE(rs.getString("OLDVALUE"));
                ah.setCHANGEBYSTAFFNAME(rs.getString("CHANGEBYSTAFFNAME"));

                return ah;
            }

        });

        return ahlist;
    }

}
