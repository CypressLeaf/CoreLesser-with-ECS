package io.github.CoreLesser.ecs.componet

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import io.github.CoreLesser.enumclass.EntitySpriteType

// 渲染组件
class RenderComponent(
    val name : String,
    val type: EntitySpriteType,
) : Component {
    // 属性
    val texture : Texture = Texture(Gdx.app.files.internal("Entity/${type}/${name}/${name}.png"))
    val sprite : Sprite = Sprite(texture)
    override fun dispose() {
        texture.dispose()
    }
}
