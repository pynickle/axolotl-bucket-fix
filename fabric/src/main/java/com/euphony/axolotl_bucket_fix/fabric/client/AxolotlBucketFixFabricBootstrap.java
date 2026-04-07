package com.euphony.axolotl_bucket_fix.fabric.client;

import com.euphony.axolotl_bucket_fix.client.property.AxolotlBucketVariant;
import com.euphony.axolotl_bucket_fix.utils.Utils;
import net.minecraft.client.renderer.item.properties.select.SelectItemModelProperties;

public final class AxolotlBucketFixFabricBootstrap {
    private AxolotlBucketFixFabricBootstrap() {}

    public static void initClient() {
        SelectItemModelProperties.ID_MAPPER.put(Utils.prefix("variant"), AxolotlBucketVariant.TYPE);
    }
}
