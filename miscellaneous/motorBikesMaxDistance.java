package miscellaneous;

/*
 * Given n motorBikes with each can travel upto 100km with its full tank 
 * each bike has its own rider and petrol siphoning pump 
 * ** find the max distance one can reach with bike
 */
class motorBikesPuzzle {
    public static void main(String[] args) {
        float max_distance_each_bike = 100.0f; // need float
        int num_bikes = 4;
        System.out.println(max_distance(num_bikes, max_distance_each_bike));
    }

    private static float max_distance(int num_bikes, float max_distance_each_bike) {
        if (num_bikes == 1) {
            return 100.00f;
        }
        return (max_distance_each_bike / num_bikes) + max_distance(num_bikes - 1, max_distance_each_bike);
    }
}
