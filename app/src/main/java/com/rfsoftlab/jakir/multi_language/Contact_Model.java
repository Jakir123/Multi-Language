package com.rfsoftlab.jakir.multi_language;
/**
 * @author Jakir Hossain
 * @version 1.3.0
 * @desc description of the class
 * @link n/a
 * @created on 26-Nov-15
 * @updated on
 * @modified by
 * @updated on
 * @since 1.0
 */
public class Contact_Model {
    private String name;
    private String phone;

    public Contact_Model(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
