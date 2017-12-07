/**
 * 
 */
package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        return countPathSum(root,sum,hm,0,0);
    }
    
    public int countPathSum(TreeNode root, int sum, HashMap<Integer,Integer> hm,int pathCount,int currentSum){
        if(root == null) return pathCount;
        currentSum += root.val;
        if(!hm.containsKey(currentSum)){
            hm.put(currentSum,0);
        }
        hm.put(currentSum,hm.get(currentSum)+1);
        int begin = currentSum - sum;
        if(hm.containsKey(begin)){
            pathCount += hm.get(begin);
        }
        if(root.val==sum){
            pathCount++;
        }
        pathCount = pathCount + countPathSum(root.left,sum,hm,pathCount,currentSum);
        pathCount = pathCount + countPathSum(root.right,sum,hm,pathCount,currentSum);
        return pathCount;
        
    }
}