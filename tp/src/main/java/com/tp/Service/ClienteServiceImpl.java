/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import com.tp.Repository.IClienteRepository;

/**
 *
 * @author shiara
 */
@Named
public class ClienteServiceImpl implements IClienteService,Serializable{
     
    private static final long serialVersionUID = 1L;

    @Inject
    private IClienteRepository clienteRepository;


    @Override
    public void saveCliente(Cliente c) {
	clienteRepository.save(c);
    }

    @Override
    public void updateCliente(Cliente c) {
	clienteRepository.update(c);
    }

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public void delete(Cliente c) {
        clienteRepository.delete(c);
    }
    
}
