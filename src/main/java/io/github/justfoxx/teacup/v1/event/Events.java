package io.github.justfoxx.teacup.v1.event;

import com.google.gson.JsonObject;
import io.github.justfoxx.teacup.v1.event.data.OnItemUseData;
import io.github.justfoxx.teacup.v1.registry.MapRegistry;
import io.github.justfoxx.teacup.v1.utils.Mod;
import io.github.justfoxx.teacup.v1.utils.ThrowingConsumer;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import oshi.util.tuples.Pair;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * A class that holds all the events
 */
public final class Events {
    static {
        CONFIG = DataEventKey.of(new MapRegistry<>(),
                EventFunctions::configEvent
        );
        ON_ITEM_USE = DataEventKey.of(new MapRegistry<>(),
                EventFunctions::onItemUse
        );
    }
    /**
     * A config event that is called when the config is loaded
     */
    public static final DataEventKey<
            ThrowingConsumer<JsonObject>,
            Pair<Mod, Optional<Object>>,
            Void
            > CONFIG;

    /**
     * An event that is called when a player uses an item
     */
    public static final DataEventKey<
            Function<OnItemUseData,ActionResult>,
            Predicate<OnItemUseData>,
            Pair<OnItemUseData, CallbackInfoReturnable<ActionResult>>
            > ON_ITEM_USE;

    private Events() {}
}
