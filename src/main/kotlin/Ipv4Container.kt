import java.util.*

// container that can contain all possible variants of ipv4 addresses
class Ipv4Container {
    private val positiveSet = BitSet(Int.MAX_VALUE)
    private val negativeSet = BitSet(Int.MAX_VALUE)

    fun add(ipv4: Int) {
        if (ipv4 >= 0) {
            positiveSet.set(ipv4)
        } else {
            negativeSet.set(ipv4.inv())
        }
    }

    // returns all set bits that represents num of unique ipv4 addresses
    fun countUnique(): Int {
        return positiveSet.cardinality() + negativeSet.cardinality()
    }
}