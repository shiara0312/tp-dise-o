/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Empleado;
import java.util.List;

/**
 *
 * @author shiara
 */
public interface IEmpleadoService {
 public void saveEmpleado(Empleado emp);
    public void updateEmpleado(Empleado emp);
    public List<Empleado> getAll();
    public void delete(Empleado emp);
      
}
