package tinkersurvival.data;

import java.util.Arrays;
import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.Tags;

import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.common.TinkerTags;

import static slimeknights.tconstruct.common.TinkerTags.Items.DURABILITY;
import static slimeknights.tconstruct.common.TinkerTags.Items.HARVEST_PRIMARY;
import static slimeknights.tconstruct.common.TinkerTags.Items.GOLD_CASTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.MULTIPART_TOOL;
import static slimeknights.tconstruct.common.TinkerTags.Items.ONE_HANDED;
import static slimeknights.tconstruct.common.TinkerTags.Items.RED_SAND_CASTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.SAND_CASTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.TOOL_PARTS;


import tinkersurvival.TinkerSurvival;
import tinkersurvival.util.TagManager;
import tinkersurvival.world.TinkerSurvivalWorld;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, TinkerSurvival.MODID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "TinkerSurvival - Item Tags";
    }

    @Override
    protected void addTags() {
        builder(TagManager.Items.FLINT_KNAPPABLE,
            Items.FLINT,
            TinkerSurvivalWorld.ROCK_STONE.get()
        );
        builder(TagManager.Items.PICKAXE_TOOLS);
        builder(
            TagManager.Items.AXE_TOOLS,
            TinkerSurvivalWorld.CRUDE_HATCHET.get()
        );
        builder(
            TagManager.Items.SAW_TOOLS,
            TinkerSurvivalWorld.CRUDE_SAW.get(),
            TinkerSurvivalWorld.SAW.get()
        );
        builder(TagManager.Items.SHOVEL_TOOLS);
        builder(TagManager.Items.HOE_TOOLS);
        builder(
            TagManager.Items.KNIFE_TOOLS,
            TinkerSurvivalWorld.CRUDE_KNIFE.get()
        );
        builder(TagManager.Items.ROCK, TinkerSurvivalWorld.ROCK_STONE.get());
        builder(
            TagManager.Items.SAW_PARTS,
            TinkerSurvivalWorld.CRUDE_SAW_HANDLE.get(),
            TinkerSurvivalWorld.CRUDE_SAW_BLADE.get()
        );
        builder(
            TagManager.Items.BANDAGES,
            TinkerSurvivalWorld.CRUDE_BANDAGE.get(),
            TinkerSurvivalWorld.BANDAGE.get()
        );

        Consumer<CastItemObject> addCast = cast -> {
            this.tag(GOLD_CASTS).add(cast.get());
            this.tag(SAND_CASTS).add(cast.getSand());
            this.tag(RED_SAND_CASTS).add(cast.getRedSand());
        };

        this.tag(MULTIPART_TOOL).add(TinkerSurvivalWorld.SAW.get());
        this.tag(DURABILITY).add(TinkerSurvivalWorld.SAW.get());
        this.tag(ONE_HANDED).add(TinkerSurvivalWorld.SAW.get());
        this.tag(HARVEST_PRIMARY).add(TinkerSurvivalWorld.SAW.get());
        this.tag(TOOL_PARTS).add(TinkerSurvivalWorld.SAW_BLADE.get());

        addCast.accept(TinkerSurvivalWorld.SAW_BLADE_CAST);
    }

    private void builder(Tag.Named<Item> tag) {
        getBuilder(tag);
    }

    private void builder(Tag.Named<Item> tag, ItemLike... items) {
        getBuilder(tag).add(Arrays.stream(items).map(ItemLike::asItem).toArray(Item[]::new));
    }

    protected TagsProvider.TagAppender<Item> getBuilder(Tag.Named<Item> tag) {
        return tag(tag);
    }

}
