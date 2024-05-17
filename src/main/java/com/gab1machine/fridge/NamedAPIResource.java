package com.gab1machine.fridge;

import java.util.UUID;

public record NamedAPIResource(String name, UUID id, String path) {
}
