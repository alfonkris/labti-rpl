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
import tokoalattulis.model.Penjualan;
/**
 *
 * @author adrianfaisal
 */
public class PenjualanTableModel extends AbstractTableModel{

    private List<Penjualan> daftarPenjualan = new ArrayList<>();
    private final String HEADER[] = {"No", "Id Barang", "Jumlah Terjual"};
    
    public PenjualanTableModel(List<Penjualan> daftarPenjualan) {
         this.daftarPenjualan = daftarPenjualan;
    }
    
    @Override
    public int getRowCount() {
        return daftarPenjualan.size();
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
        Penjualan alatTulis = daftarPenjualan.get(rowIndex);
        
        switch(columnIndex) {
            case 0 :
                return alatTulis.getId();
            case 1 :
                return alatTulis.getAlattulis_id();
            case 2 :
                return alatTulis.getJumlah_terjual();
            default :
                return null;
        }
    }
    
}
