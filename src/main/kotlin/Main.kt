import org.w3c.dom.Text

fun main() {
    println(agoToText(86400))
}

fun agoToText(second: Int) {
    when {
        second in 0..60 -> println("только что")
        second in 61..59 * 60 -> {
            val minute = second / 60
            return wordMinutes(minute)
        }

        second == 60 * 60 -> println("был(а) 1 час назад")
        second in 60 * 60 + 1..24 * 60 * 60 -> {
            val hour = second / (60 * 60)
            return wordHour(hour)
        }

        second in 24 * 60 * 60 + 1..48 * 60 * 60 -> println("был(а) вчера")
        second in 48 * 60 * 60 + 1..52 * 60 * 60 -> println("был(а) позавчера")
        else -> println("был(а) давно")
    }
}

fun wordMinutes(minute: Int) {
    when {
        minute % 10 == 1 && minute != 11 -> println("был(а) $minute минуту назад")
        minute % 10 in 2..4 -> println("был(а) $minute минуты назад")
        else -> println("был(а) $minute минут назад") //11 входит
    }
}

fun wordHour(hour: Int) {
    when {
        hour == 1 || hour == 21 -> println("был(а) $hour час назад")
        hour in 2..4 || hour in 22..24 -> println("был(а) $hour часа назад")
        else -> println("был(а) $hour часов назад")
    }
}
