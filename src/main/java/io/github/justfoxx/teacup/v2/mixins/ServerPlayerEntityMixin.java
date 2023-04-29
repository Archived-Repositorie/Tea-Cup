package io.github.justfoxx.teacup.v2.mixins;

import io.github.justfoxx.teacup.v2.event.data.MessageData;
import io.github.justfoxx.teacup.v2.event.data.MessageTextData;
import io.github.justfoxx.teacup.v2.event.data.Setter;
import io.github.justfoxx.teacup.v2.event.events.MessageEvents;
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
        MessageEvents.getON_MESSAGE_SEND().invoker().invoke(new MessageData(message, overlay,(ServerPlayerEntity) (Object) this, ci));
    }

    @ModifyVariable(method = "sendMessageToClient", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    public Text onSendingMessageToClient(Text message) {
        var setter = new MessageTextData(new Setter<>(message),(ServerPlayerEntity) (Object) this);
        MessageEvents.getON_MESSAGE_MODIFY().invoker().invoke(setter);
        return setter.getText().get();
    }
}
