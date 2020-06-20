package com.example.a1_moyeo;

public class MemberDTO {
    private int id;
    private String pw;
    private String name;
    private String bg;
    private String number;
    private String email;
    private String major_type;
    private String major;
    private int grade;
    private String state;
    private int warning;

    public MemberDTO(int id, String pw, String name, String bg, String number, String email, String major_type, String major, int grade, String state, int warning) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.bg = bg;
        this.number = number;
        this.email = email;
        this.major_type = major_type;
        this.major = major;
        this.grade = grade;
        this.state = state;
        this.warning = warning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor_type() {
        return major_type;
    }

    public void setMajor_type(String major_type) {
        this.major_type = major_type;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getWarning() {
        return warning;
    }

    public void setWarning(int warning) {
        this.warning = warning;
    }
}
