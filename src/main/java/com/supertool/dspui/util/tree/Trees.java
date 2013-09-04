package com.supertool.dspui.util.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Trees {
    
    public static class TreeNode {
        private Integer id;
        private String name;
        private Boolean isLeaf;
        private List<TreeNode> nodes;
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public List<TreeNode> getNodes() {
            return nodes;
        }
        public void setNodes(List<TreeNode> nodes) {
            this.nodes = nodes;
        }
        public Boolean getIsLeaf() {
            return isLeaf;
        }
        public void setIsLeaf(Boolean isLeaf) {
            this.isLeaf = isLeaf;
        }
    }

    /**
     * 将FlatNode (id, parentId, name) 的数组转化为递归的树状结构，并返回根节点的列表
     * 注意，根节点是指parentId = -1
     * @param nodes
     * @return
     */
    public static <T extends FlatNode> List<TreeNode> buildTree(List<T> nodes) {
        Map<Integer, TreeNode> map = new HashMap<Integer, Trees.TreeNode>();
        for (FlatNode r : nodes) {
            // 自己
            Integer id = r.getId();
            TreeNode node = null;
            if (map.containsKey(id)) {
                node = map.get(id);
            } else {
                node = new TreeNode();
                map.put(id, node);
            }
            node.setName(r.getName());
            node.setId(r.getId());

            // 父节点
            Integer parentId = r.getParentId();
            TreeNode parent = null;
            if (map.containsKey(parentId)) {
                parent = map.get(parentId);
            } else {
                parent = new TreeNode();
                map.put(parentId, parent);
            }
            List<TreeNode> siblings = parent.getNodes();
            if (null == siblings) {
                siblings = new ArrayList<Trees.TreeNode>();
                parent.setNodes(siblings);
            }
            siblings.add(node);
        }
        // 处理节点状态
        for (Integer id : map.keySet()) {
            TreeNode node = map.get(id);
            List<TreeNode> children = node.getNodes();
            if (null != children) {
                node.setIsLeaf(false);
            } else {
                node.setIsLeaf(true);
            }
        }
        // 返回parentId == -1的节点
        List<TreeNode> result = new ArrayList<Trees.TreeNode>();
        for (FlatNode r : nodes) {
            if (r.getParentId().equals(-1)) {
                TreeNode node = map.get(r.getId());
                result.add(node);
            }
        }
        return result;
    }

}
