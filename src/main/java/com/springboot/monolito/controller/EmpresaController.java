package com.springboot.monolito.controller;

import com.springboot.monolito.entity.Empresa;
import com.springboot.monolito.service.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Especificar que es un controller
@RequestMapping("/empresa") //Especificar path a la ruta
public class EmpresaController {
    @Autowired
    private IEmpresaService empresaService;

    @GetMapping("/listar")
    public List<Empresa> listar(){
        return empresaService.listar();
    }

    @GetMapping("/buscar/{id}")
    public Empresa buscar(@PathVariable(name = "id") Long id){
        return empresaService.buscar(id);
    }

    @GetMapping("/registrar")
    public Empresa registar(@RequestBody Empresa empresa){
        return empresaService.registrar(empresa);
    }

    @PutMapping("/actualizar/{id}")
    public Empresa actualizar(@PathVariable(name = "id") Long id, @RequestBody Empresa empresa) throws NoSuchFieldException {

        return empresaService.actualizar(id, empresa);
    }

    @DeleteMapping("/eliminar/{id}")
    public Empresa eliminar(@PathVariable(name = "id") Long id) throws NoSuchFieldException { // si en lugar de empresa pongo String, puedo eviar solo un mensaje
        return empresaService.eliminar(id);
    }

}
