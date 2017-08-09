/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bikash
 */
public class Stock {
    
    private int companyID;
    private String company;
    private int shares;
    private double price_per_share;

    public Stock(){
        this.companyID = 0;
        this.company = "";
        this.shares = 0;
        this.price_per_share = 0.00;
    }

    /**
     * @return the companyID
     */
    public int getCompanyID() {
        return companyID;
    }

    /**
     * @param companyID the companyID to set
     */
    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the shares
     */
    public int getShares() {
        return shares;
    }

    /**
     * @param shares the shares to set
     */
    public void setShares(int shares) {
        this.shares = shares;
    }

    /**
     * @return the price_per_share
     */
    public double getPrice_per_share() {
        return price_per_share;
    }

    /**
     * @param price_per_share the price_per_share to set
     */
    public void setPrice_per_share(double price_per_share) {
        this.price_per_share = price_per_share;
    }
}
