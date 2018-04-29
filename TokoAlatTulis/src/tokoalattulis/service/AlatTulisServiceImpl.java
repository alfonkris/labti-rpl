/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoalattulis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tokoalattulis.dao.AlatTulisDao;
import tokoalattulis.model.AlatTulis;
import tokoalattulis.model.Penjualan;

/**
 *
 * @author gde14002
 */
@Service("AlatTulisService")
@Transactional(readOnly = true)
public class AlatTulisServiceImpl implements AlatTulisService{
    
    @Autowired
    private AlatTulisDao alatTulisDao;
    
    @Override
    @Transactional
    public void updateAlatTulis(AlatTulis alatTulis) {
        alatTulisDao.updateAlatTulis(alatTulis);
    }

    @Override
    @Transactional
    public void saveAlatTulis(AlatTulis alatTulis) {
        alatTulisDao.saveAlatTulis(alatTulis);
    }

    @Override
    public List<AlatTulis> getDaftarAlatTulis() {
        return alatTulisDao.getDaftarAlatTulis();
    }

    @Override
    public void deleteAlatTulis(AlatTulis alattulis) {
        alatTulisDao.deleteAlatTulis(alattulis);
    }

    @Override
    public void saveTransaksi(Penjualan penjualan) {
        alatTulisDao.saveTransaksi(penjualan);
    }

    @Override
    public List<Penjualan> getDaftarPenjualan() {
        return alatTulisDao.getDaftarPenjualan();
    }
}
