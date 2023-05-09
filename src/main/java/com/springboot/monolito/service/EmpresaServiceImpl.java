package com.springboot.monolito.service;

import com.springboot.monolito.entity.Empresa;
import com.springboot.monolito.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service //Implementacion del service
public class EmpresaServiceImpl implements IEmpresaService{
    @Autowired //inyeccion de dependencias
    private EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> listar() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa buscar(Long id){
        return empresaRepository.findById(id).orElse(new Empresa(0L, "default", "default", "default", new Date(), "default" ));
    }

    @Override
    public Empresa registrar(Empresa empresa){
        Empresa empresaRegister = new Empresa();
        empresaRegister.setRazonSocial(empresa.getRazonSocial());
        empresaRegister.setRepresentante(empresa.getRepresentante());
        empresaRegister.setRuc(empresa.getRuc());
        empresaRegister.setFechaCreacion(empresa.getFechaCreacion());

        return empresaRepository.save(empresaRegister);
    }

    @Override
    public Empresa actualizar(Long id, Empresa empresaActualizar) throws NoSuchFieldException {

        /*Programacion Funcional
        *Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.map(value ->empresaRepository.save(value).orElse(null))
        */
        /*Logica del Profesor
        if(empresa.isEmpty()){
            throw new RuntimeException();
        }//Seria como el else
        Empresa empresaExiste = empresa.get();
        empresaExiste.setRazonSocial(empresaActualizar.getRazonSocial());
        empresaExiste.setRepresentante(empresaActualizar.getRepresentante());
        empresaExiste.setRuc(empresaActualizar.getRuc());
        empresaExiste.setFechaCreacion(empresaActualizar.getFechaCreacion());
        Empresa empresaActualizadaBD = empresaRepository.save(empresaExiste);
        return empresaRepository.save(empresa.get());
         */

        Optional<Empresa> empresa = empresaRepository.findById(id);
        if(empresa.isPresent()){
        Empresa empresaExiste = empresa.get();
        empresaExiste.setRazonSocial(empresaActualizar.getRazonSocial());
        empresaExiste.setRepresentante(empresaActualizar.getRepresentante());
        empresaExiste.setRuc(empresaActualizar.getRuc());
        empresaExiste.setFechaCreacion(empresaActualizar.getFechaCreacion());
        Empresa empresaActualizadaBD = empresaRepository.save(empresaExiste);
        return empresaActualizadaBD;

        }else{
            throw new NoSuchFieldException("No se encontró el producto con el id especificado");
        }
    }

    @Override
    public Empresa eliminar(Long id) throws NoSuchFieldException {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if(empresa.isPresent()){
            Empresa empresaEliminado = empresa.get();//capturo la info
            empresaRepository.deleteById(id);
            return empresaEliminado; // muestro datos de la emp eliminada
        }
        throw new NoSuchFieldException("No se encontró el producto con el id especificado");
    }


}
