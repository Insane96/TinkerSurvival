package tinkersurvival.data;

import java.util.Arrays;
import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import net.minecraftforge.common.data.ExistingFileHelper;

import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.tools.TinkerTools;

import static slimeknights.tconstruct.common.TinkerTags.Items.DURABILITY;
import static slimeknights.tconstruct.common.TinkerTags.Items.GOLD_CASTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.HARVEST_PRIMARY;
import static slimeknights.tconstruct.common.TinkerTags.Items.MULTIPART_TOOL;
import static slimeknights.tconstruct.common.TinkerTags.Items.ONE_HANDED;
import static slimeknights.tconstruct.common.TinkerTags.Items.RED_SAND_CASTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.SAND_CASTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.TOOL_PARTS;

import tinkersurvival.common.TagManager;
import tinkersurvival.data.integration.ModIntegration;
import tinkersurvival.items.TConItems;
import tinkersurvival.items.TinkerSurvivalItems;
import tinkersurvival.TinkerSurvival;
import tinkersurvival.world.TinkerSurvivalWorld;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, TinkerSurvival.MODID, existingFileHelper);
    }

    @Override
    public @NotNull String getName() {
        return "TinkerSurvival - Item Tags";
    }

    @Override
    protected void addTags() {
        builder(
            TagManager.Items.FLINT_KNAPPABLE,
            Items.FLINT,
            TinkerSurvivalWorld.ROCK_STONE
        );
        getBuilder(TagManager.Items.PICKAXE_TOOLS)
            .addOptional(ModIntegration.ieLoc("buzzsaw"))
            .addOptional(ModIntegration.ieLoc("drill"))
            .addOptional(ModIntegration.ieLoc("hammer"))
            .add(TinkerTools.pickaxe.asItem())
            .add(TinkerTools.pickadze.asItem())
            .add(TinkerTools.sledgeHammer.asItem())
            .add(TinkerTools.veinHammer.asItem());
        getBuilder(TagManager.Items.AXE_TOOLS)
            .addOptional(ModIntegration.ieLoc("buzzsaw"))
            .add(TinkerSurvivalItems.CRUDE_HATCHET)
            .add(TConItems.SAW.get().asItem())
            .add(TinkerTools.mattock.asItem())
            .add(TinkerTools.handAxe.asItem())
            .add(TinkerTools.broadAxe.asItem());
        builder(
            TagManager.Items.SAW_TOOLS,
            TinkerSurvivalItems.CRUDE_SAW,
            TConItems.SAW.get()
        );
        getBuilder(TagManager.Items.SHOVEL_TOOLS)
            .addOptional(ModIntegration.ieLoc("drill"))
            .add(TinkerTools.mattock.asItem())
            .add(TinkerTools.pickadze.asItem())
            .add(TinkerTools.excavator.asItem());
        builder(
            TagManager.Items.HOE_TOOLS,
            TinkerTools.mattock,
            TinkerTools.kama
        );
        builder(
            TagManager.Items.KNIFE_TOOLS,
            TinkerSurvivalItems.CRUDE_KNIFE,
            TConItems.KNIFE.get()
        );
        getBuilder(TagManager.Items.SHARP_TOOLS)
            .addOptional(ModIntegration.ieLoc("revolver"))
            .add(TinkerTools.kama.asItem())
            .addTag(TagManager.Items.KNIFE_TOOLS)
            .addTag(TagManager.Items.AXE_TOOLS)
            .add(TinkerTools.dagger.asItem())
            .add(TinkerTools.cleaver.asItem())
            .add(TinkerTools.sword.asItem());
        builder(TagManager.Items.ROCK, TinkerSurvivalWorld.ROCK_STONE);
        builder(
            TagManager.Items.SAW_PARTS,
            TinkerSurvivalItems.CRUDE_SAW_HANDLE,
            TinkerSurvivalItems.CRUDE_SAW_BLADE
        );
        builder(
            TagManager.Items.BANDAGES,
            TinkerSurvivalItems.CRUDE_BANDAGE,
            TinkerSurvivalItems.BANDAGE
        );

        // Fruit Trees
        addFTLogVariants(TagManager.Items.CHERRY_LOGS, "cherry");
        addFTLogVariants(TagManager.Items.CITRUS_LOGS, "citrus");

        // Biome Makeover
        addBMOLogVariants(TagManager.Items.BMO_ANCIENT_OAK_LOGS, "ancient_oak");
        addBMOLogVariants(TagManager.Items.BMO_BLIGHTED_BALSA_LOGS, "blighted_balsa");
        addBMOLogVariants(TagManager.Items.BMO_SWAMP_CYPRESS_LOGS, "swamp_cypress");
        addBMOLogVariants(TagManager.Items.BMO_WILLOW_LOGS, "willow");

        // Biomes O' Plenty
        addBOPLogVariants(TagManager.Items.BOP_CHERRY_LOGS, "cherry");
        addBOPLogVariants(TagManager.Items.BOP_DEAD_LOGS, "dead");
        addBOPLogVariants(TagManager.Items.BOP_FIR_LOGS, "fir");
        addBOPLogVariants(TagManager.Items.BOP_HELLBARK_LOGS, "hellbark");
        addBOPLogVariants(TagManager.Items.BOP_JACARANDA_LOGS, "jacaranda");
        addBOPLogVariants(TagManager.Items.BOP_MAGIC_LOGS, "magic");
        addBOPLogVariants(TagManager.Items.BOP_MAHOGANY_LOGS, "mahogany");
        addBOPLogVariants(TagManager.Items.BOP_PALM_LOGS, "palm");
        addBOPLogVariants(TagManager.Items.BOP_REDWOOD_LOGS, "redwood");
        addBOPLogVariants(TagManager.Items.BOP_UMBRAN_LOGS, "umbran");
        addBOPLogVariants(TagManager.Items.BOP_WILLOW_LOGS, "willow");

        // Botania
        addBotaniaLogVariants(TagManager.Items.BOTANIA_DREAMWOOD_LOGS, "dreamwood");
        addBotaniaLogVariants(TagManager.Items.BOTANIA_LIVINGWOOD_LOGS, "livingwood");

        // Quark
        addQuarkLogVariants(TagManager.Items.QUARK_AZALEA_LOGS, "azalea");
        addQuarkLogVariants(TagManager.Items.QUARK_BLOSSOM_LOGS, "blossom");

        // All You Can Eat
        addAyceLogVariants(TagManager.Items.AYCE_HAZEL_LOGS, "hazel");

        // Tinkers' Construct
        addTconLogVariants(TagManager.Items.TCON_BLOODSHROOM_LOGS, "bloodshroom");
        addTconLogVariants(TagManager.Items.TCON_GREENHEART_LOGS, "greenheart");
        addTconLogVariants(TagManager.Items.TCON_SKYROOT_LOGS, "skyroot");

        // Water Source
        addWsLogVariants(TagManager.Items.WS_PALM_TREE_LOGS, "palm_tree");

        Consumer<CastItemObject> addCast = cast -> {
            this.tag(GOLD_CASTS).add(cast.get());
            this.tag(TagManager.Items.SAW_BLADE_CAST).add(cast.get());
            this.tag(SAND_CASTS).add(cast.getSand());
            this.tag(TagManager.Items.SAW_BLADE_CAST_SINGLE).add(cast.getSand());
            this.tag(RED_SAND_CASTS).add(cast.getRedSand());
            this.tag(TagManager.Items.SAW_BLADE_CAST_SINGLE).add(cast.getRedSand());
        };

        this.tag(MULTIPART_TOOL).add(
            TConItems.SAW.get(),
            TConItems.KNIFE.get()
        );
        this.tag(DURABILITY).add(
            TConItems.SAW.get(),
            TConItems.KNIFE.get()
        );
        this.tag(ONE_HANDED).add(
            TConItems.SAW.get(),
            TConItems.KNIFE.get()
        );
        this.tag(HARVEST_PRIMARY).add(
            TConItems.SAW.get(),
            TConItems.KNIFE.get()
        );
        this.tag(TOOL_PARTS).add(TConItems.SAW_BLADE.get());

        addCast.accept(TConItems.SAW_BLADE_CAST);
    }

    private void addWsLogVariants(TagKey<Item> tag, String type) {
        getBuilder(tag)
            .addOptional(ModIntegration.wsLoc(type + "_log"))
            .addOptional(ModIntegration.wsLoc("stripped_" + type + "_log"));
    }

    private void addTconLogVariants(TagKey<Item> tag, String type) {
        getBuilder(tag)
            .addOptional(ModIntegration.tconLoc(type + "_log"))
            .addOptional(ModIntegration.tconLoc("stripped_" + type + "_log"))
            .addOptional(ModIntegration.tconLoc(type + "_wood"))
            .addOptional(ModIntegration.tconLoc("stripped_" + type + "_wood"));
    }

    private void addAyceLogVariants(TagKey<Item> tag, String type) {
        getBuilder(tag)
            .addOptional(ModIntegration.ayceLoc(type + "_log"))
            .addOptional(ModIntegration.ayceLoc("stripped_" + type + "_log"))
            .addOptional(ModIntegration.ayceLoc(type + "_wood"))
            .addOptional(ModIntegration.ayceLoc("stripped_" + type + "_wood"));
    }

    private void addQuarkLogVariants(TagKey<Item> tag, String type) {
        getBuilder(tag)
            .addOptional(ModIntegration.qLoc(type + "_log"))
            .addOptional(ModIntegration.qLoc("stripped_" + type + "_log"))
            .addOptional(ModIntegration.qLoc(type + "_wood"))
            .addOptional(ModIntegration.qLoc("stripped_" + type + "_wood"));
    }

    private void addBMOLogVariants(TagKey<Item> tag, String type) {
        getBuilder(tag)
            .addOptional(ModIntegration.bmoLoc(type + "_log"))
            .addOptional(ModIntegration.bmoLoc("stripped_" + type + "_log"))
            .addOptional(ModIntegration.bmoLoc(type + "_wood"))
            .addOptional(ModIntegration.bmoLoc("stripped_" + type + "_wood"));
    }

    private void addBOPLogVariants(TagKey<Item> tag, String type) {
        getBuilder(tag)
            .addOptional(ModIntegration.bopLoc(type + "_log"))
            .addOptional(ModIntegration.bopLoc("stripped_" + type + "_log"))
            .addOptional(ModIntegration.bopLoc(type + "_wood"))
            .addOptional(ModIntegration.bopLoc("stripped_" + type + "_wood"));
    }

    private void addBotaniaLogVariants(TagKey<Item> tag, String type) {
        getBuilder(tag)
            .addOptional(ModIntegration.botaniaLoc(type + "_log"))
            .addOptional(ModIntegration.botaniaLoc("stripped_" + type + "_log"))
            .addOptional(ModIntegration.botaniaLoc(type))
            .addOptional(ModIntegration.botaniaLoc("stripped_" + type));
    }

    private void addFTLogVariants(TagKey<Item> tag, String type) {
        getBuilder(tag)
            .addOptional(ModIntegration.ftLoc(type + "_log"))
            .addOptional(ModIntegration.ftLoc("stripped_" + type + "_log"))
            .addOptional(ModIntegration.ftLoc(type + "_wood"))
            .addOptional(ModIntegration.ftLoc("stripped_" + type + "_wood"));
    }

    protected TagsProvider.TagAppender<Item> getBuilder(TagKey<Item> tag) {
        return tag(tag);
    }

    private void builder(TagKey<Item> tag, ItemLike... items) {
        getBuilder(tag).add(Arrays.stream(items).map(ItemLike::asItem).toArray(Item[]::new));
    }

}
