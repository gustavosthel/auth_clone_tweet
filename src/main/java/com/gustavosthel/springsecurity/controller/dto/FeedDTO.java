package com.gustavosthel.springsecurity.controller.dto;

import java.util.List;

public record FeedDTO(List<FeedItemDTO> feedItens,
                      int page,
                      int pageSize,
                      int totalPages,
                      Long totalEleements) {
}
