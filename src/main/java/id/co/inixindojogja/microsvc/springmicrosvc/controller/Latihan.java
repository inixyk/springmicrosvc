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

    @RequestMapping("/hallo")   //menyatakan alamat service adalah /hallo
    @ResponseBody               //menyatakan bahwa fungsi ini mengembalikn response http
    public String hallo(){
        return "hallo spring";
    }

    @RequestMapping("/tambah/{a}/{b}")
    @ResponseBody
    public String jumlah(
        @PathVariable("a") Double a, 
        @PathVariable("b") Double b){
        return "jumlah dari "+a+" dan "+b+" adalah "+(a+b);
    }

    @RequestMapping("/kali") //http://localhost/kali?a=100&b=23
    @ResponseBody
    public String kali(
        @RequestParam("a") Double a, 
        @RequestParam("b") Double b){
        return "hasil kali dari "+a+" dan "+b+" adalah "+(a*b);
    }

    @PostMapping("/object") //http://localhost/object
    @ResponseBody
    public String terimaObject(@RequestBody Pengguna p){
        return "id pengguna : "+p.getIdPengguna()+" nama : "+p.getNama()+" alamat : "+p.getAlamat();
    }

    @PostMapping("/object2") //http://localhost/object
    @ResponseBody
    public Pengguna terimaReturnObject(@RequestBody Pengguna p){
        return p;
    }

    @Autowired
    RepoPengguna repo ;
    

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
