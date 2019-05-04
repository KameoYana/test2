/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

/**
 *
 * @author jane
 */
public class Counteiner {

    /**
     *
     */
    private String name;
    /**
     *
     */
    private Integer wight2, price;

    /**
     *
     * @param name
     * @param wight2
     * @param price
     */
    public Counteiner(String name, Integer wight2, Integer price) {
        this.name = name;
        this.wight2 = wight2;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getWight2() {
        return wight2;
    }

    public Integer getPrice() {
        return price;
    }
}
