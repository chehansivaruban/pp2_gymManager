package com.company;

import java.util.List;

public interface GymManager {
    public void addNewMember(DefaultMember member);
    public boolean removeMember(String memberId);
    public void showList();
    public List<DefaultMember> sort();
    public void save();



}
