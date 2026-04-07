package com.euphony.axolotl_bucket_fix.neoforge.client;

import com.euphony.axolotl_bucket_fix.client.property.AxolotlBucketVariant;
import com.euphony.axolotl_bucket_fix.utils.Utils;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterSelectItemModelPropertyEvent;

@EventBusSubscriber
public final class BCClientNeoforge {
    @SubscribeEvent
    private static void onRegisterSelectItemModelProperty(RegisterSelectItemModelPropertyEvent event) {
        event.register(Utils.prefix("variant"), AxolotlBucketVariant.TYPE);
    }
}
