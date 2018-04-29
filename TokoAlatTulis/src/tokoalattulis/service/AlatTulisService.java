/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoalattulis.service;

import java.util.List;
import tokoalattulis.model.AlatTulis;
import tokoalattulis.model.Penjualan;

/**
 *
 * @author gde14002
 */

public interface AlatTulisService {
    public void updateAlatTulis(AlatTulis alattulis);
    public void saveAlatTulis(AlatTulis alattulis);
    public void saveTransaksi(Penjualan penjualan);
    public void deleteAlatTulis(AlatTulis alattulis);
    public List<AlatTulis> getDaftarAlatTulis();
    public List<Penjualan> getDaftarPenjualan();
}
