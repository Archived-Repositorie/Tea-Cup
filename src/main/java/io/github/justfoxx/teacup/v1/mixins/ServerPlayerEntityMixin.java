package io.github.justfoxx.teacup.v1.mixins;

import io.github.justfoxx.teacup.v1.event.Events;
import io.github.justfoxx.teacup.v1.event.MessageData;
import io.github.justfoxx.teacup.v1.event.MessageTextData;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin {
    @Inject(method = "sendMessageToClient", at = @At("HEAD"), cancellable = true)
    public void onSendingMessageToClient(Text message, boolean overlay, CallbackInfo ci) {
        Events.getON_MESSAGE_SEND().invoker().invoke(new MessageData(message, overlay,(ServerPlayerEntity) (Object) this, ci));
    }

    @ModifyVariable(method = "sendMessageToClient", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    public Text onSendingMessageToClient(Text message) {
        return Events.getON_MESSAGE_MODIFY().invoker().invoke(new MessageTextData(message, (ServerPlayerEntity) (Object) this));
    }
}
