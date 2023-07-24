package CodingNinjaPOTD;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class FindAllNodeKDistanceTree_Hard2307 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        markParent(root , map , queue , target);
        List<Integer> list = new ArrayList<>();

        if(queue.isEmpty()) return list;
        Map<TreeNode , Boolean> isVisited = new HashMap<>();
        isVisited.put(target , true);

        while(! queue.isEmpty() && k>0)
        {
            int size = queue.size();
            if(k == 0) break;
            for(int i=0;i<size;i++)
            {
                TreeNode curr = queue.poll();

            if(curr.left != null && isVisited.get(curr.left) == null)
            {
                queue.offer(curr.left);
                isVisited.put(curr.left , true);
            }

            if(curr.right != null && isVisited.get(curr.right) == null)
            {
                queue.offer(curr.right);
                isVisited.put(curr.right , true);
            }

            if(map.get(curr) != null && isVisited.get(map.get(curr)) == null)
            {
                queue.offer(map.get(curr));
                isVisited.put(map.get(curr) , true);
            }
            }

            k--;
        }

        while(!queue.isEmpty())
        {
            list.add(queue.poll().val);
        }

        return list;
    }

    void markParent(TreeNode node, Map<TreeNode,TreeNode> map , Queue<TreeNode> targetNode ,  TreeNode target)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(! queue.isEmpty())
        {
            TreeNode curr = queue.poll();
            
            if(curr.val == target.val) targetNode.offer(curr);

            if(curr.left != null)
            {
                map.put(curr.left , curr);
                queue.offer(curr.left);
            }

            if(curr.right != null)
            {
                map.put(curr.right , curr);
                queue.offer(curr.right);
            }
        }
    }
}