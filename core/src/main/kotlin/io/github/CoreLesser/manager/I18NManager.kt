package io.github.CoreLesser.manager

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.Disposable
import com.badlogic.gdx.utils.I18NBundle
import io.github.CoreLesser.enumclass.Language
import java.io.StringReader
import java.util.Locale
import java.util.PropertyResourceBundle
import java.util.ResourceBundle

// 国际化管理器
object I18NManager : Disposable {
    // 当前国际化
    private lateinit var bundle : I18NBundle
    // 初始化语言管理器
    init {
        setLanguage(Language.SIMPLE_CHINESE)
    }
    // 设置当前语言
    fun setLanguage(language: Language) {
        try {
            bundle = I18NBundle.createBundle(
                Gdx.files.internal("bundle/i18n"),
                language.locale
            )
        } catch (_ : Exception) {
            Gdx.app.error("国际化管理器","无法识别的语言${language},将启动默认语言")
            bundle = I18NBundle.createBundle(
                Gdx.files.internal("bundle/i18n"),
                Language.SIMPLE_CHINESE.locale
            )
        }
    }
    // 设置当前语言（通过code设置）
    fun setLanguageByCode(code : String) {
        val language = Language.formCode(code)
        setLanguage(language)
    }
    // 获取本地化文本
    fun getString(key : String) : String {
        return try {
            bundle.get(key)
        } catch (_ : Exception) {
            Gdx.app.error("国际化管理器","找不到对应的本地化标记：${key}")
            "!$key!"
        }
    }
    // 资源释放（如果有的话需要写）
    override fun dispose() {}
}
