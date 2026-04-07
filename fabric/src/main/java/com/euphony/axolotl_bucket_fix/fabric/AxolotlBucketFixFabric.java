package com.euphony.axolotl_bucket_fix.fabric;

import com.euphony.axolotl_bucket_fix.AxolotlBucketFix;
import net.fabricmc.api.ModInitializer;

public final class AxolotlBucketFixFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AxolotlBucketFix.init();
    }
}
