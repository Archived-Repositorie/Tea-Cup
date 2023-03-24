package io.github.justfoxx.teacup.v1.utils

import net.minecraft.entity.Entity
import net.minecraft.nbt.NbtCompound




interface EntityDataSaver {
    fun getPersistentData(): NbtCompound
    companion object {
        fun get(entity: Entity): EntityDataSaver {
            return entity as EntityDataSaver
        }
    }
}