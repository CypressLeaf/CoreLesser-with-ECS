package io.github.CoreLesser.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.kotcrab.vis.ui.widget.VisTable
import io.github.CoreLesser.ui.GameTextButton
import ktx.app.KtxGame
import ktx.app.KtxScreen

// 主菜单
class MainMenuScreen(
    private val game: KtxGame<KtxScreen>
) : KtxScreen {
    // 定义舞台和视口类型
    private val stage : Stage = Stage(ExtendViewport(1280f,720f))
    // 定义根列表用于存储内容
    private val rootTable : VisTable = VisTable().apply {
        setFillParent(true)
        left()
        padLeft(80f)
    }
    // 定义按钮列表用于存储按钮
    private val buttonsTable : VisTable = VisTable().apply {}
    // 定义主菜单按钮
    private val buttons = listOf(
        GameTextButton("战役",24)
    )
    // 初始化主菜单
    init {
        createMainMenu()
    }
    // 主菜单构建函数
    private fun createMainMenu() {
        stage.addActor(rootTable)
        rootTable.add(buttonsTable)
        buttonsTable.apply {
            for (i in buttons.indices) {
                add(buttons[i]).width(200f).height(40f).row()
            }
        }
    }
    // 展示
    override fun show() {
        Gdx.input.inputProcessor = stage
    }
    // 渲染
    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0.5f,0.5f,0.5f,1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stage.act(delta)
        stage.draw()
    }
    // 窗口更新
    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width,height,true)
    }
    // 资源释放
    override fun dispose() {
        stage.dispose()
    }
}
