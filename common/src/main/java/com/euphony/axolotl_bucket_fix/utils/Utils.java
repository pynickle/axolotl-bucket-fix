package com.euphony.axolotl_bucket_fix.utils;

import com.euphony.axolotl_bucket_fix.AxolotlBucketFix;
import net.minecraft.resources.Identifier;

import java.util.Locale;

public final class Utils {
    private Utils() {}

    public static Identifier prefix(String name) {
        return Identifier.fromNamespaceAndPath(AxolotlBucketFix.MOD_ID, name.toLowerCase(Locale.ROOT));
    }
}
