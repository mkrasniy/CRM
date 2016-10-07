package com.intellecom.crm.controller;

import com.intellecom.crm.config.DAOConfig;
import com.intellecom.crm.dao.AccountDAO;
import com.intellecom.crm.dao.AccountHistoryDAO;
import com.intellecom.crm.dao.BillPayDAO;
import com.intellecom.crm.model.Account;
import com.intellecom.crm.model.AccountHistory;
import com.intellecom.crm.model.BillPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by MKrasnyi on 10.05.2016.
 */
@Controller
@RequestMapping("/accounting/*")
public class AccountController {

    @Autowired
    private DAOConfig daoConfig;

    @Autowired
    private AccountDAO accountDAO=daoConfig.accountDAO();



    @Autowired
    private BillPayDAO billPayDAO=daoConfig.billPayDAO();

    @Autowired
    private AccountHistoryDAO accountHistoryDAO=daoConfig.accountHistoryDAO();

    @RequestMapping(value="{acc}")
    public ModelAndView listContact(ModelAndView model, @PathVariable(value = "acc") String acc) throws IOException {
        Account account = accountDAO.getAccount(acc);
        model.addObject("account", account);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        model.addObject("date", dateFormat.format(date));
        model.setViewName("AccountView");
        return model;
    }

    @RequestMapping(value="{acc}/bill_pay")
    public ModelAndView bill_pay(ModelAndView model, @PathVariable(value = "acc") String acc) throws IOException {
        List<BillPay> bp = billPayDAO.getBillPay(acc);
        model.addObject("billpay", bp);
        model.addObject("acc", acc);
        model.setViewName("BillPayView");
        return model;
    }

    @RequestMapping(value="{acc}/history")
    public ModelAndView acc_history(ModelAndView model, @PathVariable(value = "acc") String acc) throws IOException {
        List<AccountHistory> history = accountHistoryDAO.listHistory(acc);
        model.addObject("history", history);
        model.addObject("acc", acc);
        model.setViewName("AccountHistoryView");
        return model;
    }

    @RequestMapping(value="{acc}/aaa")
    public ModelAndView aaaa(ModelAndView model, @PathVariable(value = "acc") String acc,
                                    @RequestParam(value = "uname") String uname) throws IOException {
        List<AccountHistory> history = accountHistoryDAO.listHistory(acc);
        model.addObject("history", history);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        model.addObject("uname", uname);
        model.addObject("date", dateFormat.format(date));
        model.setViewName("AccountAAAView");
        return model;
    }



    @RequestMapping(value="/search/{type}")
    public ModelAndView search(ModelAndView model,
                               @PathVariable(value = "type") String type,
                               @RequestParam(value = "val") String val) throws IOException {
        try
        {
            List<Account> acc = accountDAO.searchAccount(1,val!=""?val:"-");
            switch (acc.size()){
            case 1:{
                model.setViewName("redirect:../"+acc.get(0).getACCOUNTNUMBER());
                return model;}
            default:

                model.addObject("account",acc);
                model.setViewName("AccountSearchRes");
                return model;
        }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @RequestMapping(value="/BSInfo")
    public ModelAndView bs_info(ModelAndView model) throws IOException {
        model.setViewName("BSInfoView");
        return model;
    }
    @RequestMapping(value="/cashalot")
    public ModelAndView cashalot(ModelAndView model) throws IOException {
        model.setViewName("Cashalot");
        return model;
    }

}
