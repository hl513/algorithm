package com.xxx.tree06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author HeP
 * @date 2023/2/10 9:50
 */
@SuppressWarnings("all")
public class BinaryTreeDemo {

    static int diameter;
    static int[] path = new int[256];
    static BinaryTreeNode root;

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode l1 = new BinaryTreeNode(2);
        BinaryTreeNode r1 = new BinaryTreeNode(3);
        BinaryTreeNode ll1 = new BinaryTreeNode(4);
        BinaryTreeNode lr1 = new BinaryTreeNode(5);
        BinaryTreeNode rl1 = new BinaryTreeNode(6);
        BinaryTreeNode rl2 = new BinaryTreeNode(7);
        BinaryTreeNode ll3 = new BinaryTreeNode(8);
        root.setLeft(l1);
        root.setRight(r1);
        l1.setLeft(ll1);
        l1.setRight(lr1);
        r1.setLeft(rl1);
        r1.setRight(rl2);
        ll1.setLeft(ll3);

        // 递归调用 前序遍历
        preOrder(root);
        System.out.println();
        preOrderNonRecursive(root);

        // 中序遍历
        System.out.println();
        inOrder(root);
        // 非递归中序遍历
        System.out.println();
        inOrderRecuisive(root);


        // 后序遍历
        System.out.println();
        postOrder(root);
        System.out.println();
        postOrderNonRecursive(root);

        // 层序遍历
        System.out.println();
        levelOrder(root);

        // 求二叉树中的最大元素
        System.out.println();
        System.out.println("最大值：" + findMax(root));
        System.out.println("层序遍历查找最大元素：" + findMaxUsingLevelOrder(root));

        // 查询某个元素是否在二叉树中
        System.out.println(findInBinaryTreeUsingRecuision(root, 5));
        System.out.println(searchUsingLevelOrder(root, 3));

//        insertInBinaryTree(root, 5);

        levelOrder(root);
        System.out.println();

        System.out.println("二叉树中结点的个数：" + sizeOfBinaryTree(root));
        System.out.println("二叉树中结点的个数：" + sizeOfUsingLevelOrder(root));

        deleteBinaryTree(root);

        levelOrderTraversalInReverse(root);
        System.out.println();

        // 求树的深度
        System.out.println("树的深度：" + heightOfBinaryTree(root));
        System.out.println("树的深度：" + findHeightBinaryTree(root));

        // 查找二叉树中最深结点的算法
        BinaryTreeNode tree = deepestNodeinBinaryTree(root);
        System.out.println(tree.getData());

        // 求二叉树中叶子结点的个数
        System.out.println("二叉树中叶子结点的个数：" + numberOfLeavesInBtUsingLevelOrder(root));

        System.out.println("二叉树中满结点的个数：" + numberOfFullNodesInBtUsingLevelOrder(root));

//        System.out.println("二叉树中半结点的个数：" + numberOfHalfNodesInBtUsingLevelOrder(root));

        System.out.println("数据和最大的一层：" + findLevelWithMaxSum(root));

        // 输出所有从根结点到叶子结点的路径
        printPaths(root, path, 0);

        System.out.println("所有结点的数据之和：" + add(root));

        System.out.println("非递归的方法求所有结点的数据之和:" + sumOfBtUsingLevelOrder(root));

        // 转换为 镜像，然后层序遍历输出
        BinaryTreeNode root2 = mirrorOfBinaryTree(root);
        levelOrder(root2);

