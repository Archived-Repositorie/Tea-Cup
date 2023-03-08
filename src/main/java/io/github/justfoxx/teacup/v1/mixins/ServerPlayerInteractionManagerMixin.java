package io.github.justfoxx.teacup.v1.mixins;

import io.github.justfoxx.teacup.v1.event.Events;
import io.github.justfoxx.teacup.v1.event.data.OnItemUseData;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerInteractionManager.class)
public class ServerPlayerInteractionManagerMixin {
    @Inject(method = "interactItem", at = @At(value = "HEAD", target = "Lnet/minecraft/item/ItemStack;use(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/TypedActionResult;"), cancellable = true)
    private void onInteractingItem(ServerPlayerEntity player, World world, ItemStack stack, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        Events.INSTANCE.getON_ITEM_USING().invoke(new OnItemUseData(player, stack, hand, cir));
    }

    @Inject(method = "interactItem", at = @At(value = "RETURN", target = "Lnet/minecraft/item/ItemStack;use(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/TypedActionResult;"), cancellable = true)
    private void onInteractedItem(ServerPlayerEntity player, World world, ItemStack stack, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        Events.INSTANCE.getON_ITEM_USED().invoke(new OnItemUseData(player, stack, hand, cir));
    }
}
