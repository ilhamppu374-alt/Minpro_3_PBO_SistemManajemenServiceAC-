/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */
public abstract class DataOrang {

    private String id;
    private String nama;
    private int noTelepon;

    public DataOrang(String id, String nama, int noTelepon) {
        this.id = id;
        this.nama = nama;
        this.noTelepon = noTelepon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(int noTelepon) {
        this.noTelepon = noTelepon;
    }

    // Abstract method
    public abstract void tampilkanInfo();
}