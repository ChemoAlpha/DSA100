package com.example.dsa100

import android.content.Context
import android.text.Html
import android.util.AttributeSet
import android.widget.TextView
import androidx.core.content.ContextCompat
class CodeTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr)


{
     lateinit var textv:TextView
    fun setCodeText(code: String) {

        // Apply basic syntax highlighting using HTML tags
        val highlightedCode = highlightSyntax("if")
        text = Html.fromHtml(highlightedCode, Html.FROM_HTML_MODE_LEGACY)
    }

    private fun highlightSyntax(code: String): String {
        // Define keywords and their corresponding colors
        val keywords = listOf("int", "String", "if", "else", "for", "while")
        val keywordColor = ContextCompat.getColor(context, R.color.keywordColor)

        // Define symbols and their corresponding colors
        val symbols = listOf("{", "}", "(", ")", ";")
        val symbolColor = ContextCompat.getColor(context, R.color.symbolColor)

        // Define comments and their corresponding colors
        val commentColor = ContextCompat.getColor(context, R.color.commentColor)

        // Replace keywords with HTML-formatted text
        var highlightedCode = code
        for (keyword in keywords) {
            highlightedCode = highlightedCode.replace(
                keyword,
                "<font color='$keywordColor'>$keyword</font>"
            )
        }

        // Replace symbols with HTML-formatted text
        for (symbol in symbols) {
            highlightedCode = highlightedCode.replace(
                symbol,
                "<font color='$symbolColor'>$symbol</font>"
            )
        }

        // Highlight single-line comments (//) with commentColor
        highlightedCode = highlightedCode.replace(
            Regex("//[^\n]*"),
            "<font color='$commentColor'>$0</font>"
        )

        // Highlight multi-line comments (/* ... */) with commentColor
        highlightedCode = highlightedCode.replace(
            Regex("/\\*.*?\\*/", RegexOption.DOT_MATCHES_ALL),
            "<font color='$commentColor'>$0</font>"
        )

        // You can add more syntax highlighting rules for strings, numbers, etc.

        return highlightedCode
    }
}