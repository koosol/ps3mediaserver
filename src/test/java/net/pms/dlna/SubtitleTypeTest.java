/*
 * PS3 Media Server, for streaming any medias to your PS3.
 * Copyright (C) 2012  I. Sokolov
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; version 2
 * of the License only.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package net.pms.dlna;

import org.junit.Test;

import static org.fest.assertions.Assertions.*;

public class SubtitleTypeTest {
	@Test
	public void testGetSubtitleTypeByFileExtension_matchingExtensions() throws Exception {
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("srt")).isEqualTo(SubtitleType.SUBRIP);
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("txt")).isEqualTo(SubtitleType.TEXT);
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("sub")).isEqualTo(SubtitleType.MICRODVD);
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("smi")).isEqualTo(SubtitleType.SAMI);
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("ssa")).isEqualTo(SubtitleType.ASS);
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("ass")).isEqualTo(SubtitleType.ASS);
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("idx")).isEqualTo(SubtitleType.VOBSUB);
	}

	@Test
	public void testGetDescription() throws Exception {
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("srt").getDescription()).isEqualTo("SubRip");
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("txt").getDescription()).isEqualTo("Text file");
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("sub").getDescription()).isEqualTo("MicroDVD");
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("smi").getDescription()).isEqualTo("SAMI");
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("ssa").getDescription()).isEqualTo("SubStation Alpha / Advanced SubStation Alpha");
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("ass").getDescription()).isEqualTo("SubStation Alpha / Advanced SubStation Alpha");
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("idx").getDescription()).isEqualTo("VobSub");
	}

	@Test
	public void testGetDescriptionForUnknownAndEmbedded() throws Exception {
		assertThat(SubtitleType.UNKNOWN.getDescription()).isEqualTo("Unknown");
		assertThat(SubtitleType.EMBEDDED.getDescription()).isEqualTo("Embedded");
	}

	@Test
	public void testGetExtension() throws Exception {
		assertThat(SubtitleType.UNKNOWN.getExtension()).isEqualTo("");
		assertThat(SubtitleType.SUBRIP.getDescription()).isEqualTo("srt");
		assertThat(SubtitleType.TEXT.getDescription()).isEqualTo("txt");
		assertThat(SubtitleType.MICRODVD.getDescription()).isEqualTo("sub");
		assertThat(SubtitleType.SAMI.getDescription()).isEqualTo("smi");
		assertThat(SubtitleType.ASS.getDescription()).isEqualTo("ass");
		assertThat(SubtitleType.VOBSUB.getDescription()).isEqualTo("idx");
		assertThat(SubtitleType.EMBEDDED.getDescription()).isEqualTo("");
	}

	@Test
	public void testGetSubtitleTypeByFileExtension_nullOrBlankExtension() throws Exception {
		assertThat(SubtitleType.getSubtitleTypeByFileExtension(null)).isEqualTo(SubtitleType.UNKNOWN);
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("")).isEqualTo(SubtitleType.UNKNOWN);
	}

	@Test
	public void testGetSubtitleTypeByFileExtension_unknownExtension() throws Exception {
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("xyz")).isEqualTo(SubtitleType.UNKNOWN);
	}

	@Test
	public void testGetSubtitleTypeByFileExtension_extensionCaseInsensitivity() throws Exception {
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("ssA")).isEqualTo(SubtitleType.ASS);
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("SSA")).isEqualTo(SubtitleType.ASS);
		assertThat(SubtitleType.getSubtitleTypeByFileExtension("sSa")).isEqualTo(SubtitleType.ASS);
	}
}