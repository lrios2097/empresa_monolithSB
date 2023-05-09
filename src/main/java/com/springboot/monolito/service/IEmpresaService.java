package com.springboot.monolito.service;

import com.springboot.monolito.entity.Empresa;

import java.util.List;
import java.util.Optional;

public interface IEmpresaService {

    public List<Empresa> listar();

    public Empresa buscar(Long id);

    public Empresa registrar(Empresa empresa);

    public Empresa actualizar(Long id, Empresa empresaActualizar) throws NoSuchFieldException;

    public Empresa eliminar(Long id) throws NoSuchFieldException;
}