        System.out.println();
        System.out.println("判断两棵树是否为镜像:" + areMirrors(root, root2));

    }

    /**
     * 前序遍历  根左右  递归遍历
     *
     * @param root
     */
    public static void preOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * 非递归前序遍历
     * 需要采用一个栈来记录当前结点以便在完成左子树后能返回到右子树进行遍历。为了模拟相同的操作，
     * 首先处理当前结点，在遍历左子树之前，把当前结点保留到栈中，当遍历完左子树后，将该元素出栈，
     * 然后找到其右子树进行遍历。持续该过程直到栈为空
     *
     * @param root
     */
    public static void preOrderNonRecursive(BinaryTreeNode root) {
        if (root == null) return;
        // 用栈进行辅助
        Stack stack = new Stack();
        while (true) {
            while (root != null) {
                System.out.print(root.getData() + " ");
                // 将根阶段入栈
                stack.push(root);
                // 将根结点更新为 左子树
                root = root.getLeft();
            }
            if (stack.isEmpty()) break;
            root = (BinaryTreeNode) stack.pop();
            root = root.getRight();
        }
        return;
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void inOrder(BinaryTreeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrder(root.getRight());
        }
    }

    /**
     * 非递归中序遍历
     *
     * @param root
     */
    public static void inOrderRecuisive(BinaryTreeNode root) {
        if (root == null) return;
        Stack stack = new Stack();
        while (true) {
            // 先将左子树全部入栈
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) break;
            root = (BinaryTreeNode) stack.pop();
            System.out.print(root.getData() + " ");
            root = root.getRight();
        }
        return;
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public static void postOrder(BinaryTreeNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    /**
     * 非递归后序遍历
     *
     * @param node
     */
    public static void postOrderNonRecursive(BinaryTreeNode node) {
        if (node == null)
            return;
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();

        BinaryTreeNode curNode; //当前访问的结点
        BinaryTreeNode lastVisitNode; //上次访问的结点
        curNode = node;
        lastVisitNode = null;

        //把currentNode移到左子树的最下边
        while (curNode != null) {
            s.push(curNode);
            curNode = curNode.getLeft();
        }
        while (!s.empty()) {
            curNode = s.pop();  //弹出栈顶元素
            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if (curNode.getRight() != null && curNode.getRight() != lastVisitNode) {
                //根节点再次入栈
                s.push(curNode);
                //进入右子树，且可肯定右子树一定不为空
                curNode = curNode.getRight();
                while (curNode != null) {
                    //再走到右子树的最左边
                    s.push(curNode);
                    curNode = curNode.getLeft();
                }
            } else {
                //访问
                System.out.print(curNode.getData() + " ");
                //修改最近被访问的节点
                lastVisitNode = curNode;
            }
        } //while
    }

    /**
     * 层序遍历
     * 1、访问根结点
     * 2、在访问第l层时，将l+1层的结点按顺序保存在队列中
     * 3、进入下一层并访问该层的所有结点
     * 4、重复上述操作直至所有层都访问完
     *
     * @param root
     */
    public static void levelOrder(BinaryTreeNode root) {
        BinaryTreeNode tmp;
        Queue queue = new LinkedList();
        if (root == null) return;
        queue.add(root);
        while (!queue.isEmpty()) {
            tmp = (BinaryTreeNode) queue.poll();
            // 处理当前结点
            System.out.print(tmp.getData() + " ");
            if (tmp.getLeft() != null) queue.add(tmp.getLeft());
            if (tmp.getRight() != null) queue.add(tmp.getRight());
        }
    }

    /**
     * 找出二叉树中最大元素的算法 (使用递归)
     * 利用递归思想，分别找到左子树中的最大元素和右子树的最大元素，然后他们与根结点的值进行比较，
     * 这三个值中最大的就是问题的解
     *
     * @param root
     * @return
     */
    public static int findMax(BinaryTreeNode root) {
        int root_val, left, right, max = Integer.MIN_VALUE;
        if (root != null) {
            root_val = root.getData();
            left = findMax(root.getLeft());
            right = findMax(root.getRight());
            // 在3个值中找出最大值
            if (left > right) max = left;
            else max = right;
            if (root_val > max) max = root_val;
        }
        return max;
    }

    /**
     * 用非递归的方法实现查找二叉树中的最大元素
     * 利用层序遍历方法，在删除结点时观察其数据值是否是最大的
     *
     * @param root
     * @return
     */
    public static int findMaxUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode tmp;
        int max = Integer.MIN_VALUE;
        Queue queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            tmp = (BinaryTreeNode) queue.poll();
            // 所有值中的最大值
            if (max < tmp.getData()) max = tmp.getData();
            if (tmp.getLeft() != null) queue.add(tmp.getLeft());
            if (tmp.getRight() != null) queue.add(tmp.getRight());
        }
        return max;
    }

    /**
     * 在给出二叉树中搜索某个元素
     * 对于给定的二叉树，如果发现树中某结点的数据值与之相同，则返回true.
     * 递归地从树的根结点向下，比较左子树与右子树中各个结点的值来实现算法
     *
     * @param root
     * @param data
     * @return
     */
    public static boolean findInBinaryTreeUsingRecuision(BinaryTreeNode root, int data) {
        boolean temp;
        // 基本情况，空树
        if (root == null) return false;
        else {
            // 判断是否等于根节点的值
            if (data == root.getData()) {
                return true;
            } else {
                // 否则从左子树开始递归判断
                temp = findInBinaryTreeUsingRecuision(root.getLeft(), data);
                // 如果在左子树中找到了，则直接返回即可，否则 从右子树中继续查找
                if (temp) return temp;
                else return (findInBinaryTreeUsingRecuision(root.getRight(), data));
            }
        }
    }

    /**
     * 利用非递归算法来搜索二叉树中的某个元素
     * 可以利用层序遍历算法来解决这个问题。唯一的不同是在本算法中不是输出数据
     * 而是判断根结点的数据是否等于需要搜索元素的值
     *
     * @param root
     * @param data
     * @return
     */
    public static boolean searchUsingLevelOrder(BinaryTreeNode root, int data) {
        BinaryTreeNode tmp;
        Queue queue = new LinkedList();
        if (root == null) return false;
        queue.add(root);
        while (!queue.isEmpty()) {
            tmp = (BinaryTreeNode) queue.poll();
            // 判断是否等于当前根结点的值
            if (data == root.getData()) return true;
            if (tmp.getLeft() != null) queue.add(tmp.getLeft());
            if (tmp.getRight() != null) queue.add(tmp.getRight());
        }
        return false;
    }

    /**
     * 实现将一个元素插入二叉树
     * 给定的是二叉树，所以能在任意地方插入元素。为了插入一个元素，可以使用层序遍历方法找到一个左孩子或右孩子
     * 结点为空的结点，然后插入该元素
     *
     * @param root
     * @param data
     */
    public static void insertInBinaryTree(BinaryTreeNode root, int data) {
        Queue queue = new LinkedList();
        BinaryTreeNode temp;
        BinaryTreeNode newNode = new BinaryTreeNode();
        newNode.setLeft(null);
        newNode.setRight(null);
        if (newNode == null) {
            System.out.println("Memory Error");
            return;
        }
        if (root == null) {
            root = newNode;
            return;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            temp = (BinaryTreeNode) queue.poll();
            if (temp.getLeft() != null) queue.add(temp.getLeft());
            else {
                temp.setLeft(newNode);
//                queue.remove();
                return;
            }
            if (temp.getRight() != null) queue.add(temp.getRight());
            else {
                temp.setRight(newNode);
//                queue.remove();
                return;
            }
        }
//        queue.remove();
    }


    /**
     * 获取二叉树结点个数
     * 递归计算左子树和右子树的大小，再加1（当前结点），然后返回给其双亲结点
     *
     * @param root
     * @return
     */
    public static int sizeOfBinaryTree(BinaryTreeNode root) {
        if (root == null) return 0;
        else return (sizeOfBinaryTree(root.getLeft()) + 1 + sizeOfBinaryTree(root.getRight()));
    }


    /**
     * 利用非递归的方法 获取二叉树结点个数
     *
     * @param root
     * @return
     */
    public static int sizeOfUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        Queue queue = new LinkedList();
        int count = 0;
        if (root == null) return 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = (BinaryTreeNode) queue.poll();
            count++;
            if (temp.getLeft() != null) queue.add(temp.getLeft());
            if (temp.getRight() != null) queue.add(temp.getRight());
        }
        return count;
    }

    /**
     * 删除树
     *
     * @param root
     */
    public static void deleteBinaryTree(BinaryTreeNode root) {
        if (root == null) return;
        // 首先删除两颗子树
        deleteBinaryTree(root.getLeft());
        deleteBinaryTree(root.getRight());
        // 仅当子树删除后再删除当前结点
        root = null;
    }

    /**
     * 逆向逐层输出树中的元素
     *
     * @param root
     */
    public static void levelOrderTraversalInReverse(BinaryTreeNode root) {
        Queue queue = new LinkedList();
        Stack stack = new Stack();
        BinaryTreeNode temp;
        if (root == null) return;
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = (BinaryTreeNode) queue.poll();
            if (temp.getRight() != null) queue.add(temp.getRight());
            if (temp.getLeft() != null) queue.add(temp.getLeft());
            stack.push(temp);
        }
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
    }

    /**
     * 求二叉树的深度（高度）
     * 递归计算左子树和右子树的高度，然后找出这两颗子树高度中的最大值再加1，
     * 就是树的高度
     *
     * @param root
     * @return
     */
    public static int heightOfBinaryTree(BinaryTreeNode root) {
        int leftHeight, rightHeight;
        if (root == null) return 0;
        else {
            // 计算每颗子树的深度
            leftHeight = heightOfBinaryTree(root.getLeft());
            rightHeight = heightOfBinaryTree(root.getRight());
            // 取最大值，然后返回+1
            if (leftHeight > rightHeight) return leftHeight + 1;
            else return rightHeight + 1;
        }
    }

    /**
     * 使用非递归的方式求解二叉树的深度
     *
     * @param root
     * @return
     */
    public static int findHeightBinaryTree(BinaryTreeNode root) {
        int level = 0;
        Queue queue = new LinkedList();
        if (root == null) return 0;
        queue.add(root);
        // 第一层结束
        queue.add(null);
        while (!queue.isEmpty()) {
            root = (BinaryTreeNode) queue.poll();
            // 当前层遍历结束
            if (root == null) {
                // 为下一层增加一个标记
                if (!queue.isEmpty()) queue.add(null);
                level++;
            } else {
                if (root.getLeft() != null) queue.add(root.getLeft());
                if (root.getRight() != null) queue.add(root.getRight());
            }
        }
        return level;
    }

    /**
     * 查找二叉树中最深结点
     *
     * @param root
     * @return
     */
    public static BinaryTreeNode deepestNodeinBinaryTree(BinaryTreeNode root) {
        BinaryTreeNode temp = null;
        Queue queue = new LinkedList();
        if (root == null) return null;
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = (BinaryTreeNode) queue.poll();
            if (temp.getLeft() != null) queue.add(temp.getLeft());
            if (temp.getRight() != null) queue.add(temp.getRight());
        }
        return temp;
    }

    /**
     * 用非递归算法获取二叉树中叶子结点的个数
     * 左孩子结点和右孩子结点都为空的结点就是叶子结点
     *
     * @param root
     * @return
     */
    public static int numberOfLeavesInBtUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode tmep = null;
        Queue queue = new LinkedList();
        int count = 0;
        if (root == null) return 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            tmep = (BinaryTreeNode) queue.poll();
            if (tmep.getLeft() == null && tmep.getRight() == null) count++;
            else {
                if (tmep.getLeft() != null) queue.add(tmep.getLeft());
                if (tmep.getRight() != null) queue.add(tmep.getRight());
            }
        }
        return count;
    }

    /**
     * 非递归实现查找二叉树中满结点的个数
     * 既有左孩子结点，又有右孩子结点的结点叫做满结点。这这些结点的个数就是问题的解
     *
     * @param root
     * @return
     */
    public static int numberOfFullNodesInBtUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp = null;
        Queue queue = new LinkedList();
        int count = 0;
        if (root == null) return 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = (BinaryTreeNode) queue.poll();
            // 判断左右结点是否为空即可
            if (temp.getLeft() != null && temp.getRight() != null) count++;
            if (temp.getLeft() != null) queue.add(temp.getLeft());
            if (temp.getRight() != null) queue.add(temp.getRight());
        }
        return count;
    }

    /**
     * 用非递归算法实现查找二叉树中半结点（仅有一个孩子结点的结点）的个数。
     * 半结点就是只有左结点或者右结点的结点，半结点只能有一个孩子结点
     *
     * @param root
     * @return
     */
    public static int numberOfHalfNodesInBtUsingLevelOrder(BinaryTreeNode root) {
        int count = 0;
        BinaryTreeNode temp = null;
        Queue queue = new LinkedList();
        if (root == null) return 0;
        queue.add(root);
        while (queue.isEmpty()) {
            temp = (BinaryTreeNode) queue.poll();
            if (temp.getLeft() != null && temp.getRight() == null || temp.getLeft() == null && temp.getRight() != null) {
                count++;
            }
            if (temp.getLeft() != null) queue.add(temp.getLeft());
            if (temp.getRight() != null) queue.add(temp.getRight());
        }
        return count;
    }

    /**
     * 对于给定两颗树，判断它们的结构是否相同，如果相同就返回true，
     * 解法：
     * 1、如果两颗树都为空树，则返回true
     * 2、如果两颗树都不为空，则比较数据比递归地判断左子树与右子树是否相同
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean areStructurullySameTrees(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.getData() == root2.getData()) &&
                areStructurullySameTrees(root1.getLeft(), root2.getLeft()) &&
                areStructurullySameTrees(root1.getRight(), root2.getRight());
    }

    /**
     * 求二叉树直径的算法。树的直径（有时也叫树的宽度，就是树中两个叶子结点之间的最长路径和结点的个数）
     * 为了获取树的直径，首先需要递归地计算左子树的直径和右子树的直径。
     * 找出两者的最大值，再加1返回
     *
     * @param root
     * @param diameter 静态变量
     * @return
     */
    public static int diameterOfTree(BinaryTreeNode root, int diameter) {
        int left, right;
        if (root == null) return 0;
        left = diameterOfTree(root.getLeft(), diameter);
        right = diameterOfTree(root.getRight(), diameter);
        if (left + right > diameter) diameter = left + right;
        return Math.max(left, right) + 1;
    }

    /**
     * 找出二叉树中同一层结点数据之和最大的层
     * 逻辑上类似于查找二叉树的层数。唯一不同的是，还需要跟踪每一层结点的数据和
     *
     * @param root
     * @return
     */
    public static int findLevelWithMaxSum(BinaryTreeNode root) {
        BinaryTreeNode temp;
        int level = 0, maxLevel = 0;
        Queue queue = new LinkedList();
        int currentSum = 0, maxSum = 0;
        if (root == null) return 0;
        queue.add(root);
        queue.add(null);  // 第一层结束
        while (!queue.isEmpty()) {
            temp = (BinaryTreeNode) queue.poll();
            // 若当前层遍历完成则比较和
            if (temp == null) {
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxLevel = level;
                }
                currentSum = 0;
                // 将标记下一层结束的指示器置入队尾
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                level++;
            } else {
                currentSum += temp.getData();
                if (temp.getLeft() != null) queue.add(temp.getLeft());
                if (temp.getRight() != null) queue.add(temp.getRight());
            }
        }
        return maxLevel;
    }

    /**
     * 输出所有从根结点到叶子结点的路径
     *
     * @param node
     * @param path
     * @param pathLen
     */
    public static void printPaths(BinaryTreeNode node, int[] path, int pathLen) {
        if (node == null) return;
        // 将该结点添加到路径数组中
        path[pathLen] = node.getData();
        pathLen++;
        // 当前为叶子结点，因此输出到这里的路径
        if (node.getLeft() == null && node.getRight() == null) {
            printArray(path, pathLen);
        } else {
            // 否则，继续遍历两颗子树
            printPaths(node.getLeft(), path, pathLen);
            printPaths(node.getRight(), path, pathLen);
        }
    }

    private static void printArray(int[] ints, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }

    /**
     * a判断是否存在路径的数据和等于给定值
     * 也就是说判断 是否存在一条从根结点到任意结点的路径，其所经过结点的数据和为给定值
     *
     * @param sum
     * @return
     */
    public static boolean hasPathSum(int sum) {
        return hasPathSum(root, sum);
    }

    public static boolean hasPathSum(BinaryTreeNode root, int sum) {
        // 如果所有结点已被访问且sum==,则返回true
        if (root == null) return sum == 0;
        else {
            // 否则，检查两颗子树
            int subSum = sum - root.getData();
            return hasPathSum(root.getLeft(), subSum) || hasPathSum(root.getRight(), subSum);
        }
    }

    /**
     * 递归求出二叉树所有结点数据之和
     * 递归地求出左子树和右子树的和，然后将它们的值加到当前结点的值上
     *
     * @param root
     * @return
     */
    public static int add(BinaryTreeNode root) {
        if (root == null) return 0;
        else return (root.getData()) + add(root.getLeft()) + add(root.getRight());
    }

    /**
     * 非递归的方法求所有结点的数据之和
     *
     * @param root
     * @return
     */
    public static int sumOfBtUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp = null;
        Queue queue = new LinkedList();
        int sum = 0;
        if (root == null) return 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = (BinaryTreeNode) queue.poll();
            sum += temp.getData();
            if (temp.getLeft() != null) queue.add(temp.getLeft());
            if (temp.getRight() != null) queue.add(temp.getRight());
        }
        return sum;
    }

    /**
     * 将一课树转换为镜像的算法
     *
     * @param root
     * @return
     */
    public static BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode root) {
        BinaryTreeNode temp = null;
        if (root != null) {
            mirrorOfBinaryTree(root.getLeft());
            mirrorOfBinaryTree(root.getRight());
            temp = root.getLeft();
            // 交换两个结点的指针
            root.setLeft(root.getRight());
            root.setRight(temp);
        }
        return root;
    }

    /**
     * 判断两棵树是否为镜像
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean areMirrors(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.getData() != root2.getData()) return false;
        else return (areMirrors(root1.getLeft(), root2.getRight()) && areMirrors(root1.getRight(), root2.getLeft()));
    }

    /**
     * 根据给定的中序遍历和前序遍历序列来构建二叉树
     *
     * @param inOrder
     * @param preOrder
     * @param inStrt
     * @param inEnd
     * @return
     */
    public static BinaryTreeNode buildBinaryTree(int[] inOrder, int[] preOrder, int inStrt, int inEnd) {
        int preIndex = 0;
        BinaryTreeNode newNode = new BinaryTreeNode();
        if (inStrt > inEnd) return null;
        if (newNode == null) return null;
        // 利用preIndex在前序序列中选择当前结点
        newNode.setData(preOrder[preIndex]);
        preIndex++;
        if (inStrt == inEnd) return newNode;
        // 否则在中序序列中找到该结点的索引
        int inIndex = search(inOrder, inStrt, inEnd, newNode.getData());
        // 利用中学序列中结点的索引分别建立左子树和右子树
        newNode.setLeft(buildBinaryTree(inOrder, preOrder, inStrt, inIndex - 1));
        newNode.setLeft(buildBinaryTree(inOrder, preOrder, inIndex + 1, inEnd));
        return newNode;
    }

    private static int search(int[] inOrder, int inStrt, int inEnd, int data) {
        return 0;
    }

    /**
     * 查找二叉树中两个结点的最近公共祖先(LCA)
     *
     * @param root
     * @param a
     * @param b
     * @return
     */
    public static BinaryTreeNode lca(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
        BinaryTreeNode left, right;
        if (root == null) return root;
        if (root == a || root == b) return root;
        left = lca(root.getLeft(), a, b);
        right = lca(root.getRight(), a, b);
        if (left != null && right != null) return root;
        else return (left != null ? left : right);
    }

    /**
     * 假设一棵树，叶子结点用 "L" 表示，内部用 "I",同时假定每个结点只能有 0 个或 2个孩子结点。
     * 根据这棵树的前序序列，构建这棵树
     *
     * @param A
     * @param i
     * @return
     */
    public static BinaryTreeNode buildTreeFromPreOrder(char[] A, int i) {
        if (A == null) return null;   // 边界条件
        BinaryTreeNode newNode = new BinaryTreeNode();
        newNode.setData(A[i]);
        newNode.setLeft(null);
        newNode.setRight(null);
        if (A[i] == 'L') return newNode;    // 到达有个叶子结点，返回
        i = i + 1;
        newNode.setLeft(buildTreeFromPreOrder(A, i));  // 构建左子树
        i = i + 1;
        newNode.setRight(buildTreeFromPreOrder(A, i));  // 构建右子树
        return newNode;
    }

}
