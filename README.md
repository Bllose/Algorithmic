# bllose-algorithmic
各种算法

# LeetCode  
\6. Z字形转换 [Zsolution.java](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/java/bllose/leetcode/Zsolution.java)   [Zsolution.py](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/python/bllose/leetcode/Zsolution.py)找规律  
\7. 整数反转 [IntegerInversion.java](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/java/bllose/leetcode/IntegerInversion.java) 有待改进  
\8. 字符串转换证数(atoi) [Atoi.java](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/java/bllose/leetcode/Atoi.java)  运行速度有进步空间。 **不要用正则!**      [Atoi.py](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/python/bllose/leetcode/Atoi.py) python本身并不存在这种需求，因为其松类型控制。[Python是否存在类似于Java的Integer.MAX_VALUE的方法?](https://stackoverflow.com/questions/7604966/maximum-and-minimum-values-for-ints)  
\46. 全排列[FullArrangement.java](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/java/bllose/leetcode/FullArrangement.java)  
\96. (动态规划)(二叉搜索树基础知识)不同的二叉搜索树[DiffBST.java](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/java/bllose/leetcode/DiffBST.java)    
\611. 有效三角形的个数 [EffectiveTriangle.java](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/java/bllose/leetcode/EffectiveTriangle.java) 有待改进 | [EffectiveTriangle.py](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/python/bllose/leetcode/EffectiveTriangle.py) 执行超时...     
\968. 监控二叉树 [MonitorBT.java](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/java/bllose/leetcode/MonitorBT.java) 有待改进  
\972. 相等的有理数 [EquiRational.java](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/java/bllose/leetcode/EquiRational.java) | [EquiRational.py](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/python/bllose/leetcode/EquiRational.py) 小数转分数


# OJ2.0
270. (动态规划)做加法 [DoPlus.java](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/java/bllose/arithmetic/DoPlus.java)  [DoPlus.py](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/python/bllose/oj/DoPlus.py)  

# Others  
- (滑窗)最大子串 - 多个限制条件 [Sliding Window Algorithm with Multiple restrictions - Java](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/java/bllose/arithmetic/longestSubString/multiRestrictions/Main.java)   
- (双指针)最长的指定瑕疵度的元音子串 [Imperfections.java](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/java/bllose/arithmetic/switchsubstring/Imperfections.java)
- 一串数字字符串，除了前两位数字，每个数字都是前两个数字的和[Numbers.py](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/python/bllose/arithmetic/Numbers.py)  
- 数字转罗马数字[ConvertNumToRoman.py](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/python/bllose/arithmetic/convertNumToRoma/ConvertNumToRoman.py)  
- 求字符串中所有整数的最小和[TheMinSum.java](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/java/bllose/arithmetic/theMin/TheMinSum.java)  
- VLAN资源池[VlanResourcePool.java](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/java/bllose/arithmetic/switchsubstring/VlanResourcePool.java)  
- 找朋友（找到前方最近一个更大数）[FindFriends.py](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/python/bllose/arithmetic/FindFriends.py)  
- 滚动筛子(使用数组抽象化具体事例，找规律) [TurnDice.py](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/python/bllose/arithmetic/Dice/TurnDice.py)
- 可以组成网络的服务器 (图，最大岛屿问题， 广度优先) [breath_first_search.py](https://github.com/Bllose/bllose-algorithmic/blob/main/src/main/python/bllose/arithmetic/graphs/breath_first_search.py)




## 二叉查找树，平衡树
- Leetcode 1382 将二叉搜索树变平衡  
- - java/bllose/binaryTree/BinaryTrees
![balanceBTS](https://github.com/Bllose/Algorithmic/blob/main/src/main/java/bllose/binaryTree/resourses/balanceBTS.png)

## 分治  
- Leetcode 875 爱吃香蕉的珂珂 
- - java/bllose/sortrelated/KakaEatingBanans.java
- - python/bllose/sortrelated/KakaEatingBananas.py  
- Leetcode 23 合并K个升序链表  
- - java/bllose/sortrelated/MergeLists.java


## 搜索算法
- **深度优先** 
- - Leetcode 98 验证二叉搜索树 Validate Binary Search Tree
- - - java/bllose/binaryTree/BinaryTrees.java
![binaryTree](https://github.com/Bllose/Algorithmic/blob/main/src/main/java/bllose/binaryTree/resourses/validBTS.png)  

- **广度优先** Level Order
- - Leetcode 102 二叉树的层序遍历 Binary Tree Level Order Traversal  
- - - java/bllose/binaryTree/BinaryTrees.java
![levelOrderTraversal](https://github.com/Bllose/Algorithmic/blob/main/src/main/java/bllose/binaryTree/resourses/LevelOrderTraversal.png)

## 回溯 
- Leetcode 5 最长回文子串
- - java/bllose/backtracking/LongestPalindrome.java

## 动态规划
- Leetcode 5 最长回文子串
- - java/bllose/backtracking/LongestPalindrome.java


# 递归思想  
# 分治策略  
# 单调栈  
# 并查集 （DSU）
# 滑动窗口  
# 前缀和\[&哈希表优化\]
# 差分  
# 拓扑排序（专业级）
# 字符串  
# 二分查找
# BFS广搜
# DFS深搜&回溯  
# 动态规划  
# 贪心算法  
# 字典树  
