package BinaryTree;

public class BinaryTreeImpl {

    BTNode root;

    public void add(int data) {
        BTNode nodeToAdd = new BTNode(data);

        if(root == null) {
            root = nodeToAdd;
        } else {
            BTNode traversingNode = root;
            traverseAndAddNode(traversingNode, nodeToAdd);
        }
    }

    private void traverseAndAddNode(BTNode nodeToTraverse, BTNode nodeToAdd) {
        if (nodeToAdd.data < nodeToTraverse.data) {
            if (nodeToTraverse.left == null) {
                nodeToAdd.parent = nodeToTraverse;
                nodeToTraverse.left = nodeToAdd;
            } else {
                traverseAndAddNode(nodeToTraverse.left, nodeToAdd);
            }
        } else {
            if (nodeToTraverse.right == null) {
                nodeToAdd.parent = nodeToTraverse;
                nodeToTraverse.right = nodeToAdd;
            } else {
                traverseAndAddNode(nodeToTraverse.right, nodeToAdd);
            }
        }
    }

    //Inorder -> L,Ro,R
    //Pre Order -> Ro,L,R
    //Post Order -> L,R,Ro
    private void traverse() {
        if (root != null) {
            BTNode nodeToTraverse = root;
            if (nodeToTraverse.left == null && nodeToTraverse.right == null) {
                System.out.println(nodeToTraverse.data);
            }
            else {
                postOrderTraversal(nodeToTraverse);
            }
        }
    }

    private void inOrderTraversal(BTNode node) {
        if (node.left!=null) {
            inOrderTraversal(node.left);
        }
        System.out.println(node.data);

        if (node.right !=null) {
            inOrderTraversal(node.right);
        }
    }

    private void preOrderTraversal(BTNode node) {

        System.out.println(node.data);

        if (node.left!=null) {
            inOrderTraversal(node.left);
        }
        if (node.right !=null) {
            inOrderTraversal(node.right);
        }
    }

    private void postOrderTraversal(BTNode node) {

        if (node.left!=null) {
            inOrderTraversal(node.left);
        }
        if (node.right !=null) {
            inOrderTraversal(node.right);
        }
        System.out.println(node.data);
    }

    private void delete(int val) {
        //Case1 : node to be deleted has no children
        //Case2 : node to be deleted either has no left child or no right child
        //Case3 : node to be deleted has both children
        BTNode nodeToBeDeleted = find(val);

        if (nodeToBeDeleted!=null) {
            if (nodeToBeDeleted.left == null && nodeToBeDeleted.right == null) {
                deleteCase1(nodeToBeDeleted);
            }
            else if(nodeToBeDeleted.left != null) {
                deleteCase2(nodeToBeDeleted);
            } else if (nodeToBeDeleted.right != null) {
                deleteCase2(nodeToBeDeleted);
            } else {
                deleteCase3(nodeToBeDeleted);
            }
        }
    }

    private void deleteCase3(BTNode nodeToBeDeleted) {
        if (nodeToBeDeleted.right!=null) {
            BTNode minNode = minLeftTraversal(nodeToBeDeleted.right);
            deleteCase2(minNode);

            minNode.parent = nodeToBeDeleted.parent;
            minNode.left = nodeToBeDeleted.left;
            minNode.right = nodeToBeDeleted.right;

            if (nodeToBeDeleted.parent.left == nodeToBeDeleted) {
                nodeToBeDeleted.parent.left = minNode;
            } else if(nodeToBeDeleted.parent.right == nodeToBeDeleted) {
                nodeToBeDeleted.parent.right = minNode;
            }
        }
    }

    private BTNode minLeftTraversal(BTNode node) {

        if (node.left == null) {
            return node;
        }
        return minLeftTraversal(node.left);
    }

    private void deleteCase2(BTNode nodeToBeDeleted) {
        if (nodeToBeDeleted.parent.left == nodeToBeDeleted) {
            if (nodeToBeDeleted.left !=null) {
                nodeToBeDeleted.parent.left = nodeToBeDeleted.left;
            } else if (nodeToBeDeleted.right !=null) {
                nodeToBeDeleted.parent.left = nodeToBeDeleted.right;
            }
        } else if (nodeToBeDeleted.parent.right == nodeToBeDeleted) {
            if (nodeToBeDeleted.left != null) {
                nodeToBeDeleted.parent.right = nodeToBeDeleted.left;
            } else if (nodeToBeDeleted.right != null) {
                nodeToBeDeleted.parent.right = nodeToBeDeleted.right;
            }
        }
    }

    private void deleteCase1(BTNode nodeToBeDeleted) {
        if (nodeToBeDeleted.parent.left==nodeToBeDeleted) {
            nodeToBeDeleted.parent.left = null;
        } else {
            nodeToBeDeleted.parent.right = null;
        }
    }


    private BTNode find(int val) {
        if (root !=null) {
            return findNode(root, new BTNode(val));
        }
        return null;
    }

    private BTNode findNode(BTNode search, BTNode node) {
        if (search == null) {
            return null;
        }
        if (search.data == node.data) {
            return search;
        } else {
            BTNode returnNode = findNode(search.left, node);
            if (returnNode == null) {
                returnNode = findNode(search.right, node);
            }
            return returnNode;
        }
    }


    public static void main(String[] args) {

        BinaryTreeImpl b = new BinaryTreeImpl();
        b.add(10);
        b.add(8);
        b.add(7);
        b.add(11);

        b.traverse();

        b.delete(8);
    }
}

