package io.github.justfoxx.teacup.v1.mixins;

import io.github.justfoxx.teacup.v1.event.Events;
import io.github.justfoxx.teacup.v1.event.InternalPacketData;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkState;
import net.minecraft.network.PacketCallbacks;
import net.minecraft.network.packet.Packet;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {
    @Inject(method = "sendInternal", at = @At("HEAD"), cancellable = true)
    public void onSend(Packet<?> packet, @Nullable PacketCallbacks callbacks, NetworkState packetState, NetworkState currentState, CallbackInfo ci) {

        Events.getON_INTERNAL_SEND_PACKET().invoker().invoke(new InternalPacketData(packet, callbacks, packetState, currentState, (ClientConnection) (Object) this, ci));
    }
}
