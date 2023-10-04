package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/clone-graph/description/

class GraphCloneNode {
	public int val;
	public List<GraphCloneNode> neighbors;
	public GraphCloneNode() {
		val = 0;
		neighbors = new ArrayList<GraphCloneNode>();
	}
	public GraphCloneNode(int _val) {
		val = _val;
		neighbors = new ArrayList<GraphCloneNode>();
	}
	public GraphCloneNode(int _val, ArrayList<GraphCloneNode> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class CloneGraph {
	public GraphCloneNode cloneGraph(GraphCloneNode GraphCloneNode) {
		if(GraphCloneNode == null) return null;


		Queue<GraphCloneNode> queue = new LinkedList<>();
		Map<GraphCloneNode,GraphCloneNode> map = new HashMap<>();

		queue.add(GraphCloneNode);
		map.put(GraphCloneNode , new GraphCloneNode(GraphCloneNode.val));

		while(! queue.isEmpty())
		{
			GraphCloneNode curr = queue.poll();

			for( GraphCloneNode currGraphCloneNode : curr.neighbors)
			{
				if(!map.containsKey(currGraphCloneNode))
				{
					map.put(currGraphCloneNode , new GraphCloneNode(currGraphCloneNode.val));
					queue.offer(currGraphCloneNode);
				}

				map.get(curr).neighbors.add(map.get(currGraphCloneNode));
			}
		}

		return map.get(GraphCloneNode);
	}
}