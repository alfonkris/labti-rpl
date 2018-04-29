/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoalattulis.config;

/**
 *
 * @author gde14002
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tokoalattulis.model.AlatTulis;
/**
 *
 * @author adrianfaisal
 */
public class AlatTulisTableModel extends AbstractTableModel{

    private List<AlatTulis> daftarAlatTulis = new ArrayList<>();
    private final String HEADER[] = {"Jenis", "Merk", "Jumlah", "Harga", "Tahun"};
    
    public AlatTulisTableModel(List<AlatTulis> daftarAlatTulis) {
         this.daftarAlatTulis = daftarAlatTulis;
    }
    
    @Override
    public int getRowCount() {
        return daftarAlatTulis.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return HEADER[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AlatTulis alatTulis = daftarAlatTulis.get(rowIndex);
        
        switch(columnIndex) {
            case 0 :
                return alatTulis.getJenis();
            case 1 :
                return alatTulis.getMerk();
            case 2 :
                return alatTulis.getJumlah();
            case 3 : 
                return alatTulis.getHarga();
            case 4 :
                return alatTulis.getTahun();
            default :
                return null;
        }
    }
    
}
