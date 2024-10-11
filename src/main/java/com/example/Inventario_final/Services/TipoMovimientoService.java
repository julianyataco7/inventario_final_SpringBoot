package com.example.Inventario_final.Services;

import com.example.Inventario_final.Models.TipoMovimiento;
import com.example.Inventario_final.Repository.TipoMovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoMovimientoService {

    @Autowired
    private TipoMovimientoRepository tipoMovimientoRepository;

    public Optional<TipoMovimiento> findById(Integer id) {
        return tipoMovimientoRepository.findById(id);
    }
}
