package com.company;

import java.io.Serializable;

public class Over60Member extends DefaultMember implements Serializable {
    public int age;

    public Over60Member(String memberNumber, String name, Date startDate,int age) {
        super(memberNumber, name, startDate);
       setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if (age >= 60){
            this.age = age;
        }
        else{
            throw new IllegalArgumentException("Not over 60");
        }
    }
}
