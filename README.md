# Minpro-3-PBO-SistemManajemenJasaServiceAC

**Nama:** Muhammad Ilham Zaini  
**NIM:** 2509116091  
**Kelas:** C'25  

---

## 1. Deskripsi Singkat Program
Program **Sistem Manajemen Jasa Service AC** adalah aplikasi berbasis Console Java yang mengelola pemesanan, data pelanggan, teknisi, serta layanan service AC (cuci dan perbaikan). Program ini mendukung operasi CRUD (*Create, Read, Update, Delete*) secara interaktif berbasis CLI, menggunakan arsitektur MVC, serta menerapkan seluruh pilar Pemrograman Berbasis Objek (Encapsulation, Inheritance, Abstraction, dan Polymorphism).

---

## 2. Penjelasan Struktur Package
Proyek ini menerapkan arsitektur **MVC (Model-View-Controller)** untuk memisahkan logika bisnis, struktur data, dan antarmuka pengguna secara modular:

1. **`model`**:
   - `DataOrang.java` *(Abstract Class)*: Class induk abstrak untuk entitas individu yang menampung identitas dasar (`id`, `nama`, `noTelepon`).
   - `Pelanggan.java`: Subclass dari `DataOrang` yang mencatat data spesifik pelanggan (`alamat`).
   - `Teknisi.java`: Subclass dari `DataOrang` yang mencatat keahlian spesifik teknisi (`spesialisasi`).
   - `ServiceAC.java` *(Abstract Class)*: Class induk abstrak untuk mendefinisikan jenis layanan service AC (`namaService`).
   - `ServiceCuciAC.java`: Subclass spesifik dari `ServiceAC` untuk mengelola layanan pembersihan AC berdasarkan jumlah unit (`jumlahUnit`).
   - `ServicePerbaikanAC.java`: Subclass spesifik dari `ServiceAC` untuk mengelola layanan perbaikan AC berdasarkan indikator tingkat kerusakan (`tingkatKerusakan`).
   - `DetailService.java`: Class penampung transaksi layanan service yang menghubungkan ID pelanggan, ID teknisi, jenis AC, keluhan, tanggal, status, dan biaya.
2. **`controller`**:
   - `ServiceController.java`: Mengelola logika bisnis, penampungan data berbasis `ArrayList`, serta manipulasi data CRUD untuk pelanggan, teknisi, dan transaksi service.
3. **`view`**:
   - `ServiceView.java`: Menangani antarmuka CLI, menampilkan navigasi menu, serta mengolah dan memvalidasi masukan (*input*) pengguna.
4. **`main`**:
   - `Main.java`: Class utama (*entry point*) yang mendefinisikan controller dan view, lalu menjalankan aplikasi.

---

## 3. Penjelasan Alur Program
1. **Inisialisasi**: Program dimulai melalui `Main.java` yang memanggil `ServiceView.jalankanProgram()`. Controller dimuat dan menginisialisasi data awal (*dummy data*).
2. **Menu Utama**: Pengguna disajikan 5 pilihan menu utama (Kelola Pelanggan, Kelola Teknisi, Kelola Service AC, Informasi Jenis Service, Dashboard, dan Keluar).
3. **Tambah Data**: Pengguna dapat menambahkan data Pelanggan, Teknisi, maupun Service AC. Sistem memvalidasi keunikan ID agar tidak terjadi duplikasi sebelum disimpan ke dalam `ArrayList` melalui Controller.
4. **Tampilkan Data**: Mengiterasi seluruh objek dalam penampung data untuk mencetak informasi pelanggan, teknisi, serta detail pesanan service.
5. **Ubah Data**: Pengguna memasukkan ID target. Sistem memverifikasi keberadaan ID dan memperbarui atribut data jika masukan valid.
6. **Hapus Data**: Menghapus data terpilih setelah dikonfirmasi oleh pengguna (`Y/T`).
7. **Ubah Status & Dashboard**: Pengguna dapat memperbarui status pengerjaan service (`Menunggu`, `Diproses`, `Selesai`), serta melihat ringkasan total data pada menu Dashboard.

---

## 4. Penjelasan Penerapan Encapsulation dan Inheritance
- **Encapsulation**:
  - Seluruh atribut entitas diset bertipe 'private' (seperti 'id', nama', 'noTelepon, 'alamat', 'spesialisasi', 'keluhan', 'biaya').
  - Akses dan modifikasi data dilakukan melalui method *getter* dan *setter* yang dilengkapi validasi input (seperti validasi teks non-kosong, format nomor telepon, dan biaya bernilai positif).
