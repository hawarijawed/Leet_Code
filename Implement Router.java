/*
Design a data structure that can efficiently manage data packets in a network router. Each data packet consists of the following attributes:

source: A unique identifier for the machine that generated the packet.
destination: A unique identifier for the target machine.
timestamp: The time at which the packet arrived at the router.
Implement the Router class:

Router(int memoryLimit): Initializes the Router object with a fixed memory limit.

memoryLimit is the maximum number of packets the router can store at any given time.
If adding a new packet would exceed this limit, the oldest packet must be removed to free up space.
bool addPacket(int source, int destination, int timestamp): Adds a packet with the given attributes to the router.

A packet is considered a duplicate if another packet with the same source, destination, and timestamp already exists in the router.
Return true if the packet is successfully added (i.e., it is not a duplicate); otherwise return false.
int[] forwardPacket(): Forwards the next packet in FIFO (First In First Out) order.

Remove the packet from storage.
Return the packet as an array [source, destination, timestamp].
If there are no packets to forward, return an empty array.
int getCount(int destination, int startTime, int endTime):

Returns the number of packets currently stored in the router (i.e., not yet forwarded) that have the specified destination and have timestamps in the inclusive range [startTime, endTime].
Note that queries for addPacket will be made in increasing order of timestamp.
*/

class Router {
    private final int size;
    private final Map<Integer, List<Integer>> counts;
    private final Map<Long, int[]> packets;
    private final Queue<Long> queue;

    public Router(final int memoryLimit) {
        this.size = memoryLimit;
        this.packets = new HashMap<>();
        this.counts = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public boolean addPacket(final int source, final int destination, final int timestamp) {
        final long key = encode(source, destination, timestamp);

        if(packets.containsKey(key))
            return false;

        if(packets.size() >= size)
            forwardPacket();

        packets.put(key, new int[] { source, destination, timestamp });
        queue.offer(key);

        counts.putIfAbsent(destination, new ArrayList<>());
        counts.get(destination).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if(packets.isEmpty())
            return new int[] {};

        final long key = queue.poll();
        final int[] packet = packets.remove(key);

        if(packet == null)
            return new int[]{};

        final int destination = packet[1];
        final List<Integer> list = counts.get(destination);

        list.remove(0);

        return packet;
    }

    public int getCount(final int destination, final int startTime, final int endTime) {
        final List<Integer> list = counts.get(destination);
        if(list == null || list.isEmpty())
            return 0;

        final int left = lowerBound(list, startTime);
        final int right = upperBound(list, endTime);

        return right - left;
    }

    private long encode(final int source, final int destination, final int timestamp) {
        return ((long)source << 40) | ((long)destination << 20) | timestamp;
    }

    private int lowerBound(final List<Integer> list, final int target) {
        int low = 0, high = list.size();

        while(low < high) {
            final int mid = (low + high) >>> 1;
            if(list.get(mid) < target) low = mid + 1;
            else high = mid;
        }

        return low;
    }

    private int upperBound(final List<Integer> list, final int target) {
        int low = 0, high = list.size();

        while(low < high) {
            final int mid = (low + high) >>> 1;

            if(list.get(mid) <= target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}
