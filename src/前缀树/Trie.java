package 前缀树;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/16 20:46
 * @Filename Solution207
 */

/*208. 实现 前缀树.Trie (前缀树)
前缀树.Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

请你实现 前缀树.Trie 类：

前缀树.Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。*/

/*
1.this是一个系统隐含的指针被自动附加在非静态的成员函数参数列表中。
2.当前时刻，哪个对象调用该函数，那么this就指向当前调用该函数的对象，系统就会自动在该函数的参数列表中添加一个隐藏的this指针，
并且把调用该函数的对象地址赋给this指针，这样一来，在函数的内部通过this就可以访问当前正在调用该函数的对象的成员。
3.静态函数内部，没有this指针。
*/

class Trie {
    private Trie[] nextNode;
    private boolean isEnd;

    public Trie() {
        nextNode = new Trie[26];
        isEnd = false;
    }

    // 插入字符串，对于当前字符对应的子节点有两种情况
    // 子节点存在。沿着指针移动到子节点，继续处理下一个字符。
    // 子节点不存在。创建一个新的子节点，记录在 nextNode 数组的对应位置上，然后沿着指针移动到子节点，继续搜索下一个字符。
    public void insert(String word) {
        // this指针指向当前正在调用方法的对象
        // 或者也可以使用内部类
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            int index = character - 'a';
            // 如果该分支不存在，创建一个新的节点
            if (node.nextNode[index] == null) {
                node.nextNode[index] = new Trie();
            } else {
                // 存在就搜索下一个字符
                node = node.nextNode[index];
            }
        }
        // 重复以上步骤，直到处理字符串的最后一个字符，然后将当前节点标记为字符串的结尾。
        node.isEnd = true;
    }

    public boolean search(String word) {
        // 若搜索到了前缀的末尾，就说明字典树中存在该前缀。此外，若前缀末尾对应节点的 isEnd 为真，则说明字典树中存在该字符串。
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = new Trie();
        for (int i = 0; i < prefix.length(); i++) {
            char character = prefix.charAt(i);
            int index = character - 'a';
            // 如果该分支不存在，表示该单词不存在
            if (node.nextNode[index] == null) {
                return null;
            } else {
                // 如果存在就继续向下遍历
                node = node.nextNode[index];
            }
        }
        return node;
    }
}
