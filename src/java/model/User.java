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
public class User {
    
    private int userID;
    private String first_name;
    private String last_name;
    private String dob;
    private String mobile; 
    private String sex;
    private String postal_address;
    private String personal_address;    
    private String city;
    private String state;
    private String pincode;
    private String joinedDate;
    private String useremail;
    private String username;
    private String password;    
    private String re_entered_password;
    private double funds;
    private String holdings;
    private double value_of_holdings;
    
    public User(){
        this.userID = 0;
        this.username = "";
        this.password = "";
        this.useremail = "";
        this.first_name = "";
        this.last_name = "";
        this.postal_address = "";
        this.personal_address = "";
        this.sex = "";
        this.city = "";
        this.state = "";
        this.pincode = "";
        this.dob = "";
        this.mobile = "";
        this.re_entered_password="";
        this.joinedDate = "";
        this.funds = 0.00;
        this.holdings = "";
        this.value_of_holdings = 0.00;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }  

    /**
     * @return the adminID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param adminID the adminID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the useremail
     */
    public String getUseremail() {
        return useremail;
    }

    /**
     * @param useremail the useremail to set
     */
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the postal_address
     */
    public String getPostal_address() {
        return postal_address;
    }

    /**
     * @param postal_address the postal_address to set
     */
    public void setPostal_address(String postal_address) {
        this.postal_address = postal_address;
    }

    /**
     * @return the personal_address
     */
    public String getPersonal_address() {
        return personal_address;
    }

    /**
     * @param personal_address the personal_address to set
     */
    public void setPersonal_address(String personal_address) {
        this.personal_address = personal_address;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the pincode
     */
    public String getPincode() {
        return pincode;
    }

    /**
     * @param pincode the pincode to set
     */
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the re_entered_password
     */
    public String getRe_entered_password() {
        return re_entered_password;
    }

    /**
     * @param re_entered_password the re_entered_password to set
     */
    public void setRe_entered_password(String re_entered_password) {
        this.re_entered_password = re_entered_password;
    }

    /**
     * @return the joinedDate
     */
    public String getJoinedDate() {
        return joinedDate;
    }

    /**
     * @param joinedDate the joinedDate to set
     */
    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    /**
     * @return the funds
     */
    public double getFunds() {
        return funds;
    }

    /**
     * @param funds the funds to set
     */
    public void setFunds(double funds) {
        this.funds = funds;
    }

    /**
     * @return the holdings
     */
    public String getHoldings() {
        return holdings;
    }

    /**
     * @param holdings the holdings to set
     */
    public void setHoldings(String holdings) {
        this.holdings = holdings;
    }

    /**
     * @return the value_of_holdings
     */
    public double getValue_of_holdings() {
        return value_of_holdings;
    }

    /**
     * @param value_of_holdings the value_of_holdings to set
     */
    public void setValue_of_holdings(double value_of_holdings) {
        this.value_of_holdings = value_of_holdings;
    }
}
