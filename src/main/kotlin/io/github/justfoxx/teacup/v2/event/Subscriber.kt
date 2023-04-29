package io.github.justfoxx.teacup.v2.event

import io.github.justfoxx.teacup.v2.utils.sort.Priority

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Subscriber(val priority: Priority = Priority.NORMAL)
