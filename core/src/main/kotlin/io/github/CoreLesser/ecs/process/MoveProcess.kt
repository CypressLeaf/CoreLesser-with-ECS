package io.github.CoreLesser.ecs.process

import com.badlogic.gdx.math.Vector2
import io.github.CoreLesser.ecs.componet.MoveComponent
import io.github.CoreLesser.manager.LevelEntityManager
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

// 移动进程
class MoveProcess(
    private val manager : LevelEntityManager
) : Process {
    // 渲染
    override fun render(delta: Float) {}
    // 更新
    override fun update(delta: Float) {
        manager.allEntity().forEach { entity ->
            val moveComponent = entity.findComponent<MoveComponent>()
            if (moveComponent != null && moveComponent.canMove && moveComponent.move) {
                // 移动属性
                val toTarget = Vector2(moveComponent.target).sub(moveComponent.position)
                val distance = toTarget.len()
                val direction = Vector2(toTarget).nor()
                // 速率更新
                if (distance < (moveComponent.speed * moveComponent.speed) / (2 * moveComponent.decelerated)) {
                    moveComponent.speed -= moveComponent.decelerated
                    if (moveComponent.speed < 0f) {
                        moveComponent.speed = 0f
                    }
                } else {
                    moveComponent.speed += moveComponent.accelerated
                    if (moveComponent.speed > moveComponent.maxSpeed) {
                        moveComponent.speed = moveComponent.maxSpeed
                    }
                }
                // 旋转更新
                val targetAngle = Math.toDegrees(atan2(direction.y.toDouble(), direction.x.toDouble())).toFloat()
                var angleDiff = targetAngle - moveComponent.rotation
                if (angleDiff > 180f) {
                    angleDiff -= 360f
                }
                if (angleDiff < -180f) {
                    angleDiff += 360f
                }
                if (angleDiff > moveComponent.rotateSpeed * delta) {
                    moveComponent.rotation += moveComponent.rotateSpeed * delta
                } else if (angleDiff < -moveComponent.rotateSpeed * delta) {
                    moveComponent.rotation -= moveComponent.rotateSpeed * delta
                } else {
                    moveComponent.rotation = targetAngle
                }
                // 位置更新
                val radian = Math.toRadians(moveComponent.rotation.toDouble())
                val moveX = cos(radian).toFloat() * moveComponent.speed * delta
                val moveY = sin(radian).toFloat() * moveComponent.speed * delta
                moveComponent.position.add(moveX, moveY)
            }
        }
    }
}
