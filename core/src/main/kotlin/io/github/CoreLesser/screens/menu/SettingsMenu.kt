package io.github.CoreLesser.screens.menu

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import io.github.CoreLesser.manager.I18NManager
import io.github.CoreLesser.ui.GameTextButton
import io.github.CoreLesser.ui.GameWindow
import ktx.app.KtxGame
import ktx.app.KtxScreen

class SettingsMenu(
    private val game : KtxGame<KtxScreen>
) : GameWindow("",24) {
    // 定义按钮
    private val buttons = listOf(
        GameTextButton("返回",24).apply {
            addListener(object : ClickListener() {
                override fun clicked(event: InputEvent?, x: Float, y: Float) {
                    this@SettingsMenu.isVisible = false
                }
            })
        },
        GameTextButton("语言",24),
    )
    // 定义按钮文本
    private val buttonsText = listOf(
        "返回",
        "语言"
    )
    // 初始化设置菜单
    init {
        isModal = true
        isVisible = false
        isMovable = false
        //color = Color(0f,0f,0f,0.4f)
        setSize(200f,100f)
        centerWindow()
        for (i in buttons.indices) {
            add(buttons[i]).width(200f).height(40f).row()
        }
    }
    // 更新文本
    fun updateText() {
        for (i in buttonsText.indices) {
            buttons[i].setText(I18NManager.getString(buttonsText[i]))
        }
    }
}
