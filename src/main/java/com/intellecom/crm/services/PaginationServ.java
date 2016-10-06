package com.intellecom.crm.services;

import com.intellecom.crm.model.Pagination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkrasnyi on 27.09.2016.
 */
public class PaginationServ {
    public static List<Pagination> getPaginaion(int pnum, int p_max){
        // обработка Pagination
        List<Pagination> P=new ArrayList<Pagination>();

        if (pnum==1){
            P.add( new Pagination("Disabled", "&laquo;", "#"));
        }
        else{
            P.add( new Pagination("enabled", "&laquo;", "./"+1));
        }


        if (p_max<=7)
        {
            for (int i = 1; i <= p_max; i++) {
                if (i==pnum){
                    P.add( new Pagination("Active", ""+i, "./"+i));
                }
                else{
                    P.add( new Pagination("Enabled", ""+i, "./"+i));
                }
            }
        }
        else{
            if (p_max/2>=pnum){
                if(pnum==1){
                    P.add( new Pagination("Active", "1", "./1"));
                    P.add( new Pagination("Enabled", "2", "./2"));
                    P.add( new Pagination("Enabled", "3", "./3"));
                }
                else {
                    P.add( new Pagination("Enabled", ""+(pnum-1), "./"+(pnum-1)));
                    P.add( new Pagination("Active", ""+pnum, "./"+pnum));
                    P.add( new Pagination("Enabled", ""+(pnum+1), "./"+(pnum+1)));
                }
            }
            else{
                P.add( new Pagination("Enabled", "1", "./1"));
                P.add( new Pagination("Enabled", "2", "./2"));
                P.add( new Pagination("Enabled", "3", "./3"));
            }
            P.add(4, new Pagination("Disabled", "<span>...</span>", "./#"));

            if (p_max/2<pnum){
                if (pnum==p_max){
                    P.add( new Pagination("Enabled", ""+(p_max-2), "./"+(p_max-2)));
                    P.add( new Pagination("Enabled", ""+(p_max-1), "./"+(p_max-1)));
                    P.add( new Pagination("Active", ""+p_max, "./"+p_max));
                }
                else{
                    P.add( new Pagination("Enabled", ""+(pnum-1), "./"+(pnum-1)));
                    P.add( new Pagination("Active", ""+pnum, "./"+pnum));
                    P.add( new Pagination("Enabled", ""+(pnum+1), "./"+(pnum+1)));
                }
            }
            else{
                    P.add( new Pagination("Enabled", ""+(p_max-2), "./"+(p_max-2)));
                    P.add( new Pagination("Enabled", ""+(p_max-1), "./"+(p_max-1)));
                    P.add( new Pagination("Enabled", ""+p_max, "./"+p_max));
                }
            }

            if (pnum==p_max){
                P.add( new Pagination("Disabled", "&raquo;", "#"));
            }
            else{
                P.add( new Pagination("Enabled", "&raquo;", "./"+p_max));
            }



            return P;
    }

}
