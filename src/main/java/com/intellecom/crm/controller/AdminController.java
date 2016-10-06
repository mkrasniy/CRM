package com.intellecom.crm.controller;

import com.intellecom.crm.dao.CustomerInformDAO;
import com.intellecom.crm.dao.CustomerRateDAO;
import com.intellecom.crm.model.CustomerInform;
import com.intellecom.crm.model.CustomerRate;
import com.intellecom.crm.model.Pagination;
import com.intellecom.crm.services.PaginationServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.util.List;

/**
 * Created by MKrasnyi on 28.04.2016.
 */
@Controller
public class AdminController {

    @Autowired
    private CustomerInformDAO customerInformDAO;

    @Autowired
    private CustomerRateDAO customerRateDAO;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Login Form - Database Authentication");
        model.addObject("message", "This page is for ROLE_ADMIN only!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value="/admin/listCustomers")
    public ModelAndView listContact(ModelAndView model) throws IOException {
        List<CustomerInform> listCustomer = customerInformDAO.list();
        model.addObject("listCustomer", listCustomer);
        model.setViewName("listCust");
        return model;
    }

    @RequestMapping(value="/admin/listCustomersOnHold/{pnum}")
    public ModelAndView listContactOnHold(ModelAndView model,
                                          @PathVariable(value = "pnum") int pnum) throws IOException {
        int start = pnum*25-24;
        int end = pnum*25;
        List<CustomerInform> listCustomer = customerInformDAO.listOnHold(start, end);
        int p_max=(int)Math.ceil(listCustomer.get(1).getMax_rn()/25);


        model.addObject("Pagins", PaginationServ.getPaginaion(pnum,p_max));
        model.addObject("listCustomer", listCustomer);
        model.setViewName("listCustOnHold");
        return model;
    }

    @RequestMapping(value="/admin/listCustomersTen")
    public ModelAndView listCustomersTen(ModelAndView model) throws IOException {
        List<CustomerInform> listCustomer = customerInformDAO.listTen();
        model.addObject("listCustomer", listCustomer);
        model.setViewName("listCustTen");
        return model;
    }

    @RequestMapping(value="/admin/listCustomersHistory/{pnum}")
    public ModelAndView listCustomersHistory(ModelAndView model,
                                             @PathVariable(value = "pnum") int pnum) throws IOException {
        int start = pnum*25-24;
        int end = pnum*25;
        List<CustomerRate> listCustomer = customerRateDAO.list(start, end);
        int p_max=(int)Math.ceil(listCustomer.get(1).getMax_rn()/25);


        model.addObject("listCustomer", listCustomer);
        model.addObject("Pagins", PaginationServ.getPaginaion(pnum,p_max));
        model.setViewName("listCustHist");
        return model;
    }

    @RequestMapping(value="/admin/addRate")
    public ModelAndView addRate(ModelAndView model,
                                @RequestParam(value = "acc") String acc,
                                @RequestParam(value = "type") Integer type,
                                @RequestParam(value = "staff") String staff,
                                @RequestParam(value = "rate") Integer rate,
                                @RequestParam(value = "comm") String comm,
                                @RequestParam(value = "onhold") String OnHold) throws IOException {
        int res=customerInformDAO.add_rate(acc, type, staff,rate,comm, OnHold);
        model.addObject("res", res);
        model.setViewName("addResult");
        return model;
    }

}
