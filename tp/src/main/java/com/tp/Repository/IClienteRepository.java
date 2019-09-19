/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.Cliente;
import java.util.List;

/**
 *
 * @author shiara
 */
public interface IClienteRepository {
   public void save(Cliente c);
    public void update(Cliente c);
    public void delete(Cliente c);
    public List<Cliente> findAll();
}
