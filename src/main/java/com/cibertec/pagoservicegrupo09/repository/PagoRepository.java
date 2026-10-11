package com.cibertec.pagoservicegrupo09.repository;

import com.cibertec.pagoservicegrupo09.model.Pago;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PagoRepository {
    private final List<Pago> pagos = new ArrayList<>();

    @PostConstruct
    private void cargarDatosDePrueba() {
        pagos.add(new Pago(1L, 1L, 1L, "TARJETA_CREDITO", 2600.00,
                LocalDateTime.now().minusDays(3), "AUT-0001", "APROBADO"));
        pagos.add(new Pago(2L, 2L, 1L, "TRANSFERENCIA", 500.00,
                LocalDateTime.now().minusDays(2), "AUT-0002", "APROBADO"));
        pagos.add(new Pago(3L, 3L, 2L, "TARJETA_CREDITO", 450.00,
                LocalDateTime.now().minusDays(1), "AUT-0003", "APROBADO"));
    }

    public Optional<Pago> buscarPorIdPedido(Long idPedido) {
        return pagos.stream()
                .filter(pago -> pago.idPedido().equals(idPedido))
                .findFirst();
    }

    public List<Pago> buscarPorClienteId(Long clienteId) {
        return pagos.stream()
                .filter(pago -> pago.clienteId().equals(clienteId))
                .toList();
    }
}
