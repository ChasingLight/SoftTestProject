package classicalAlgorithm.TreeAlgorithm;


import java.util.ArrayList;
import java.util.List;

/**
 * 1.给定一颗二叉树的根节点，遍历输出每一层的值，以二维数组的形式
 * 示例：
 *      3
 *    4    5
 *      6    7
 * 输出[[3],[4,5],[6,7]]
 */
public class TwoDimsionArrayShowTree {

    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node4 = new TreeNode(4,null,node6);
        TreeNode node5 = new TreeNode(5,null,node7);
        TreeNode root = new TreeNode(3,node4,node5);


        List<List<Integer>> finalResult = new ArrayList<>();

        List<TreeNode> currLevel = new ArrayList<>();
        currLevel.add(root);
        while(currLevel.size() != 0){
            List<Integer> currLevleResult = new ArrayList<>();
            for (TreeNode temp : currLevel){
                currLevleResult.add(temp.getValue());
            }
            finalResult.add(currLevleResult);

            currLevel = getNextLevelTreeNode(currLevel);
        }

        //将finalResult转换为二维数组就行
        System.out.println(finalResult);
    }

    private static List<TreeNode> getNextLevelTreeNode(List<TreeNode> currLevel){
        List<TreeNode> nextLevel = new ArrayList<>();
        for (TreeNode temp : currLevel) {
            if (null != temp.getLeft()){
                nextLevel.add(temp.getLeft());
            }
            if (null != temp.getRight()){
                nextLevel.add(temp.getRight());
            }
        }
        return nextLevel;
    }


}
