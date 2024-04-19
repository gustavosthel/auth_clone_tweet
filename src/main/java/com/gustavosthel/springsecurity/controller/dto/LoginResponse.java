package com.gustavosthel.springsecurity.controller.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}
