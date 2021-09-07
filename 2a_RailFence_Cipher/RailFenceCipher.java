class RailFenceCipherHelper {
	String encode(String msg, int depth) throws Exception {
		int r = depth;
		int l = msg.length();
		int c = l / depth;
		int k = 0;
		char mat[][] = new char[r][c];
		String enc = "";
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				if (k != l) {
					mat[j][i] = msg.charAt(k++);
				} else {
					mat[j][i] = 'X';
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				enc += mat[i][j];
			}
		}
		return enc;
	}

	String decode(String encodedMsg, int depth) throws Exception {
		int r = depth;
		int l = encodedMsg.length();
		int c = l / depth;
		int k = 0;
		char mat[][] = new char[r][c];
		String dec = "";
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				mat[i][j] = encodedMsg.charAt(k++);
			}
		}
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				dec += mat[j][i];
			}
		}
		return dec;
	}
}

public class RailFenceCipher {
	public static void main(String[] args) throws Exception {
		RailFenceCipherHelper rf = new RailFenceCipherHelper();
		String msg = "Anna University, Chennai";
		int DEPTH = 2;
		String enc = rf.encode(msg, DEPTH);
		String dec = rf.decode(enc, DEPTH);
		System.out.println("Simulating RailFence Cipher\n-------------------------");
		System.out.println("Input Message : " + msg);
		System.out.println("Encrypted Message : " + enc);
		System.out.println("Decrypted Message : " + dec);
	}
}
