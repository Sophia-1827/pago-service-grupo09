package com.cibertec.pagoservicegrupo09.controller;

import com.cibertec.pagoservicegrupo09.dto.PagoDTO;
import com.cibertec.pagoservicegrupo09.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/pagos")
public class PagoController {
    private final PagoService pagoService;

    @GetMapping("/pedido/{idPedido}")
    public PagoDTO obtenerPagoPorPedido(@PathVariable Long idPedido) {
        return pagoService.obtenerPagoPorPedido(idPedido);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<PagoDTO> obtenerPagosPorCliente(@PathVariable Long clienteId) {
        return pagoService.obtenerPagosPorCliente(clienteId);
    }
}
