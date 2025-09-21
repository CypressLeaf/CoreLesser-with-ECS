package io.github.CoreLesser.ecs.process

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.CoreLesser.ecs.componet.MoveComponent
import io.github.CoreLesser.ecs.componet.RenderComponent
import io.github.CoreLesser.manager.LevelEntityManager

// 渲染进程
class RenderProcess(
    private val manager : LevelEntityManager,
    private val batch : SpriteBatch
) : Process {
    // 渲染
    override fun render(delta: Float) {
        batch.begin()
        manager.allEntity().forEach { entity ->
            val renderComponent = entity.findComponent<RenderComponent>()
            val moveComponent = entity.findComponent<MoveComponent>()
            if (renderComponent != null && moveComponent != null) {
                renderComponent.sprite.run {
                    setPosition(
                        moveComponent.position.x / 2,
                        moveComponent.position.y / 2
                    )
                    rotation = moveComponent.rotation - 90f
                    draw(batch)
                }
            }
        }
        batch.end()
    }
    // 更新
    override fun update(delta: Float) {}
}
