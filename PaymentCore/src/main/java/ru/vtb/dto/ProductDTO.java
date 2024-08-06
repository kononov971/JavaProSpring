package ru.vtb.dto;

import java.math.BigDecimal;

public record ProductDTO(Long id, Long accountNum, BigDecimal balance, String type, Long userId) {
}
