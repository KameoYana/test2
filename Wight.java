/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jane
 */
public class Wight {
   private  List<Counteiner> l1;
   private Integer summ;
/**
 * 
 */
    public Wight() {
        List<Counteiner> l1=new ArrayList<>();
    }

    public List<Counteiner> getL1() {
        return l1;
    }

    public void setL1(List<Counteiner> l1) {
        this.l1 = l1;
    }

    public Integer getSumm() {
        return summ;
    }

    public void setSumm(Integer summ) {
        this.summ = summ;
    }
   
   
}
