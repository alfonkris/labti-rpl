/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoalattulis.controller;

import tokoalattulis.app.App;
import tokoalattulis.config.AlatTulisTableModel;
import tokoalattulis.dao.AlatTulisDao;
import tokoalattulis.view.AlatTulisView;
import java.util.List;
import tokoalattulis.model.AlatTulis;
import javax.swing.JOptionPane;
import tokoalattulis.config.PenjualanTableModel;
import tokoalattulis.model.Penjualan;

/**
 *
 * @author gde14002
 */
public class AlatTulisController {
    private final AlatTulisView alatTulisView;
    private AlatTulisTableModel alatTulisTableModel;
    private PenjualanTableModel penjualanTableModel;
    private List<AlatTulis> daftarAlatTulis;
    private List<Penjualan> daftarPenjualan;
    
    public AlatTulisController(AlatTulisView alatTulisView){
        this.alatTulisView = alatTulisView;
    }
    
    public void tampilData(){
        clearAlatTulis();
        daftarAlatTulis = App.getAlatTulisService().getDaftarAlatTulis();
        daftarPenjualan = App.getAlatTulisService().getDaftarPenjualan();
        alatTulisTableModel = new AlatTulisTableModel(daftarAlatTulis);
        penjualanTableModel = new PenjualanTableModel(daftarPenjualan);
        this.alatTulisView.getTblBarang().setModel(alatTulisTableModel);
        this.alatTulisView.getTblBarangPenjualan().setModel(alatTulisTableModel);
        this.alatTulisView.getTblTransaksi().setModel(penjualanTableModel);
    }
    
    public void simpanAlatTulis(){
        AlatTulis alatTulis = new AlatTulis();
        alatTulis.setJenis(this.alatTulisView.getTxtJenis().getText());
        alatTulis.setMerk(this.alatTulisView.getTxtMerk().getText());
        alatTulis.setJumlah(Integer.parseInt(this.alatTulisView.getTxtJumlah().getText()));
        alatTulis.setHarga(Float.parseFloat(this.alatTulisView.getTxtHarga().getText()));
        alatTulis.setTahun(Integer.parseInt(this.alatTulisView.getTxtTahun().getText()));
        
        App.getAlatTulisService().saveAlatTulis(alatTulis);
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);
        tampilData();
    }
    
    public void simpanTransaksiPenjualan(){
        int index = this.alatTulisView.getTblBarangPenjualan().getSelectedRow();
        
        Penjualan penjualan = new Penjualan();
        penjualan.setAlattulis_id(this.daftarAlatTulis.get(index).getId());
        penjualan.setJumlah_terjual(Integer.parseInt(this.alatTulisView.getTxtTerjual().getText()));
        
        App.getAlatTulisService().saveTransaksi(penjualan);
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);
        tampilData();
    }
    
    public void updateAlatTulis(){
        if(this.alatTulisView.getTxtId().getText() == null){
            JOptionPane.showMessageDialog(null,
                "Alat Tulis belum dipilih",
                "Error",
                JOptionPane.INFORMATION_MESSAGE);
        }else{
            AlatTulis alatTulis = new AlatTulis();
            alatTulis.setId(Integer.parseInt(this.alatTulisView.getTxtId().getText()));
            alatTulis.setJenis(this.alatTulisView.getTxtJenis().getText());
            alatTulis.setMerk(this.alatTulisView.getTxtMerk().getText());
            alatTulis.setJumlah(Integer.parseInt(this.alatTulisView.getTxtJumlah().getText()));
            alatTulis.setHarga(Float.parseFloat(this.alatTulisView.getTxtHarga().getText()));
            alatTulis.setTahun(Integer.parseInt(this.alatTulisView.getTxtTahun().getText()));
            App.getAlatTulisService().updateAlatTulis(alatTulis);

            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Info", JOptionPane.INFORMATION_MESSAGE);
            tampilData();
        }
    }
    
    public void deleteAlatTulis(){
        if(this.alatTulisView.getTxtId().getText() == null){
            JOptionPane.showMessageDialog(null,
                "Alat Tulis belum dipilih",
                "Error",
                JOptionPane.INFORMATION_MESSAGE);
        }else{
            AlatTulis alatTulis = new AlatTulis();
            alatTulis.setId(Integer.parseInt(this.alatTulisView.getTxtId().getText()));
            
            int confirm = JOptionPane.showConfirmDialog(null,
                "Hapus data?",
                "Warning",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            if(confirm == JOptionPane.YES_OPTION){
                App.getAlatTulisService().deleteAlatTulis(alatTulis);
                JOptionPane.showMessageDialog(null,
                    "Data berhasil dihapus",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
        tampilData();
    }
    
    public void cekAlatTulis(){
        int index = this.alatTulisView.getTblBarang().getSelectedRow();
        
        this.alatTulisView.getTxtId().setText(String.valueOf(daftarAlatTulis.get(index).getId()));
        this.alatTulisView.getTxtJenis().setText(String.valueOf(this.alatTulisView.getTblBarang()
                .getValueAt(index, 0)));
        this.alatTulisView.getTxtMerk().setText(String.valueOf(this.alatTulisView.getTblBarang()
                .getValueAt(index, 1)));
        this.alatTulisView.getTxtJumlah().setText(String.valueOf(this.alatTulisView.getTblBarang()
                .getValueAt(index, 2)));
        this.alatTulisView.getTxtHarga().setText(String.valueOf(this.alatTulisView.getTblBarang()
                .getValueAt(index, 3)));
        this.alatTulisView.getTxtTahun().setText(String.valueOf(this.alatTulisView.getTblBarang()
                .getValueAt(index, 4)));
    }
    
    public void cekAlatTulisPenjualan(){
        int index = this.alatTulisView.getTblBarangPenjualan().getSelectedRow();
        
        this.alatTulisView.getTxtJenisPenjualan().setText(String.valueOf(this.alatTulisView.getTblBarangPenjualan()
                .getValueAt(index, 0)));
        this.alatTulisView.getTxtMerkPenjualan().setText(String.valueOf(this.alatTulisView.getTblBarangPenjualan()
                .getValueAt(index, 1)));
    }
   
    public void clearAlatTulis(){
        this.alatTulisView.getTxtJenis().setText("");
        this.alatTulisView.getTxtMerk().setText("");
        this.alatTulisView.getTxtJumlah().setText("");
        this.alatTulisView.getTxtHarga().setText("");
        this.alatTulisView.getTxtTahun().setText("");
        
        this.alatTulisView.getTxtJenisPenjualan().setText("");
        this.alatTulisView.getTxtMerkPenjualan().setText("");
        this.alatTulisView.getTxtTerjual().setText("");
    }
}
