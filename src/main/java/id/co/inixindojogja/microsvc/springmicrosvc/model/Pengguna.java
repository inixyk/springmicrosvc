package id.co.inixindojogja.microsvc.springmicrosvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "tbl_pengguna")  //mapping dengan tabel pengguna
public class Pengguna {
    @Id()  //menyatakan primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //menyatakan auto increment
    private Integer idPengguna;
    private String nama;
    @Column(name = "alamat_pengguna",columnDefinition = "TEXT") //mapping nama kolom
    private String alamat;

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
