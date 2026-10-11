package com.cibertec.pagoservicegrupo09.service;

import com.cibertec.pagoservicegrupo09.dto.PagoDTO;
import com.cibertec.pagoservicegrupo09.model.Pago;
import com.cibertec.pagoservicegrupo09.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PagoService {
    private final PagoRepository pagoRepository;

    public PagoDTO obtenerPagoPorPedido(Long idPedido) {
        return pagoRepository.buscarPorIdPedido(idPedido)
                .map(this::aDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No existe un pago registrado para el pedido " + idPedido));
    }

    public List<PagoDTO> obtenerPagosPorCliente(Long clienteId) {
        return pagoRepository.buscarPorClienteId(clienteId).stream()
                .map(this::aDto)
                .toList();
    }

    private PagoDTO aDto(Pago pago) {
        return new PagoDTO(pago.idPago(), pago.idPedido(), pago.metodoPago(),
                pago.montoPagado(), pago.fechaPago(), pago.codigoAutorizacion(), pago.estadoPago());
    }
}
