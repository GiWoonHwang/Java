package io.dustin.api.command;

public record UserCommand(
    String id,
    String pwd,
    String email
) {}
