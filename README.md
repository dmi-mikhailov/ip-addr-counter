# IPv4 unique addresses counter

Task description - https://github.com/Ecwid/new-job/blob/master/IP-Addr-Counter.md

## Task solution 

1. Convert ipv4 address to int to reduce memory usage required to store the address.
2. Save ipv4 address to container that consists of two BitSet. 
This container that can contain all possible variants of ipv4 addresses. 
That means that by count all set bits we will get the number of all unique ipv4 address.
3. Count all set bits.


## What else can be done

1. Create concurrent implementation of BitSet.
2. Process file asynchronously by chunks using coroutines.