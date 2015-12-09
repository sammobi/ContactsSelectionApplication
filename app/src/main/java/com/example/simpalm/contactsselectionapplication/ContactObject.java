package com.example.simpalm.contactsselectionapplication;

import java.io.Serializable;

/**
 * Created by Simpalm on 12/8/15.
 */
public class ContactObject implements Serializable {
    private static final long serialVersionUID = 1L;


    private String name, phone, website;

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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public ContactObject(String name, String phone, String website) {
        this.name = name;
        this.phone = phone;
        this.website = website;


    }
}
