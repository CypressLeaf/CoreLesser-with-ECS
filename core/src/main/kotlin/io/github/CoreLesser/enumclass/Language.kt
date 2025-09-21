package io.github.CoreLesser.enumclass

import java.util.Locale

enum class Language(
    val code : String,
    val locale : Locale
) {
    SIMPLE_CHINESE("zh_CN", Locale.SIMPLIFIED_CHINESE),
    ENGLISH("en_UK", Locale.UK);
    /***
     * 根据语言内容设置对应的Language枚举
     * code：语言代码（如zh_CN）
     */
    companion object {
        fun formCode(code : String) : Language {
            return values().firstOrNull { it.code == code } ?: Language.SIMPLE_CHINESE
        }
    }
}
