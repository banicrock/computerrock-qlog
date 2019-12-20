package com.computerrock.qlog

import android.util.Log
import java.lang.StringBuilder

class QLog {

    companion object {

        private const val UNNECESSARILY_STEPS_STACK_TRACE: Int = 5
        private const val FIXED_TAG = "T"

        fun dLog(tag: String, message: String) {
            val stringBuilder = StringBuilder().append(" " + createFixedRow(message.length) + "\n")
                .append(createMessageSpace() + message + createMessageSpace())
                .append(createFixedRow(message.length))
            Log.d(tag, stringBuilder.toString())
        }

        fun dLogStackTrace() {
            val separated = Log.getStackTraceString(Exception()).split("\n")
            val maxLength = findLongestElement(separated)
            val stringBuilder = StringBuilder().append(" " + createFixedRow(maxLength) + "\n")
            var index = separated.size - UNNECESSARILY_STEPS_STACK_TRACE
            for (m in 3 until separated.size - 1) {
                stringBuilder.append("\n" + (index--) + "." + createMessageSpace() + separated[m] + createMessageSpace())
            }
            stringBuilder.append(createFixedRow(maxLength))
            Log.d(FIXED_TAG, stringBuilder.toString())
        }

        fun dLogList(tag: String, messages: List<String>) {
            val maxLength = findLongestElement(messages)
            val stringBuilder = StringBuilder().append(" " + createFixedRow(maxLength))
            for (i in 0 until messages.size) {
                stringBuilder.append("\n" + (i) + "." + createMessageSpace() + messages[i] + createMessageSpace())
            }
            stringBuilder.append(createFixedRow(maxLength))
            Log.d(tag, stringBuilder.toString())
        }

        private fun findLongestElement(messages: List<String>): Int {
            var longestLength = Int.MIN_VALUE
            for (n in messages) {
                if (n.length > longestLength) {
                    longestLength = n.length
                }
            }
            return longestLength
        }

        fun eLog(tag: String, message: String) {
            val stringBuilder = StringBuilder().append(" " + createFixedRow(message.length) + "\n")
                .append(createMessageSpace() + message + createMessageSpace())
                .append(createFixedRow(message.length))
            Log.e(tag, stringBuilder.toString())
        }

        private fun createFixedRow(messageSize: Int): String {
            val stringBuilder = StringBuilder().append("\n+")
            for (i in 0..messageSize + 5) {
                stringBuilder.append("-")
            }
            stringBuilder.append("+")
            return stringBuilder.toString()
        }

        private fun createMessageSpace(): String {
            val stringBuilder = StringBuilder()
            stringBuilder.append("")
            for (i in 0..3) {
                stringBuilder.append(" ")
            }
            return stringBuilder.toString()
        }
    }

}

