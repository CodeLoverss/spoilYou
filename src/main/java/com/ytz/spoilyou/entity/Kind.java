package com.ytz.spoilyou.entity;

//宠物类别类
public class Kind {
    private int id;
    private String kno;
    private String name;

    public Kind() {
    }

    public Kind(String kno, String name) {
        this.kno = kno;
        this.name = name;
    }

    public Kind(int id, String kno, String name) {
        this.id = id;
        this.kno = kno;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKno() {
        return kno;
    }

    public void setKno(String kno) {
        this.kno = kno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Kind{" +
                "id=" + id +
                ", kno='" + kno + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
