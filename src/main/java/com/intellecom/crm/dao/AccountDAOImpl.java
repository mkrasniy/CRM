package com.intellecom.crm.dao;

/**
 * Created by MKrasnyi on 10.05.2016.
 */
import com.intellecom.crm.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.apache.commons.dbcp2.BasicDataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    private JdbcTemplate jdbcTemplate;
    private JdbcTemplate jdbcTemplateCRM;
    public AccountDAOImpl(BasicDataSource dataSource,BasicDataSource dataSourceCRM) throws SQLException {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplateCRM = new JdbcTemplate(dataSourceCRM);
    }

    @Override
    public Account getAccount(String accnumber) {
        if (accnumber!=null) {
            String sql =  "select BILLINGAREANAME, ACTIVATION, EMAILADDRESS, ACCOUNTNUMBER, ACCOUNTNAME, " +
                                "ACCOUNTUSERNAME, PARENT, PASSW, AMOUNT, ACCOUNTSTATUSNAME, REPLY_GROUP, SERVICE, RENT, " +
                                "CPENAME, STATIC_IP, EXP_DATE, USED_TRAF_MBYTES, MANAGER, HPHONENO," +
                                " OPHONENO, MPHONENO, FPHONENO , CPEID, AMOUNT_NEED, TECH, CANOPY_CHARGE, IS_EXPARED, " +
                                " BILLINGADDRESS, PERMANENTADDRESS, PREFBS, PREFMAC \n" +
                         "  from VW_ABONENTLIST_CRM  where accountnumber = ?";

          //  System.out.println(sql);

            return jdbcTemplate.queryForObject(sql,new Object[]{accnumber},  new RowMapper<Account>() {
                public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Account account = new Account();
                    account.setBILLINGAREANAME(rs.getString("BILLINGAREANAME"));
                    account.setACTIVATION(rs.getString("ACTIVATION"));
                    account.setEMAILADDRESS(rs.getString("EMAILADDRESS"));
                    account.setACCOUNTNUMBER(rs.getString("ACCOUNTNUMBER"));
                    account.setACCOUNTNAME(rs.getString("ACCOUNTNAME"));
                    account.setACCOUNTUSERNAME(rs.getString("ACCOUNTUSERNAME"));
                    account.setPARENT(rs.getString("PARENT"));
                    account.setPASSW(rs.getString("PASSW"));
                    account.setAMOUNT(rs.getFloat("AMOUNT"));
                    account.setAMOUNT_NEED(rs.getFloat("AMOUNT_NEED"));
                    account.setACCOUNTSTATUSNAME(rs.getString("ACCOUNTSTATUSNAME"));
                    account.setREPLY_GROUP(rs.getString("REPLY_GROUP"));
                    account.setSERVICE(rs.getString("SERVICE"));
                    account.setRENT(rs.getString("RENT"));
                    account.setCPENAME(rs.getString("CPENAME"));
                    account.setCPEID(rs.getString("CPEID"));
                    account.setSTATIC_IP(rs.getString("STATIC_IP"));
                    account.setEXP_DATE(rs.getString("EXP_DATE"));
                    account.setUSED_TRAF_MBYTES(rs.getString("USED_TRAF_MBYTES"));
                    account.setMANAGER(rs.getString("MANAGER"));
                    account.setHPHONENO(rs.getString("HPHONENO"));
                    account.setOPHONENO(rs.getString("OPHONENO"));
                    account.setMPHONENO(rs.getString("MPHONENO"));
                    account.setFPHONENO(rs.getString("FPHONENO"));
                    account.setTECH(rs.getString("TECH"));
                    account.setCANOPY_CHARGE(rs.getString("CANOPY_CHARGE"));
                    account.setIS_EXP(rs.getBoolean("IS_EXPARED"));
                    account.setBILLINGADRESS(rs.getString("BILLINGADDRESS"));
                    account.setPERMANENTADRESS(rs.getString("PERMANENTADDRESS"));
                    account.setPREFBS(rs.getString("PREFBS"));
                    account.setMAC(rs.getString("PREFMAC"));

                    return account;
                }
            });

        }
        else return null;
       // aCustomer.setAccountnumber(rs.getString("accountnumber"));
    }

    @Override
    public List<Account> searchAccount(int type, String value) {
        switch(type){

            case 1:
                 return searchbyaccountnumber(value);
                //break;
            case 2:
                break;
            default:
                return null;
        }
        return null;
    }

   private List<Account> searchbyaccountnumber(String accountnumber){
         String sql =  "select BILLINGAREANAME, ACTIVATION, EMAILADDRESS, ACCOUNTNUMBER, ACCOUNTNAME, " +
                "ACCOUNTUSERNAME, PARENT, PASSW, AMOUNT, ACCOUNTSTATUSNAME, REPLY_GROUP, SERVICE, RENT, " +
                "CPENAME, STATIC_IP, EXP_DATE, USED_TRAF_MBYTES, MANAGER, HPHONENO," +
                " OPHONENO, MPHONENO, FPHONENO , CPEID, AMOUNT_NEED, TECH, CANOPY_CHARGE, IS_EXPARED, " +
                " BILLINGADDRESS, PERMANENTADDRESS, PREFBS, PREFMAC \n" +
                "  from VW_ABONENTLIST_CRM  where accountnumber like \'%"+accountnumber+"%\'";
       List<Account> acclist = jdbcTemplate.query(sql, new RowMapper<Account>() {
             @Override
             public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account = new Account();

                account.setBILLINGAREANAME(rs.getString("BILLINGAREANAME"));
                account.setACTIVATION(rs.getString("ACTIVATION"));
                account.setEMAILADDRESS(rs.getString("EMAILADDRESS"));
                account.setACCOUNTNUMBER(rs.getString("ACCOUNTNUMBER"));
                account.setACCOUNTNAME(rs.getString("ACCOUNTNAME"));
                account.setACCOUNTUSERNAME(rs.getString("ACCOUNTUSERNAME"));
                account.setPARENT(rs.getString("PARENT"));
                account.setPASSW(rs.getString("PASSW"));
                account.setAMOUNT(rs.getFloat("AMOUNT"));
                account.setAMOUNT_NEED(rs.getFloat("AMOUNT_NEED"));
                account.setACCOUNTSTATUSNAME(rs.getString("ACCOUNTSTATUSNAME"));
                account.setREPLY_GROUP(rs.getString("REPLY_GROUP"));
                account.setSERVICE(rs.getString("SERVICE"));
                account.setRENT(rs.getString("RENT"));
                account.setCPENAME(rs.getString("CPENAME"));
                account.setCPEID(rs.getString("CPEID"));
                account.setSTATIC_IP(rs.getString("STATIC_IP"));
                account.setEXP_DATE(rs.getString("EXP_DATE"));
                account.setUSED_TRAF_MBYTES(rs.getString("USED_TRAF_MBYTES"));
                account.setMANAGER(rs.getString("MANAGER"));
                account.setHPHONENO(rs.getString("HPHONENO"));
                account.setOPHONENO(rs.getString("OPHONENO"));
                account.setMPHONENO(rs.getString("MPHONENO"));
                account.setFPHONENO(rs.getString("FPHONENO"));
                account.setTECH(rs.getString("TECH"));
                account.setCANOPY_CHARGE(rs.getString("CANOPY_CHARGE"));
                account.setIS_EXP(rs.getBoolean("IS_EXPARED"));
                account.setBILLINGADRESS(rs.getString("BILLINGADDRESS"));
                account.setPERMANENTADRESS(rs.getString("PERMANENTADDRESS"));
                account.setPREFBS(rs.getString("PREFBS"));
                account.setMAC(rs.getString("PREFMAC"));
                return account;
            }
        //return null;
        });

       return  acclist;
    }
}
