package com.ytz.spoilyou.entity;

//宠物详情类
public class PetDetail {
    private int id;
    private int pno;
    private String name;
    private int age;

    public PetDetail() {
    }

    public PetDetail(int pno, String name, int age) {
        this.pno = pno;
        this.name = name;
        this.age = age;
    }

    public PetDetail(int id, int pno, String name, int age) {
        this.id = id;
        this.pno = pno;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PetDetail{" +
                "id=" + id +
                ", pno=" + pno +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
