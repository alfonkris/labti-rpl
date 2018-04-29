/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoalattulis.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author macbookpro
 */
@Entity
@Table(name = "tb_transaksi")
public class Penjualan implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 13)
    private int id;
    
    @Column(name = "alattulis_id", length = 13)
    private int alattulis_id;
    
    @Column(name = "jumlah_terjual")
    private int jumlah_terjual;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlattulis_id() {
        return alattulis_id;
    }

    public void setAlattulis_id(int alattulis_id) {
        this.alattulis_id = alattulis_id;
    }

    public int getJumlah_terjual() {
        return jumlah_terjual;
    }

    public void setJumlah_terjual(int jumlah_terjual) {
        this.jumlah_terjual = jumlah_terjual;
    }
}
