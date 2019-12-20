@file:Suppress("unused")

package com.computerrock.qlog

fun <T> dLog(vararg message: T) {
    if (message.size == 1) {
        QLog.dLog("T", message[0].toString())
    } else {
        QLog.dLogList("T", message.map { it.toString() })
    }
}

fun <T> dLog(message: List<T>) {
    if (message.size == 1) {
        QLog.dLog("T", message[0].toString())
    } else {
        QLog.dLogList("T", message.map { it.toString() })
    }
}

fun dStackTrace() {
    QLog.dLogStackTrace()
}

fun eLog(message: String) = QLog.eLog("T", message)

fun eLog(vararg message: String) {
    for (m in message) QLog.eLog("T", m)
}