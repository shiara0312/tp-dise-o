/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.Empleado;
import java.util.List;

/**
 *
 * @author shiara
 */
public interface IEmpleadoRepository {
    public void save(Empleado empl);
    public void update(Empleado empl);
    public void delete(Empleado empl);
    public List<Empleado> findAll();
}