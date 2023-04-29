package io.github.justfoxx.teacup.v2.mixins;

import io.github.justfoxx.teacup.v2.event.data.OnItemUseData;
import io.github.justfoxx.teacup.v2.event.events.ItemEvents;
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
        ItemEvents.getON_ITEM_USING().invoker().invoke(new OnItemUseData(player, stack, hand, cir));
    }

    @Inject(method = "interactItem", at = @At(value = "RETURN", target = "Lnet/minecraft/item/ItemStack;use(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/TypedActionResult;"), cancellable = true)
    private void onInteractedItem(ServerPlayerEntity player, World world, ItemStack stack, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ItemEvents.getON_ITEM_USED().invoker().invoke(new OnItemUseData(player, stack, hand, cir));
    }
}
