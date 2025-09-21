package io.github.CoreLesser.ecs.process

// 系统接口
interface Process {
    fun render(delta : Float) {}
    fun update(delta : Float) {}
}
