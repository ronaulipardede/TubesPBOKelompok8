/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Aplikasi;
import model.Matakuliah;
import view.TambahMatkulkeKelasAdmin;

/**
 *
 * @author Rona
 */
public class ControllerTambahMatkulkeKelasAdmin implements ActionListener{
    private Aplikasi app;
    private TambahMatkulkeKelasAdmin view;
    
    
    public ControllerTambahMatkulkeKelasAdmin(){
        view = new TambahMatkulkeKelasAdmin();
        app = new Aplikasi();
        view.setVisible(true);
        view.addListener(this);
        
        for (int i = 0; i < app.getListKelasFromFile().size(); i++) {
            if (app.getListKelasFromFile().get(i).getMatakuliah()==null){
                view.setIsiNamaKelas(app.getListKelasFromFile().get(i).getNamaKelas());
            }
        }
        
        for (int i = 0; i < app.getListMatkulFromFile().size(); i++) {
            for (int j = 0; j < app.getListKelasFromFile().size(); j++) {
                if (app.getListMatkulFromFile().get(i).getnamaMK().equals(app.getListKelasFromFile().get(j).getMatakuliah().getnamaMK())) {
                    
                }
                else {
                    view.setIsiMatakuliah(app.getListMatkulFromFile().get(i).getnamaMK());
                }
            }
        }
     
    }
    
    public Matakuliah getMatakuliah(String nama){
            for (int i = 0; i < app.getListMatkulFromFile().size(); i++) {
                if (app.getListMatkulFromFile().get(i).getnamaMK().equals(nama)) {
                    return app.getListMatkulFromFile().get(i);
                }
            }
            return null;
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(view.getBtnCancel())){
            ControllerHomeAdmin cha = new ControllerHomeAdmin();
            view.dispose();
        }
        
        if (source.equals(view.getBtnAdd())) {
            for (int i = 0; i < app.getListKelasFromFile().size(); i++) {
                if (app.getListKelasFromFile().get(i).getNamaKelas().equals(view.getIsiNamaKelas())){
                    app.getListKelasFromFile().get(i).setMatakuliah(getMatakuliah(view.getIsiMatakuliah()));
                    JOptionPane.showMessageDialog(null, "Mata Kuliah Berhasil Ditambahkan!");
                }
                
            }
        }
    }
    
}