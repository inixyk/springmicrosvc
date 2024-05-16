package id.co.inixindojogja.microsvc.springmicrosvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Setter //milik library lombol
@Getter
@Entity(name = "tbl_pengguna")  //mapping dengan tabel tbl_pengguna
public class Pengguna {
    @Id()  //menyatakan primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //menyatakan auto increment
    private Integer idPengguna; //tanpa anotasi @Column akan menjadi id_pengguna di tabel
    private String nama;
    @Column(name = "alamat_pengguna",columnDefinition = "TEXT") //mapping nama kolom(optional)
    private String alamat;

    //dengan menggunakan @Setter dan @Getter milik library lombok, set get tidak perlu diketik manual
    // public void setAlamat(String alamat) {
    //     this.alamat = alamat;
    // }
    // public void setIdPengguna(Integer idPengguna) {
    //     this.idPengguna = idPengguna;
    // }
    // public void setNama(String nama) {
    //     this.nama = nama;
    // }
    // public String getAlamat() {
    //     return alamat;
    // }
    // public Integer getIdPengguna() {
    //     return idPengguna;
    // }
    // public String getNama() {
    //     return nama;
    // }
    
}
