package io.github.CoreLesser.ecs.entity

import com.badlogic.gdx.utils.Disposable
import io.github.CoreLesser.ecs.componet.Component

// 抽象实体基类
abstract class Entity : Disposable {
    // 实体ID
    val id : String = "${System.currentTimeMillis()}"
    // 组件Map存储所有组件
    val components = mutableMapOf<String, Component>()
    // 添加组件
    fun addComponent(component : Component) : Entity {
        components["${component::class}"] = component
        return this
    }
    // 查找组件
    inline fun <reified T : Component> findComponent() : T? {
        return components["${T::class}"] as T?
    }
    // 删除组件
    fun removeComponent(component : Component) : Entity {
        components.remove("${component::class}")
        return this
    }
    // 释放
    override fun dispose() {
        components.values.forEach { it.dispose() }
    }
}
