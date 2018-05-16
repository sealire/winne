package org.winne.base.util;

import java.util.UUID;

public final class UUIDUtil {

    private UUIDUtil() {}

    public static final String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
