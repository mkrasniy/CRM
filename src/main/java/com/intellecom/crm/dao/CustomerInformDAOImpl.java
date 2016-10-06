package com.intellecom.crm.dao;

/**
 * Created by MKrasnyi on 05.05.2016.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import com.intellecom.crm.model.CustomerInform;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CustomerInformDAOImpl implements CustomerInformDAO{

    private JdbcTemplate jdbcTemplate;
    public CustomerInformDAOImpl(BasicDataSource dataSource) throws SQLException{
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<CustomerInform> list() {
        String sql = "select a.accountnumber, a.accountname, a.phone_home, a.phone_mobile, a.phone_office, b.prefbs as bs, '' as comm, '' as type \n" +
                     "  from vw_abonentlist_light a \n" +
                     "  left join mv_preffered_cell b \n" +
                     "    on a.accountnumber = b.accountnumber \n" +
                     " where a.activation_date between trunc(sysdate - 5) and \n" +
                     "       trunc(sysdate - 1) + 86399/86400 \n" +
                     "   and not exists(select * from t_ratecustomers r where a.accountnumber=r.accountnumber and r.type=1)\n";
        List<CustomerInform> listCustomer = getListCustomer(sql);

        return listCustomer;
    }

    @Override
    public List<CustomerInform> listTen() {
        String sql = "select a.accountnumber, a.accountname, a.phone_home, a.phone_mobile, a.phone_office, b.prefbs as bs, '' as comm, '' as type \n" +
                "  from vw_abonentlist_light a \n" +
                "  left join mv_preffered_cell b \n" +
                "    on a.accountnumber = b.accountnumber \n" +
                " where a.activation_date between trunc(sysdate - 14) and \n" +
                "       trunc(sysdate - 10) + 86399/86400 \n" +
                "   and not exists(select * from t_ratecustomers r where a.accountnumber=r.accountnumber and r.type=10)\n";
        List<CustomerInform> listCustomer = getListCustomer(sql);

        return listCustomer;
    }


    @Override
    public List<CustomerInform> listOnHold(int start, int end) {
        String sql = "select * from(select row_number() over (order by r.eff_date desc) rn ,a.accountnumber, replace(a.accountname,'_','')accountname, a.phone_home, a.phone_mobile, a.phone_office, b.prefbs as bs, r.CUST_COMMENT as comm, r.type, \n" +
                "       max(rownum)over()as max_rn\n " +
                "  from vw_abonentlist_light a \n" +
                "  left join mv_preffered_cell b \n" +
                "    on a.accountnumber = b.accountnumber, t_ratecustomers r \n" +
                " where a.accountnumber=r.accountnumber and r.rate=-1) where  rn BETWEEN ? and ? ";
        List<CustomerInform> listCustomer = getListCustomer(sql, start, end);

        return listCustomer;
    }

    private List<CustomerInform> getListCustomer(String sql){
        return jdbcTemplate.query(sql, new RowMapper<CustomerInform>() {
            @Override
            public CustomerInform mapRow(ResultSet rs, int rowNum) throws SQLException {
                CustomerInform aCustomer = new CustomerInform();
                aCustomer.setAccountnumber(rs.getString("accountnumber"));
                aCustomer.setBs(rs.getString("bs"));
                aCustomer.setAccountname(rs.getString("accountname"));
                aCustomer.setPhoneHome(rs.getString("phone_home"));
                aCustomer.setPhoneMobile(rs.getString("phone_mobile"));
                aCustomer.setPhoneOffice(rs.getString("phone_office"));
                aCustomer.setComm(rs.getString("comm"));
                aCustomer.setType(rs.getString("type"));

                return aCustomer;
            }

        });

    }

        private List<CustomerInform> getListCustomer(String sql, int start, int end) {
            return jdbcTemplate.query(sql, new Object[]{start, end}, new RowMapper<CustomerInform>() {
                @Override
                public CustomerInform mapRow(ResultSet rs, int rowNum) throws SQLException {
                    CustomerInform aCustomer = new CustomerInform();
                    aCustomer.setAccountnumber(rs.getString("accountnumber"));
                    aCustomer.setBs(rs.getString("bs"));
                    aCustomer.setAccountname(rs.getString("accountname"));
                    aCustomer.setPhoneHome(rs.getString("phone_home"));
                    aCustomer.setPhoneMobile(rs.getString("phone_mobile"));
                    aCustomer.setPhoneOffice(rs.getString("phone_office"));
                    aCustomer.setComm(rs.getString("comm"));
                    aCustomer.setType(rs.getString("type"));
                    aCustomer.setRn(rs.getInt("rn"));
                    aCustomer.setMax_rn(rs.getInt("max_rn"));

                    return aCustomer;
                }

            });
        }


    @Override
    public int add_rate(String acc, Integer type, String staff, Integer rate, String comm, String OnHold) {
        if (acc!=null&&rate!=null&&comm!=null){
            if (OnHold!="0")
            {

                System.out.println("Update T_RATECUSTOMERS set type=-1, rate=0\n" +
                        "where accountnumber = "+acc+" and type="+type);
                int res = jdbcTemplate.update("Update T_RATECUSTOMERS set type=?, rate=0 \n" +
                        "where accountnumber = ? and type=?", type*-1, acc,  type);
            }

            System.out.println("INSERT into T_RATECUSTOMERS(ACCOUNTNUMBER,EFF_DATE,TYPE,STAFF,RATE,CUST_COMMENT)\n" +
                    "VALUES ( "+acc+", sysdate, "+type+", "+staff+","+rate+","+comm+")");
            return jdbcTemplate.update("INSERT into T_RATECUSTOMERS(ACCOUNTNUMBER,EFF_DATE,TYPE,STAFF,RATE,CUST_COMMENT)\n" +
                                     "VALUES ( ?, sysdate, ?, ?,?,?)", acc, type, staff,rate,comm);


        }
        else{
            return 0;
        }
    }
}
