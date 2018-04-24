package graphs;

public class Edge implements Comparable<Edge>  {
	public int first;
	public int second;
	public int weight;
	
	public Edge(int first, int second, int weight) {
		this.first = first;
		this.second = second;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return weight - o.weight;
	}
}
