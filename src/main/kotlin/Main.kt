import java.io.File
import java.io.FileNotFoundException
import kotlin.system.measureTimeMillis

fun main() {
    // Replace "path/to/your/file.txt" with the actual file path
    val filePath = "path/to/your/file.txt"

    val timeInMillis = measureTimeMillis {
        val uniqueCount = countUniqueIpv4Addresses(filePath)
        println("Number of unique IP addresses: $uniqueCount")
    }
    println("Time in millis: $timeInMillis")
}

fun countUniqueIpv4Addresses(filePath: String): Int {
    try {
        File(filePath).useLines { return countUnique(it) }
    } catch (e: FileNotFoundException) {
        println("ERROR. No such file or directory: $filePath")
    }
    return 0
}

private fun countUnique(ipv4Addresses: Sequence<String>): Int {
    val container = Ipv4Container()
    ipv4Addresses.forEach { container.add(ipv4ToInt(it)) }
    return container.countUnique()
}

// converts ipv4 addresses to int
fun ipv4ToInt(ipAddress: String): Int {
    var result = 0
    var octet = 0
    ipAddress.forEach {
        if (it == '.') {
            result = result shl Byte.SIZE_BITS or octet
            octet = 0
        } else {
            octet = it.digitToInt()  + octet * 10
        }
    }
    return result shl Byte.SIZE_BITS or octet
}

