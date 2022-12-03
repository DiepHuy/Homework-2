package com.huy.homework2.model;

public class HocSinh {
    private String tenhocsinh;
    private String emailhocsinh;
    private int tuoihocsinh;

    public HocSinh(String tenhocsinh, String emailhocsinh, int tuoihocsinh) {
        this.tenhocsinh = tenhocsinh;
        this.emailhocsinh = emailhocsinh;
        this.tuoihocsinh = tuoihocsinh;
    }

    public String getTenhocsinh() {
        return tenhocsinh;
    }

    public void setTenhocsinh(String tenhocsinh) {
        this.tenhocsinh = tenhocsinh;
    }

    public String getEmailhocsinh() {
        return emailhocsinh;
    }

    public void setEmailhocsinh(String emailhocsinh) {
        this.emailhocsinh = emailhocsinh;
    }

    public int getTuoihocsinh() {
        return tuoihocsinh;
    }

    public void setTuoihocsinh(int tuoihocsinh) {
        this.tuoihocsinh = tuoihocsinh;
    }
}