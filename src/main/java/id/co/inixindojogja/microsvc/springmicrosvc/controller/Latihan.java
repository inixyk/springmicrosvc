package id.co.inixindojogja.microsvc.springmicrosvc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import id.co.inixindojogja.microsvc.springmicrosvc.model.Pengguna;
import id.co.inixindojogja.microsvc.springmicrosvc.model.RepoPengguna;

@Controller  //menyatakan bahwa class ini adalah web service
public class Latihan {

    //contoh fungsi tanpa parameter input
    @RequestMapping("/hallo")   //menyatakan alamat service adalah /hallo
    @ResponseBody               //menyatakan bahwa fungsi ini mengembalikn response http
    public String hallo(){
        return "hallo spring";
    }

    //contoh fungsi dengan path parameter
    @RequestMapping("/tambah/{a}/{b}")
    @ResponseBody
    public String jumlah(
        @PathVariable("a") Double a, 
        @PathVariable("b") Double b){
        return "jumlah dari "+a+" dan "+b+" adalah "+(a+b);
    }

    //contoh fungsi dengan request param (bisa post atau get)
    @RequestMapping("/kali") //http://localhost/kali?a=100&b=23
    @ResponseBody
    public String kali(
        @RequestParam("a") Double a, 
        @RequestParam("b") Double b){
        return "hasil kali dari "+a+" dan "+b+" adalah "+(a*b);
    }

    //contoh fungsi dengan input via post body dengan format json object, return string
    @PostMapping("/object") //http://localhost/object
    @ResponseBody
    public String terimaObject(@RequestBody Pengguna p){
        return "id pengguna : "+p.getIdPengguna()+" nama : "+p.getNama()+" alamat : "+p.getAlamat();
    }

    //contoh fungsi dengan input via post body dengan format json object, return object pengguna
    @PostMapping("/object2") //http://localhost/object
    @ResponseBody
    public Pengguna terimaReturnObject(@RequestBody Pengguna p){
        return p;
    }

    //auto wired untuk menggunakan object RepoPengguna via injeksi (dimanage oleh framework)
    //kalau tanpa autowired RepoPengguna repo = new RepoPengguna();
    @Autowired
    RepoPengguna repo ;
    

    //kalau mau return dalam struktur yang bukan sesuai object Pengguna (misal tanpa id)
    @RequestMapping("/daftarpengguna")
    @ResponseBody
    public Object ambilPengguna(){
        HashMap m = new HashMap<>();
        m.put("nama", "amir");
        m.put("alamat", "jogja");
        //return m;
        //return repo.findAll();
        return repo.findAllMap();
    }
}
