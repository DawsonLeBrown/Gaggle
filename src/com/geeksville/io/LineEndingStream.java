/*******************************************************************************
 * Gaggle is Copyright 2010 by Geeksville Industries LLC, a California limited liability corporation. 
 * 
 * Gaggle is distributed under a dual license.  We've chosen this approach because within Gaggle we've used a number
 * of components that Geeksville Industries LLC might reuse for commercial products.  Gaggle can be distributed under
 * either of the two licenses listed below.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details. 
 * 
 * Commercial Distribution License
 * If you would like to distribute Gaggle (or portions thereof) under a license other than 
 * the "GNU General Public License, version 2", contact Geeksville Industries.  Geeksville Industries reserves
 * the right to release Gaggle source code under a commercial license of its choice.
 * 
 * GNU Public License, version 2
 * All other distribution of Gaggle must conform to the terms of the GNU Public License, version 2.  The full
 * text of this license is included in the Gaggle source, see assets/manual/gpl-2.0.txt.
 ******************************************************************************/
package com.geeksville.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Converts newlines to cr/lf or whatever line ending convention you want
 * 
 * @author kevinh
 * 
 */
public class LineEndingStream extends FilterOutputStream {

	public LineEndingStream(OutputStream out) {
		super(out);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.FilterOutputStream#write(byte[], int, int)
	 */
	@Override
	public void write(byte[] buffer, int offset, int count) throws IOException {
		// Low performing but easy (FIXME)
		for (int i = 0; i < count; i++)
			write(buffer[offset + i]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.FilterOutputStream#write(int)
	 */
	@Override
	public void write(int oneByte) throws IOException {

		if (oneByte == '\n') {
			super.write('\r');
			super.write('\n'); // cr/lf
		} else
			super.write(oneByte);
	}

}
