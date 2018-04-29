/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoalattulis.dao;

import tokoalattulis.model.AlatTulis;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tokoalattulis.model.Penjualan;

/**
 *
 * @author gde14002
 */
@Repository
public class AlatTulisDaoImpl implements AlatTulisDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void updateAlatTulis(AlatTulis alattulis) {
        sessionFactory.getCurrentSession().update(alattulis);
    }

    @Override
    public void saveAlatTulis(AlatTulis alattulis) {
        sessionFactory.getCurrentSession().save(alattulis);
    }

    @Override
    public List<AlatTulis> getDaftarAlatTulis() {
        return sessionFactory.getCurrentSession().createCriteria(AlatTulis.class).list();
    }

    @Override
    public void deleteAlatTulis(AlatTulis alattulis) {
        sessionFactory.getCurrentSession().delete(alattulis);
    }

    @Override
    public void saveTransaksi(Penjualan penjualan) {
        sessionFactory.getCurrentSession().save(penjualan);
    }

    @Override
    public List<Penjualan> getDaftarPenjualan() {
        return sessionFactory.getCurrentSession().createCriteria(Penjualan.class).list();
    }
    
    
    
    
}
