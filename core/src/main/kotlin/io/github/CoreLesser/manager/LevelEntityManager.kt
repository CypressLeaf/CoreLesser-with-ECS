package io.github.CoreLesser.manager

import io.github.CoreLesser.ecs.entity.Entity

// 关卡实体管理器
class LevelEntityManager {
    // 定义实体存储Map
    private val entities = mutableMapOf<String, Entity>()
    // 添加实体
    fun addEntity(entity : Entity) {
        entities.put(entity.id,entity)
    }
    // 查找实体
    fun findEntity(entity : Entity) : Entity? {
        return entities[entity.id]
    }
    // 所有实体
    fun allEntity() : Collection<Entity> {
        return entities.values
    }
    // 删除实体
    fun removeEntity(entity : Entity) {
        entities.remove(entity.id,entity)
    }
    // 清除实体
    fun clearAllEntity() {
        entities.values.forEach { it.dispose() }
        entities.clear()
    }
}
