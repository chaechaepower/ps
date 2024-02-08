import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Node[] arr = new Node[n];

		for (int i = 0; i < n; i++) {
			arr[i] = new Node();
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char data = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			int idx = data - 'A';

			arr[idx].data = data;

			if (left == '.') {
				arr[idx].left = null;
			} else {
				arr[idx].left = arr[left - 'A'];
			}

			if (right == '.') {
				arr[idx].right = null;
			} else {
				arr[idx].right = arr[right - 'A'];
			}
		}

		preorder(arr[0]);
		System.out.println();
		inorder(arr[0]);
		System.out.println();
		postorder(arr[0]);
		System.out.println();

	}

	static void preorder(Node node) {

		if (node != null) {
			System.out.print(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}

	static void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data);
			inorder(node.right);
		}
	}

	static void postorder(Node node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data);
		}
	}

	static class Node {
		char data;
		Node left;
		Node right;
	}

}