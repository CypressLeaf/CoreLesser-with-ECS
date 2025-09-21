package io.github.CoreLesser.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.joints.MouseJoint
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.kotcrab.vis.ui.widget.VisTable
import io.github.CoreLesser.manager.I18NManager
import io.github.CoreLesser.screens.settings.SettingsMenuScreen
import io.github.CoreLesser.ui.GameTextButton
import ktx.app.KtxGame
import ktx.app.KtxScreen

// 主菜单
class MainMenuScreen(
    private val game: KtxGame<KtxScreen>
) : KtxScreen {
    // 定义舞台和视口类型
    private val stage : Stage = Stage(ExtendViewport(1280f,720f))
    // 定义按钮列表
    private val buttonsTable : VisTable = VisTable().apply {
        setFillParent(true)
        left()
        padLeft(40f)
    }
    // 定义按钮
    private val buttons = listOf(
        GameTextButton("战役",24),
        GameTextButton("联机",24),
        GameTextButton("教程",24),
        GameTextButton("设置",24).apply {
            addListener(object : ClickListener() {
                override fun clicked(event: InputEvent?, x: Float, y: Float) {
                    game.addScreen(SettingsMenuScreen(game))
                    game.setScreen<SettingsMenuScreen>()
                }
            })
        },
        GameTextButton("退出",24).apply {
            addListener(object : ClickListener() {
                override fun clicked(event: InputEvent?, x: Float, y: Float) {
                    Gdx.app.exit()
                }
            })
        },
    )
    // 定义按钮文本
    private val buttonsText = listOf(
        "战役",
        "联机",
        "教程",
        "设置",
        "退出"
    )
    // 初始化主菜单
    init {
        createMainMenu()
    }
    // 主菜单构建函数
    private fun createMainMenu() {
        stage.addActor(buttonsTable)
        buttonsTable.apply {
            for (i in buttons.indices) {
                add(buttons[i]).width(200f).height(40f).pad(10f).row()
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
