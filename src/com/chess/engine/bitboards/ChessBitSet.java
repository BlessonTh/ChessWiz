package com.chess.engine.bitboards;
import java.util.BitSet;

public final class ChessBitSet extends BitSet {

	public ChessBitSet() {
		super(64);
	}

	public ChessBitSet(final ChessBitSet bSet) {
		super(64);
		or(bSet);
	}

	public BitSet shiftLeft(BitSet bits, int n) {
		final long[] words = bits.toLongArray();
		// Do the shift
		for (int i = 0; i < words.length - 1; i++) {
			words[i] >>>= n; // Shift current word
			words[i] |= words[i + 1] << (64 - n); // Do the carry
		}
		words[words.length - 1] >>>= n; // shift [words.length-1] separately, since no carry
		return BitSet.valueOf(words);
	}


	@Override
	public String toString() {
		final StringBuilder s = new StringBuilder();
		for (int i = 0; i < size(); i++) {
			final boolean bit_is_set = get(i);
			if (bit_is_set) {
				s.append(" 1 ");
			} else {
				s.append(" . ");
			}
			if ((i + 1) % 8 == 0) {
				s.append("\n");
			}
		}
		return s.toString();
	}

}
