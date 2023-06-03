package udemyDSA.greedyAlgorithms;

;

public class fractionalKnapSack {
    private int index;
    private int value;
    private int weight;
    private double ratio;

    public fractionalKnapSack(int index, int value, int weight) {
        this.index = index;
        this.value = value;
        this.weight = weight;
        this.ratio = value * 1.0 / weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "index=" + index + ", value=" + value + ", weight=" + weight + ", ratio=" + ratio;
    }

}
