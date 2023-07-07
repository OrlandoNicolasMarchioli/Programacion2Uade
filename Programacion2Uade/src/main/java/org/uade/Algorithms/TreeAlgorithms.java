package org.uade.Algorithms;

import org.uade.adt.BinaryTree;
import org.uade.adt.Dictionary;
import org.uade.adt.definitions.IBinaryTree;
import org.uade.adt.definitions.IQueue;
import org.uade.dynamic.GenericBinaryTree;
import org.uade.dynamic.node.GenericBinaryTreeNode;

import java.util.Random;

public class TreeAlgorithms<T> {

    public static BinaryTree generateBinaryTree(int range) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.create(5);
        int value = new Random().nextInt(20);
        for (int i = 0; i < range; i++) {
            binaryTree = addRecursive(binaryTree, value);
        }
        return binaryTree;
    }

    /**
     * \TODO: resolve recurrent adding problem
     *
     * @param current
     * @param value
     * @return
     */
    public static BinaryTree addRecursive(BinaryTree current, int value) {
        int rValue = new Random().nextInt(20);
        if (current == null) {
            BinaryTree binaryTree = new BinaryTree();
            binaryTree.create(5);
            return binaryTree;
        }

        if (value < current.getValue()) {
            current.addLeft(value);
            addRecursive(current, rValue);
        } else if (value > current.getValue()) {
            current.addRight(value);
            addRecursive(current, rValue);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public static Dictionary getAncestorsPerNode(BinaryTree tree, Dictionary dictionary) {
        if (tree.getLeft() != null && tree.getRight() == null) {
            dictionary.add(tree.getValue(), getSumOfValues(tree.getLeft(),tree.getLeft().getValue()));
            getAncestorsPerNode(tree.getLeft(), dictionary);
        }
        if (tree.getLeft() != null && tree.getRight() != null) {
            if (tree.getLeft().getLeft() != null) {
                dictionary.add(tree.getValue(), getSumOfValues(tree.getLeft(), tree.getLeft().getValue() + tree.getRight().getValue()));
                getAncestorsPerNode(tree.getLeft(), dictionary);
            }
            if (tree.getLeft().getRight() != null) {
                dictionary.add(tree.getValue(), getSumOfValues(tree.getLeft(), tree.getLeft().getValue() + tree.getRight().getValue()));
                getAncestorsPerNode(tree.getLeft(), dictionary);
            }
            if (tree.getRight().getRight() != null) {
                dictionary.add(tree.getValue(), getSumOfValues(tree.getRight(), tree.getLeft().getValue() + tree.getRight().getValue()));
                getAncestorsPerNode(tree.getLeft(), dictionary);
            }
            if (tree.getRight().getLeft() != null) {
                dictionary.add(tree.getValue(), getSumOfValues(tree.getRight(), tree.getLeft().getValue() + tree.getRight().getValue()));
                getAncestorsPerNode(tree.getLeft(), dictionary);
            }
        }
        if (tree.getRight() != null && tree.getLeft() == null) {
            dictionary.add(tree.getValue(),  getSumOfValues(tree.getRight(),tree.getRight().getValue()));
            getAncestorsPerNode(tree.getRight(), dictionary);
        }
        return dictionary;
    }
    public static int getSumOfValues(IBinaryTree binaryTree, int sumOfValues) {
        if (binaryTree.getLeft() != null) {
            sumOfValues = sumOfValues + binaryTree.getLeft().getValue();
            getSumOfValues(binaryTree.getLeft(), sumOfValues);
        }
        if (binaryTree.getRight() != null) {
            sumOfValues = sumOfValues + binaryTree.getRight().getValue();
            getSumOfValues(binaryTree.getRight(), sumOfValues);
        }
        return sumOfValues;
    }

    public static int travelIntoTheBinaryTreeAndSumValues(BinaryTree binaryTree, int sumOfValues) {
        if (binaryTree.getLeft() != null && binaryTree.getRight() != null) {
            if (binaryTree.getLeft().getLeft() != null || binaryTree.getLeft().getRight() != null) {
                if (binaryTree.getLeft().getLeft() != null) {
                    sumOfValues = sumOfValues + binaryTree.getLeft().getValue();
                    BinaryTree newBranch = binaryTree.getLeft();
                    return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
                }
                if (binaryTree.getLeft().getRight() != null) {
                    sumOfValues = sumOfValues + binaryTree.getRight().getValue();
                    BinaryTree newBranch = binaryTree.getRight();
                    return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
                }
            }
            if (binaryTree.getRight().getLeft() != null || binaryTree.getRight().getRight() != null) {
                if (binaryTree.getRight().getLeft() != null) {
                    sumOfValues = sumOfValues + binaryTree.getRight().getValue();
                    BinaryTree newBranch = binaryTree.getLeft();
                    return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
                }
                if (binaryTree.getRight().getRight() != null) {
                    sumOfValues = sumOfValues + binaryTree.getRight().getValue();
                    BinaryTree newBranch = binaryTree.getRight();
                    return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
                }
            }
        } else if (binaryTree.getRight() != null && binaryTree.getLeft() == null) {
            if (binaryTree.getRight().getLeft() != null) {
                sumOfValues = sumOfValues + binaryTree.getRight().getValue();
                BinaryTree newBranch = binaryTree.getLeft();
                return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
            }
            if (binaryTree.getRight().getRight() != null) {
                sumOfValues = sumOfValues + binaryTree.getRight().getValue();
                BinaryTree newBranch = binaryTree.getRight();
                return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
            }
        } else if (binaryTree.getLeft() != null && binaryTree.getRight() == null) {
            if (binaryTree.getLeft().getLeft() != null) {
                sumOfValues = sumOfValues + binaryTree.getLeft().getValue();
                BinaryTree newBranch = binaryTree.getLeft();
                return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
            }
            if (binaryTree.getLeft().getRight() != null) {
                sumOfValues = sumOfValues + binaryTree.getRight().getValue();
                BinaryTree newBranch = binaryTree.getRight();
                return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
            }
        }
        return sumOfValues;
    }

    public static int travelInsideTheTreeToGetTheLowerValue(BinaryTree binaryTree, int lowerValue) {
        if (binaryTree.getLeft() != null) {

            if (binaryTree.getLeft().getLeft() != null) {
                if (binaryTree.getLeft().getValue() < lowerValue) {
                    lowerValue = binaryTree.getLeft().getValue();
                }
                BinaryTree newBranch = binaryTree.getLeft();
                return travelInsideTheTreeToGetTheLowerValue(newBranch, lowerValue);
            }
            if (binaryTree.getLeft().getRight() != null && binaryTree.getLeft().getRight().getValue() < lowerValue) {
                if (binaryTree.getLeft().getValue() < lowerValue) {
                    lowerValue = binaryTree.getLeft().getValue();
                }
                BinaryTree newBranch = binaryTree.getRight();
                return travelInsideTheTreeToGetTheLowerValue(newBranch, lowerValue);
            }
            if (binaryTree.getLeft().getValue() < lowerValue) {
                lowerValue = binaryTree.getLeft().getValue();
            }
        }
        return lowerValue;
    }

    public static int travelIntoTheBinaryTreeAndGetTheHigh(BinaryTree binaryTree, int high) {

        if (binaryTree.getLeft() != null) {
            high = high + 1;
            if (binaryTree.getLeft().getLeft() != null) {
                return travelIntoTheBinaryTreeAndGetTheHigh(binaryTree.getLeft(), high);
            }
            if (binaryTree.getLeft().getRight() != null) {
                return travelIntoTheBinaryTreeAndGetTheHigh(binaryTree.getRight(), high);
            }
        }
        if (binaryTree.getRight() != null) {
            high = high + 1;
            if (binaryTree.getRight().getLeft() != null) {
                return travelIntoTheBinaryTreeAndGetTheHigh(binaryTree.getLeft(), high);
            }
            if (binaryTree.getRight().getRight() != null) {
                return travelIntoTheBinaryTreeAndGetTheHigh(binaryTree.getRight(), high);
            }
        }
        return high;
    }

    public static boolean travelIntoTheBinaryTreeAndShowIfIsComplete(BinaryTree binaryTree, boolean isComplete) {

        if (binaryTree.getLeft() != null && binaryTree.getRight() != null) {

            if (binaryTree.getLeft().getLeft() == null && binaryTree.getLeft().getRight() != null || binaryTree.getLeft().getLeft() != null && binaryTree.getLeft().getRight() == null ||
                    binaryTree.getRight().getLeft() == null && binaryTree.getRight().getRight() != null || binaryTree.getLeft().getLeft() != null && binaryTree.getRight().getRight() == null) {
                isComplete = false;
            }

            if (binaryTree.getLeft().getLeft() != null) {
                return travelIntoTheBinaryTreeAndShowIfIsComplete(binaryTree.getLeft(), isComplete);
            }
            if (binaryTree.getLeft().getRight() != null) {
                return travelIntoTheBinaryTreeAndShowIfIsComplete(binaryTree.getRight(), isComplete);
            }
            if (binaryTree.getRight().getLeft() != null) {
                return travelIntoTheBinaryTreeAndShowIfIsComplete(binaryTree.getLeft(), isComplete);
            }
            if (binaryTree.getRight().getRight() != null) {
                return travelIntoTheBinaryTreeAndShowIfIsComplete(binaryTree.getRight(), isComplete);
            }
        }
        return isComplete;
    }

    public static void  binaryTreeToQueue(IBinaryTree binaryTree, IQueue queue){
        if (binaryTree == null || binaryTree.isEmpty()) {
            return;
        }
        binaryTreeToQueue(binaryTree.getLeft(), queue);
        queue.add(binaryTree.getValue());
        binaryTreeToQueue(binaryTree.getRight(), queue);
    }

    public static BinaryTree generateHardcodedBinaryTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.create(5);
        int value = new Random().nextInt(20);
        binaryTree.addLeft(3);
        binaryTree.addRight(7);
        BinaryTree firstLeftLevel = binaryTree.getLeft();
        BinaryTree firstRightLevel = binaryTree.getRight();

        firstLeftLevel.addLeft(2);
        firstLeftLevel.addRight(4);
        firstRightLevel.addLeft(6);
        firstRightLevel.addRight(9);

        BinaryTree secondLeftLeftLevel = firstLeftLevel.getLeft();

        BinaryTree secondRightRightLevel = firstRightLevel.getRight();

        secondLeftLeftLevel.addLeft(1);
        secondRightRightLevel.addRight(12);
        secondRightRightLevel.addLeft(8);

        return binaryTree;
    }

    public static BinaryTree generateHardcodedCompleteBinaryTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.create(10);

        binaryTree.addLeft(6);
        binaryTree.addRight(15);
        BinaryTree firstLeftLevel = binaryTree.getLeft();
        BinaryTree firstRightLevel = binaryTree.getRight();

        firstLeftLevel.addLeft(4);
        firstLeftLevel.addRight(8);

        firstRightLevel.addLeft(13);
        firstRightLevel.addRight(18);
        BinaryTree secondLeftLeftLevel = firstLeftLevel.getLeft();
        BinaryTree secondLeftRightLevel = firstLeftLevel.getRight();
        BinaryTree secondRightLeftLevel = firstRightLevel.getLeft();
        BinaryTree secondRightRightLevel = firstRightLevel.getRight();

        secondLeftLeftLevel.addLeft(3);
        secondLeftLeftLevel.addRight(5);

        secondLeftRightLevel.addLeft(7);
        secondLeftRightLevel.addRight(9);

        secondRightLeftLevel.addRight(14);
        secondRightLeftLevel.addLeft(12);

        secondRightRightLevel.addRight(19);
        secondRightRightLevel.addLeft(17);

        return binaryTree;
    }

    public static void inOrder(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return;
        }

        inOrder(binaryTree.getLeft());
        System.out.println(binaryTree.getValue());
        inOrder(binaryTree.getRight());
    }

    public static void preOrder(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return;
        }

        System.out.println(binaryTree.getValue());
        inOrder(binaryTree.getLeft());
        inOrder(binaryTree.getRight());
    }

    public static void postOrder(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return;
        }

        inOrder(binaryTree.getLeft());
        inOrder(binaryTree.getRight());
        System.out.println(binaryTree.getValue());
    }

    public static int weight(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }
        return 1 + weight(binaryTree.getLeft()) + weight(binaryTree.getRight());
    }

    public static int height(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }
        return 1 + Math.max(height(binaryTree.getLeft()), height(binaryTree.getRight()));
    }

    public static int order(IBinaryTree binaryTree, int element) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return -1;
        }
        if (binaryTree.getValue() == element) {
            int hasLeft = binaryTree.getLeft() == null ? 0 : 1;
            int hasRight = binaryTree.getRight() == null ? 0 : 1;
            return hasLeft + hasRight;
        }
        int candidate = order(binaryTree.getLeft(), element);
        if (candidate == -1) {
            return order(binaryTree.getRight(), element);
        }
        return candidate;
    }

    public static boolean skewed(IBinaryTree binaryTree) {
        return leftSkewed(binaryTree) || rightSkewed(binaryTree);
    }

    public static boolean leftSkewed(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }
        return binaryTree.getRight() == null && leftSkewed(binaryTree);
    }

    public static boolean rightSkewed(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }
        return binaryTree.getLeft() == null && rightSkewed(binaryTree);
    }

    public static boolean degenerate(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }

        if (binaryTree.getLeft() != null) {
            if (binaryTree.getRight() != null) {
                return false;
            }
            return degenerate(binaryTree.getLeft());
        }

        if (binaryTree.getRight() != null) {
            if (binaryTree.getLeft() != null) {
                return false;
            }
            return degenerate(binaryTree.getRight());
        }

        return true;
    }

    public static boolean complete(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }

        return binaryTree.getLeft() != null &&
                binaryTree.getRight() != null &&
                complete(binaryTree.getLeft()) &&
                complete(binaryTree.getRight()) ||
                binaryTree.getLeft() == null && binaryTree.getRight() == null;
    }

    public static boolean perfect(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }

        if (!complete(binaryTree.getLeft()) || !complete(binaryTree.getRight())) {
            return false;
        }

        if (height(binaryTree.getLeft()) != height(binaryTree.getRight())) {
            return false;
        }

        return perfect(binaryTree.getLeft()) && perfect(binaryTree.getRight());
    }

    private static boolean existsLT(IBinaryTree binaryTree, int value) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return false;
        }
        if (binaryTree.getValue() < value) {
            return true;
        }
        return existsLT(binaryTree.getLeft(), value) || existsLT(binaryTree.getRight(), value);
    }

    private static boolean existsGT(IBinaryTree binaryTree, int value) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return false;
        }
        if (binaryTree.getValue() > value) {
            return true;
        }
        return existsGT(binaryTree.getLeft(), value) || existsGT(binaryTree.getRight(), value);
    }

    private static boolean isSBT(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }
        return !existsGT(binaryTree.getLeft(), binaryTree.getValue()) &&
                !existsLT(binaryTree.getRight(), binaryTree.getValue()) &&
                isSBT(binaryTree.getLeft()) &&
                isSBT(binaryTree.getRight());
    }

    public static boolean swap(IBinaryTree binaryTree, int value) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return false;
        }
        if ((binaryTree.getLeft() != null &&
                !binaryTree.getLeft().isEmpty() &&
                binaryTree.getLeft().getValue() == value) ||
                (binaryTree.getRight() != null &&
                        !binaryTree.getRight().isEmpty() &&
                        binaryTree.getRight().getValue() == value)
        ) {
            IBinaryTree aux = binaryTree.getLeft();
            copy(binaryTree.getLeft(), binaryTree.getRight());
            copy(binaryTree.getRight(), aux);
            return true;
        }

        return swap(binaryTree.getLeft(), value) || swap(binaryTree.getRight(), value);
    }

    public static void copy(IBinaryTree binaryTree, IBinaryTree binaryTree2) {
        if (binaryTree2 == null || binaryTree2.isEmpty() || binaryTree2.getValue() == -1) {
            return;
        }
        binaryTree.create(binaryTree2.getValue());
        binaryTree.addLeft(binaryTree2.getLeft().getValue());
        binaryTree.addRight(binaryTree2.getRight().getValue());
        if (binaryTree2.getLeft() == null) {
            binaryTree2.addLeft(-1);
        }
        if (binaryTree2.getRight() == null) {
            binaryTree2.addRight(-1);
        }
        copy(binaryTree.getLeft(), binaryTree2.getLeft());
        copy(binaryTree.getRight(), binaryTree2.getRight());
        if (binaryTree.getLeft().getValue() == -1) {
            binaryTree.removeLeft();
        }
        if (binaryTree.getRight().getValue() == -1) {
            binaryTree.removeRight();
        }
    }

    public static boolean leafWithSameHeight(IBinaryTree binaryTree) {
        int height = height(binaryTree);

        return validLeafDepth(binaryTree, height);
    }

    private static boolean validLeafDepth(IBinaryTree binaryTree, int depth) {
        if (depth == 0) {
            return binaryTree == null || binaryTree.isEmpty();
        }

        if (depth == 1) {
            return binaryTree != null &&
                    !binaryTree.isEmpty() &&
                    binaryTree.getLeft() == null &&
                    binaryTree.getRight() == null;
        }

        if (binaryTree == null ||
                binaryTree.isEmpty() ||
                (binaryTree.getLeft() == null && binaryTree.getRight() == null)) {
            return false;
        }

        if (binaryTree.getLeft() != null && binaryTree.getRight() == null) {
            return validLeafDepth(binaryTree.getLeft(), depth - 1);
        }

        if (binaryTree.getRight() != null && binaryTree.getLeft() == null) {
            return validLeafDepth(binaryTree.getRight(), depth - 1);
        }

        return validLeafDepth(binaryTree.getLeft(), depth - 1) && validLeafDepth(binaryTree.getRight(), depth - 1);
    }

    /**
     * Precondicion: Arbol no vacio
     *
     * @param binaryTree arbol a mappear
     * @return codigo LaTeX que representa el arbol.
     */
    public static String latex(IBinaryTree binaryTree) {
        if (binaryTree.getLeft() != null && binaryTree.getRight() != null) {
            return "\\begin{tikzpicture}[level distance=1.5cm,\n" +
                    "level 1/.style={sibling distance=6cm},\n" +
                    "level 2/.style={sibling distance=3cm},\n" +
                    "level 3/.style={sibling distance=1.5cm}]\n" +
                    String.format("\\node[circle,draw] {$%d$}", binaryTree.getValue()) + "\n" +
                    latexChild(binaryTree.getLeft(), 1) + "\n" +
                    latexChild(binaryTree.getRight(), 1) + ";\n" +
                    "\\end{tikzpicture}";
        }
        if (binaryTree.getLeft() != null) {
            return "\\begin{tikzpicture}[level distance=1.5cm,\n" +
                    "level 1/.style={sibling distance=6cm},\n" +
                    "level 2/.style={sibling distance=3cm},\n" +
                    "level 3/.style={sibling distance=1.5cm}]\n" +
                    String.format("\\node[circle,draw] {$%d$}", binaryTree.getValue()) + "\n" +
                    latexChild(binaryTree.getLeft(), 1) + ";\n" +
                    "\\end{tikzpicture}";
        }

        if (binaryTree.getRight() != null) {
            return "\\begin{tikzpicture}[level distance=1.5cm,\n" +
                    "level 1/.style={sibling distance=6cm},\n" +
                    "level 2/.style={sibling distance=3cm},\n" +
                    "level 3/.style={sibling distance=1.5cm}]\n" +
                    String.format("\\node[circle,draw] {$%d$}", binaryTree.getValue()) + "\n" +
                    latexChild(binaryTree.getRight(), 1) + ";\n" +
                    "\\end{tikzpicture}";
        }

        return "\\begin{tikzpicture}[level distance=1.5cm,\n" +
                "level 1/.style={sibling distance=6cm},\n" +
                "level 2/.style={sibling distance=3cm},\n" +
                "level 3/.style={sibling distance=1.5cm}]\n" +
                String.format("\\node[circle,draw] {$%d$}", binaryTree.getValue()) + ";\n" +
                "\\end{tikzpicture}";
    }

    private static String latexChild(IBinaryTree binaryTree, int spaces) {
        if (binaryTree.getLeft() == null && binaryTree.getRight() == null) {
            return String.format("child {node[circle,draw] {$%s$}}", binaryTree.getValue());
        }

        if (binaryTree.getLeft() != null && binaryTree.getRight() == null) {
            return String.format("child {node[circle,draw] {$%s$}", binaryTree.getValue()) + "\n" +
                    repeatSpaces(spaces + 1) + latexChild(binaryTree.getLeft(), spaces + 1) + "\n" +
                    "}";
        }

        if (binaryTree.getLeft() == null && binaryTree.getRight() != null) {
            return String.format("child {node[circle,draw] {$%s$}", binaryTree.getValue()) + "\n" +
                    repeatSpaces(spaces + 1) + latexChild(binaryTree.getRight(), spaces + 1) + "\n" +
                    "}";
        }

        return String.format("child {node[circle,draw] {$%s$}", binaryTree.getValue()) + "\n" +
                repeatSpaces(spaces + 1) + latexChild(binaryTree.getLeft(), spaces + 1) + "\n" +
                repeatSpaces(spaces + 1) + latexChild(binaryTree.getRight(), spaces + 1) + "\n" +
                "}";
    }

    private static String repeatSpaces(int n) {
        if (n == 0) {
            return "";
        }
        return " " + repeatSpaces(n - 1);
    }


}
