package com.pacheco.purrfectbreeds.ui.event

interface EventListener<TEvent> {
    fun onEvent(event: TEvent)
}