package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager implements GymManager {

    //initializing the member List
    public static List<DefaultMember> memberList = new ArrayList<DefaultMember>();

    @Override
    public void addNewMember(DefaultMember member) {
        System.out.println("Members registered    :" + " " + (memberList.size() + 1));
        System.out.println("Available Registrations   :" + (100 - (memberList.size() + 1)));
        if (memberList.size() < 100) {
            memberList.add(member);
            save();
        } else {
            System.err.println("Maximum Registration Reached");
        }
    }

    @Override
    public boolean removeMember(String memberId) {
        boolean flag = false;
        for (DefaultMember member : memberList) {
            if (member.getMemberId().equals(memberId)) {
                flag = true;

                if (member instanceof StudentMember) {
                    System.out.println("Type = Student Member");
                } else if (member instanceof Over60Member) {
                    System.out.println("Type = Over 60 Member");
                } else {
                    System.out.println("Type = Default Member");
                }
                memberList.remove(member);
                System.out.println("Member Removed");
                System.out.println("Members registered    :" + " " + memberList.size());
                System.out.println("Available Registrations   :" + (100 - memberList.size()));
                save();
                break;
            }
        }
        if (!flag) {
            System.out.println("Member Not Found");
        }

        return flag;
    }

    @Override
    public void showList() {
        for (DefaultMember member : memberList) {
            System.out.print("Membership Id : " + member.getMemberId() + "  |   ");
            if (member instanceof StudentMember) {
                System.out.print("Type = Student Member  | ");
                System.out.print("School : " + ((StudentMember) member).getSchool() + "  |   ");
            } else if (member instanceof Over60Member) {
                System.out.print("Type = Over 60 Member   |  ");
                System.out.print("Age : " + ((Over60Member) member).getAge() + "     |    ");
            } else {
                System.out.print("Type = Default Member  |   ");
            }
            System.out.print("Name : " + member.getName() + "   |   ");
            System.out.println("Membership Date   : " + member.getStartDate() + " ");
            System.out.println("\n");
        }
        if (memberList.size() == 0) {
            System.out.println("No Registrations made ");
        }

    }

    @Override
    public List<DefaultMember> sort() {
        DefaultMember[] arr = memberList.toArray(new DefaultMember[]{});
        // BubbleSort.bubbleSort(arr,true);
        List<DefaultMember> sortedList = Arrays.asList(arr);
        return sortedList;
    }

    @Override
    public void save() {
        try {
            ObjectOutputStream saveFile = new ObjectOutputStream(new FileOutputStream("memberData.bin"));
            for (DefaultMember member : memberList) {
                saveFile.writeObject(member);
            }
            saveFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        File data = new File("memberData.bin");
        if (data.exists()) {
            try {
                ObjectInputStream readData = new ObjectInputStream(new FileInputStream("memberData.bin"));
                while (true) {
                    Object temp;

                    try {
                        temp = readData.readObject();
                        if (temp != null) {
                            memberList.add((DefaultMember) temp);
                        }
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }





}
