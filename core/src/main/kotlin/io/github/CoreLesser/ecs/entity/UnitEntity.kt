package io.github.CoreLesser.ecs.entity

import com.badlogic.gdx.math.Vector2
import io.github.CoreLesser.ecs.componet.MoveComponent
import io.github.CoreLesser.ecs.componet.RenderComponent
import io.github.CoreLesser.enumclass.EntitySpriteType

class UnitEntity(
    name : String,
    position : Vector2,
    rotation : Float
) : Entity() {
    init {
        addComponent(MoveComponent(true,position,rotation,100f,60f,10f,8f))
        addComponent(RenderComponent(name, EntitySpriteType.Unit))
    }
    fun setTarget(newTarget : Vector2) {
        findComponent<MoveComponent>()?.target = newTarget
    }
}
