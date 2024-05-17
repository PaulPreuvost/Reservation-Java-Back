package com.gab1machine.fridge.common;

import java.util.UUID;

public record NamedAPIResource<T>(String name, UUID id, String path) {
}
