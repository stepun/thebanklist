package com.dev.bank.model;

import java.security.Provider;
import java.util.HashSet;
import java.util.Set;

public class User {
	public static final String TABLE_NAME = "user";
	public static final String ID_COLUMN = "userid";
	public static final String NAME_COLUMN = "name";
	public static final String SURENAME_COLUMN = "sureName";
	
	private Integer userid;
    private String name;
    private String sureName;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
	public String toString() {
    	return "User[id=" + this.userid + ", name=" + this.name + "]";
    }
}