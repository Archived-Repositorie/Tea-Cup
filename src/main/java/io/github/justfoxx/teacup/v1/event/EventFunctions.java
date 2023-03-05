package io.github.justfoxx.teacup.v1.event;

import com.google.gson.JsonObject;
import io.github.justfoxx.teacup.v1.event.data.OnItemUseData;
import io.github.justfoxx.teacup.v1.utils.JsonHelper;
import io.github.justfoxx.teacup.v1.utils.Mod;
import io.github.justfoxx.teacup.v1.utils.ThrowingConsumer;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import oshi.util.tuples.Pair;

import java.nio.file.Files;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * A class that holds all the event functions
 */
final class EventFunctions {

    public static void configEvent(Set<Map.Entry<ThrowingConsumer<JsonObject>, Pair<Mod, Optional<Object>>>> entries) throws Exception {
        for (var entry : entries) {
            var value = entry.getValue();
            var configPath = value.getA().getConfigPath();
            var defaultObject = value.getB();
            var invoker = entry.getKey();

            JsonObject configObject;
            if (Files.notExists(configPath)) {
                Files.createFile(configPath);
                configObject = JsonHelper.getDefaultJsonObject(defaultObject, configPath);
            } else {
                configObject = JsonHelper.readJsonObject(configPath);
            }
            invoker.accept(configObject);
        }
    }

    public static void onItemUse(Set<Map.Entry<Function<OnItemUseData, ActionResult>, Predicate<OnItemUseData>>> entries, Pair<OnItemUseData, CallbackInfoReturnable<ActionResult>> data) {
        for (var entry : entries) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (!value.test(data.getA())) {
                continue;
            }
            var returned = key.apply(data.getA());
            if (returned != ActionResult.PASS) {
                data.getB().setReturnValue(returned);
            }
        }
    }

    private EventFunctions() {}
}
