package com.company;

import java.io.Serializable;

public class StudentMember extends DefaultMember implements Serializable {
    public String school;

    public StudentMember(String memberId, String name, Date startDate,String school) {
        super(memberId, name, startDate);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
