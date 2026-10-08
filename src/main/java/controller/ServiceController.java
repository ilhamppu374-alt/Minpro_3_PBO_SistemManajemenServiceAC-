/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author USER
 */
import model.DetailService;
import model.Pelanggan;
import model.Teknisi;
import java.util.ArrayList;

public class ServiceController {

    private ArrayList<Pelanggan> daftarPelanggan;
    private ArrayList<Teknisi> daftarTeknisi;
    private ArrayList<DetailService> daftarService;

    public ServiceController() {

        daftarPelanggan = new ArrayList<>();
        daftarTeknisi = new ArrayList<>();
        daftarService = new ArrayList<>();

        isiDataDummy();
    }

    // =====================================================
    // DATA DUMMY
    // =====================================================

    private void isiDataDummy() {

        daftarPelanggan.add(
                new Pelanggan(
                        "P001",
                        "Budi Santoso",
                        812345678,
                        "Jl. Pahlawan No. 10"
                )
        );

        daftarPelanggan.add(
                new Pelanggan(
                        "P002",
                        "Siti Aminah",
                        813456789,
                        "Jl. Mulawarman No. 25"
                )
        );

        daftarTeknisi.add(
                new Teknisi(
                        "T001",
                        "Andi Pratama",
                        814567890,
                        "AC Split"
                )
        );

        daftarTeknisi.add(
                new Teknisi(
                        "T002",
                        "Rizky Maulana",
                        815678901,
                        "AC Inverter"
                )
        );

        daftarService.add(
                new DetailService(
                        "S001",
                        "P001",
                        "T001",
                        "AC Split",
                        "AC tidak dingin",
                        "08-10-2026",
                        "Diproses",
                        150000
                )
        );

        daftarService.add(
                new DetailService(
                        "S002",
                        "P002",
                        "T002",
                        "AC Inverter",
                        "AC mengeluarkan suara berisik",
                        "08-10-2026",
                        "Menunggu",
                        200000
                )
        );
    }

    // =====================================================
    // GET DATA
    // =====================================================

    public ArrayList<Pelanggan> getDaftarPelanggan() {
        return daftarPelanggan;
    }

    public ArrayList<Teknisi> getDaftarTeknisi() {
        return daftarTeknisi;
    }

    public ArrayList<DetailService> getDaftarService() {
        return daftarService;
    }

    // =====================================================
    // PELANGGAN
    // =====================================================

    public boolean tambahPelanggan(Pelanggan pelanggan) {

        if (cariPelanggan(pelanggan.getId()) != null) {
            return false;
        }

        daftarPelanggan.add(pelanggan);
        return true;
    }

    public Pelanggan cariPelanggan(String id) {

        for (Pelanggan p : daftarPelanggan) {

            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }

        return null;
    }

    public boolean ubahPelanggan(
            String id,
            String nama,
            int noTelepon,
            String alamat) {

        Pelanggan p = cariPelanggan(id);

        if (p == null) {
            return false;
        }

        p.setNama(nama);
        p.setNoTelepon(noTelepon);
        p.setAlamat(alamat);

        return true;
    }

    public boolean hapusPelanggan(String id) {

        Pelanggan p = cariPelanggan(id);

        if (p == null) {
            return false;
        }

        daftarPelanggan.remove(p);
        return true;
    }

    // =====================================================
    // TEKNISI
    // =====================================================

    public boolean tambahTeknisi(Teknisi teknisi) {

        if (cariTeknisi(teknisi.getId()) != null) {
            return false;
        }

        daftarTeknisi.add(teknisi);
        return true;
    }

    public Teknisi cariTeknisi(String id) {

        for (Teknisi t : daftarTeknisi) {

            if (t.getId().equalsIgnoreCase(id)) {
                return t;
            }
        }

        return null;
    }

    public boolean ubahTeknisi(
            String id,
            String nama,
            int noTelepon,
            String spesialisasi) {

        Teknisi t = cariTeknisi(id);

        if (t == null) {
            return false;
        }

        t.setNama(nama);
        t.setNoTelepon(noTelepon);
        t.setSpesialisasi(spesialisasi);

        return true;
    }

    public boolean hapusTeknisi(String id) {

        Teknisi t = cariTeknisi(id);

        if (t == null) {
            return false;
        }

        daftarTeknisi.remove(t);
        return true;
    }

    // =====================================================
    // SERVICE AC
    // =====================================================

    public boolean tambahService(DetailService service) {

        if (cariService(service.getIdService()) != null) {
            return false;
        }

        // Pastikan pelanggan tersedia
        if (cariPelanggan(service.getIdPelanggan()) == null) {
            return false;
        }

        // Pastikan teknisi tersedia
        if (cariTeknisi(service.getIdTeknisi()) == null) {
            return false;
        }

        daftarService.add(service);
        return true;
    }

    public DetailService cariService(String id) {

        for (DetailService s : daftarService) {

            if (s.getIdService().equalsIgnoreCase(id)) {
                return s;
            }
        }

        return null;
    }

    public boolean ubahService(
            String id,
            String idPelanggan,
            String idTeknisi,
            String jenisAc,
            String keluhan,
            String tanggal,
            String status,
            double biaya) {

        DetailService s = cariService(id);

        if (s == null) {
            return false;
        }

        if (cariPelanggan(idPelanggan) == null) {
            return false;
        }

        if (cariTeknisi(idTeknisi) == null) {
            return false;
        }

        s.setIdPelanggan(idPelanggan);
        s.setIdTeknisi(idTeknisi);
        s.setJenisAc(jenisAc);
        s.setKeluhan(keluhan);
        s.setTanggal(tanggal);
        s.setStatus(status);
        s.setBiaya(biaya);

        return true;
    }

    public boolean hapusService(String id) {

        DetailService s = cariService(id);

        if (s == null) {
            return false;
        }

        daftarService.remove(s);
        return true;
    }

    // =====================================================
    // UPDATE STATUS SERVICE
    // =====================================================

    public boolean ubahStatusService(
            String idService,
            String statusBaru) {

        DetailService service = cariService(idService);

        if (service == null) {
            return false;
        }

        service.setStatus(statusBaru);
        return true;
    }

    // =====================================================
    // DASHBOARD
    // =====================================================

    public int jumlahPelanggan() {
        return daftarPelanggan.size();
    }

    public int jumlahTeknisi() {
        return daftarTeknisi.size();
    }

    public int jumlahService() {
        return daftarService.size();
    }
}