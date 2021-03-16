package com.company;

import java.io.Serializable;
import java.util.Scanner;

public class DefaultMember implements Serializable {
    private String memberId;
    private String name;
    private Date startDate;


    //constructor
    public DefaultMember(String memberId, String name, Date startDate) {
        Scanner input = new Scanner(System.in);
        this.name = name;
        this.memberId = memberId;
        this.startDate = startDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public boolean compareTo(DefaultMember member) {
        return true;
    }
}


