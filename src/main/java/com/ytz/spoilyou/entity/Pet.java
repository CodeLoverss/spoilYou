package com.ytz.spoilyou.entity;

//宠物类
public class Pet {
    private int id;
    private String pno;
    private String name;
    private int kind;

    public Pet() {
    }

    public Pet(String pno, String name, int kind) {
        this.pno = pno;
        this.name = name;
        this.kind = kind;
    }

    public Pet(int id, String pno, String name, int kind) {
        this.id = id;
        this.pno = pno;
        this.name = name;
        this.kind = kind;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", pno='" + pno + '\'' +
                ", name='" + name + '\'' +
                ", kind=" + kind +
                '}';
    }
}
