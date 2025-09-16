package io.github.CoreLesser.ui

import com.kotcrab.vis.ui.VisUI
import com.kotcrab.vis.ui.widget.VisTextButton
import io.github.CoreLesser.manager.FontManager

class GameTextButton(
    private val text : String,
    private val textSize : Int
) : VisTextButton(
    text,
) {
    init {
        val style = VisTextButtonStyle(VisUI.getSkin().get(VisTextButtonStyle::class.java))
        style.font = FontManager.loadAllFonts(textSize)
        this.style = style
        this.text
    }
}