- **Inheritance**:
  - Class `Pelanggan` dan `Teknisi` menurunkan (*extends*) class induk `DataOrang`. Subclass mewarisi seluruh atribut dasar serta method dari class induk.
  - Class `ServiceCuciAC` dan `ServicePerbaikanAC` menurunkan (*extends*) class induk `ServiceAC`.

---

## 5. Penjelasan Penerapan Polymorphism dan Abstraction
- **Abstraction**:
  - Class `DataOrang` dan `ServiceAC` dideklarasikan sebagai `abstract class` sehingga tidak dapat diinstansiasi secara langsung.
  - Class `DataOrang` memiliki abstract method `tampilkanInfo()`, sedangkan class `ServiceAC` memiliki abstract method `tampilkanService()` yang wajib diimplementasikan oleh masing-masing subclass.
- **Polymorphism**:
  - **Overriding**:
    - Method `tampilkanInfo()` di-override pada class `Pelanggan` dan `Teknisi` untuk menyesuaikan tampilan data spesifik.
    - Method `tampilkanService()` di-override pada class `ServiceCuciAC` dan `ServicePerbaikanAC`.
  - **Overloading**:
    - Overloading Constructor pada class `DetailService` (Constructor dengan 8 parameter lengkap dan Constructor dengan 7 parameter tanpa status yang default-nya bernilai `"Menunggu"`).
    - Overloading Method `inputInt()` pada class `ServiceView`:
      - `inputInt(String pesan)`
      - `inputInt(String pesan, int minimum, int maksimum)`

---

## 6. Penjelasan Letak Penerapan Nilai Tambah
- **Fitur Validasi Input Ketat dan Relasi Entitas (Input Validation & Error Handling)**:
  - **Validasi Regex Nama**: Penggunaan ekspresi reguler `[a-zA-Z .]+` untuk menjamin nama hanya berisi huruf dan spasi.
  - **Validasi Format Tanggal**: Penggunaan regex `\d{2}-\d{2}-\d{4}` untuk memastikan input tanggal sesuai format `DD-MM-YYYY`.
  - **Validasi Integritas Relasi Entitas**: Pada saat menambah/mengubah transaksi service, controller akan mengecek apakah `idPelanggan` dan `idTeknisi` benar-benar terdaftar di dalam sistem sebelum data disimpan.
  - **Fitur Dashboard Summary**: Menyediakan ringkasan total pelanggan, teknisi, dan transaksi service secara *real-time*.

---

## 7. Contoh Output Program & Dokumentasi Screenshot

### A. Tampilan Menu Utama

<img width="527" height="202" alt="image" src="https://github.com/user-attachments/assets/7072cd6f-d370-4ba0-aab3-ec918e4ed407" />

---

### B. Kelola Data Pelanggan (Tambah Pelanggan, Lihat Pelanggan, Ubah Pelanggan, Hapus Pelanggan, Kembali)

<img width="895" height="758" alt="image" src="https://github.com/user-attachments/assets/40bf5bee-ced9-4eea-bc6f-fbab37a4e00c" />

<img width="481" height="597" alt="image" src="https://github.com/user-attachments/assets/c8401c11-2001-459b-91a8-a6d5700b4c37" />

---

### C. Kelola Data Teknisi (Tambah Teknisi, Lihat Teknisi, Ubah Teknisi, Hapus Teknisi, Kembali)

<img width="867" height="797" alt="image" src="https://github.com/user-attachments/assets/1d4da7a1-7615-47c8-8a49-674ff1c5c6d5" />

<img width="502" height="480" alt="image" src="https://github.com/user-attachments/assets/d50c1ecb-2fa8-444b-9e57-99054bc2cdb7" />

---

### D. Kelola Data Service AC (Tambah Service, Lihat Service, Ubah Service, Hapus Service, Ubah Status Service, Kembali)

<img width="590" height="800" alt="image" src="https://github.com/user-attachments/assets/af8afef4-909a-4f5d-bc1a-60084d874d11" />

<img width="850" height="802" alt="image" src="https://github.com/user-attachments/assets/bfc8d074-2159-4695-87d0-9915e0184852" />

<img width="475" height="740" alt="image" src="https://github.com/user-attachments/assets/6687ddb3-3577-4d1d-ab21-d9dc8d99266a" />


---

### E. Informasi Jenis Service

<img width="863" height="432" alt="image" src="https://github.com/user-attachments/assets/0be3fe40-09ee-4ecc-8d6b-ba65317f5115" />

---

### F. Dashboard

<img width="500" height="400" alt="image" src="https://github.com/user-attachments/assets/91bebdd9-af30-479a-8344-4b87857500c6" />

---

### G. Keluar

<img width="616" height="380" alt="image" src="https://github.com/user-attachments/assets/9bbfee0a-5c3c-488f-b748-8fa20bfe2fe8" />
