package io.github.CoreLesser.ui

import com.kotcrab.vis.ui.widget.VisWindow
import io.github.CoreLesser.manager.FontManager

open class GameWindow(
    private val title : String,
    private val titleSize : Int
) : VisWindow(title) {
    init {
        this.titleLabel.style.font = FontManager.loadAllFonts(titleSize)
        this.title
        this.titleSize
    }
}
