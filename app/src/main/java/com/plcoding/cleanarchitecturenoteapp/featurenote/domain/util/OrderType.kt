package com.plcoding.cleanarchitecturenoteapp.featurenote.domain.util

sealed class OrderType {
  object Ascending : OrderType()
  object Descending : OrderType()
}
