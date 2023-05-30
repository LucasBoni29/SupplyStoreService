/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.supplystoreservice;

import com.myacompany.supplystoreservice.views.Menu;

/**
 * Classe responsável por iniciar o sistema SupplyStoreService
 * @Class SupplyStoredService
 */
public class SupplyStoreService {

    /**
     * Método main que vai rodar a classe principal do sistema
     * @param args Array de String com todos os argumentos do sistema
     */
    public static void main(String[] args) {
        Menu frmCadastroClientes = new Menu();
        frmCadastroClientes.setVisible(true);
    }
}
