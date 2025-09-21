package io.github.CoreLesser.manager

import io.github.CoreLesser.ecs.process.Process

// 进程管理器
class ProcessManager {
    // 进程列表
    private val processes = mutableListOf<Process>()
    // 添加进程
    fun addProcess(process : Process) {
        processes.add(process)
    }
    // 删除进程
    fun removeProcess(process : Process) {
        processes.remove(process)
    }
    // 进程更新
    fun update(delta : Float) {
        processes.forEach { it.update(delta) }
    }
    // 进程渲染
    fun render(delta : Float) {
        processes.forEach { it.render(delta) }
    }
}
