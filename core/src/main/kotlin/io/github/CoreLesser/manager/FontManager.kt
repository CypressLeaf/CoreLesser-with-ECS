package io.github.CoreLesser.manager

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.utils.Disposable

// 字符管理器
object FontManager : Disposable {
    // 加载所有字符
    fun loadAllFonts(textSize: Int) : BitmapFont {
        return loadChinese(textSize)
    }
    // 加载中文字符
    private fun loadChinese(textSize : Int) : BitmapFont {
        val generator = FreeTypeFontGenerator(Gdx.files.internal("fonts/SourceHanSansCN-Light.otf"))
        val parameter = FreeTypeFontParameter().apply {
            size = textSize
            mono = false
            incremental = true
        }
        return generator.generateFont(parameter)
    }
    // 资源释放（如果有的话需要写）
    override fun dispose() {}
}
