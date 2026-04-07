package com.euphony.axolotl_bucket_fix.fabric.client;

import net.fabricmc.api.ClientModInitializer;

public final class AxolotlBucketFixFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AxolotlBucketFixFabricBootstrap.initClient();
    }
}
