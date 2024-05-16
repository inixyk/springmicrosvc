package id.co.inixindojogja.microsvc.springmicrosvc.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository                       // mengelola obyek Pengguna yang tipe pk-nya Integer
public interface RepoPengguna extends CrudRepository<Pengguna, Integer> {
    //menambahkan fungsi untuk custom return data
    default List findAllMap() {
        List daf = new LinkedList<>();
        for(Pengguna t:findAll()){
            Map<String,String> m = new HashMap<>();
            m.put("nama", t.getNama());
            m.put("alamat", t.getAlamat());
            daf.add(m);
        }
        System.out.println(daf);
        return daf;
    }

}
