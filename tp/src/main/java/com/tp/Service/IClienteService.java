/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Cliente;
import java.util.List;

/**
 *
 * @author shiara
 */
interface IClienteService {
     public void saveCliente(Cliente c);
    public void updateCliente(Cliente c);
    public List<Cliente> getAll();
    public void delete(Cliente c);
}
