using System;
using System.Collections.Generic;
using System.Linq;

namespace Solving
{
    class Program
    {
        private static List<int>[] graph;
        private static List<int>[] reversedGraph;
        private static Stack<int> stack = new Stack<int>();
        private static bool[] visited;

        private static List<List<int>> stronglyConnectedComponents;
        static void Main(string[] args)
        {
            var graph = new List<int>[]
            {
                new List<int>() {1, 11, 13}, // children of node 0
                new List<int>() {6},         // children of node 1
                new List<int>() {0},         // children of node 2
                new List<int>() {4},         // children of node 3
                new List<int>() {3, 6},      // children of node 4
                new List<int>() {13},        // children of node 5
                new List<int>() {0, 11},     // children of node 6
                new List<int>() {12},        // children of node 7
                new List<int>() {6, 11},     // children of node 8
                new List<int>() {0},         // children of node 9
                new List<int>() {4, 6, 10},  // children of node 10
                new List<int>() {},          // children of node 11
                new List<int>() {7},         // children of node 12
                new List<int>() {2, 9},      // children of node 13
            };

            var result = FindStronglyConnectedComponents(graph);

            Console.WriteLine("Strongly Connected Components:");
            foreach (var component in result)
            {
                Console.WriteLine("{{{0}}}", string.Join(", ", component));
            }
        }

        private static List<List<int>> FindStronglyConnectedComponents(List<int>[] targetGraph)
        {
            graph = targetGraph;

            visited = new bool[graph.Length];

            BuildReversedGraph();

            for (int node = 0; node < graph.Length; node++)
            {
                if (!visited[node]) {
                    Dfs(node);
                }
            }

            stronglyConnectedComponents = new List<List<int>>();
            visited = new bool[graph.Length];
            while (stack.Count > 0)
            {
                var node = stack.Pop();

                if (!visited[node]) {
                    stronglyConnectedComponents.Add(new List<int>());
                    ReversedDfs(node);
                }
            }

            return stronglyConnectedComponents;
        }

        private static void BuildReversedGraph() {
            reversedGraph = new List<int>[graph.Length];

            for (int node = 0; node < reversedGraph.Length; node++)
            {
                reversedGraph[node] = new List<int>();
            }

            for (int node = 0; node < graph.Length; node++)
            {
                foreach (var child in graph[node])
                {
                    reversedGraph[child].Add(node);
                }
            }
        }

        private static void ReversedDfs(int node) {
            if (!visited[node]) {
                visited[node] = true;
                stronglyConnectedComponents.Last().Add(node);
                foreach (var child in reversedGraph[node])
                {
                    ReversedDfs(child);
                }
            }
        }

        private static void Dfs(int node) {
            if (!visited[node]) {
                visited[node] = true;

                foreach(var child in graph[node]) {
                    Dfs(child);
                }

                stack.Push(node);
            }
        }
    }
}
