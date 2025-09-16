package io.github.CoreLesser

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Array
import com.kotcrab.vis.ui.VisUI
import io.github.CoreLesser.screens.MainMenuScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.app.clearScreen
import ktx.assets.disposeSafely
import ktx.assets.toInternalFile
import ktx.async.KtxAsync
import ktx.collections.GdxArray
import ktx.graphics.use

class CoreLesserLoader : KtxGame<KtxScreen>() {
    // 定义一个屏幕列表防止重复
    private val screenList = ArrayList<KtxScreen>()
    // 构建游戏
    override fun create() {
        KtxAsync.initiate()
        VisUI.load()
        addScreen(MainMenuScreen(this))
        setScreen<MainMenuScreen>()
    }
    // 重写addScreen方法
    override fun <Type : KtxScreen> addScreen(type: Class<Type>, screen: Type) {
        if (screenList.any { it::class == screen::class }) {
            Gdx.app.log("屏幕管理器","已经具有该类型屏幕：${screen::class}")
        } else {
            screenList.add(screen)
            super.addScreen(type, screen)
        }
    }
    // 重写removeScreen方法
    override fun <Type : KtxScreen> removeScreen(type: Class<Type>): Type? {
        if (screenList.any { it::class == type }) {
            for (i in screenList.indices) {
                if (screenList[i]::class == type) {
                    screenList.removeAt(i)
                }
            }
            return super.removeScreen(type)
        } else {
            Gdx.app.error("屏幕管理器","屏幕管理器找不到该类型屏幕：${type}，为了安全起见已自动退出")
            Gdx.app.exit()
            return null
        }
    }
}

/*class FirstScreen : KtxScreen {
    private val image = Texture("logo.png".toInternalFile(), true).apply { setFilter(Linear, Linear) }
    private val batch = SpriteBatch()

    override fun render(delta: Float) {
        clearScreen(red = 0.7f, green = 0.7f, blue = 0.7f)
        batch.use {
            it.draw(image, 100f, 160f)
        }
    }

    override fun dispose() {
        image.disposeSafely()
        batch.disposeSafely()
    }
}*/
