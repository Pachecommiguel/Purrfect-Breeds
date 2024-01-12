package com.pacheco.purrfectbreeds.ui.viewmodel

import com.pacheco.purrfectbreeds.ui.event.EventListener

interface BaseViewModel<TEvent, TState> : EventListener<TEvent>, StateProvider<TState>