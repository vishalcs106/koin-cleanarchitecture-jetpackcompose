package com.android.core.network

sealed class Either<out L, out R> {
    data class Left<out L>(val value: L) : Either<L, Nothing>()
    data class Right<out R>(val value: R) : Either<Nothing, R>()

    fun <L> left(value: L): Either<L, Nothing> = Left(value)
    fun <R> right(value: R): Either<Nothing, R> = Right(value)

    fun fold(onLeft: (L) -> Unit, onRight: (R) -> Unit) {
        when (this) {
            is Left -> onLeft(value)
            is Right -> onRight(value)
        }
    }
}
