package com.euphony.axolotl_bucket_fix.neoforge.datagen;

import com.euphony.axolotl_bucket_fix.AxolotlBucketFix;
import com.euphony.axolotl_bucket_fix.client.property.AxolotlBucketVariant;
import com.euphony.axolotl_bucket_fix.utils.Utils;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.List;

public class ModelGenerator extends ModelProvider {
    public ModelGenerator(PackOutput output) {
        super(output, AxolotlBucketFix.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        generateAxolotlBucket(itemModels, Items.AXOLOTL_BUCKET);
    }

    public void generateAxolotlBucket(ItemModelGenerators itemModels, Item item) {
        ItemModel.Unbaked wild = createAxolotlBucketModel("_wild", itemModels);
        ItemModel.Unbaked gold = createAxolotlBucketModel("_gold", itemModels);
        ItemModel.Unbaked cyan = createAxolotlBucketModel("_cyan", itemModels);
        ItemModel.Unbaked blue = createAxolotlBucketModel("_blue", itemModels);
        itemModels.itemModelOutput.accept(
                item,
                ItemModelUtils.select(
                        new AxolotlBucketVariant(0),
                        wild,
                        new SelectItemModel.SwitchCase<>(
                                List.of(0.0f),
                                ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(Items.AXOLOTL_BUCKET))),
                        new SelectItemModel.SwitchCase<>(List.of(0.01f), wild),
                        new SelectItemModel.SwitchCase<>(List.of(0.02f), gold),
                        new SelectItemModel.SwitchCase<>(List.of(0.03f), cyan),
                        new SelectItemModel.SwitchCase<>(List.of(0.04f), blue)));
    }

    public ItemModel.Unbaked createAxolotlBucketModel(String suffix, ItemModelGenerators itemModels) {
        Identifier resourceLocation = Utils.prefix("item/axolotl_bucket" + suffix);
        return ItemModelUtils.plainModel(ModelTemplates.FLAT_ITEM.create(
                resourceLocation, TextureMapping.layer0(new Material(resourceLocation)), itemModels.modelOutput));
    }

    public void itemModel(ItemModelGenerators itemModels, Item item, ModelTemplate template) {
        Identifier itemId = BuiltInRegistries.ITEM.getKey(item);
        Identifier textureLoc = Identifier.fromNamespaceAndPath(itemId.getNamespace(), "item/" + itemId.getPath());
        TextureMapping textureMapping = new TextureMapping().put(TextureSlot.LAYER0, new Material(textureLoc));
        itemModels.itemModelOutput.accept(
                item, ItemModelUtils.plainModel(template.create(item, textureMapping, itemModels.modelOutput)));
    }
}
