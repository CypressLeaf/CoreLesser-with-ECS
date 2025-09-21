package io.github.CoreLesser.screens.settings

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputEventQueue
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.kotcrab.vis.ui.widget.VisTable
import io.github.CoreLesser.manager.I18NManager
import io.github.CoreLesser.screens.MainMenuScreen
import io.github.CoreLesser.ui.GameTextButton
import ktx.app.KtxGame
import ktx.app.KtxScreen

// 设置菜单
class SettingsMenuScreen(
    private val game: KtxGame<KtxScreen>
) : KtxScreen {
    // 定义舞台和视口类型
    private val stage = Stage(ExtendViewport(1280f,720f))
    // 定义按钮列表
    private val buttonsTable = VisTable().apply {
        setFillParent(true)
        center()
    }
    // 定义按钮
    private val buttons = listOf(
        GameTextButton("返回",24).apply {
            addListener(object : ClickListener() {
                override fun clicked(event: InputEvent?, x: Float, y: Float) {
                    game.addScreen(MainMenuScreen(game))
                    game.setScreen<MainMenuScreen>()
                }
            })
        },
        GameTextButton("语言",24)
    )
    // 定义语言文本
    private val buttonsText = listOf(
        "返回",
        "语言"
    )
    // 初始化设置菜单
    init {
        createSettingsMenu()
    }
    // 设置菜单构建函数
    private fun createSettingsMenu() {
        stage.addActor(buttonsTable)
        buttonsTable.apply {
            for (i in buttons.indices) {
                add(buttons[i]).width(200f).height(40f).row()
            }
        }
    }
    // 更新文本
    private fun updateText() {
        for (i in buttonsText.indices) {
            buttons[i].setText(I18NManager.getString(buttonsText[i]))
        }
    }
    // 展示
    override fun show() {
        Gdx.input.inputProcessor = stage
        updateText()
    }
    // 渲染
    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0.5f,0.5f,0.5f,1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stage.act(delta)
        stage.draw()
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.addScreen(MainMenuScreen(game))
            game.setScreen<MainMenuScreen>()
        }
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
