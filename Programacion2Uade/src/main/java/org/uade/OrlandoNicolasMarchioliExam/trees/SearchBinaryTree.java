package org.uade.OrlandoNicolasMarchioliExam.trees;

public class SearchBinaryTree implements ISearchBinaryTreeExam {
    private final BinaryTreeExam binaryTree;

    public SearchBinaryTree() {
        this.binaryTree = new BinaryTreeExam();
    }

    private SearchBinaryTree(BinaryTreeExam binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public int getValue() {
        if (this.isEmpty()) {
            System.out.println("SearchBinaryTree is not initialized");
            return -1;
        }
        return this.binaryTree.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.binaryTree == null || this.binaryTree.isEmpty();
    }

    @Override
    public void add(int element,int timesToAdd) {
        if (timesToAdd < 1){
            throw new RuntimeException("Times to add, cant be lower than 1");
        }
        if (binaryTree.isEmpty()) {
            binaryTree.create(element,timesToAdd);
            return;
        }
        if (element > binaryTree.getValue()) {
            if (binaryTree.getRight() == null) {
                binaryTree.addRight(element,timesToAdd);
                return;
            }
            SearchBinaryTree searchBinaryTree = new SearchBinaryTree(binaryTree.getRight());
            searchBinaryTree.add(element,timesToAdd);
            return;
        }

        if (binaryTree.getLeft() == null) {
            binaryTree.addLeft(element,timesToAdd);
            return;
        }
        SearchBinaryTree searchBinaryTree = new SearchBinaryTree(binaryTree.getLeft());
        searchBinaryTree.add(element,timesToAdd);
    }

    @Override
    public void removeLeft() {
        this.binaryTree.removeLeft();
    }

    @Override
    public void removeRight() {
        this.binaryTree.removeRight();
    }

    @Override
    public ISearchBinaryTreeExam getLeft() {
        try {
            SearchBinaryTree candidate = new SearchBinaryTree(this.binaryTree.getLeft());
            if (candidate.isEmpty()) {
                return null;
            }
            return candidate;
        } catch (RuntimeException e) {
            throw new RuntimeException("The search binary tree is empty");
        }
    }

    @Override
    public ISearchBinaryTreeExam getRight() {
        try {
            SearchBinaryTree candidate = new SearchBinaryTree(this.binaryTree.getRight());
            if (candidate.isEmpty()) {
                return null;
            }
            return candidate;
        } catch (RuntimeException e) {
            throw new RuntimeException("The search binary tree is empty");
        }
    }
}
