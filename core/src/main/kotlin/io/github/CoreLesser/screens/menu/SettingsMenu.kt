package io.github.CoreLesser.screens.menu

import com.kotcrab.vis.ui.widget.VisTable
import io.github.CoreLesser.ui.GameTextButton
import ktx.app.KtxGame
import ktx.app.KtxScreen

// 设置菜单
class SettingsMenu(
    private val game: KtxGame<KtxScreen>
) : VisTable() {
    // 定义设置菜单按钮
    private val buttons = listOf(
        GameTextButton("语言",24)
    )
    init {
        isVisible = false
        setFillParent(true)
        for (i in buttons.indices) {
            add(buttons[i]).width(200f).height(40f).row()
        }
    }
}
