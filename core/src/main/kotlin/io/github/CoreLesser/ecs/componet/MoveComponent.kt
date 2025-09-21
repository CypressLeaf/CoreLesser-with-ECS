package io.github.CoreLesser.ecs.componet

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.bullet.linearmath.btIDebugDraw
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.sin

// 移动组件
class MoveComponent(
    val canMove : Boolean,
    var position : Vector2,
    var rotation : Float,
    val maxSpeed : Float,
    val rotateSpeed : Float,
    val accelerated : Float,
    val decelerated : Float,
) : Component {
    // 属性
    var target : Vector2 = Vector2()
    var move : Boolean = false
    var speed = 0f
    fun setTarget(newTarget : Vector2) {
        target = newTarget
        move = true
    }
    // 释放
    override fun dispose() {}
}
