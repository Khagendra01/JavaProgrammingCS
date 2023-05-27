import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class BST<Key extends Comparable<Key>, Value> {
	Node root;

	class Node {
		Key key;
		Value value;
		Node left;
		Node right;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "[" + key + ", " + value + "]";
		}

	}

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, Value value) {
		if (x == null)
			return new Node(key, value);

		int cmp = key.compareTo(x.key);

		if (cmp < 0)
			x.left = put(x.left, key, value);
		else if (cmp > 0)
			x.right = put(x.right, key, value);
		else
			x.value = value;
		return x;
	}

	public String toString() {
		return toString(root);
	}

	public String toString(Node root) {
		if (root == null)
			return "";

		return toString(root.left) + " " + root.toString() + toString(root.right);
	}

	public Value get(Key key) {
		return get(root, key);
	}

	public Value get(Node root, Key key) {
		if (root == null)
			return null;

		if (key.compareTo(root.key) < 0)
			return get(root.left, key);
		else if (key.compareTo(root.key) > 0)
			return get(root.right, key);
		else
			return root.value;
	}

	public Value getValue(Key key) {
		return get(key);
	}

	public boolean contains(Key key) {
		return (get(key) != null);
	}

	public Key minimum() {

		return minimumHelper(root);
	}

	private Key minimumHelper(Node minRoot) {

		if (minRoot.left == null) {
			return minRoot.key;
		}
		return minimumHelper(minRoot.left);
	}

	public Key smallest() {

		if (root == null) {
			return null;
		}

		Node newNode = root;
		while (newNode.left != null) {
			newNode = newNode.left;
		}
		return newNode.key;

	}

	public Node deleteMinimum() {

		return deleteMinimumHelper(root);

	}

	private Node deleteMinimumHelper(Node minRoot) {

		if (minRoot == null) {
			return null;
		}
		if (minRoot.left == null) {
			Node returningNode = minRoot;
			root = null;
			return returningNode;
		}

		if (minRoot.left.left == null) {
			Node returningNode = minRoot.left;
			if(minRoot.left.right != null) {
				minRoot.left = minRoot.left.right;
			}else {
				minRoot.left = null;
			}			
			return returningNode;
		}
		return deleteMinimumHelper(minRoot.left);

	}

	public Key maximum() {
		return maximumHelper(root);
	}

	private Key maximumHelper(Node maxRoot) {
		if (maxRoot == null) {
			return null;
		}
		if (maxRoot.right == null) {
			return maxRoot.key;
		}
		return maximumHelper(maxRoot.right);

	}

	public String toStringReverse() {
		return toStringReverse(root);
	}

	public String toStringReverse(Node root) {
		if (root == null) {
			return null;
		}
		return toString(root.right) + " " + root.toString() + toString(root.left);
	}

	public int size() {
		return sizeFinder(root);
	}

	private int sizeFinder(Node sizeOfRoot) {
		if (sizeOfRoot == null) {
			return 0;
		}
		if (sizeOfRoot.left == null && sizeOfRoot.right == null) {
			return 1;
		}
		return sizeFinder(sizeOfRoot.left) + sizeFinder(sizeOfRoot.right) + 1;
	}

	public int height() {
		return heightFinder(root);
	}

	private int heightFinder(Node heightOfRoot) {
		if (heightOfRoot == null) {
			return 0;
		}
		if (heightOfRoot.left == null && heightOfRoot.right == null) {
			return 1;
		}
		return Math.max(heightFinder(heightOfRoot.left), heightFinder(heightOfRoot.right)) + 1;
	}

	public int countValue(Value value) {
		return countValueHelper(root, value);
	}

	private int countValueHelper(Node myRoot, Value value) {
		if (myRoot == null) {
			return 0;
		}
		int count = 0;
		if (myRoot.value == value) {
			count++;
		}
		count += countValueHelper(myRoot.left, value);
		count += countValueHelper(myRoot.right, value);
		return count;
	}

	public Key getParentKey(Key target) {
		return getParentKeyHelper(root, target);
	}

	private Key getParentKeyHelper(Node helperRoot, Key target) {

		if (helperRoot == null) {
			return null;
		}
		if (helperRoot.left != null) {
			if (helperRoot.left.key == target) {
				return helperRoot.key;
			}
		}
		if (helperRoot.right != null) {
			if (helperRoot.right.key == target) {
				return helperRoot.key;
			}
		}
		return (getParentKeyHelper(helperRoot.left, target) != null) ? getParentKeyHelper(helperRoot.left, target)
				: getParentKeyHelper(helperRoot.right, target);
	}

	public void balanceMe() {
		ArrayList<Key> myArrayList = new ArrayList<>();

		HashMap<Key, Value> myHashMap = new HashMap<>();

		fillItUpRegular(myArrayList, root, myHashMap);

		myArrayList.sort(null);

		root = doMyBalancing(myArrayList, myHashMap, 0, myArrayList.size());
		return;
	}

	private Node doMyBalancing(ArrayList<Key> myArrayList, HashMap<Key, Value> myHashMap, int start, int end) {

		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		if (mid >= myArrayList.size() || mid < 0) {
			return null;
		}

		Node balancedNode = new Node(myArrayList.get(mid), myHashMap.get(myArrayList.get(mid)));

		balancedNode.left = doMyBalancing(myArrayList, myHashMap, start, mid - 1);

		balancedNode.right = doMyBalancing(myArrayList, myHashMap, mid + 1, end);

		return balancedNode;

	}

	private void fillItUpRegular(ArrayList<Key> myArrayList, Node fillerRoot, HashMap<Key, Value> myHashMap) {
		if (fillerRoot == null) {
			return;
		}
		myArrayList.add(fillerRoot.key);
		myHashMap.put(fillerRoot.key, fillerRoot.value);
		fillItUpRegular(myArrayList, fillerRoot.left, myHashMap);
		fillItUpRegular(myArrayList, fillerRoot.right, myHashMap);
		return;
	}
	
	public Node deleteMaximum() {
		return deleteMaximumHelper(root);
	}
	
	private Node deleteMaximumHelper(Node maxRoot) {
		if(maxRoot == null) {
			return null;
		}
		
		if(maxRoot.right == null) {
			Node returningNode = maxRoot;
			if(maxRoot.left != null) {
				root = maxRoot.left;
			}else {
				root = null;
			}
			return returningNode;
		}
		
		if(maxRoot.right.right == null) {
			Node returningNode = maxRoot.right;
			if(maxRoot.right.left != null) {
				maxRoot.right = maxRoot.right.left;
			}else {
				maxRoot.right = null;
			}
			return returningNode;
		}
		return deleteMaximumHelper(maxRoot.right);
	}
	
	public void printInReverse() {
		printInReverseHelper(root);
	}
	
	private void printInReverseHelper(Node pRoot) {
		if(pRoot == null) {
			return;
		}
		printInReverseHelper(pRoot.right);
		System.out.println(pRoot);
		printInReverseHelper(pRoot.left);
	}
	

	public static void main(String[] args) {
		//runMyTest();
		Scanner in = new Scanner(System.in);

		BST<Character, Integer> bst = new BST();

		while (true) {
			System.out.println("1. put");
			System.out.println("2. get");
			System.out.println("3. put multiple");
			System.out.println("4. getValue");
			System.out.println("5. contains");
			System.out.println("6. minimum");
			System.out.println("7. smallest");
			System.out.println("8. deleteMinimum");
			System.out.println("9. toString");
			System.out.println("10. maximum");
			System.out.println("11. toStringReverse");
			System.out.println("12. size");
			System.out.println("13. height");
			System.out.println("14. count value of your desired entry");
			System.out.println("15. getParentKey");
			System.out.println("16. balance the tree");
			System.out.println("17. delete the maximum");
			System.out.println("18. print in reverse");

			switch (in.nextLine()) {
			case "1":
				System.out.println("Please enter key and value");
				bst.put(in.nextLine().charAt(0), Integer.valueOf(in.nextLine()));
				break;
			case "2":
				System.out.println("Please enter key");
				System.out.println("Value: " + bst.get(in.nextLine().charAt(0)));
				break;
			case "3":
				System.out.println("Please enter multiple keys");
				String keys = in.nextLine();
				int i = 0;
				for (char c : keys.toCharArray())
					bst.put(c, i++);
				break;
			case "4":
				System.out.println("Give the key to get value");
				System.out.println("Your value is : " + bst.getValue(in.nextLine().charAt(0)));
				break;	
			case "5":
				System.out.println("Give the key to check the value if contains or not");
				System.out.println("Your value is : " + bst.contains(in.nextLine().charAt(0)));
				break;	
			case "6":
				System.out.println("The minimum key is " + bst.minimum());
				break;	
			case "7":
				System.out.println("The smallest key is " + bst.smallest());
				break;	
			case "8":
				System.out.println("The minimum key is " + bst.deleteMinimum() + " and I deleted it My master.");
				break;	
			case "9":
				System.out.println(bst);
				break;
			case "10":
				System.out.println("The maximum key is " + bst.maximum());
				break;	
			case "11":
				System.out.println("The reverse of toString is " + bst.toStringReverse());
				break;	
			case "12":
				System.out.println("The size is " + bst.size());
				break;	
			case "13":
				System.out.println("The height is " + bst.height());
				break;	
			case "14":
				System.out.println("Give the value to check the number of key with same value ");
				System.out.println("Your value is : " + bst.countValue(in.nextInt()));
				break;	
			case "15":
				System.out.println("Give the key to get parent key");
				System.out.println("Your value is : " + bst.getParentKey(in.nextLine().charAt(0)));
				break;
			case "16":
				System.out.println("The tree is balanced.");
				bst.balanceMe();
				break;	
			case "17":
				System.out.println(bst.deleteMaximum());
				break;	
			case "18":
				bst.printInReverse();
				break;	
			case "99":
				break;
			}
		}
	}

	private static void runMyTest() {
		BST<Integer, String> bst = new BST<>();
		bst.put(3, "apple");
		bst.put(1, "banana");
		bst.put(5, "cherry");
		bst.put(4, "date");
		bst.put(6, "elderberry");

		// Test basic functionality
		System.out.println(bst.toString()); // [1, banana] [3, apple] [4, date] [5, cherry] [6, elderberry]
		System.out.println(bst.get(3)); // "apple"
		System.out.println(bst.contains(5)); // true
		System.out.println(bst.contains(2)); // false

		// Test deletion
		bst.deleteMinimum();
		System.out.println(bst.toString()); //[3, apple] [4, date] [5, cherry] [6, elderberry]

		// Test tree traversal
		System.out.println(bst.toStringReverse()); //[4, date] [5, cherry] [6, elderberry] [3, apple]
		System.out.println(bst.minimum()); // 3
		System.out.println(bst.maximum()); // 6
		System.out.println(bst.smallest()); // 3
		System.out.println(bst.getParentKey(6)); // 5
		System.out.println(bst.getParentKey(4)); // 5

		// Test size and height
		System.out.println(bst.size()); // 4
		System.out.println(bst.height()); // 3

		// Test countValue
		bst.put(4, "date");
		bst.put(6, "date");
		System.out.println(bst.countValue("date")); // 3

		// Test balancing
		bst.balanceMe();
		System.out.println(bst.toString()); // [3, apple] [4, date] [5, cherry] [6, date]

		
	}
}